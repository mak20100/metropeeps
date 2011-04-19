package integration.metropeeps.com

import static org.junit.Assert.*
import grails.test.*

import org.joda.time.LocalDate
import org.joda.time.LocalTime
import org.junit.After
import org.junit.Before
import org.junit.Test

import com.metropeeps.Event
import com.metropeeps.Profile
import com.metropeeps.User

class EventTests {

	User testUser;

	@Before
	public void setUp() {
		testUser = User.list()[0]
	}

	@After
	public void tearDown() {
		Event.findAllByOwner(testUser).each { e -> e.delete(flush:true) }
	}

	@Test
	void test_event_lifecycle() {
		// create and save event
		def e1 = new Event(
				owner:testUser,
				title:"Test Event",
				description:"Super Special Event",
				date:new LocalDate().plusDays(2),
				startTime:new LocalTime().plusHours(2),
				endTime:new LocalTime().plusHours(4))
		e1.save(flush:true)

		// verify the save
		def actual = Event.findAllByOwner(testUser)
		assertNotNull "Event should be saved", actual
		assertTrue "Event that was saved should be found", actual.contains(e1)
		
		// modify and re-save
		e1.startTime = new LocalTime().minusHours(2)
		e1.save(flush:true)
		actual = Event.findAllByOwner(testUser)
		assertNotNull "Modified Event should be saved", actual
		assertTrue "Event that was saved should be found", actual.contains(e1) 
		
		// delete the event
		e1.delete(flush:true)
		actual = Event.findAllByOwner(testUser)
		assertFalse "Event that was saved should be found", actual?.contains(e1)
	}
}
