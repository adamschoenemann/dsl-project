/**
 */
package dk.itu.chomsky.configurator.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dk.itu.chomsky.configurator.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/dk.itu.chomsky.configurator.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dk.itu.chomsky.configurator.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = dk.itu.chomsky.configurator.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.LabeledElemImpl <em>Labeled Elem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.LabeledElemImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getLabeledElem()
	 * @generated
	 */
	int LABELED_ELEM = 10;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_ELEM__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Labeled Elem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_ELEM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Labeled Elem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_ELEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ModelElemImpl <em>Elem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ModelElemImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getModelElem()
	 * @generated
	 */
	int MODEL_ELEM = 11;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEM__LABEL = LABELED_ELEM__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEM__NAME = LABELED_ELEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Elem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEM_FEATURE_COUNT = LABELED_ELEM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Elem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEM_OPERATION_COUNT = LABELED_ELEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ModelImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__LABEL = MODEL_ELEM__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = MODEL_ELEM__NAME;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CHILDREN = MODEL_ELEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__TYPES = MODEL_ELEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = MODEL_ELEM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = MODEL_ELEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ModelChildImpl <em>Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ModelChildImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getModelChild()
	 * @generated
	 */
	int MODEL_CHILD = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHILD__LABEL = LABELED_ELEM__LABEL;

	/**
	 * The number of structural features of the '<em>Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHILD_FEATURE_COUNT = LABELED_ELEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHILD_OPERATION_COUNT = LABELED_ELEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ProductGroupImpl <em>Product Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ProductGroupImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getProductGroup()
	 * @generated
	 */
	int PRODUCT_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_GROUP__LABEL = MODEL_CHILD__LABEL;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_GROUP__CHILDREN = MODEL_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Product Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_GROUP_FEATURE_COUNT = MODEL_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Product Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_GROUP_OPERATION_COUNT = MODEL_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ProductImpl <em>Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ProductImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__LABEL = MODEL_CHILD__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__NAME = MODEL_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__CHILDREN = MODEL_CHILD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__CONSTRAINTS = MODEL_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = MODEL_CHILD_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_OPERATION_COUNT = MODEL_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ProductChildImpl <em>Product Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ProductChildImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getProductChild()
	 * @generated
	 */
	int PRODUCT_CHILD = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_CHILD__LABEL = LABELED_ELEM__LABEL;

	/**
	 * The number of structural features of the '<em>Product Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_CHILD_FEATURE_COUNT = LABELED_ELEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Product Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_CHILD_OPERATION_COUNT = LABELED_ELEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ParamGroupImpl <em>Param Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ParamGroupImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getParamGroup()
	 * @generated
	 */
	int PARAM_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_GROUP__LABEL = PRODUCT_CHILD__LABEL;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_GROUP__CHILDREN = PRODUCT_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Param Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_GROUP_FEATURE_COUNT = PRODUCT_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Param Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_GROUP_OPERATION_COUNT = PRODUCT_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ParamImpl <em>Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ParamImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getParam()
	 * @generated
	 */
	int PARAM = 6;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__LABEL = PRODUCT_CHILD__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__NAME = PRODUCT_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__OPTIONAL = PRODUCT_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_FEATURE_COUNT = PRODUCT_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_OPERATION_COUNT = PRODUCT_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.EnumTypeImpl <em>Enum Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.EnumTypeImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getEnumType()
	 * @generated
	 */
	int ENUM_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE__LABEL = MODEL_ELEM__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE__NAME = MODEL_ELEM__NAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE__VALUES = MODEL_ELEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_FEATURE_COUNT = MODEL_ELEM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_OPERATION_COUNT = MODEL_ELEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.EnumValImpl <em>Enum Val</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.EnumValImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getEnumVal()
	 * @generated
	 */
	int ENUM_VAL = 8;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VAL__LABEL = MODEL_ELEM__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VAL__NAME = MODEL_ELEM__NAME;

	/**
	 * The number of structural features of the '<em>Enum Val</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VAL_FEATURE_COUNT = MODEL_ELEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Enum Val</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VAL_OPERATION_COUNT = MODEL_ELEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.NamedElemImpl <em>Named Elem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.NamedElemImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getNamedElem()
	 * @generated
	 */
	int NAMED_ELEM = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEM__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Elem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Elem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.PrimParamImpl <em>Prim Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.PrimParamImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getPrimParam()
	 * @generated
	 */
	int PRIM_PARAM = 12;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIM_PARAM__LABEL = PARAM__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIM_PARAM__NAME = PARAM__NAME;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIM_PARAM__OPTIONAL = PARAM__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIM_PARAM__TYPE = PARAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Prim Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIM_PARAM_FEATURE_COUNT = PARAM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Prim Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIM_PARAM_OPERATION_COUNT = PARAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.EnumParamImpl <em>Enum Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.EnumParamImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getEnumParam()
	 * @generated
	 */
	int ENUM_PARAM = 13;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_PARAM__LABEL = PARAM__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_PARAM__NAME = PARAM__NAME;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_PARAM__OPTIONAL = PARAM__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_PARAM__TYPE = PARAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_PARAM_FEATURE_COUNT = PARAM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_PARAM_OPERATION_COUNT = PARAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ConstraintImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 14;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__LABEL = LABELED_ELEM__LABEL;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EXPR = LABELED_ELEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = LABELED_ELEM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = LABELED_ELEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ExprImpl <em>Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ExprImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getExpr()
	 * @generated
	 */
	int EXPR = 15;

	/**
	 * The number of structural features of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ConstNumImpl <em>Const Num</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ConstNumImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getConstNum()
	 * @generated
	 */
	int CONST_NUM = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_NUM__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Const Num</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_NUM_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Const Num</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_NUM_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.BinOpImpl <em>Bin Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.BinOpImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getBinOp()
	 * @generated
	 */
	int BIN_OP = 26;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN_OP__LEFT = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN_OP__RIGHT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bin Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN_OP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bin Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIN_OP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.PlusImpl <em>Plus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.PlusImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getPlus()
	 * @generated
	 */
	int PLUS = 17;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.MinusImpl <em>Minus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.MinusImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getMinus()
	 * @generated
	 */
	int MINUS = 18;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Minus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Minus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.LeqImpl <em>Leq</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.LeqImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getLeq()
	 * @generated
	 */
	int LEQ = 19;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEQ__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEQ__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Leq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEQ_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Leq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEQ_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.GeqImpl <em>Geq</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.GeqImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getGeq()
	 * @generated
	 */
	int GEQ = 20;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEQ__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEQ__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Geq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEQ_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Geq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEQ_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.EqImpl <em>Eq</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.EqImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getEq()
	 * @generated
	 */
	int EQ = 21;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQ__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQ__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Eq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQ_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Eq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQ_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.LtImpl <em>Lt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.LtImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getLt()
	 * @generated
	 */
	int LT = 22;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LT__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LT__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Lt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LT_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Lt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LT_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.GtImpl <em>Gt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.GtImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getGt()
	 * @generated
	 */
	int GT = 23;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Gt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Gt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ConstBoolImpl <em>Const Bool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ConstBoolImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getConstBool()
	 * @generated
	 */
	int CONST_BOOL = 24;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_BOOL__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Const Bool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_BOOL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Const Bool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_BOOL_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.MultImpl <em>Mult</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.MultImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getMult()
	 * @generated
	 */
	int MULT = 25;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Mult</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mult</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.DivImpl <em>Div</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.DivImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getDiv()
	 * @generated
	 */
	int DIV = 27;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Div</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Div</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.AndImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 28;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.OrImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getOr()
	 * @generated
	 */
	int OR = 29;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LEFT = BIN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RIGHT = BIN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = BIN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATION_COUNT = BIN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ParamValueRefImpl <em>Param Value Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ParamValueRefImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getParamValueRef()
	 * @generated
	 */
	int PARAM_VALUE_REF = 30;

	/**
	 * The feature id for the '<em><b>Param</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_VALUE_REF__PARAM = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Param Value Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_VALUE_REF_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Param Value Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_VALUE_REF_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ValueRefImpl <em>Value Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ValueRefImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getValueRef()
	 * @generated
	 */
	int VALUE_REF = 31;

	/**
	 * The feature id for the '<em><b>Enum Val</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_REF__ENUM_VAL = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_REF_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Value Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_REF_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ConstStringImpl <em>Const String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ConstStringImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getConstString()
	 * @generated
	 */
	int CONST_STRING = 32;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_STRING__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Const String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_STRING_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Const String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_STRING_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.NotImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 33;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__EXPR = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.ITEImpl <em>ITE</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.ITEImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getITE()
	 * @generated
	 */
	int ITE = 34;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITE__GUARD = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>True Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITE__TRUE_BRANCH = EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>False Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITE__FALSE_BRANCH = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ITE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITE_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>ITE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITE_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.impl.FunAppImpl <em>Fun App</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.impl.FunAppImpl
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getFunApp()
	 * @generated
	 */
	int FUN_APP = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUN_APP__NAME = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUN_APP__ARGS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fun App</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUN_APP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Fun App</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUN_APP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.itu.chomsky.configurator.model.PrimitiveType <em>Primitive Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.itu.chomsky.configurator.model.PrimitiveType
	 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 36;


	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see dk.itu.chomsky.configurator.model.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.chomsky.configurator.model.Model#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see dk.itu.chomsky.configurator.model.Model#getChildren()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Children();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.chomsky.configurator.model.Model#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see dk.itu.chomsky.configurator.model.Model#getTypes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Types();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ModelChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child</em>'.
	 * @see dk.itu.chomsky.configurator.model.ModelChild
	 * @generated
	 */
	EClass getModelChild();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ProductGroup <em>Product Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product Group</em>'.
	 * @see dk.itu.chomsky.configurator.model.ProductGroup
	 * @generated
	 */
	EClass getProductGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.chomsky.configurator.model.ProductGroup#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see dk.itu.chomsky.configurator.model.ProductGroup#getChildren()
	 * @see #getProductGroup()
	 * @generated
	 */
	EReference getProductGroup_Children();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Product <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product</em>'.
	 * @see dk.itu.chomsky.configurator.model.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.chomsky.configurator.model.Product#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see dk.itu.chomsky.configurator.model.Product#getChildren()
	 * @see #getProduct()
	 * @generated
	 */
	EReference getProduct_Children();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.chomsky.configurator.model.Product#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see dk.itu.chomsky.configurator.model.Product#getConstraints()
	 * @see #getProduct()
	 * @generated
	 */
	EReference getProduct_Constraints();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ProductChild <em>Product Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product Child</em>'.
	 * @see dk.itu.chomsky.configurator.model.ProductChild
	 * @generated
	 */
	EClass getProductChild();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ParamGroup <em>Param Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Group</em>'.
	 * @see dk.itu.chomsky.configurator.model.ParamGroup
	 * @generated
	 */
	EClass getParamGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.chomsky.configurator.model.ParamGroup#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see dk.itu.chomsky.configurator.model.ParamGroup#getChildren()
	 * @see #getParamGroup()
	 * @generated
	 */
	EReference getParamGroup_Children();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Param <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param</em>'.
	 * @see dk.itu.chomsky.configurator.model.Param
	 * @generated
	 */
	EClass getParam();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.chomsky.configurator.model.Param#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see dk.itu.chomsky.configurator.model.Param#isOptional()
	 * @see #getParam()
	 * @generated
	 */
	EAttribute getParam_Optional();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.EnumType <em>Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Type</em>'.
	 * @see dk.itu.chomsky.configurator.model.EnumType
	 * @generated
	 */
	EClass getEnumType();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.chomsky.configurator.model.EnumType#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see dk.itu.chomsky.configurator.model.EnumType#getValues()
	 * @see #getEnumType()
	 * @generated
	 */
	EReference getEnumType_Values();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.EnumVal <em>Enum Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Val</em>'.
	 * @see dk.itu.chomsky.configurator.model.EnumVal
	 * @generated
	 */
	EClass getEnumVal();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.NamedElem <em>Named Elem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Elem</em>'.
	 * @see dk.itu.chomsky.configurator.model.NamedElem
	 * @generated
	 */
	EClass getNamedElem();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.chomsky.configurator.model.NamedElem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dk.itu.chomsky.configurator.model.NamedElem#getName()
	 * @see #getNamedElem()
	 * @generated
	 */
	EAttribute getNamedElem_Name();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.LabeledElem <em>Labeled Elem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labeled Elem</em>'.
	 * @see dk.itu.chomsky.configurator.model.LabeledElem
	 * @generated
	 */
	EClass getLabeledElem();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.chomsky.configurator.model.LabeledElem#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see dk.itu.chomsky.configurator.model.LabeledElem#getLabel()
	 * @see #getLabeledElem()
	 * @generated
	 */
	EAttribute getLabeledElem_Label();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ModelElem <em>Elem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Elem</em>'.
	 * @see dk.itu.chomsky.configurator.model.ModelElem
	 * @generated
	 */
	EClass getModelElem();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.PrimParam <em>Prim Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prim Param</em>'.
	 * @see dk.itu.chomsky.configurator.model.PrimParam
	 * @generated
	 */
	EClass getPrimParam();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.chomsky.configurator.model.PrimParam#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see dk.itu.chomsky.configurator.model.PrimParam#getType()
	 * @see #getPrimParam()
	 * @generated
	 */
	EAttribute getPrimParam_Type();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.EnumParam <em>Enum Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Param</em>'.
	 * @see dk.itu.chomsky.configurator.model.EnumParam
	 * @generated
	 */
	EClass getEnumParam();

	/**
	 * Returns the meta object for the reference '{@link dk.itu.chomsky.configurator.model.EnumParam#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see dk.itu.chomsky.configurator.model.EnumParam#getType()
	 * @see #getEnumParam()
	 * @generated
	 */
	EReference getEnumParam_Type();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see dk.itu.chomsky.configurator.model.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.chomsky.configurator.model.Constraint#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see dk.itu.chomsky.configurator.model.Constraint#getExpr()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Expr();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Expr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr</em>'.
	 * @see dk.itu.chomsky.configurator.model.Expr
	 * @generated
	 */
	EClass getExpr();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ConstNum <em>Const Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const Num</em>'.
	 * @see dk.itu.chomsky.configurator.model.ConstNum
	 * @generated
	 */
	EClass getConstNum();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.chomsky.configurator.model.ConstNum#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dk.itu.chomsky.configurator.model.ConstNum#getValue()
	 * @see #getConstNum()
	 * @generated
	 */
	EAttribute getConstNum_Value();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus</em>'.
	 * @see dk.itu.chomsky.configurator.model.Plus
	 * @generated
	 */
	EClass getPlus();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Minus <em>Minus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minus</em>'.
	 * @see dk.itu.chomsky.configurator.model.Minus
	 * @generated
	 */
	EClass getMinus();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Leq <em>Leq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leq</em>'.
	 * @see dk.itu.chomsky.configurator.model.Leq
	 * @generated
	 */
	EClass getLeq();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Geq <em>Geq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geq</em>'.
	 * @see dk.itu.chomsky.configurator.model.Geq
	 * @generated
	 */
	EClass getGeq();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Eq <em>Eq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eq</em>'.
	 * @see dk.itu.chomsky.configurator.model.Eq
	 * @generated
	 */
	EClass getEq();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Lt <em>Lt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lt</em>'.
	 * @see dk.itu.chomsky.configurator.model.Lt
	 * @generated
	 */
	EClass getLt();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Gt <em>Gt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gt</em>'.
	 * @see dk.itu.chomsky.configurator.model.Gt
	 * @generated
	 */
	EClass getGt();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ConstBool <em>Const Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const Bool</em>'.
	 * @see dk.itu.chomsky.configurator.model.ConstBool
	 * @generated
	 */
	EClass getConstBool();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.chomsky.configurator.model.ConstBool#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dk.itu.chomsky.configurator.model.ConstBool#isValue()
	 * @see #getConstBool()
	 * @generated
	 */
	EAttribute getConstBool_Value();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Mult <em>Mult</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mult</em>'.
	 * @see dk.itu.chomsky.configurator.model.Mult
	 * @generated
	 */
	EClass getMult();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.BinOp <em>Bin Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bin Op</em>'.
	 * @see dk.itu.chomsky.configurator.model.BinOp
	 * @generated
	 */
	EClass getBinOp();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.chomsky.configurator.model.BinOp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see dk.itu.chomsky.configurator.model.BinOp#getLeft()
	 * @see #getBinOp()
	 * @generated
	 */
	EReference getBinOp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.chomsky.configurator.model.BinOp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see dk.itu.chomsky.configurator.model.BinOp#getRight()
	 * @see #getBinOp()
	 * @generated
	 */
	EReference getBinOp_Right();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Div <em>Div</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Div</em>'.
	 * @see dk.itu.chomsky.configurator.model.Div
	 * @generated
	 */
	EClass getDiv();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see dk.itu.chomsky.configurator.model.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see dk.itu.chomsky.configurator.model.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ParamValueRef <em>Param Value Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Value Ref</em>'.
	 * @see dk.itu.chomsky.configurator.model.ParamValueRef
	 * @generated
	 */
	EClass getParamValueRef();

	/**
	 * Returns the meta object for the reference '{@link dk.itu.chomsky.configurator.model.ParamValueRef#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Param</em>'.
	 * @see dk.itu.chomsky.configurator.model.ParamValueRef#getParam()
	 * @see #getParamValueRef()
	 * @generated
	 */
	EReference getParamValueRef_Param();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ValueRef <em>Value Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Ref</em>'.
	 * @see dk.itu.chomsky.configurator.model.ValueRef
	 * @generated
	 */
	EClass getValueRef();

	/**
	 * Returns the meta object for the reference '{@link dk.itu.chomsky.configurator.model.ValueRef#getEnumVal <em>Enum Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enum Val</em>'.
	 * @see dk.itu.chomsky.configurator.model.ValueRef#getEnumVal()
	 * @see #getValueRef()
	 * @generated
	 */
	EReference getValueRef_EnumVal();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ConstString <em>Const String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const String</em>'.
	 * @see dk.itu.chomsky.configurator.model.ConstString
	 * @generated
	 */
	EClass getConstString();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.chomsky.configurator.model.ConstString#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dk.itu.chomsky.configurator.model.ConstString#getValue()
	 * @see #getConstString()
	 * @generated
	 */
	EAttribute getConstString_Value();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see dk.itu.chomsky.configurator.model.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.chomsky.configurator.model.Not#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see dk.itu.chomsky.configurator.model.Not#getExpr()
	 * @see #getNot()
	 * @generated
	 */
	EReference getNot_Expr();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.ITE <em>ITE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITE</em>'.
	 * @see dk.itu.chomsky.configurator.model.ITE
	 * @generated
	 */
	EClass getITE();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.chomsky.configurator.model.ITE#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see dk.itu.chomsky.configurator.model.ITE#getGuard()
	 * @see #getITE()
	 * @generated
	 */
	EReference getITE_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.chomsky.configurator.model.ITE#getTrueBranch <em>True Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>True Branch</em>'.
	 * @see dk.itu.chomsky.configurator.model.ITE#getTrueBranch()
	 * @see #getITE()
	 * @generated
	 */
	EReference getITE_TrueBranch();

	/**
	 * Returns the meta object for the containment reference '{@link dk.itu.chomsky.configurator.model.ITE#getFalseBranch <em>False Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>False Branch</em>'.
	 * @see dk.itu.chomsky.configurator.model.ITE#getFalseBranch()
	 * @see #getITE()
	 * @generated
	 */
	EReference getITE_FalseBranch();

	/**
	 * Returns the meta object for class '{@link dk.itu.chomsky.configurator.model.FunApp <em>Fun App</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fun App</em>'.
	 * @see dk.itu.chomsky.configurator.model.FunApp
	 * @generated
	 */
	EClass getFunApp();

	/**
	 * Returns the meta object for the attribute '{@link dk.itu.chomsky.configurator.model.FunApp#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dk.itu.chomsky.configurator.model.FunApp#getName()
	 * @see #getFunApp()
	 * @generated
	 */
	EAttribute getFunApp_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.itu.chomsky.configurator.model.FunApp#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Args</em>'.
	 * @see dk.itu.chomsky.configurator.model.FunApp#getArgs()
	 * @see #getFunApp()
	 * @generated
	 */
	EReference getFunApp_Args();

	/**
	 * Returns the meta object for enum '{@link dk.itu.chomsky.configurator.model.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type</em>'.
	 * @see dk.itu.chomsky.configurator.model.PrimitiveType
	 * @generated
	 */
	EEnum getPrimitiveType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ModelImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__CHILDREN = eINSTANCE.getModel_Children();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__TYPES = eINSTANCE.getModel_Types();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ModelChildImpl <em>Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ModelChildImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getModelChild()
		 * @generated
		 */
		EClass MODEL_CHILD = eINSTANCE.getModelChild();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ProductGroupImpl <em>Product Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ProductGroupImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getProductGroup()
		 * @generated
		 */
		EClass PRODUCT_GROUP = eINSTANCE.getProductGroup();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT_GROUP__CHILDREN = eINSTANCE.getProductGroup_Children();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ProductImpl <em>Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ProductImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT__CHILDREN = eINSTANCE.getProduct_Children();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT__CONSTRAINTS = eINSTANCE.getProduct_Constraints();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ProductChildImpl <em>Product Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ProductChildImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getProductChild()
		 * @generated
		 */
		EClass PRODUCT_CHILD = eINSTANCE.getProductChild();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ParamGroupImpl <em>Param Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ParamGroupImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getParamGroup()
		 * @generated
		 */
		EClass PARAM_GROUP = eINSTANCE.getParamGroup();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_GROUP__CHILDREN = eINSTANCE.getParamGroup_Children();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ParamImpl <em>Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ParamImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getParam()
		 * @generated
		 */
		EClass PARAM = eINSTANCE.getParam();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM__OPTIONAL = eINSTANCE.getParam_Optional();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.EnumTypeImpl <em>Enum Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.EnumTypeImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getEnumType()
		 * @generated
		 */
		EClass ENUM_TYPE = eINSTANCE.getEnumType();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_TYPE__VALUES = eINSTANCE.getEnumType_Values();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.EnumValImpl <em>Enum Val</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.EnumValImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getEnumVal()
		 * @generated
		 */
		EClass ENUM_VAL = eINSTANCE.getEnumVal();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.NamedElemImpl <em>Named Elem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.NamedElemImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getNamedElem()
		 * @generated
		 */
		EClass NAMED_ELEM = eINSTANCE.getNamedElem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEM__NAME = eINSTANCE.getNamedElem_Name();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.LabeledElemImpl <em>Labeled Elem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.LabeledElemImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getLabeledElem()
		 * @generated
		 */
		EClass LABELED_ELEM = eINSTANCE.getLabeledElem();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABELED_ELEM__LABEL = eINSTANCE.getLabeledElem_Label();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ModelElemImpl <em>Elem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ModelElemImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getModelElem()
		 * @generated
		 */
		EClass MODEL_ELEM = eINSTANCE.getModelElem();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.PrimParamImpl <em>Prim Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.PrimParamImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getPrimParam()
		 * @generated
		 */
		EClass PRIM_PARAM = eINSTANCE.getPrimParam();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIM_PARAM__TYPE = eINSTANCE.getPrimParam_Type();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.EnumParamImpl <em>Enum Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.EnumParamImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getEnumParam()
		 * @generated
		 */
		EClass ENUM_PARAM = eINSTANCE.getEnumParam();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_PARAM__TYPE = eINSTANCE.getEnumParam_Type();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ConstraintImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__EXPR = eINSTANCE.getConstraint_Expr();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ExprImpl <em>Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ExprImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getExpr()
		 * @generated
		 */
		EClass EXPR = eINSTANCE.getExpr();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ConstNumImpl <em>Const Num</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ConstNumImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getConstNum()
		 * @generated
		 */
		EClass CONST_NUM = eINSTANCE.getConstNum();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONST_NUM__VALUE = eINSTANCE.getConstNum_Value();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.PlusImpl <em>Plus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.PlusImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getPlus()
		 * @generated
		 */
		EClass PLUS = eINSTANCE.getPlus();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.MinusImpl <em>Minus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.MinusImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getMinus()
		 * @generated
		 */
		EClass MINUS = eINSTANCE.getMinus();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.LeqImpl <em>Leq</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.LeqImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getLeq()
		 * @generated
		 */
		EClass LEQ = eINSTANCE.getLeq();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.GeqImpl <em>Geq</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.GeqImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getGeq()
		 * @generated
		 */
		EClass GEQ = eINSTANCE.getGeq();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.EqImpl <em>Eq</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.EqImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getEq()
		 * @generated
		 */
		EClass EQ = eINSTANCE.getEq();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.LtImpl <em>Lt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.LtImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getLt()
		 * @generated
		 */
		EClass LT = eINSTANCE.getLt();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.GtImpl <em>Gt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.GtImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getGt()
		 * @generated
		 */
		EClass GT = eINSTANCE.getGt();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ConstBoolImpl <em>Const Bool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ConstBoolImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getConstBool()
		 * @generated
		 */
		EClass CONST_BOOL = eINSTANCE.getConstBool();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONST_BOOL__VALUE = eINSTANCE.getConstBool_Value();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.MultImpl <em>Mult</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.MultImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getMult()
		 * @generated
		 */
		EClass MULT = eINSTANCE.getMult();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.BinOpImpl <em>Bin Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.BinOpImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getBinOp()
		 * @generated
		 */
		EClass BIN_OP = eINSTANCE.getBinOp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIN_OP__LEFT = eINSTANCE.getBinOp_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIN_OP__RIGHT = eINSTANCE.getBinOp_Right();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.DivImpl <em>Div</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.DivImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getDiv()
		 * @generated
		 */
		EClass DIV = eINSTANCE.getDiv();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.AndImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.OrImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ParamValueRefImpl <em>Param Value Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ParamValueRefImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getParamValueRef()
		 * @generated
		 */
		EClass PARAM_VALUE_REF = eINSTANCE.getParamValueRef();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_VALUE_REF__PARAM = eINSTANCE.getParamValueRef_Param();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ValueRefImpl <em>Value Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ValueRefImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getValueRef()
		 * @generated
		 */
		EClass VALUE_REF = eINSTANCE.getValueRef();

		/**
		 * The meta object literal for the '<em><b>Enum Val</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_REF__ENUM_VAL = eINSTANCE.getValueRef_EnumVal();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ConstStringImpl <em>Const String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ConstStringImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getConstString()
		 * @generated
		 */
		EClass CONST_STRING = eINSTANCE.getConstString();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONST_STRING__VALUE = eINSTANCE.getConstString_Value();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.NotImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT__EXPR = eINSTANCE.getNot_Expr();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.ITEImpl <em>ITE</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.ITEImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getITE()
		 * @generated
		 */
		EClass ITE = eINSTANCE.getITE();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITE__GUARD = eINSTANCE.getITE_Guard();

		/**
		 * The meta object literal for the '<em><b>True Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITE__TRUE_BRANCH = eINSTANCE.getITE_TrueBranch();

		/**
		 * The meta object literal for the '<em><b>False Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITE__FALSE_BRANCH = eINSTANCE.getITE_FalseBranch();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.impl.FunAppImpl <em>Fun App</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.impl.FunAppImpl
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getFunApp()
		 * @generated
		 */
		EClass FUN_APP = eINSTANCE.getFunApp();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUN_APP__NAME = eINSTANCE.getFunApp_Name();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUN_APP__ARGS = eINSTANCE.getFunApp_Args();

		/**
		 * The meta object literal for the '{@link dk.itu.chomsky.configurator.model.PrimitiveType <em>Primitive Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.itu.chomsky.configurator.model.PrimitiveType
		 * @see dk.itu.chomsky.configurator.model.impl.ModelPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

	}

} //ModelPackage
