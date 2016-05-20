/**
 * generated by Xtext 2.9.2
 */
package org.xtext.example.mydsl.myBash;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myBash.VariableId#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myBash.MyBashPackage#getVariableId()
 * @model
 * @generated
 */
public interface VariableId extends Expression
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Assignment)
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getVariableId_Ref()
   * @model
   * @generated
   */
  Assignment getRef();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myBash.VariableId#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Assignment value);

} // VariableId
