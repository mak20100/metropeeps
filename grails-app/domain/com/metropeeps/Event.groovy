package com.metropeeps

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder
import org.joda.time.DateTime


/**
 * Class that represents a spatial (address/location) and temporal (date/time) target
 */
class Event extends _Auditable{
	String title, description
	DateTime start, end

	// relations
	static belongsTo = [owner:User]
	static hasMany = [membership:Membership]

	static constraints = {
		title blank:false, maxSize:80
		description nullable:true
	}
	
	static mapping = {
		membership cascade: "all-delete-orphan" // allows uni-directional deleting of members
	}
	
	/**
	 * @return all members of this event
	 */
	List members(){
		membership.collect{it.user}
	}

	/**
	 * @param user to add to this events membership
	 * @return all members of this event
	 */
	List register(User user){
		Membership.link(user, this)
		members()
	}

	/**
	 * @param user to remove from this events membership
	 * @return all members of this event
	 */
	List unregister(User user){
		Membership.unlink(user, this)
		members()
	}

	boolean equals( obj ) {
		if(!(obj instanceof Event)) return false
		if(obj.is(this)) return true

		Event e = (Event) obj
		new EqualsBuilder().
				append(title, e.title).
				append(description, e.description).
				append(start, e.start).
				append(end, e.end).isEquals()
	}

	int hashCode() {
		new HashCodeBuilder().
				append(title).
				append(description).
				append(start).
				append(end).toHashCode()
	}

	String toString(){
		ToStringBuilder.reflectionToString(this)
	}
}
