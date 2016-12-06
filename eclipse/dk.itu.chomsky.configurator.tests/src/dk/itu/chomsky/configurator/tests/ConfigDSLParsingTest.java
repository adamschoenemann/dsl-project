package dk.itu.chomsky.configurator.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import dk.itu.chomsky.configurator.model.Constraint;
import dk.itu.chomsky.configurator.model.Expr;
import dk.itu.chomsky.configurator.model.Model;
import dk.itu.chomsky.configurator.model.Product;
import dk.itu.chomsky.configurator.scala.Chomsky;

@RunWith(XtextRunner.class)
@InjectWith(ConfigDSLInjectorProvider.class)
public class ConfigDSLParsingTest {
	final String input1 =
		  "model foo \"foo\" {"
		+ "   types {"
		+ "      t1 \"Type 1\" {"
		+ "          v1 \"Val1\""
		+ "          v2 \"Val2\""
		+ "      }"
		+ "      t2 \"Type 2\" {"
		+ "      }"
		+ "   }"
		+ "	  product bar \"bar\" {"
		+ "      param baz \"baz\" Int"
		+ "      param p2 \"Param 2\" t1"
		+ "      constraints {"
		+ "         constraint on baz \"fooconstraint\" !(5 + 10 > 0)"
		+ "         constraint \"c1\" v1 == 0"
		+ "         constraint \"c2\" value(p2) == ((52 / 42 * 10) > 0)"
		+ "         constraint \"c3\" 5 > 5"
		+ "         constraint \"c4\" if (value(p2) > true) then false else true"
		+ "         constraint \"c5\" contains(value(p2), \"foo\") == true"
		+ "      }"
		+ "   }"
		+ "}";
	
	final String input2 = 
		  "model computer_model \"Customize Your Computer\" {"
		+ "  types {"
		+ "    arch \"Architecture\" {"
		+ "      x64 \"64 bit\""
		+ "      x86 \"32 bit\""
		+ "    }"
		+ "    gpu \"GPU\" {"
		+ "      gtx970 \"Asus Geforce GTX 970\""
		+ "      gtx980 \"MSI Geforce GTX 980\""
		+ "      rx480 \"Sapphire Radeon RX 840 NITRO+\""
		+ "    }"
		+ "    cpu \"CPU\" {"
		+ "      i5 \"Intel 2.3 GHz i5\""
		+ "      i7 \"Intel 2.2 GHz i7\""
		+ "      x4 \"AMD 2.8 GHz Athlon X4\""
		+ "    }"
		+ "    mouse \"Mouse\" {"
		+ "      razor \"Razord\""
		+ "      logitech \"Logitech\""
		+ "      microsoft \"Microsft\""
		+ "    }"
		+ "    keyboard \"Keyboard\" {"
		+ "      ltkb \"Logitech\""
		+ "      mskb \"Microsoft\""
		+ "    }"
		+ "  }"
		+ "  product computer \"Computer\" {"
		+ "    param arch \"Architecture\" arch"
		+ "    param cpu \"CPU\" cpu"
		+ "    param gpu \"GPU\" gpu"
		+ "    param ram \"RAM\" Int"
		+ "    param engraving \"Engraving\" Text"
		+ "    param deliver \"Deliver\" Bool"
		+ "    param ghz \"GHz\" Double"
		+ ""
		+ "    group \"Peripherals\" {"
		+ "      param keyboard \"Keyboard\" keyboard optional"
		+ "      param mouse \"Mouse\" mouse optional"
		+ "    }"
		+ "    constraints {"
		+ "      constraint on ram \"Ram must be positive\" value(ram) > 0"
		+ "      constraint on ram \"32-bits can at most have 4g ram\" if value(arch) == x86 then value(ram) <= 4 else true"
		+ "      constraint on keyboard \"c1\" if value(gpu) == gtx970 then value(keyboard) == ltkb else true"
		+ "      constraint \"c2\" if value(cpu) == i5 then value(gpu) == gtx970 || value(gpu) == gtx980 else true"
		+ "      constraint on cpu \"CPU must be intel\" contains(label(\"cpu\"), \"Intel\")"
		+ "    }"
		+ "  }"
		+ ""
		+ "  group \"Peripherals\" {"
		+ ""
		+ "    group \"Inner group\" {"
		+ ""
		+ "    }"
		+ "    product mouse \"Mouse\" {"
		+ ""
		+ "    }"
		+ ""
		+ "    product keyboard \"Keyboard\" {"
		+ ""
		+ "    }"
		+ "  }"
		+ "}";

	@Inject	ParseHelper<Model> parser;
	@Inject ValidationTestHelper validator;

	public final String fext = ".cnfgdsl"; // get this from configuration somehow
	
	@Test
	public void testTemplate() {
		Chomsky.testTemplates();
	}
	
	private void testInputOutput(Function<Model, String> generator, String dirName, String ext) throws Exception {
		File inputDir = new File("resources/input/");

		for (File f : inputDir.listFiles()) {
			if (f.getName().indexOf(".gitignore") > -1)
				continue;
			String fname = f.getName();
			String input = readFile(f);
			Model model = parser.parse(input);
			if (model == null) {
				System.err.println("Model is null for " + f.getName());
				assertTrue("model " + fname + " is null", false);
				continue;
			}
			try {
				validator.assertNoIssues(model);
			} catch (AssertionError err) {
				throw new AssertionError(err.getMessage() + " in file " + fname);
			}
			String output = generator.apply(model);
			String expectedDir = "resources/expected/" + dirName + "/";
			createDir(expectedDir);
			String expectedPath = expectedDir  + fname.replace(fext, "." + ext);
			File expectedFile = new File(expectedPath);
			String outputDir = "resources/output/" + dirName + "/";
			createDir(outputDir);
			String outputPath = outputDir + fname.replace(fext, "." + ext);
											
			writeFile(outputPath, output);
			 
			if (expectedFile.exists() == false) {
				System.out.println("Writing expected file " + expectedPath);
				writeFile(expectedPath, output);
			} else {
				// have to read output file and not use output, since encoding and newline issues whatever
				String expectedContents = readFile(expectedFile);
				String outputContents = readFile(new File(outputPath));
				assertEquals(fname, expectedContents, outputContents);
			}
		}
	}
	
	private void createDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists()) {
			if (!dir.isDirectory()) {
				throw new IllegalArgumentException(path + " exists but is not a directory");
			}
			return; // yeah, not necessary but good for documentation imo
		} else {
			dir.mkdirs();
		}
	}

	@Test
	public void testJsonInputOutput() throws Exception {
		testInputOutput(model -> Chomsky.generateJson(model), "json", "json");
	}

	@Test
	public void testHtmlInputOutput() throws Exception {
		testInputOutput(model -> Chomsky.generateHtml(model), "html", "html");
	}

	@Test
	public void testHtmlGen() {
		try {
			Chomsky.testHtmlGen(parser.parse(input2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String readFile(File file) throws IOException {
		Scanner scanner = null;
		StringBuilder result = new StringBuilder();
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
			return result.toString();
		} catch (IOException e) {
			throw e;
		} finally {
			scanner.close();
		}
	}
	
	private void writeFile(String path, String contents) throws IOException {
		File file = new File(path);
		if (file.exists() == false) {
			System.out.println("Creating file " + path);
			file.createNewFile();
		}
		OutputStream os = new FileOutputStream(file);
		os.write(contents.getBytes());
		os.close();
	}

	@Test
	public void testValidateNoEmptyTypes() {

		try {
			Model model = parser.parse("model foo \"foo\" {"
					+ "   types {"
					+ "      t1 \"Type 1\" {}"
					+ "   }");

			validator.assertError(model, null, null, "Type >t2< must have values");

		} catch (Exception e) {}
	}
	
	@Test
	public void testJSExprGen() {
		
		try {
			Model model = parser.parse(input1);
			
			EList<Constraint> constrs = ((Product)model.getChildren().get(0)).getConstraints();
			System.out.println("Number of constraints: " + constrs.size());
			for (Constraint cons : constrs) {
				Expr expr = cons.getExpr();
				if (expr == null) {
					System.out.println(cons.getLabel() + "'s expression was null!");
					continue;
				}
				String generated = Chomsky.genJSExpr(expr);
				System.out.println(generated);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void loadModel() {
		try {
			String input = 
				  "model computer_model \"Customize Your Computer\" {"
				+ "  types {"
				+ "    arch \"Architecture\" {"
				+ "      x64 \"64 bit\""
				+ "      x86 \"32 bit\""
				+ "    }"
				+ "    gpu \"GPU\" {"
				+ "      gtx970 \"Asus Geforce GTX 970\""
				+ "      gtx980 \"MSI Geforce GTX 980\""
				+ "      rx480 \"Sapphire Radeon RX 840 NITRO+\""
				+ "    }"
				+ "    cpu \"CPU\" {"
				+ "      i5 \"Intel 2.3 GHz i5\""
				+ "      i7 \"Intel 2.2 GHz i7\""
				+ "      x4 \"AMD 2.8 GHz Athlon X4\""
				+ "    }"
				+ "    mouse \"Mouse\" {"
				+ "      razor \"Razord\""
				+ "      logitech \"Logitech\""
				+ "      microsoft \"Microsft\""
				+ "    }"
				+ "    keyboard \"Keyboard\" {"
				+ "      ltkb \"Logitech\""
				+ "      mskb \"Microsoft\""
				+ "    }"
				+ "  }"
				+ "  product computer \"Computer\" {"
				+ "    param arch \"Architecture\" arch"
				+ "    param cpu \"CPU\" cpu"
				+ "    param gpu \"GPU\" gpu"
				+ "    param ram \"RAM\" Int"
				+ "    param engraving \"Engraving\" Text"
				+ "    param deliver \"Deliver\" Bool"
				+ "    param ghz \"GHz\" Double"
				+ "    "
				+ "    group \"Peripherals\" {"
				+ "      param keyboard \"Keyboard\" keyboard optional"
				+ "      param mouse \"Mouse\" mouse optional"
				+ "    }"
				+ "    constraints {"
				+ "      \"Ram\" ram > 0"
				+ "      \"ram positive\" 20 * 10 + 10 - 2 == ram - 10 / 5"
				+ "      \"nonsense\" (true && false || true == ((20 > 0) == false)) == true"
				+ "      \"nonsense2\" 20 > 30 == false"
				+ "      /*\"ram 64-bit \"if (arch == x86) then ram <= 4 else ram <= 16*/"
				+ "    }"
				+ "  }"
				+ "  "
				+ "  group \"Peripherals\" {"
				+ "    "
				+ "    group \"Inner group\" {"
				+ "      "
				+ "    }"
				+ "    product mouse \"Mouse\" {"
				+ "      "
				+ "    }"
				+ "    "
				+ "    product keyboard \"Keyboard\" {"
				+ "      "
				+ "    }"
				+ "  }"
				+ "}";
			Model model = parser.parse(input);
			String json = Chomsky.generateJson(model);
			assertTrue(json.contains("Computer"));
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
