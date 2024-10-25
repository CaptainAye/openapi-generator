package org.openapitools.api

import java.time.OffsetDateTime
import org.openapitools.model.User
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

import kotlinx.coroutines.flow.Flow
import kotlin.collections.List
import kotlin.collections.Map

@RestController
@Validated
@RequestMapping("\${api.base-path:/v2}")
class UserApiController(@Autowired(required = true) val service: UserApiService) {

    @Operation(
        summary = "Create user",
        operationId = "createUser",
        description = """This can only be done by the logged in user.""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/user"]
    )
    suspend fun createUser(@Parameter(description = "Created user object", required = true) @Valid @RequestBody body: User): ResponseEntity<Unit> {
        return ResponseEntity(service.createUser(body), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Creates list of users with given input array",
        operationId = "createUsersWithArrayInput",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/user/createWithArray"]
    )
    suspend fun createUsersWithArrayInput(@Parameter(description = "List of user object", required = true) @Valid @RequestBody body: Flow<User>): ResponseEntity<Unit> {
        return ResponseEntity(service.createUsersWithArrayInput(body), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Creates list of users with given input array",
        operationId = "createUsersWithListInput",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/user/createWithList"]
    )
    suspend fun createUsersWithListInput(@Parameter(description = "List of user object", required = true) @Valid @RequestBody body: Flow<User>): ResponseEntity<Unit> {
        return ResponseEntity(service.createUsersWithListInput(body), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Delete user",
        operationId = "deleteUser",
        description = """This can only be done by the logged in user.""",
        responses = [
            ApiResponse(responseCode = "400", description = "Invalid username supplied"),
            ApiResponse(responseCode = "404", description = "User not found") ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/user/{username}"]
    )
    suspend fun deleteUser(@Parameter(description = "The name that needs to be deleted", required = true) @PathVariable("username") username: String): ResponseEntity<Unit> {
        return ResponseEntity(service.deleteUser(username), HttpStatus.valueOf(400))
    }

    @Operation(
        summary = "Get user by user name",
        operationId = "getUserByName",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = User::class))]),
            ApiResponse(responseCode = "400", description = "Invalid username supplied"),
            ApiResponse(responseCode = "404", description = "User not found") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/user/{username}"],
        produces = ["application/xml", "application/json"]
    )
    suspend fun getUserByName(@Parameter(description = "The name that needs to be fetched. Use user1 for testing.", required = true) @PathVariable("username") username: String): ResponseEntity<User> {
        return ResponseEntity(service.getUserByName(username), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Logs user into the system",
        operationId = "loginUser",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = String::class))]),
            ApiResponse(responseCode = "400", description = "Invalid username/password supplied") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/user/login"],
        produces = ["application/xml", "application/json"]
    )
    suspend fun loginUser(@NotNull @Parameter(description = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) username: String,@NotNull @Parameter(description = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) password: String): ResponseEntity<String> {
        return ResponseEntity(service.loginUser(username, password), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Logs out current logged in user session",
        operationId = "logoutUser",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/user/logout"]
    )
    suspend fun logoutUser(): ResponseEntity<Unit> {
        return ResponseEntity(service.logoutUser(), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Updated user",
        operationId = "updateUser",
        description = """This can only be done by the logged in user.""",
        responses = [
            ApiResponse(responseCode = "400", description = "Invalid user supplied"),
            ApiResponse(responseCode = "404", description = "User not found") ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/user/{username}"]
    )
    suspend fun updateUser(@Parameter(description = "name that need to be deleted", required = true) @PathVariable("username") username: String,@Parameter(description = "Updated user object", required = true) @Valid @RequestBody body: User): ResponseEntity<Unit> {
        return ResponseEntity(service.updateUser(username, body), HttpStatus.valueOf(400))
    }
}
