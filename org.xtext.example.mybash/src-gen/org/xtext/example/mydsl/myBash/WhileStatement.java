/**
 * generated by Xtext 2.9.2
 */
package org.xtext.example.mydsl.myBash;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myBash.WhileStatement#getC <em>C</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myBash.WhileStatement#getD <em>D</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myBash.MyBashPackage#getWhileStatement()
 * @model
 * @generated
 */
public interface WhileStatement extends ShellCommand
{
  /**
   * Returns the value of the '<em><b>C</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>C</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>C</em>' containment reference.
   * @see #setC(CompoundList)
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getWhileStatement_C()
   * @model containment="true"
   * @generated
   */
  CompoundList getC();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myBash.WhileStatement#getC <em>C</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>C</em>' containment reference.
   * @see #getC()
   * @generated
   */
  void setC(CompoundList value);

  /**
   * Returns the value of the '<em><b>D</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>D</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>D</em>' containment reference.
   * @see #setD(CompoundList)
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getWhileStatement_D()
   * @model containment="true"
   * @generated
   */
  CompoundList getD();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myBash.WhileStatement#getD <em>D</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>D</em>' containment reference.
   * @see #getD()
   * @generated
   */
  void setD(CompoundList value);

} // WhileStatement