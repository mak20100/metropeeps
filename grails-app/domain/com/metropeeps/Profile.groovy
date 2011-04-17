package com.metropeeps

class Profile extends _Auditable{
	String firstName, lastNameInitial, nickName
	String profilePic

	static constraints = {
		firstName(maxSize:500)
//		firstName(blank:false, size:2..32)
//		lastNameInitial(blank:false, size:1)
//		nickName(blank:true, nullable:true)
	}
}
