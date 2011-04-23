package integration.metropeeps.com

import static org.junit.Assert.*
import grails.test.*

import org.joda.time.DateTime
import org.junit.After
import org.junit.Test

import com.metropeeps.Event
import com.metropeeps.User


class UserTests {
	def testEmail = "test@metropeeps.com"
	def altEmail = "testy@metropeeps.com"
	def testPassword = "superSecret"
	def eventTitle = "UserTestsEventTitle"

	@After
	void tearDown() {
		User.findAllByEmailOrEmail(testEmail, altEmail).each { u -> u.delete(flush:true) }
		Event.findAllByTitle(eventTitle).each { e -> e.delete(flush:true) }
	}

	@Test
	void test_user_lifecycle() {
		// create and save a new user
		def original = new User(email:testEmail, password:testPassword)
		original.save(flush:true)
		def actual = User.findByEmail(testEmail)
		assertTrue "Users should be identical", original == actual

		// modify and re-save the user
		original.email = altEmail
		original.save(flush:true)
		actual = User.findByEmail(altEmail)
		assertTrue "Modified users should be identical", original == actual

		// delete the original user
		original.delete(flush:true)
		actual = User.findByEmail(testEmail)
		assertNull "User should be deleted", actual
	}

	@Test
	void test_email_constraints(){
		// validate good email
		def user = new User(email:"test@metropeeps.com", password:testPassword)
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

	@Test
	void test_add_remove_Event() {
		def owner = new User(email:testEmail, password:"password")
		def member = new User(email:altEmail, password:"password")
		def event = new Event(owner: owner,
				title: eventTitle,
				start: new DateTime(),
				end: new DateTime())
		owner.save(flush:true)
		event.save(flush:true)
		member.save(flush:true)
		member.registerFor(event)

		def events = member.registeredEvents()
		assertNotNull "Member events should not be null", events
		assertFalse "Member events should not be empty", events.isEmpty()
		assertTrue "Member should be associated to the event", events.contains(event)

		member.unregisterFrom(event)
		events = member.registeredEvents()
		assertNotNull "Member events should not be null", events
		assertTrue "Member events should be emtpy", events.isEmpty()
	}
}
