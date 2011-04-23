package unit.com.metropeeps

import grails.test.*

import org.joda.time.DateTime
import org.junit.Test

import com.metropeeps.Event
import com.metropeeps.User

class EventTests extends GrailsUnitTestCase {
	
	@Test
	void test_equals() {
		DateTime start = new DateTime()
		DateTime end = new DateTime()
		
		def event1 = new Event(owner: new User(),
				title: "Test Title",
				start: start,
				end: end)
		assertTrue "Event should be equal to itself", event1 == event1

		def event2 = new Event(owner: new User(),
				title: "Test Title",
				start: start,
				end: end)
		assertTrue "Events should be equal", event1 == event2

		// modify event2 so it is not equal
		event2.title = "Different Test Title"
		assertTrue "Events should NOT be equals", event1 != event2
	}

	@Test
	void test_hashCode() {
		DateTime start = new DateTime()
		DateTime end = new DateTime()
		
		def event1 = new Event(owner: new User(),
				title: "Test Title",
				start: start,
				end: end)
		assertTrue "Event hash code should be equal to itself", event1.hashCode() == event1.hashCode()

		def event2 = new Event(owner: new User(),
				title: "Test Title",
				start: start,
				end: end)
		assertTrue "Events hash codes should be equal", event1.hashCode() == event2.hashCode()

		// modify event2 so it is not equal
		event2.title = "Different Test Title"
		assertTrue "Events hash codes should NOT be equals", event1.hashCode() != event2.hashCode()
	}
}
