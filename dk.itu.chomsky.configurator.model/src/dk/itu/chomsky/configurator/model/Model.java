/**
 */
package dk.itu.chomsky.configurator.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.itu.chomsky.configurator.model.Model#getChildren <em>Children</em>}</li>
 *   <li>{@link dk.itu.chomsky.configurator.model.Model#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @see dk.itu.chomsky.configurator.model.ModelPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends ModelElem {
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
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getModel_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelChild> getChildren();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link dk.itu.chomsky.configurator.model.EnumType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see dk.itu.chomsky.configurator.model.ModelPackage#getModel_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumType> getTypes();

} // Model
