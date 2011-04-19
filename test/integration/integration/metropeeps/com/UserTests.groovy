package integration.metropeeps.com

import static org.junit.Assert.*
import grails.test.*

import org.junit.After
import org.junit.Test

import com.metropeeps.User

class UserTests {
	def testEmail = "test@metropeeps.com"
	def modifiedEmail = "testy@metropeeps.com"

	@After
	void tearDown() {
		User.findAllByEmailOrEmail(testEmail, modifiedEmail).each { u -> u.delete(flush:true) }
	}

	@Test
	void test_user_lifecycle() {
		// create and save a new user
		def original = new User(email: testEmail)
		original.save(flush:true)
		def actual = User.findByEmail(testEmail)
		assertTrue "Users should be identical", original == actual

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

	@Test
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
