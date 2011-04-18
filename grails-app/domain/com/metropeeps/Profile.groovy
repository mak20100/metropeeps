package com.metropeeps

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder

import com.Auditable

class Profile extends Auditable{
	static belongsTo = [user:User]
	
	String firstName, lastName, nickName
	//	String profilePic

	static constraints = {
		firstName blank:false
		lastName blank:false
		nickName nullable:true
	}
	
	boolean equals( obj ) {
		if(!(obj instanceof Profile)) return false
		if(obj.is(this)) return true

		Profile p = (Profile) obj
		new EqualsBuilder().append(firstName, p.firstName).append(lastName, p.lastName).append(nickName, p.nickName).isEquals()
	}

	int hashCode() {
		new HashCodeBuilder().append(firstName).append(lastName).append(nickName).toHashCode()
	}

	String toString(){
		ToStringBuilder.reflectionToString(this)
	}
}
