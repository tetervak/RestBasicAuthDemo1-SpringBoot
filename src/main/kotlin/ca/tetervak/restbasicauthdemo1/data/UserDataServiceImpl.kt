package ca.tetervak.restbasicauthdemo1.data

import ca.tetervak.restbasicauthdemo1.model.User
import org.springframework.stereotype.Service

@Service
class UserDataServiceImpl: UserDataService {

    private val userList: List<User> =
        listOf(
            User("1", "Sunnat", "sunnat123@gmail.com"),
            User("2", "Chaity", "chaity123@gmail.com"),
            User("3", "Jisan", "jisan123@gmail.com"),
            User("4", "Mirza", "mirza123@gmail.com"),
            User("5", "Hasib", "hasib123@gmail.com")
        )

    override fun getUsers(): List<User> {
        return userList
    }
}
