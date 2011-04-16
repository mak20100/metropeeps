package com.metropeeps

import grails.test.*

/**
 * Test the {@link User} domain
 */
class UserTests extends GrailsUnitTestCase {
	void test_toString() {
		def user = new User(email: "test@metropeeps.com", firstName: "Unit", lastName: "Test")
		assertEquals "Unit Test - test@metropeeps.com", user.toString()
	}

	void test_equals() {
		def user1 = new User(email: "test@metropeeps.com", firstName: "Unit", lastName: "Test")
		assertTrue "User should be equal to itself", user1 == user1

		def user2 = new User(email: "test@metropeeps.com", firstName: "Unit", lastName: "Test")
		assertTrue "Users should be equal", user1 == user2

		// modify user2 so it is not equal
		user2.lastName = "Testy"
		assertTrue "Users should NOT be equals",  user1 != user2
	}

	void test_hashCode() {
		def user1 = new User(email: "test@metropeeps.com", firstName: "Unit", lastName: "Test")
		assertEquals "User's hash code should equal itself", user1.hashCode(), user1.hashCode()

		def user2 = new User(email: "test@metropeeps.com", firstName: "Unit", lastName: "Test")
		assertEquals "Users should have the same hash code", user1.hashCode(), user2.hashCode()

		// modify user2 so it is not equal
		user2.lastName = "Testy"
		assertFalse "Users should NOT have the same hash code", user1.hashCode() == user2.hashCode()
	}
}
