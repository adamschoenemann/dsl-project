package dk.itu.chomsky.configurator.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
//import dk.itu.chomsky.configurator.Main
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import dk.itu.chomsky.configurator.model.EnumVal;
import dk.itu.chomsky.configurator.model.ModelPackage;
//import dk.itu.chomsky.configurator.scala.Chomsky;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class ConfigDSLScopeProvider extends AbstractConfigDSLScopeProvider {
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == ModelPackage.Literals.VALUE_REF__ENUM_VAL) {
			EObject rootElem = EcoreUtil2.getRootContainer(context);
			List<EnumVal> candidates = EcoreUtil2.getAllContentsOfType(rootElem, EnumVal.class);
			return Scopes.scopeFor(candidates);
		}
		return super.getScope(context, reference);
	}
}