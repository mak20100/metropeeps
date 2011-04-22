package com.metropeeps

/**
 * Class that represents a postal address
 */
enum CountryType{US, CA, MX}
class Address extends _Auditable{
	/*
	 * street					10 Main Street
	 * complement				Apt. B
	 * city, state postalCode	New York, NY 10272
	 * country					US
	 */
	String street, complement, city, state, postalCode
	CountryType country
	
    static constraints = {
		street blank:false
		complements nullable: true
    }
}
