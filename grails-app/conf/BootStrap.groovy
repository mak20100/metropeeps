import org.joda.time.LocalDate
import org.joda.time.LocalTime

import com.metropeeps.Event
import com.metropeeps.Profile
import com.metropeeps.User

class BootStrap {

	def init = { servletContext ->
		User u1, u2

		if(!User.count()){
			u1 = new User(
					email: "admin@metropeeps.com",
					password: "hotspots",
					profile: new Profile(firstName: "metro", lastName: "peeps"))
			u2 = new User(
					email: "timstorm@metropeeps.com",
					password: "password",
					profile: new Profile(firstName: "tim", lastName: "storm", nickName: "timmay"))

			u1.save(failOnError:true)
			u2.save(failOnError:true)
		}

		Event e1, e2
		if(!Event.count()){
			e1 = new Event(
					owner: u1,
					title: "Speciel Event",
					date: new LocalDate().plusDays(2),
					startTime: new LocalTime(15, 0, 0),
					endTime: new LocalTime(17, 0, 0))
			e2 = new Event(
					owner: u2,
					title: "Another Event",
					date: new LocalDate().plusDays(2),
					startTime: new LocalTime(15, 0, 0),
					endTime: new LocalTime(18, 0, 0))

			e1.save(failOnError:true)
			e2.save(failOnError:true)
		}
	}

	def destroy = {
	}
}
