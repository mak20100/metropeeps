package com

import org.joda.time.DateTime
import org.joda.time.contrib.hibernate.PersistentDateTime


abstract class Auditable {
	DateTime dateCreated, lastUpdated // GORM convention
}
