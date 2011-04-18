package com.metropeeps

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder

import com.Auditable


class User extends Auditable{
	String email
	Profile profile
	static hasMany = [ events : Event ]

	static constraints = {
		email blank:false, email:true, unique:true
		profile nullable:true, unique:true
	}

	boolean equals( obj ) {
		if(!(obj instanceof User)) return false
		if(obj.is(this)) return true

		User u = (User) obj
		new EqualsBuilder().append(email, u.email).append(profile, u.profile).isEquals()
	}

	int hashCode() {
		new HashCodeBuilder().append(email).append(profile).toHashCode()
	}

	String toString(){
		ToStringBuilder.reflectionToString(this)
	}
}
