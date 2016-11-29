/**
 */
package dk.itu.chomsky.configurator.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.itu.chomsky.configurator.model.ValueRef#getEnumVal <em>Enum Val</em>}</li>
 * </ul>
 *
 * @see dk.itu.chomsky.configurator.model.ModelPackage#getValueRef()
 * @model
 * @generated
 */
public interface ValueRef extends Expr {
	/**
	 * Returns the value of the '<em><b>Enum Val</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Val</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Val</em>' reference.
	 * @see #setEnumVal(EnumVal)
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getValueRef_EnumVal()
	 * @model required="true"
	 * @generated
	 */
	EnumVal getEnumVal();

	/**
	 * Sets the value of the '{@link dk.itu.chomsky.configurator.model.ValueRef#getEnumVal <em>Enum Val</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Val</em>' reference.
	 * @see #getEnumVal()
	 * @generated
	 */
	void setEnumVal(EnumVal value);

} // ValueRef
