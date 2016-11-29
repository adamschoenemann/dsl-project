/**
 */
package dk.itu.chomsky.configurator.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ITE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.itu.chomsky.configurator.model.ITE#getGuard <em>Guard</em>}</li>
 *   <li>{@link dk.itu.chomsky.configurator.model.ITE#getTrueBranch <em>True Branch</em>}</li>
 *   <li>{@link dk.itu.chomsky.configurator.model.ITE#getFalseBranch <em>False Branch</em>}</li>
 * </ul>
 *
 * @see dk.itu.chomsky.configurator.model.ModelPackage#getITE()
 * @model
 * @generated
 */
public interface ITE extends Expr {
	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(Expr)
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getITE_Guard()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getGuard();

	/**
	 * Sets the value of the '{@link dk.itu.chomsky.configurator.model.ITE#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Expr value);

	/**
	 * Returns the value of the '<em><b>True Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Branch</em>' containment reference.
	 * @see #setTrueBranch(Expr)
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getITE_TrueBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getTrueBranch();

	/**
	 * Sets the value of the '{@link dk.itu.chomsky.configurator.model.ITE#getTrueBranch <em>True Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Branch</em>' containment reference.
	 * @see #getTrueBranch()
	 * @generated
	 */
	void setTrueBranch(Expr value);

	/**
	 * Returns the value of the '<em><b>False Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Branch</em>' containment reference.
	 * @see #setFalseBranch(Expr)
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getITE_FalseBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getFalseBranch();

	/**
	 * Sets the value of the '{@link dk.itu.chomsky.configurator.model.ITE#getFalseBranch <em>False Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Branch</em>' containment reference.
	 * @see #getFalseBranch()
	 * @generated
	 */
	void setFalseBranch(Expr value);

} // ITE
