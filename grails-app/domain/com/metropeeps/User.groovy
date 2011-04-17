package com.metropeeps

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class User extends Auditable{
	String firstName, lastName, email

	static constraints = {
		email(unique:true, blank:false, email:true)
		firstName(blank:false, size:2..32)
		lastName(blank:false, size:2..32)
	}

	boolean equals( obj ) {
		if(obj.is(null)) return false
		if(!(obj instanceof User)) return false
		if(obj.is(this)) return true

		User u = (User) obj
		new EqualsBuilder().append(firstName, u.firstName).append(lastName, u.lastName).append(email, u.email).isEquals()
	}

	int hashCode() {
		new HashCodeBuilder().append(firstName).append(lastName).append(email).toHashCode()
	}

	String toString(){
		"$firstName $lastName - $email"
	}
}
