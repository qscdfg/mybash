/**
 * generated by Xtext 2.9.2
 */
package org.xtext.example.mydsl.myBash.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.example.mydsl.myBash.CommandUnit;
import org.xtext.example.mydsl.myBash.MyBashPackage;
import org.xtext.example.mydsl.myBash.PipelineCommand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myBash.impl.PipelineCommandImpl#isNot <em>Not</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myBash.impl.PipelineCommandImpl#getPipeline <em>Pipeline</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PipelineCommandImpl extends CommandUnitImpl implements PipelineCommand
{
  /**
   * The default value of the '{@link #isNot() <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNot()
   * @generated
   * @ordered
   */
  protected static final boolean NOT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNot() <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNot()
   * @generated
   * @ordered
   */
  protected boolean not = NOT_EDEFAULT;

  /**
   * The cached value of the '{@link #getPipeline() <em>Pipeline</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPipeline()
   * @generated
   * @ordered
   */
  protected CommandUnit pipeline;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PipelineCommandImpl()
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
    return MyBashPackage.Literals.PIPELINE_COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNot()
  {
    return not;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNot(boolean newNot)
  {
    boolean oldNot = not;
    not = newNot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyBashPackage.PIPELINE_COMMAND__NOT, oldNot, not));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandUnit getPipeline()
  {
    return pipeline;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPipeline(CommandUnit newPipeline, NotificationChain msgs)
  {
    CommandUnit oldPipeline = pipeline;
    pipeline = newPipeline;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyBashPackage.PIPELINE_COMMAND__PIPELINE, oldPipeline, newPipeline);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPipeline(CommandUnit newPipeline)
  {
    if (newPipeline != pipeline)
    {
      NotificationChain msgs = null;
      if (pipeline != null)
        msgs = ((InternalEObject)pipeline).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyBashPackage.PIPELINE_COMMAND__PIPELINE, null, msgs);
      if (newPipeline != null)
        msgs = ((InternalEObject)newPipeline).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyBashPackage.PIPELINE_COMMAND__PIPELINE, null, msgs);
      msgs = basicSetPipeline(newPipeline, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyBashPackage.PIPELINE_COMMAND__PIPELINE, newPipeline, newPipeline));
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
      case MyBashPackage.PIPELINE_COMMAND__PIPELINE:
        return basicSetPipeline(null, msgs);
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
      case MyBashPackage.PIPELINE_COMMAND__NOT:
        return isNot();
      case MyBashPackage.PIPELINE_COMMAND__PIPELINE:
        return getPipeline();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyBashPackage.PIPELINE_COMMAND__NOT:
        setNot((Boolean)newValue);
        return;
      case MyBashPackage.PIPELINE_COMMAND__PIPELINE:
        setPipeline((CommandUnit)newValue);
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
      case MyBashPackage.PIPELINE_COMMAND__NOT:
        setNot(NOT_EDEFAULT);
        return;
      case MyBashPackage.PIPELINE_COMMAND__PIPELINE:
        setPipeline((CommandUnit)null);
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
      case MyBashPackage.PIPELINE_COMMAND__NOT:
        return not != NOT_EDEFAULT;
      case MyBashPackage.PIPELINE_COMMAND__PIPELINE:
        return pipeline != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (not: ");
    result.append(not);
    result.append(')');
    return result.toString();
  }

} //PipelineCommandImpl