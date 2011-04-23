
import org.joda.time.DateTime

import com.metropeeps.Event
import com.metropeeps.Profile
import com.metropeeps.User

class BootStrap {

	def init = { servletContext ->
		User u1, u2, u3, u4

		if(!User.count()){
			u1 = new User(
					email: "admin@mps.com",
					password: "supersecret",
					profile: new Profile(firstName: "metro", lastName: "peeps"))
			u2 = new User(
					email: "tim@metropeeps.com",
					password: "password",
					profile: new Profile(firstName: "tim", lastName: "storm", nickName: "timmay"))
			u3 = new User(
					email: "ayman@metropeeps.com",
					password: "password",
					profile: new Profile(firstName: "ayman", lastName: "kayali"))
			u4 = new User(
					email: "wael@metropeeps.com",
					password: "password",
					profile: new Profile(firstName: "wael", lastName: "adi"))

			u1.save(failOnError:true)
			u2.save(failOnError:true)
			u3.save(failOnError:true)
			u4.save(failOnError:true)
		}

		if(!Event.count()){
			new Event(
					owner: u1,
					title: "Lenny Kravitz Concert",
					description: "Lenny Kravitz Concert at Mile High Stadium",
					start: new DateTime().plusDays(14).withHourOfDay(17),
					end: new DateTime().plusDays(14).withHourOfDay(20)).save(failOnError:true)
			new Event(
					owner: u1,
					title: "Lady GaGa Concert",
					description: "The GaGa at Pepsi Center",
					start: new DateTime().plusDays(21).withHourOfDay(18),
					end: new DateTime().plusDays(21).withHourOfDay(18)).save(failOnError:true)
			new Event(
					owner: u2,
					title: "Newcastle vs. Liverpool Soccer",
					start: new DateTime().plusDays(4).withHourOfDay(10),
					end: new DateTime().plusDays(4).withHourOfDay(14)).save(failOnError:true)
			new Event(
					owner: u2,
					title: "Web 2.0 Conference",
					start: new DateTime().plusDays(5).withHourOfDay(9),
					end: new DateTime().plusDays(5).withHourOfDay(18)).save(failOnError:true)
			new Event(
					owner: u3,
					title: "Rock Climbing in Boulder",
					description: "Going to the Flat Irons to do some redpointing",
					start: new DateTime().plusDays(1).withHourOfDay(8),
					end: new DateTime().plusDays(1).withHourOfDay(16)).save(failOnError:true)
			new Event(
					owner: u4,
					title: "Orienteering Training",
					description: "REI training on orienteering and navigation",
					start: new DateTime().plusDays(7).withHourOfDay(17),
					end: new DateTime().plusDays(7).withHourOfDay(18)).save(failOnError:true)
			new Event(
					owner: u4,
					title: "Leonid Meteor Shower",
					start: new DateTime().plusDays(7).withHourOfDay(21),
					end:new DateTime().plusDays(8).withHourOfDay(2)).save(failOnError:true)
		}
	}

	def destroy = {
	}
}
