package id.swarawan.repository

import id.swarawan.entity.Profile
import org.springframework.stereotype.Repository

@Repository
class ProfileRepository {

	private val profiles: List<Profile> by lazy {
		initData()
	}

	fun findDetailsById(id: Int): Profile? =
		profiles.find { it.id == id }

	private fun initData(): List<Profile> {
		return arrayListOf(
			Profile(
				id = 1,
				name = "Abdul Khoir",
				email = "ii@investree.id",
				address = "Planet Mars",
				image = "https://randomuser.me/api/portraits/men/75.jpg"
			),
			Profile(
				id = 2,
				name = "Eka Heriyawan",
				email = "eka@investree.id",
				address = "Bawah Meja Setrika",
				image = "https://randomuser.me/api/portraits/men/76.jpg"
			),
			Profile(
				id = 3,
				name = "Feri Setiyawan",
				email = "feri@investree.id",
				address = "Ghana",
				image = "https://randomuser.me/api/portraits/men/77.jpg"
			)
		)
	}
}