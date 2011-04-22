package com.metropeeps

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder

/**
 * Class that represents the details of a user
 */
class Profile extends _Auditable{
	String firstName, lastName, nickName

	// relations
	static belongsTo = User

	static constraints = {
		firstName blank:false
		lastName blank:false
		nickName nullable:true
	}

	boolean equals( obj ) {
		if(!(obj instanceof Profile)) return false
		if(obj.is(this)) return true

		Profile p = (Profile) obj
		new EqualsBuilder().
				append(firstName, p.firstName).
				append(lastName, p.lastName).
				append(nickName, p.nickName).isEquals()
	}

	int hashCode() {
		new HashCodeBuilder().
				append(firstName).
				append(lastName).
				append(nickName).toHashCode()
	}

	String toString(){
		ToStringBuilder.reflectionToString(this)
	}
}
