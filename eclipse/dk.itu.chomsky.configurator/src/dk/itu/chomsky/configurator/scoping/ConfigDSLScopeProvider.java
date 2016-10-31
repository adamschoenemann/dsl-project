package dk.itu.chomsky.configurator.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
//import dk.itu.chomsky.configurator.Main
import org.eclipse.xtext.scoping.IScope;
import dk.itu.chomsky.configurator.scala.Chomsky;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class ConfigDSLScopeProvider extends AbstractConfigDSLScopeProvider {
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		return super.getScope(context, reference);
	}
}