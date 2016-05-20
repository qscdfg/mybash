/**
 * generated by Xtext 2.9.2
 */
package org.xtext.example.mydsl.myBash;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myBash.CaseStatement#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myBash.CaseStatement#getPatterns <em>Patterns</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myBash.MyBashPackage#getCaseStatement()
 * @model
 * @generated
 */
public interface CaseStatement extends ShellCommand
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(Word)
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getCaseStatement_Variable()
   * @model containment="true"
   * @generated
   */
  Word getVariable();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myBash.CaseStatement#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(Word value);

  /**
   * Returns the value of the '<em><b>Patterns</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myBash.CasePattern}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Patterns</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Patterns</em>' containment reference list.
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getCaseStatement_Patterns()
   * @model containment="true"
   * @generated
   */
  EList<CasePattern> getPatterns();

} // CaseStatement