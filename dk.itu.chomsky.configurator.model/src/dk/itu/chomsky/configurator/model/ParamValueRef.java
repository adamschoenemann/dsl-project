/**
 */
package dk.itu.chomsky.configurator.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param Value Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.itu.chomsky.configurator.model.ParamValueRef#getParam <em>Param</em>}</li>
 * </ul>
 *
 * @see dk.itu.chomsky.configurator.model.ModelPackage#getParamValueRef()
 * @model
 * @generated
 */
public interface ParamValueRef extends Expr {
	/**
	 * Returns the value of the '<em><b>Param</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' reference.
	 * @see #setParam(Param)
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getParamValueRef_Param()
	 * @model
	 * @generated
	 */
	Param getParam();

	/**
	 * Sets the value of the '{@link dk.itu.chomsky.configurator.model.ParamValueRef#getParam <em>Param</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param</em>' reference.
	 * @see #getParam()
	 * @generated
	 */
	void setParam(Param value);

} // ParamValueRef
