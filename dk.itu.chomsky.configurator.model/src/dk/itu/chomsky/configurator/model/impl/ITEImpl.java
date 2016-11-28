/**
 */
package dk.itu.chomsky.configurator.model.impl;

import dk.itu.chomsky.configurator.model.Expr;
import dk.itu.chomsky.configurator.model.ITE;
import dk.itu.chomsky.configurator.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ITE</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dk.itu.chomsky.configurator.model.impl.ITEImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link dk.itu.chomsky.configurator.model.impl.ITEImpl#getTrueBranch <em>True Branch</em>}</li>
 *   <li>{@link dk.itu.chomsky.configurator.model.impl.ITEImpl#getFalseBranch <em>False Branch</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ITEImpl extends ExprImpl implements ITE {
	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected Expr guard;

	/**
	 * The cached value of the '{@link #getTrueBranch() <em>True Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueBranch()
	 * @generated
	 * @ordered
	 */
	protected Expr trueBranch;

	/**
	 * The cached value of the '{@link #getFalseBranch() <em>False Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseBranch()
	 * @generated
	 * @ordered
	 */
	protected Expr falseBranch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ITEImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuard(Expr newGuard, NotificationChain msgs) {
		Expr oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ITE__GUARD, oldGuard, newGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(Expr newGuard) {
		if (newGuard != guard) {
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ITE__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ITE__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ITE__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getTrueBranch() {
		return trueBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrueBranch(Expr newTrueBranch, NotificationChain msgs) {
		Expr oldTrueBranch = trueBranch;
		trueBranch = newTrueBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ITE__TRUE_BRANCH, oldTrueBranch, newTrueBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueBranch(Expr newTrueBranch) {
		if (newTrueBranch != trueBranch) {
			NotificationChain msgs = null;
			if (trueBranch != null)
				msgs = ((InternalEObject)trueBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ITE__TRUE_BRANCH, null, msgs);
			if (newTrueBranch != null)
				msgs = ((InternalEObject)newTrueBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ITE__TRUE_BRANCH, null, msgs);
			msgs = basicSetTrueBranch(newTrueBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ITE__TRUE_BRANCH, newTrueBranch, newTrueBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getFalseBranch() {
		return falseBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFalseBranch(Expr newFalseBranch, NotificationChain msgs) {
		Expr oldFalseBranch = falseBranch;
		falseBranch = newFalseBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ITE__FALSE_BRANCH, oldFalseBranch, newFalseBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseBranch(Expr newFalseBranch) {
		if (newFalseBranch != falseBranch) {
			NotificationChain msgs = null;
			if (falseBranch != null)
				msgs = ((InternalEObject)falseBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ITE__FALSE_BRANCH, null, msgs);
			if (newFalseBranch != null)
				msgs = ((InternalEObject)newFalseBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ITE__FALSE_BRANCH, null, msgs);
			msgs = basicSetFalseBranch(newFalseBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ITE__FALSE_BRANCH, newFalseBranch, newFalseBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ITE__GUARD:
				return basicSetGuard(null, msgs);
			case ModelPackage.ITE__TRUE_BRANCH:
				return basicSetTrueBranch(null, msgs);
			case ModelPackage.ITE__FALSE_BRANCH:
				return basicSetFalseBranch(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ITE__GUARD:
				return getGuard();
			case ModelPackage.ITE__TRUE_BRANCH:
				return getTrueBranch();
			case ModelPackage.ITE__FALSE_BRANCH:
				return getFalseBranch();
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
			case ModelPackage.ITE__GUARD:
				setGuard((Expr)newValue);
				return;
			case ModelPackage.ITE__TRUE_BRANCH:
				setTrueBranch((Expr)newValue);
				return;
			case ModelPackage.ITE__FALSE_BRANCH:
				setFalseBranch((Expr)newValue);
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
			case ModelPackage.ITE__GUARD:
				setGuard((Expr)null);
				return;
			case ModelPackage.ITE__TRUE_BRANCH:
				setTrueBranch((Expr)null);
				return;
			case ModelPackage.ITE__FALSE_BRANCH:
				setFalseBranch((Expr)null);
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
			case ModelPackage.ITE__GUARD:
				return guard != null;
			case ModelPackage.ITE__TRUE_BRANCH:
				return trueBranch != null;
			case ModelPackage.ITE__FALSE_BRANCH:
				return falseBranch != null;
		}
		return super.eIsSet(featureID);
	}

} //ITEImpl
