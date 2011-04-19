package com.metropeeps

import org.joda.time.LocalDate
import org.joda.time.LocalTime

import com.Auditable

class Event extends Auditable{
	String title, description
	LocalDate date
	LocalTime startTime, endTime
	static belongsTo = [owner:User]
	
	
	static constraints = {
		title blank:false, maxSize:80
		description nullable:true
	}
}
