package integration.metropeeps.com

import static org.junit.Assert.*
import grails.test.*

import org.joda.time.DateTime
import org.junit.After
import org.junit.Before
import org.junit.Test

import com.metropeeps.Event
import com.metropeeps.User


class EventTests {
	User owner, member;
	String eventTitle = "EventTestsTitle"

	@Before
	public void setUp() {
		def users = User.list()

		owner = users[0]
		member = users[1]
	}

	@After
	public void tearDown() {
		owner.ownerOf.clear()
		member.memberOf.clear()
	}

	@Test
	void test_event_lifecycle() {
		// create and save event
		def e1 = new Event(
				owner:owner,
				title:eventTitle,
				description:"Super Special Event",
				start:new DateTime().plusDays(2).withHourOfDay(2),
				end:new DateTime().plusDays(2).withHourOfDay(4))
		e1.save(flush:true)

		// verify the save
		def actual = Event.findAllByOwner(owner)
		assertNotNull "Event should be saved", actual
		assertTrue "Event that was saved should be found", actual.contains(e1)

		// modify and re-save
		e1.start = e1.start.minusHours(2)
		e1.save(flush:true)
		actual = Event.findAllByOwner(owner)
		assertNotNull "Modified Event should be saved", actual
		assertTrue "Event that was saved should be found", actual.contains(e1)

		// delete the event
		e1.delete(flush:true)
		actual = Event.findAllByOwner(owner)
		assertFalse "Event that was saved should be found", actual?.contains(e1)
	}

	@Test
	void test_addToEvent() {
		def owner = owner
		def member = member
		def event = new Event(owner: owner,
				title: eventTitle,
				start: new DateTime(),
				end: new DateTime())
		event.save(flush:true)
		event.register(member)

		def eventMembers = event.members()
		assertNotNull "Event members should not be null", eventMembers
		assertFalse "Event members should not be empty", eventMembers.isEmpty()
		assertTrue "Event members should be associated to the member", eventMembers.contains(member)

		event.unregister(member)
		eventMembers = event.members()
		assertNotNull "Event members should not be null", eventMembers
		assertTrue "Event members should be empty", eventMembers.isEmpty()
	}
}
