package com.metropeeps

/**
 * Many-to-Many xref between {@link User} (a.k.a member) and {@link Event}
 */
class Membership extends _Auditable{
	User user
	Event event
	boolean approved

	/**
	 * Utility method for linking a user and event together
	 * @param user
	 * @param event
	 * @return the {@link Membership} link of the user and event
	 */
	static Membership link(User user, Event event){
		def m = Membership.findByUserAndEvent(user, event)
		if(!m){
			m = new Membership()
			user?.addToMemberOf(m)
			event?.addToMembership(m)
			m.save()
		}
		return m
	}

	/**
	 * Utility method for unlinking a user and event together
	 * @param user
	 * @param event
	 */
	static void unlink(User user, Event event){
		def m = Membership.findByUserAndEvent(user, event)
		if(m){
			user?.removeFromMemberOf(m)
			event?.removeFromMembership(m)
			m.delete()
		}
	}
}
