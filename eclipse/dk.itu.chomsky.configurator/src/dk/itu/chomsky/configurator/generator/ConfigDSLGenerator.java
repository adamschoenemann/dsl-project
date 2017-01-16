package dk.itu.chomsky.configurator.generator;

//import java.util.Scanner;

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
		// The Utils was not pushed or is it the one on scala folder?
		String css = Utils.getResource(this, "dk/itu/chomsky/configurator/scala/generators/html/model.css");
		
		//System.out.println("css:\n" + css);
		
		Model model = (Model)input.getAllContents().next();
		String json = Chomsky.generateJson(model);
		String html = Chomsky.generateHtml(model);
		
        //Android
		// String androidManifest = Chomsky.generateAndroidManifest(model);
		String java  = Chomsky.generateAndroidMainActivity(model);
		// String xml   = Chomsky.generateAndroidMainView(model);
		//Android
		// fsa.generateFile(model.getName() + "Manifest.xml", androidManifest);
		fsa.generateFile(model.getName()+ "Activity.java", java);
		// fsa.generateFile(model.getName() + "View.xml", xml); 
		
		fsa.generateFile(model.getName() + ".json", json);
		fsa.generateFile(model.getName() + ".html", html);
		fsa.generateFile("model.css", css);
		
	}
	

}
