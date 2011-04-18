package integration.metropeeps.com

import grails.test.*

import com.metropeeps.User

class UserTests extends GroovyTestCase {
	def testEmail = "test@metropeeps.com"
	def modifiedEmail = "testy@metropeeps.com"
	
	void tearDown() {
		User.findAllByEmailOrEmail(testEmail, modifiedEmail).each { u -> u.delete(flush:true) }
	}

	void test_user_lifecycle() {
		// create and save a new user
		def original = new User(email: testEmail)
		original.save(flush:true)
		def actual = User.findByEmail(testEmail)
		assertTrue "Users should be identical", original == actual
		
		// try re-saving
		original.save(flush:true)
		def allActual = User.findAllByEmail(testEmail)
		assertEquals "Only 1 user should be saved", 1, allActual.size()
		assertTrue "Users should still be identical", original == actual
		
		// modify and re-save the user
		original.email = modifiedEmail
		original.save(flush:true)
		actual = User.findByEmail(modifiedEmail)
		assertTrue "Modified users should be identical", original == actual
		
		// delete the original user
		original.delete(flush:true)
		actual = User.findByEmail(testEmail)
		assertNull "User should be deleted", actual
	}
	
	void test_email_constraints(){
		// validate good email
		def user = new User(email: "test@metropeeps.com")
		assertTrue user.validate()
		
		// invalid domain
		user.email = "test@metropeeps"
		assertFalse user.validate()
		
		// invalid @
		user.email = "test#metropeeps.com"
		assertFalse user.validate()
		
		// invalid local part
		user.email = "integration;test@metropeeps.com"
		assertFalse user.validate()
	}
}
