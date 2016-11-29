/**
 */
package dk.itu.chomsky.configurator.model.util;

import dk.itu.chomsky.configurator.model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see dk.itu.chomsky.configurator.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = caseModelElem(model);
				if (result == null) result = caseLabeledElem(model);
				if (result == null) result = caseNamedElem(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MODEL_CHILD: {
				ModelChild modelChild = (ModelChild)theEObject;
				T result = caseModelChild(modelChild);
				if (result == null) result = caseLabeledElem(modelChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PRODUCT_GROUP: {
				ProductGroup productGroup = (ProductGroup)theEObject;
				T result = caseProductGroup(productGroup);
				if (result == null) result = caseModelChild(productGroup);
				if (result == null) result = caseLabeledElem(productGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PRODUCT: {
				Product product = (Product)theEObject;
				T result = caseProduct(product);
				if (result == null) result = caseModelChild(product);
				if (result == null) result = caseModelElem(product);
				if (result == null) result = caseLabeledElem(product);
				if (result == null) result = caseNamedElem(product);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PRODUCT_CHILD: {
				ProductChild productChild = (ProductChild)theEObject;
				T result = caseProductChild(productChild);
				if (result == null) result = caseLabeledElem(productChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PARAM_GROUP: {
				ParamGroup paramGroup = (ParamGroup)theEObject;
				T result = caseParamGroup(paramGroup);
				if (result == null) result = caseProductChild(paramGroup);
				if (result == null) result = caseLabeledElem(paramGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PARAM: {
				Param param = (Param)theEObject;
				T result = caseParam(param);
				if (result == null) result = caseProductChild(param);
				if (result == null) result = caseModelElem(param);
				if (result == null) result = caseLabeledElem(param);
				if (result == null) result = caseNamedElem(param);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ENUM_TYPE: {
				EnumType enumType = (EnumType)theEObject;
				T result = caseEnumType(enumType);
				if (result == null) result = caseModelElem(enumType);
				if (result == null) result = caseLabeledElem(enumType);
				if (result == null) result = caseNamedElem(enumType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ENUM_VAL: {
				EnumVal enumVal = (EnumVal)theEObject;
				T result = caseEnumVal(enumVal);
				if (result == null) result = caseModelElem(enumVal);
				if (result == null) result = caseLabeledElem(enumVal);
				if (result == null) result = caseNamedElem(enumVal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.NAMED_ELEM: {
				NamedElem namedElem = (NamedElem)theEObject;
				T result = caseNamedElem(namedElem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.LABELED_ELEM: {
				LabeledElem labeledElem = (LabeledElem)theEObject;
				T result = caseLabeledElem(labeledElem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MODEL_ELEM: {
				ModelElem modelElem = (ModelElem)theEObject;
				T result = caseModelElem(modelElem);
				if (result == null) result = caseLabeledElem(modelElem);
				if (result == null) result = caseNamedElem(modelElem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PRIM_PARAM: {
				PrimParam primParam = (PrimParam)theEObject;
				T result = casePrimParam(primParam);
				if (result == null) result = caseParam(primParam);
				if (result == null) result = caseProductChild(primParam);
				if (result == null) result = caseModelElem(primParam);
				if (result == null) result = caseLabeledElem(primParam);
				if (result == null) result = caseNamedElem(primParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ENUM_PARAM: {
				EnumParam enumParam = (EnumParam)theEObject;
				T result = caseEnumParam(enumParam);
				if (result == null) result = caseParam(enumParam);
				if (result == null) result = caseProductChild(enumParam);
				if (result == null) result = caseModelElem(enumParam);
				if (result == null) result = caseLabeledElem(enumParam);
				if (result == null) result = caseNamedElem(enumParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseLabeledElem(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EXPR: {
				Expr expr = (Expr)theEObject;
				T result = caseExpr(expr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONST_NUM: {
				ConstNum constNum = (ConstNum)theEObject;
				T result = caseConstNum(constNum);
				if (result == null) result = caseExpr(constNum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PLUS: {
				Plus plus = (Plus)theEObject;
				T result = casePlus(plus);
				if (result == null) result = caseBinOp(plus);
				if (result == null) result = caseExpr(plus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MINUS: {
				Minus minus = (Minus)theEObject;
				T result = caseMinus(minus);
				if (result == null) result = caseBinOp(minus);
				if (result == null) result = caseExpr(minus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.LEQ: {
				Leq leq = (Leq)theEObject;
				T result = caseLeq(leq);
				if (result == null) result = caseBinOp(leq);
				if (result == null) result = caseExpr(leq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.GEQ: {
				Geq geq = (Geq)theEObject;
				T result = caseGeq(geq);
				if (result == null) result = caseBinOp(geq);
				if (result == null) result = caseExpr(geq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EQ: {
				Eq eq = (Eq)theEObject;
				T result = caseEq(eq);
				if (result == null) result = caseBinOp(eq);
				if (result == null) result = caseExpr(eq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.LT: {
				Lt lt = (Lt)theEObject;
				T result = caseLt(lt);
				if (result == null) result = caseBinOp(lt);
				if (result == null) result = caseExpr(lt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.GT: {
				Gt gt = (Gt)theEObject;
				T result = caseGt(gt);
				if (result == null) result = caseBinOp(gt);
				if (result == null) result = caseExpr(gt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONST_BOOL: {
				ConstBool constBool = (ConstBool)theEObject;
				T result = caseConstBool(constBool);
				if (result == null) result = caseExpr(constBool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MULT: {
				Mult mult = (Mult)theEObject;
				T result = caseMult(mult);
				if (result == null) result = caseBinOp(mult);
				if (result == null) result = caseExpr(mult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.BIN_OP: {
				BinOp binOp = (BinOp)theEObject;
				T result = caseBinOp(binOp);
				if (result == null) result = caseExpr(binOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DIV: {
				Div div = (Div)theEObject;
				T result = caseDiv(div);
				if (result == null) result = caseBinOp(div);
				if (result == null) result = caseExpr(div);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.AND: {
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null) result = caseBinOp(and);
				if (result == null) result = caseExpr(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.OR: {
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null) result = caseBinOp(or);
				if (result == null) result = caseExpr(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PARAM_VALUE_REF: {
				ParamValueRef paramValueRef = (ParamValueRef)theEObject;
				T result = caseParamValueRef(paramValueRef);
				if (result == null) result = caseExpr(paramValueRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.VALUE_REF: {
				ValueRef valueRef = (ValueRef)theEObject;
				T result = caseValueRef(valueRef);
				if (result == null) result = caseExpr(valueRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONST_STRING: {
				ConstString constString = (ConstString)theEObject;
				T result = caseConstString(constString);
				if (result == null) result = caseExpr(constString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.NOT: {
				Not not = (Not)theEObject;
				T result = caseNot(not);
				if (result == null) result = caseExpr(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ITE: {
				ITE ite = (ITE)theEObject;
				T result = caseITE(ite);
				if (result == null) result = caseExpr(ite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.FUN_APP: {
				FunApp funApp = (FunApp)theEObject;
				T result = caseFunApp(funApp);
				if (result == null) result = caseExpr(funApp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelChild(ModelChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProductGroup(ProductGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProduct(Product object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProductChild(ProductChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamGroup(ParamGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParam(Param object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumType(EnumType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Val</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumVal(EnumVal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Elem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Elem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElem(NamedElem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Labeled Elem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Labeled Elem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabeledElem(LabeledElem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Elem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Elem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElem(ModelElem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prim Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prim Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimParam(PrimParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumParam(EnumParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpr(Expr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Num</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Num</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstNum(ConstNum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlus(Plus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Minus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Minus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinus(Minus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leq</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leq</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeq(Leq object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Geq</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Geq</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeq(Geq object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eq</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eq</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEq(Eq object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLt(Lt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGt(Gt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Bool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Bool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstBool(ConstBool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mult</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mult</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMult(Mult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bin Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bin Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinOp(BinOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Div</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Div</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiv(Div object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnd(And object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOr(Or object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Value Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Value Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamValueRef(ParamValueRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueRef(ValueRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstString(ConstString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNot(Not object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITE</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITE</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITE(ITE object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fun App</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fun App</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunApp(FunApp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
