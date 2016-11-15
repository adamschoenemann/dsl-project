package dk.itu.chomsky.configurator.generator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.emf.ecore.resource.Resource;

import dk.itu.chomsky.configurator.model.Model;
import dk.itu.chomsky.configurator.model.ModelElem;
import dk.itu.chomsky.configurator.scala.*;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
public class ConfigDSLGenerator extends AbstractGenerator {
	
	@Override
	public void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		input.getAllContents().forEachRemaining(obj -> {
//			if (obj instanceof ModelELem) {
//				ModelELem elem = (ModelELem)obj;
//				fsa.generateFile(elem.getName() + ".json", Chomsky.generateJson(elem));
//			}
//		});
		String css = getFile("/model.css");
		
		System.out.println("css:\n" + css);
		
		Model model = (Model)input.getAllContents().next();
		String json = Chomsky.generateJson(model);
		String html = Chomsky.generateHtml(model);
		
		fsa.generateFile(model.getName() + ".json", json);
		fsa.generateFile(model.getName() + ".html", html);
		fsa.generateFile("model.css", css);
		
	}
	
	private String getFile(String fileName) {

		StringBuilder result = new StringBuilder("");

		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	  }
}
