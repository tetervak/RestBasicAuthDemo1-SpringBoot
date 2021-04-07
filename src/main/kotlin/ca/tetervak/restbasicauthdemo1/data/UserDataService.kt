package ca.tetervak.restbasicauthdemo1.data

import ca.tetervak.restbasicauthdemo1.model.User

interface UserDataService {
    fun getUsers(): List<User>
}
