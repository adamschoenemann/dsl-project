package dk.itu.chomsky.configurator.generator;

import java.util.Scanner;

import org.eclipse.emf.ecore.resource.Resource;
import dk.itu.chomsky.configurator.model.Model;
import dk.itu.chomsky.configurator.scala.Chomsky;
import dk.itu.chomsky.configurator.util.Utils;

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
		String css = Utils.getResource(this, "dk/itu/chomsky/configurator/scala/generators/html/model.css");
		
		System.out.println("css:\n" + css);
		
		Model model = (Model)input.getAllContents().next();
		String json = Chomsky.generateJson(model);
		String html = Chomsky.generateHtml(model);

		fsa.generateFile(model.getName() + ".json", json);
		fsa.generateFile(model.getName() + ".html", html);
		fsa.generateFile("model.css", css);
		
	}
	

}
