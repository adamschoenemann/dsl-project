/*
 * generated by Xtext 2.10.0
 */
package dk.itu.chomsky.configurator.tests;

import com.google.inject.Inject;
import dk.itu.chomsky.configurator.model.*;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.util.ParseHelper;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import dk.itu.chomsky.configurator.scala.*;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.emf.common.util.*;

@RunWith(XtextRunner.class)
@InjectWith(ConfigDSLInjectorProvider.class)
public class ConfigDSLParsingTest {

	@Inject	ParseHelper<Model> parser;
	
	@Test
	public void testTemplate() {
		Chomsky.testTemplates();
	}

	@Test
	public void testJSExprGen() {
		String input =
			  "model foo \"foo\" {"
			+ "   types {"
			+ "      t1 \"Type 1\" {"
			+ "          v1 \"Val1\""
			+ "          v2 \"Val2\""
			+ "      }"
			+ "   }"
			+ "	  product bar \"bar\" {"
			+ "      param baz \"baz\" Int"
			+ "      param p2 \"Param 2\" t1"
			+ "      constraints {"
			+ "         \"fooconstraint\" baz > 0"
			+ "         \"c1\" baz == 0"
			+ "         \"c2\" p2 == ((52 / 42 * 10) > 0)"
			+ "      }"
			+ "   }"
			+ "}";
		
		try {
			Model model = parser.parse(input);
			EList<Constraint> constrs = ((Product)model.getChildren().get(0)).getConstraints();
			for (Constraint cons : constrs) {
				Expr expr = cons.getExpr();
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
