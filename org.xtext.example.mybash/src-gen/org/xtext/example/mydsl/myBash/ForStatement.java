/**
 * generated by Xtext 2.9.2
 */
package org.xtext.example.mydsl.myBash;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myBash.ForStatement#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myBash.ForStatement#getWords <em>Words</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myBash.ForStatement#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myBash.MyBashPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends ShellCommand
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' attribute.
   * @see #setVariable(String)
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getForStatement_Variable()
   * @model
   * @generated
   */
  String getVariable();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myBash.ForStatement#getVariable <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' attribute.
   * @see #getVariable()
   * @generated
   */
  void setVariable(String value);

  /**
   * Returns the value of the '<em><b>Words</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myBash.Word}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Words</em>' containment reference list.
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getForStatement_Words()
   * @model containment="true"
   * @generated
   */
  EList<Word> getWords();

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(CompoundList)
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getForStatement_Body()
   * @model containment="true"
   * @generated
   */
  CompoundList getBody();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myBash.ForStatement#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(CompoundList value);

} // ForStatement
