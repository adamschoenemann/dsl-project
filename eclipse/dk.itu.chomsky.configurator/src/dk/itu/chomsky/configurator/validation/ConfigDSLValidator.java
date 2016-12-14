/*
 * generated by Xtext 2.10.0
 */
package dk.itu.chomsky.configurator.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

import dk.itu.chomsky.configurator.model.Constraint;
import dk.itu.chomsky.configurator.model.EnumType;
import dk.itu.chomsky.configurator.model.Expr;
import dk.itu.chomsky.configurator.model.Model;
import dk.itu.chomsky.configurator.model.NamedElem;
import dk.itu.chomsky.configurator.model.Param;
import dk.itu.chomsky.configurator.model.Product;
import dk.itu.chomsky.configurator.model.EnumVal;
import dk.itu.chomsky.configurator.scala.Chomsky;
import dk.itu.chomsky.configurator.scala.types.*;

import scala.Option;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class ConfigDSLValidator extends AbstractConfigDSLValidator {
	
	public static final String TYPE_ERROR = "TYPE_ERROR";
	public static final String UNIQUE_NAME_ERROR = "UNIQUE_NAME_ERROR";

	@Check
	void checkConstraint(Constraint constraint) { 
		if (constraint == null || constraint.getExpr() == null)
			return;
		Expr expr = constraint.getExpr();
		Option<ExprTy> ty = Chomsky.checkExpr(expr);
		if (ty.isEmpty()) {
			error("Expression " + Chomsky.genJSExpr(expr) + " did not type-check", constraint, null, TYPE_ERROR);
		} else if (!ty.get().equals(TyBool$.MODULE$)) {
			//error(message, source, feature, code, issueData);
			error("Constraint must have a boolean expression", constraint, null, TYPE_ERROR);
		}
	}

	@Check
	void checkEmptyTypes(EnumType enumType) { 
		if (enumType == null)
			return;

		Integer count = enumType.getValues().size();

		if (count <= 0) {
			error("Type >" + enumType.getName() + "< must have values", enumType, null);
		}
	}
	
	<T extends NamedElem> void checkUniqueNames(EObject root, Class<T> type) {
		List<T> vals = EcoreUtil2.getAllContentsOfType(root, type);
		Set<String> seen = new HashSet<>();
		// System.out.println("\n---------Checking " + " something " + "-------------");
		for (T val : vals) {
			if (seen.contains(val.getName())) {
				error(val.getName() + " is not unique", val, null, UNIQUE_NAME_ERROR);
			}
			// System.out.println("Seen " + val.getName());
			seen.add(val.getName());
		}
	}
	
	@Check
	void checkUniqueEnums(Model model) {
		EObject root = EcoreUtil2.getRootContainer(model);
		checkUniqueNames(root, EnumVal.class);
		checkUniqueNames(root, EnumType.class);
		checkUniqueNames(root, Product.class);
		checkUniqueNames(root, Param.class);
	}
	
//	@Check
//	void checkUniqueProducts(Product product) {
//		EObject root = EcoreUtil2.getRootContainer(product);
//		checkUniqueNames(root, Product.class);
//	}
//
//	@Check
//	void checkUniqueParams(Param param) {
//		EObject root = EcoreUtil2.getRootContainer(param);
//		checkUniqueNames(root, Param.class);
//	}
}