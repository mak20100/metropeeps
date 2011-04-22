package com.metropeeps

import javax.persistence.FetchType;

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder


/**
 * Class that represents a registered user
 */
class User extends _Auditable{
	String email
	String password, passwordVerify
	Profile profile

	// relations
	static transients = ['passwordVerify']
	static hasMany = [ownerOf:Event, memberOf:Membership]
	static mappedBy = [ownerOf:'owner']

	static constraints = {
		email blank:false, email:true, unique:true
		profile nullable:true, unique:true
		password blank:false, size:8..32
	}

	/**
	 * @return all events this user is a member of
	 */
	List memberOfEvents(){
		memberOf.collect{it.event}
	}

	/**
	 * @param event this user should be added as a member of
	 * @return all events this user is a member of
	 */
	List addToEvent(event){
		Membership.link(this, event)
		memberOfEvents()
	}

	/**
	 * @param event this user should be removed as a member of
	 * @return all events this user is a member of
	 */
	List removeFromEvent(event){
		Membership.unlink(this, event)
		memberOfEvents()
	}

	boolean equals( obj ) {
		if(!(obj instanceof User)) return false
		if(obj.is(this)) return true

		User u = (User) obj
		new EqualsBuilder().
				append(email, u.email).
				append(profile, u.profile).isEquals()
	}

	int hashCode() {
		new HashCodeBuilder().
				append(email).
				append(profile).toHashCode()
	}

	String toString(){
		ToStringBuilder.reflectionToString(this)
	}
}
