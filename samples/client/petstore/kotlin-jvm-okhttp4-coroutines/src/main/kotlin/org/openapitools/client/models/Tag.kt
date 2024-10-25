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


import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * A tag for a pet
 *
 * @param id 
 * @param name 
 */


data class Tag (

    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("name")
    val name: String? = null

) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 123
    }


}

