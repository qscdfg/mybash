/**
 * generated by Xtext 2.9.2
 */
package org.xtext.example.mydsl.myBash;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myBash.GroupCommand#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myBash.MyBashPackage#getGroupCommand()
 * @model
 * @generated
 */
public interface GroupCommand extends ShellCommand
{
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
   * @see org.xtext.example.mydsl.myBash.MyBashPackage#getGroupCommand_Body()
   * @model containment="true"
   * @generated
   */
  CompoundList getBody();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myBash.GroupCommand#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(CompoundList value);

} // GroupCommand