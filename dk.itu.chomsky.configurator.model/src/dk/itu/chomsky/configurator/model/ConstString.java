/**
 */
package dk.itu.chomsky.configurator.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Const String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.itu.chomsky.configurator.model.ConstString#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see dk.itu.chomsky.configurator.model.ModelPackage#getConstString()
 * @model
 * @generated
 */
public interface ConstString extends Expr {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getConstString_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link dk.itu.chomsky.configurator.model.ConstString#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // ConstString
