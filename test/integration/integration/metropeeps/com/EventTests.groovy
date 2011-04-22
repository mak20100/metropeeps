package integration.metropeeps.com

import static org.junit.Assert.*
import grails.test.*


import org.joda.time.LocalDate
import org.joda.time.LocalTime
import org.junit.After
import org.junit.Before
import org.junit.Test

import com.metropeeps.Event;
import com.metropeeps.Profile;
import com.metropeeps.User;


class EventTests {

	User testUser, altTestUser;
	String eventTitle = "EventTestsTitle"

	@Before
	public void setUp() {
		def users = User.list()
		
		testUser = users[0]
		altTestUser = users[1]
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
	
//	@Test
//	void test_addToEvent() {
//		def owner = testUser
//		def member = altTestUser
//		def event = new Event(owner: owner,
//				title: eventTitle,
//				date: new LocalDate(),
//				startTime: new LocalTime(),
//				endTime: new LocalTime())
//		owner.save(flush:true)
//		event.save(flush:true)
//		member.save(flush:true)
//		event.addToMembership(member)
//		
//		def eventMembers = event.eventMembership()
//		assertNotNull "Event members should not be null", eventMembers
//		assertFalse "Event members should not be empty", eventMembers.isEmpty()
//		assertTrue "Event members should be associated to the member", eventMembers.contains(member)
//		
//		event.removeFromMembership(member)
//		eventMembers = event.eventMembership()
//		assertNotNull "Event members should not be null", eventMembers
//		assertTrue "Event members should be empty", eventMembers.isEmpty()
//	}
}
