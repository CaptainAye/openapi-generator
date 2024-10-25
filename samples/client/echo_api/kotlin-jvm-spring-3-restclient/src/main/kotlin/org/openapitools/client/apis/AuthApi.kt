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

package org.openapitools.client.apis

import com.fasterxml.jackson.annotation.JsonProperty

import org.springframework.web.client.RestClient
import org.springframework.web.client.RestClientResponseException

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.ResponseEntity
import org.springframework.http.MediaType


import org.openapitools.client.infrastructure.*

class AuthApi(client: RestClient) : ApiClient(client) {

    constructor(baseUrl: String) : this(RestClient.builder()
        .baseUrl(baseUrl)
        .messageConverters { it.add(MappingJackson2HttpMessageConverter()) }
        .build()
    )


    @Throws(RestClientResponseException::class)
    fun testAuthHttpBasic(): String {
        val result = testAuthHttpBasicWithHttpInfo()
        return result.body!!
    }

    @Throws(RestClientResponseException::class)
    fun testAuthHttpBasicWithHttpInfo(): ResponseEntity<String> {
        val localVariableConfig = testAuthHttpBasicRequestConfig()
        return request<Unit, String>(
            localVariableConfig
        )
    }

    fun testAuthHttpBasicRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "text/plain"

        val params = mutableMapOf<String, Any>(
        )

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/auth/http/basic",
            params = params,
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }


    @Throws(RestClientResponseException::class)
    fun testAuthHttpBearer(): String {
        val result = testAuthHttpBearerWithHttpInfo()
        return result.body!!
    }

    @Throws(RestClientResponseException::class)
    fun testAuthHttpBearerWithHttpInfo(): ResponseEntity<String> {
        val localVariableConfig = testAuthHttpBearerRequestConfig()
        return request<Unit, String>(
            localVariableConfig
        )
    }

    fun testAuthHttpBearerRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "text/plain"

        val params = mutableMapOf<String, Any>(
        )

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/auth/http/bearer",
            params = params,
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

}
