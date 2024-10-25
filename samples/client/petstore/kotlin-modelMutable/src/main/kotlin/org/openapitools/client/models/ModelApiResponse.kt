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
 * Describes the result of uploading an image resource
 *
 * @param code 
 * @param type 
 * @param message 
 */


data class ModelApiResponse (

    @Json(name = "code")
    var code: Int? = null,

    @Json(name = "type")
    var type: String? = null,

    @Json(name = "message")
    var message: String? = null

) {


}

