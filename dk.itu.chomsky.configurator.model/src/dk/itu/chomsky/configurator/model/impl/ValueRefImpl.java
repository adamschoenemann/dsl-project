/**
 */
package dk.itu.chomsky.configurator.model.impl;

import dk.itu.chomsky.configurator.model.EnumVal;
import dk.itu.chomsky.configurator.model.ModelPackage;
import dk.itu.chomsky.configurator.model.ValueRef;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dk.itu.chomsky.configurator.model.impl.ValueRefImpl#getEnumVal <em>Enum Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueRefImpl extends ExprImpl implements ValueRef {
	/**
	 * The cached value of the '{@link #getEnumVal() <em>Enum Val</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumVal()
	 * @generated
	 * @ordered
	 */
	protected EnumVal enumVal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.VALUE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumVal getEnumVal() {
		if (enumVal != null && enumVal.eIsProxy()) {
			InternalEObject oldEnumVal = (InternalEObject)enumVal;
			enumVal = (EnumVal)eResolveProxy(oldEnumVal);
			if (enumVal != oldEnumVal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.VALUE_REF__ENUM_VAL, oldEnumVal, enumVal));
			}
		}
		return enumVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumVal basicGetEnumVal() {
		return enumVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumVal(EnumVal newEnumVal) {
		EnumVal oldEnumVal = enumVal;
		enumVal = newEnumVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VALUE_REF__ENUM_VAL, oldEnumVal, enumVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.VALUE_REF__ENUM_VAL:
				if (resolve) return getEnumVal();
				return basicGetEnumVal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.VALUE_REF__ENUM_VAL:
				setEnumVal((EnumVal)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.VALUE_REF__ENUM_VAL:
				setEnumVal((EnumVal)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.VALUE_REF__ENUM_VAL:
				return enumVal != null;
		}
		return super.eIsSet(featureID);
	}

} //ValueRefImpl
