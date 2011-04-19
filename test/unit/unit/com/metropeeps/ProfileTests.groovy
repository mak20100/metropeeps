package unit.com.metropeeps

import static org.junit.Assert.*
import grails.test.*

import org.junit.Test

import com.metropeeps.Profile

class ProfileTests {

	@Test
	void test_equals() {
		def profile1 = new Profile(firstName: "metro", lastName: "peeps")
		assertTrue "Profile should be equal to itself", profile1 == profile1

		def profile2 = new Profile(firstName: "metro", lastName: "peeps")
		assertTrue "Profiles should be equal", profile1 == profile2

		// modify profile2 so it is not equal
		profile2.nickName = "sparky"
		assertTrue "Profiles should NOT be equals",  profile1 != profile2
	}

	@Test
	void test_hashCode() {
		def profile1 = new Profile(firstName: "metro", lastName: "peeps")
		assertEquals "Profiles's hash code should equal itself", profile1.hashCode(), profile1.hashCode()

		def profile2 = new Profile(firstName: "metro", lastName: "peeps")
		assertEquals "Profiles should have the same hash code", profile1.hashCode(), profile2.hashCode()

		// modify profile2 so it is not equal
		profile2.nickName = "sparky"
		assertFalse "Profiles should NOT have the same hash code", profile1.hashCode() == profile2.hashCode()
	}
}
