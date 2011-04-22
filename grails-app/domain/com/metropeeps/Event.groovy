package com.metropeeps

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder
import org.joda.time.LocalDate
import org.joda.time.LocalTime


/**
 * Class that represents a spatial (address/location) and temporal (date/time) target
 */
class Event extends _Auditable{
	String title, description
	LocalDate date
	LocalTime startTime, endTime

	// relations
	static belongsTo = [owner:User]
	static hasMany = [membership:Membership]

	static constraints = {
		title blank:false, maxSize:80
		description nullable:true
	}

	/**
	 * @return all members of this event
	 */
	List eventMembership(){
		membership.collect{it.user}
	}

	/**
	 * @param user to add to this events membership
	 * @return all members of this event
	 */
	List addToMembership(User user){
		Membership.link(user, this)
		eventMembership()
	}

	/**
	 * @param user to remove from this events membership
	 * @return all members of this event
	 */
	List removeFromMembership(User user){
		Membership.unlink(user, this)
		eventMembership()
	}

	boolean equals( obj ) {
		if(!(obj instanceof Event)) return false
		if(obj.is(this)) return true

		Event e = (Event) obj
		new EqualsBuilder().
				append(title, e.title).
				append(description, e.description).
				append(date, e.date).
				append(startTime, e.startTime).
				append(endTime, e.endTime).isEquals()
	}

	int hashCode() {
		new HashCodeBuilder().
				append(title).
				append(description).
				append(date).
				append(startTime).
				append(endTime).toHashCode()
	}

	String toString(){
		ToStringBuilder.reflectionToString(this)
	}
}
