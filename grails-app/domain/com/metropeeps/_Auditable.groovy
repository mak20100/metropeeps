package com.metropeeps

import java.util.Date

abstract class _Auditable {
	Date dateCreated, lastUpdated // GORM convention
}
