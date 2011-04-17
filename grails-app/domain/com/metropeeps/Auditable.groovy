package com.metropeeps

import java.util.Date

abstract class Auditable {
	Date dateCreated, lastUpdated // GORM convention
}
