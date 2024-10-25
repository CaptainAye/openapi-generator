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

import org.openapitools.client.models.Category
import org.openapitools.client.models.Tag

import com.google.gson.annotations.SerializedName

/**
 * A pet for sale in the pet store
 *
 * @param name 
 * @param photoUrls 
 * @param id 
 * @param category 
 * @param tags 
 * @param status pet status in the store
 */


data class Pet (

    @SerializedName("name")
    val name: String,

    @SerializedName("photoUrls")
    val photoUrls: kotlin.collections.List<String>,

    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("category")
    val category: Category? = null,

    @SerializedName("tags")
    val tags: List<Tag>? = null,

    /* pet status in the store */
    @SerializedName("status")
    val status: Pet.Status? = null

) {

    /**
     * pet status in the store
     *
     * Values: available,pending,sold,unknown_default_open_api
     */
    enum class Status(val value: String) {
        @SerializedName(value = "available") available("available"),
        @SerializedName(value = "pending") pending("pending"),
        @SerializedName(value = "sold") sold("sold"),
        @SerializedName(value = "unknown_default_open_api") unknown_default_open_api("unknown_default_open_api");
    }

}

