package unit.com.metropeeps

import static org.junit.Assert.*
import grails.test.*

import org.junit.Test

import com.metropeeps.User

/**
 * Test the {@link User} domain
 */
class UserTests {
	
	@Test
	void test_equals() {
		def user1 = new User(email: "test@metropeeps.com")
		assertTrue "User should be equal to itself", user1 == user1

		def user2 = new User(email: "test@metropeeps.com")
		assertTrue "Users should be equal", user1 == user2

		// modify user2 so it is not equal
		user2.email = "testy@metropeeps.com"
		assertTrue "Users should NOT be equals",  user1 != user2
	}

	@Test
	void test_hashCode() {
		def user1 = new User(email: "test@metropeeps.com")
		assertEquals "User's hash code should equal itself", user1.hashCode(), user1.hashCode()

		def user2 = new User(email: "test@metropeeps.com")
		assertEquals "Users should have the same hash code", user1.hashCode(), user2.hashCode()

		// modify user2 so it is not equal
		user2.email = "testy@metropeeps.com"
		assertFalse "Users should NOT have the same hash code", user1.hashCode() == user2.hashCode()
	}
}
