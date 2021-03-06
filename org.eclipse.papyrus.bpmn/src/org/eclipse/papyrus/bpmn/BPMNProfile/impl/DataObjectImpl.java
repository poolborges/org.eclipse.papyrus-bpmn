/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataObject;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataState;
import org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectImpl#getDataState <em>Data State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectImpl#getBase_TypedElement <em>Base Typed Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectImpl#getItemSubjectRef <em>Item Subject Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectImpl#isCollection <em>Is Collection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectImpl#getBase_DataStoreNode <em>Base Data Store Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataObjectImpl extends FlowElementImpl implements DataObject {
	/**
	 * The cached value of the '{@link #getDataState() <em>Data State</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataState()
	 * @generated
	 * @ordered
	 */
	protected EList<DataState> dataState;

	/**
	 * The cached value of the '{@link #getBase_TypedElement() <em>Base Typed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_TypedElement()
	 * @generated
	 * @ordered
	 */
	protected TypedElement base_TypedElement;

	/**
	 * The cached value of the '{@link #getItemSubjectRef() <em>Item Subject Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemSubjectRef()
	 * @generated
	 * @ordered
	 */
	protected ItemDefinition itemSubjectRef;

	/**
	 * The default value of the '{@link #isCollection() <em>Is Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COLLECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCollection() <em>Is Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollection()
	 * @generated
	 * @ordered
	 */
	protected boolean isCollection = IS_COLLECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_DataStoreNode() <em>Base Data Store Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DataStoreNode()
	 * @generated
	 * @ordered
	 */
	protected DataStoreNode base_DataStoreNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getDataObject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataState> getDataState() {
		if (dataState == null) {
			dataState = new EObjectResolvingEList<DataState>(DataState.class, this, BPMNProfilePackage.DATA_OBJECT__DATA_STATE);
		}
		return dataState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement getBase_TypedElement() {
		if (base_TypedElement != null && base_TypedElement.eIsProxy()) {
			InternalEObject oldBase_TypedElement = (InternalEObject)base_TypedElement;
			base_TypedElement = (TypedElement)eResolveProxy(oldBase_TypedElement);
			if (base_TypedElement != oldBase_TypedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_OBJECT__BASE_TYPED_ELEMENT, oldBase_TypedElement, base_TypedElement));
			}
		}
		return base_TypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement basicGetBase_TypedElement() {
		return base_TypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_TypedElement(TypedElement newBase_TypedElement) {
		TypedElement oldBase_TypedElement = base_TypedElement;
		base_TypedElement = newBase_TypedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_OBJECT__BASE_TYPED_ELEMENT, oldBase_TypedElement, base_TypedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemDefinition getItemSubjectRef() {
		if (itemSubjectRef != null && itemSubjectRef.eIsProxy()) {
			InternalEObject oldItemSubjectRef = (InternalEObject)itemSubjectRef;
			itemSubjectRef = (ItemDefinition)eResolveProxy(oldItemSubjectRef);
			if (itemSubjectRef != oldItemSubjectRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_OBJECT__ITEM_SUBJECT_REF, oldItemSubjectRef, itemSubjectRef));
			}
		}
		return itemSubjectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemDefinition basicGetItemSubjectRef() {
		return itemSubjectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemSubjectRef(ItemDefinition newItemSubjectRef) {
		ItemDefinition oldItemSubjectRef = itemSubjectRef;
		itemSubjectRef = newItemSubjectRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_OBJECT__ITEM_SUBJECT_REF, oldItemSubjectRef, itemSubjectRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCollection() {
		return isCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCollection(boolean newIsCollection) {
		boolean oldIsCollection = isCollection;
		isCollection = newIsCollection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_OBJECT__IS_COLLECTION, oldIsCollection, isCollection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStoreNode getBase_DataStoreNode() {
		if (base_DataStoreNode != null && base_DataStoreNode.eIsProxy()) {
			InternalEObject oldBase_DataStoreNode = (InternalEObject)base_DataStoreNode;
			base_DataStoreNode = (DataStoreNode)eResolveProxy(oldBase_DataStoreNode);
			if (base_DataStoreNode != oldBase_DataStoreNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_OBJECT__BASE_DATA_STORE_NODE, oldBase_DataStoreNode, base_DataStoreNode));
			}
		}
		return base_DataStoreNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStoreNode basicGetBase_DataStoreNode() {
		return base_DataStoreNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_DataStoreNode(DataStoreNode newBase_DataStoreNode) {
		DataStoreNode oldBase_DataStoreNode = base_DataStoreNode;
		base_DataStoreNode = newBase_DataStoreNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_OBJECT__BASE_DATA_STORE_NODE, oldBase_DataStoreNode, base_DataStoreNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ItemAwareElementdataState(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.ITEM_AWARE_ELEMENT__ITEM_AWARE_ELEMENTDATA_STATE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ItemAwareElementdataState", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean DataObjectdataState(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.DATA_OBJECT__DATA_OBJECTDATA_STATE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataObjectdataState", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.DATA_OBJECT__DATA_STATE:
				return getDataState();
			case BPMNProfilePackage.DATA_OBJECT__BASE_TYPED_ELEMENT:
				if (resolve) return getBase_TypedElement();
				return basicGetBase_TypedElement();
			case BPMNProfilePackage.DATA_OBJECT__ITEM_SUBJECT_REF:
				if (resolve) return getItemSubjectRef();
				return basicGetItemSubjectRef();
			case BPMNProfilePackage.DATA_OBJECT__IS_COLLECTION:
				return isCollection();
			case BPMNProfilePackage.DATA_OBJECT__BASE_DATA_STORE_NODE:
				if (resolve) return getBase_DataStoreNode();
				return basicGetBase_DataStoreNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BPMNProfilePackage.DATA_OBJECT__DATA_STATE:
				getDataState().clear();
				getDataState().addAll((Collection<? extends DataState>)newValue);
				return;
			case BPMNProfilePackage.DATA_OBJECT__BASE_TYPED_ELEMENT:
				setBase_TypedElement((TypedElement)newValue);
				return;
			case BPMNProfilePackage.DATA_OBJECT__ITEM_SUBJECT_REF:
				setItemSubjectRef((ItemDefinition)newValue);
				return;
			case BPMNProfilePackage.DATA_OBJECT__IS_COLLECTION:
				setIsCollection((Boolean)newValue);
				return;
			case BPMNProfilePackage.DATA_OBJECT__BASE_DATA_STORE_NODE:
				setBase_DataStoreNode((DataStoreNode)newValue);
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
			case BPMNProfilePackage.DATA_OBJECT__DATA_STATE:
				getDataState().clear();
				return;
			case BPMNProfilePackage.DATA_OBJECT__BASE_TYPED_ELEMENT:
				setBase_TypedElement((TypedElement)null);
				return;
			case BPMNProfilePackage.DATA_OBJECT__ITEM_SUBJECT_REF:
				setItemSubjectRef((ItemDefinition)null);
				return;
			case BPMNProfilePackage.DATA_OBJECT__IS_COLLECTION:
				setIsCollection(IS_COLLECTION_EDEFAULT);
				return;
			case BPMNProfilePackage.DATA_OBJECT__BASE_DATA_STORE_NODE:
				setBase_DataStoreNode((DataStoreNode)null);
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
			case BPMNProfilePackage.DATA_OBJECT__DATA_STATE:
				return dataState != null && !dataState.isEmpty();
			case BPMNProfilePackage.DATA_OBJECT__BASE_TYPED_ELEMENT:
				return base_TypedElement != null;
			case BPMNProfilePackage.DATA_OBJECT__ITEM_SUBJECT_REF:
				return itemSubjectRef != null;
			case BPMNProfilePackage.DATA_OBJECT__IS_COLLECTION:
				return isCollection != IS_COLLECTION_EDEFAULT;
			case BPMNProfilePackage.DATA_OBJECT__BASE_DATA_STORE_NODE:
				return base_DataStoreNode != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ItemAwareElement.class) {
			switch (derivedFeatureID) {
				case BPMNProfilePackage.DATA_OBJECT__DATA_STATE: return BPMNProfilePackage.ITEM_AWARE_ELEMENT__DATA_STATE;
				case BPMNProfilePackage.DATA_OBJECT__BASE_TYPED_ELEMENT: return BPMNProfilePackage.ITEM_AWARE_ELEMENT__BASE_TYPED_ELEMENT;
				case BPMNProfilePackage.DATA_OBJECT__ITEM_SUBJECT_REF: return BPMNProfilePackage.ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ItemAwareElement.class) {
			switch (baseFeatureID) {
				case BPMNProfilePackage.ITEM_AWARE_ELEMENT__DATA_STATE: return BPMNProfilePackage.DATA_OBJECT__DATA_STATE;
				case BPMNProfilePackage.ITEM_AWARE_ELEMENT__BASE_TYPED_ELEMENT: return BPMNProfilePackage.DATA_OBJECT__BASE_TYPED_ELEMENT;
				case BPMNProfilePackage.ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF: return BPMNProfilePackage.DATA_OBJECT__ITEM_SUBJECT_REF;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ItemAwareElement.class) {
			switch (baseOperationID) {
				case BPMNProfilePackage.ITEM_AWARE_ELEMENT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP: return BPMNProfilePackage.DATA_OBJECT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BPMNProfilePackage.DATA_OBJECT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP:
				return ItemAwareElementdataState((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.DATA_OBJECT___DATA_OBJECTDATA_STATE__DIAGNOSTICCHAIN_MAP:
				return DataObjectdataState((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isCollection: ");
		result.append(isCollection);
		result.append(')');
		return result.toString();
	}

} //DataObjectImpl
