package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * A User who is purchasing from the pet store
 * @param username 
 * @param id 
 * @param firstName 
 * @param lastName 
 * @param email 
 * @param password 
 * @param phone 
 * @param userStatus User Status
 */
data class User(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("username", required = true) val username: String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("id") val id: Long? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("firstName") val firstName: String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("lastName") val lastName: String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("email") val email: String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("password") val password: String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("phone") val phone: String? = null,

    @Schema(example = "null", description = "User Status")
    @get:JsonProperty("userStatus") val userStatus: Int? = null
    ) {

}

