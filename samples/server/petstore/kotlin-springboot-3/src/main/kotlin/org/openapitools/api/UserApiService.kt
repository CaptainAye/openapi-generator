package org.openapitools.api

import java.time.OffsetDateTime
import org.openapitools.model.User

interface UserApiService {

    /**
     * POST /user : Create user
     * This can only be done by the logged in user.
     *
     * @param user Created user object (required)
     * @return successful operation (status code 200)
     * @see UserApi#createUser
     */
    fun createUser(user: User): Unit

    /**
     * POST /user/createWithArray : Creates list of users with given input array
     * 
     *
     * @param user List of user object (required)
     * @return successful operation (status code 200)
     * @see UserApi#createUsersWithArrayInput
     */
    fun createUsersWithArrayInput(user: List<User>): Unit

    /**
     * POST /user/createWithList : Creates list of users with given input array
     * 
     *
     * @param user List of user object (required)
     * @return successful operation (status code 200)
     * @see UserApi#createUsersWithListInput
     */
    fun createUsersWithListInput(user: List<User>): Unit

    /**
     * DELETE /user/{username} : Delete user
     * This can only be done by the logged in user.
     *
     * @param username The name that needs to be deleted (required)
     * @return Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     * @see UserApi#deleteUser
     */
    fun deleteUser(username: String): Unit

    /**
     * GET /user/{username} : Get user by user name
     * 
     *
     * @param username The name that needs to be fetched. Use user1 for testing. (required)
     * @return successful operation (status code 200)
     *         or Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     * @see UserApi#getUserByName
     */
    fun getUserByName(username: String): User

    /**
     * GET /user/login : Logs user into the system
     * 
     *
     * @param username The user name for login (required)
     * @param password The password for login in clear text (required)
     * @return successful operation (status code 200)
     *         or Invalid username/password supplied (status code 400)
     * @see UserApi#loginUser
     */
    fun loginUser(username: String, password: String): String

    /**
     * GET /user/logout : Logs out current logged in user session
     * 
     *
     * @return successful operation (status code 200)
     * @see UserApi#logoutUser
     */
    fun logoutUser(): Unit

    /**
     * PUT /user/{username} : Updated user
     * This can only be done by the logged in user.
     *
     * @param username name that need to be deleted (required)
     * @param user Updated user object (required)
     * @return Invalid user supplied (status code 400)
     *         or User not found (status code 404)
     * @see UserApi#updateUser
     */
    fun updateUser(username: String, user: User): Unit
}
