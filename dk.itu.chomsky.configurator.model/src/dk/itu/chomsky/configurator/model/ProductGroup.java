/**
 */
package dk.itu.chomsky.configurator.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Product Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.itu.chomsky.configurator.model.ProductGroup#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see dk.itu.chomsky.configurator.model.ModelPackage#getProductGroup()
 * @model
 * @generated
 */
public interface ProductGroup extends ModelChild {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.chomsky.configurator.model.ModelChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getProductGroup_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelChild> getChildren();

} // ProductGroup
