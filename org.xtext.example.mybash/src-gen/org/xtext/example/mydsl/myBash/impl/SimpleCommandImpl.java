/**
 * generated by Xtext 2.9.2
 */
package org.xtext.example.mydsl.myBash.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.myBash.Assignment;
import org.xtext.example.mydsl.myBash.MyBashPackage;
import org.xtext.example.mydsl.myBash.Redirection;
import org.xtext.example.mydsl.myBash.SimpleCommand;
import org.xtext.example.mydsl.myBash.Word;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myBash.impl.SimpleCommandImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myBash.impl.SimpleCommandImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myBash.impl.SimpleCommandImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myBash.impl.SimpleCommandImpl#getR <em>R</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleCommandImpl extends CommandUnitImpl implements SimpleCommand
{
  /**
   * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignments()
   * @generated
   * @ordered
   */
  protected EList<Assignment> assignments;

  /**
   * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommand()
   * @generated
   * @ordered
   */
  protected Word command;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<EObject> parameters;

  /**
   * The cached value of the '{@link #getR() <em>R</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getR()
   * @generated
   * @ordered
   */
  protected EList<Redirection> r;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleCommandImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyBashPackage.Literals.SIMPLE_COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Assignment> getAssignments()
  {
    if (assignments == null)
    {
      assignments = new EObjectContainmentEList<Assignment>(Assignment.class, this, MyBashPackage.SIMPLE_COMMAND__ASSIGNMENTS);
    }
    return assignments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Word getCommand()
  {
    return command;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCommand(Word newCommand, NotificationChain msgs)
  {
    Word oldCommand = command;
    command = newCommand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyBashPackage.SIMPLE_COMMAND__COMMAND, oldCommand, newCommand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCommand(Word newCommand)
  {
    if (newCommand != command)
    {
      NotificationChain msgs = null;
      if (command != null)
        msgs = ((InternalEObject)command).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyBashPackage.SIMPLE_COMMAND__COMMAND, null, msgs);
      if (newCommand != null)
        msgs = ((InternalEObject)newCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyBashPackage.SIMPLE_COMMAND__COMMAND, null, msgs);
      msgs = basicSetCommand(newCommand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyBashPackage.SIMPLE_COMMAND__COMMAND, newCommand, newCommand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<EObject>(EObject.class, this, MyBashPackage.SIMPLE_COMMAND__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Redirection> getR()
  {
    if (r == null)
    {
      r = new EObjectContainmentEList<Redirection>(Redirection.class, this, MyBashPackage.SIMPLE_COMMAND__R);
    }
    return r;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyBashPackage.SIMPLE_COMMAND__ASSIGNMENTS:
        return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
      case MyBashPackage.SIMPLE_COMMAND__COMMAND:
        return basicSetCommand(null, msgs);
      case MyBashPackage.SIMPLE_COMMAND__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case MyBashPackage.SIMPLE_COMMAND__R:
        return ((InternalEList<?>)getR()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyBashPackage.SIMPLE_COMMAND__ASSIGNMENTS:
        return getAssignments();
      case MyBashPackage.SIMPLE_COMMAND__COMMAND:
        return getCommand();
      case MyBashPackage.SIMPLE_COMMAND__PARAMETERS:
        return getParameters();
      case MyBashPackage.SIMPLE_COMMAND__R:
        return getR();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyBashPackage.SIMPLE_COMMAND__ASSIGNMENTS:
        getAssignments().clear();
        getAssignments().addAll((Collection<? extends Assignment>)newValue);
        return;
      case MyBashPackage.SIMPLE_COMMAND__COMMAND:
        setCommand((Word)newValue);
        return;
      case MyBashPackage.SIMPLE_COMMAND__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends EObject>)newValue);
        return;
      case MyBashPackage.SIMPLE_COMMAND__R:
        getR().clear();
        getR().addAll((Collection<? extends Redirection>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyBashPackage.SIMPLE_COMMAND__ASSIGNMENTS:
        getAssignments().clear();
        return;
      case MyBashPackage.SIMPLE_COMMAND__COMMAND:
        setCommand((Word)null);
        return;
      case MyBashPackage.SIMPLE_COMMAND__PARAMETERS:
        getParameters().clear();
        return;
      case MyBashPackage.SIMPLE_COMMAND__R:
        getR().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyBashPackage.SIMPLE_COMMAND__ASSIGNMENTS:
        return assignments != null && !assignments.isEmpty();
      case MyBashPackage.SIMPLE_COMMAND__COMMAND:
        return command != null;
      case MyBashPackage.SIMPLE_COMMAND__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case MyBashPackage.SIMPLE_COMMAND__R:
        return r != null && !r.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SimpleCommandImpl
