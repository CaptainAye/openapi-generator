/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * A User who is purchasing from the pet store
 *
 * @param id 
 * @param username 
 * @param firstName 
 * @param lastName 
 * @param email 
 * @param password 
 * @param phone 
 * @param userStatus User Status
 */
@JsonClass(generateAdapter = true)

data class User (

    @Json(name = "id")
    val id: Long? = null,

    @Json(name = "username")
    val username: String? = null,

    @Json(name = "firstName")
    val firstName: String? = null,

    @Json(name = "lastName")
    val lastName: String? = null,

    @Json(name = "email")
    val email: String? = null,

    @Json(name = "password")
    val password: String? = null,

    @Json(name = "phone")
    val phone: String? = null,

    /* User Status */
    @Json(name = "userStatus")
    val userStatus: Int? = null

) {


}

