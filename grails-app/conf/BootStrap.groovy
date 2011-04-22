
import org.joda.time.LocalDate
import org.joda.time.LocalTime

import com.metropeeps.Event;
import com.metropeeps.Profile;
import com.metropeeps.User;

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
					date: new LocalDate().plusDays(14),
					startTime: new LocalTime(17, 0, 0),
					endTime: new LocalTime(20, 0, 0)).save(failOnError:true)
			new Event(
					owner: u1,
					title: "Lady GaGa Concert",
					description: "The GaGa at Pepsi Center",
					date: new LocalDate().plusDays(21),
					startTime: new LocalTime(18, 0, 0),
					endTime: new LocalTime(21, 0, 0)).save(failOnError:true)
			new Event(
					owner: u2,
					title: "Newcastle vs. Liverpool Soccer",
					date: new LocalDate().plusDays(4),
					startTime: new LocalTime(10, 0, 0),
					endTime: new LocalTime(14, 0, 0)).save(failOnError:true)
			new Event(
					owner: u2,
					title: "Web 2.0 Conference",
					date: new LocalDate().plusDays(5),
					startTime: new LocalTime(9, 0, 0),
					endTime: new LocalTime(18, 0, 0)).save(failOnError:true)
			new Event(
					owner: u3,
					title: "Rock Climbing in Boulder",
					description: "Going to the Flat Irons to do some redpointing",
					date: new LocalDate().plusDays(1),
					startTime: new LocalTime(8, 0, 0),
					endTime: new LocalTime(16, 0, 0)).save(failOnError:true)
			new Event(
					owner: u4,
					title: "Orienteering Training",
					description: "REI training on orienteering and navigation",
					date: new LocalDate().plusDays(7),
					startTime: new LocalTime(17, 0, 0),
					endTime: new LocalTime(18, 0, 0)).save(failOnError:true)
			new Event(
					owner: u4,
					title: "Leonid Meteor Shower",
					date: new LocalDate().plusDays(7),
					startTime: new LocalTime(21, 0, 0),
					endTime: new LocalTime(23, 0, 0)).save(failOnError:true)
		}
	}

	def destroy = {
	}
}
