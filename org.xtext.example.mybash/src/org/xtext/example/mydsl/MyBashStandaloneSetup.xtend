/*
 * generated by Xtext 2.9.1
 */
package org.xtext.example.mydsl


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class MyBashStandaloneSetup extends MyBashStandaloneSetupGenerated {

	def static void doSetup() {
		new MyBashStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
