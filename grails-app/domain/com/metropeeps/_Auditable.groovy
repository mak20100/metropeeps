package com.metropeeps


import org.joda.time.DateTime


/**
 * Base domain class that can be extended by any class wishing to have auditing properties
 */
abstract class _Auditable {
	DateTime dateCreated, lastUpdated // GORM convention
}
