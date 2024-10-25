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

import java.io.IOException

import org.openapitools.client.models.Order

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference

import io.vertx.core.Vertx
import io.vertx.core.http.RequestOptions
import io.vertx.core.http.HttpMethod
import io.vertx.core.buffer.Buffer
import io.vertx.core.Future
import io.vertx.ext.web.client.WebClient
import io.vertx.uritemplate.UriTemplate

import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import org.openapitools.client.infrastructure.*

@Suppress ("UNUSED")
class StoreApi(basePath: kotlin.String = ApiClient.defaultBasePath, accessToken: String? = null, apiKey: MutableMap<String, String> = mutableMapOf(), apiKeyPrefix: MutableMap<String, String> = mutableMapOf(), username: String? = null, password: String? = null, vertx: Vertx): ApiClient(basePath, accessToken, apiKey, apiKeyPrefix, username, password, vertx) {
    /**
     * Delete purchase order by ID
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
     * @param orderId ID of the order that needs to be deleted
     * @return void
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deleteOrder(orderId: String) : Unit {
        return deleteOrderWithHttpInfo(orderId = orderId).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> Unit
                ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
                ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
                ResponseType.ClientError -> {
                    val localVarError = localVarResponse as ClientError<*>
                    throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
                }
                ResponseType.ServerError -> {
                    val localVarError = localVarResponse as ServerError<*>
                    throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
                }
            }
        }.await()
    }

    /**
     * Delete purchase order by ID
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
     * @param orderId ID of the order that needs to be deleted
     * @return ApiResponse<Unit?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Throws(IllegalStateException::class, IOException::class)
    fun deleteOrderWithHttpInfo(orderId: String) : Future<ApiResponse<Unit?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.DELETE, UriTemplate.of("$basePath/store/order/{orderId}".replace("{"+"orderId"+"}", encodeURIComponent(orderId.toString()))))

        
        
        
        




        return request
            .send()
            .map {
                val apiResponse: ApiResponse<Unit?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * Returns pet inventories by status
     * Returns a map of status codes to quantities
     * @return Map<String, Int>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getInventory() : Map<String, Int> {
        return getInventoryWithHttpInfo().map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as Map<String, Int>
                ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
                ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
                ResponseType.ClientError -> {
                    val localVarError = localVarResponse as ClientError<*>
                    throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
                }
                ResponseType.ServerError -> {
                    val localVarError = localVarResponse as ServerError<*>
                    throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
                }
            }
        }.await()
    }

    /**
     * Returns pet inventories by status
     * Returns a map of status codes to quantities
     * @return ApiResponse<Map<String, Int>?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getInventoryWithHttpInfo() : Future<ApiResponse<Map<String, Int>?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.GET, UriTemplate.of("$basePath/store/inventory"))

        
        
        
        request.putHeader("Accept", "application/json")



        if (apiKey["api_key"] != null) {
            if (apiKeyPrefix["api_key"] != null) {
                request.putHeader("api_key", apiKeyPrefix["api_key"]!! + " " + apiKey["api_key"]!!)
            } else {
                request.putHeader("api_key", apiKey["api_key"]!!)
            }
        }

        return request
            .send()
            .map {
                val apiResponse: ApiResponse<Map<String, Int>?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * Find purchase order by ID
     * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generate exceptions
     * @param orderId ID of pet that needs to be fetched
     * @return Order
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getOrderById(orderId: Long) : Order {
        return getOrderByIdWithHttpInfo(orderId = orderId).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as Order
                ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
                ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
                ResponseType.ClientError -> {
                    val localVarError = localVarResponse as ClientError<*>
                    throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
                }
                ResponseType.ServerError -> {
                    val localVarError = localVarResponse as ServerError<*>
                    throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
                }
            }
        }.await()
    }

    /**
     * Find purchase order by ID
     * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generate exceptions
     * @param orderId ID of pet that needs to be fetched
     * @return ApiResponse<Order?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getOrderByIdWithHttpInfo(orderId: Long) : Future<ApiResponse<Order?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.GET, UriTemplate.of("$basePath/store/order/{orderId}".replace("{"+"orderId"+"}", encodeURIComponent(orderId.toString()))))

        
        
        
        request.putHeader("Accept", "application/xml, application/json")




        return request
            .send()
            .map {
                val apiResponse: ApiResponse<Order?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * Place an order for a pet
     * 
     * @param order order placed for purchasing the pet
     * @return Order
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun placeOrder(order: Order) : Order {
        return placeOrderWithHttpInfo(order = order).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as Order
                ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
                ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
                ResponseType.ClientError -> {
                    val localVarError = localVarResponse as ClientError<*>
                    throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
                }
                ResponseType.ServerError -> {
                    val localVarError = localVarResponse as ServerError<*>
                    throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
                }
            }
        }.await()
    }

    /**
     * Place an order for a pet
     * 
     * @param order order placed for purchasing the pet
     * @return ApiResponse<Order?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun placeOrderWithHttpInfo(order: Order) : Future<ApiResponse<Order?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.POST, UriTemplate.of("$basePath/store/order"))

        
        
        
                    request.putHeader("Content-Type", "application/json")
        
        request.putHeader("Accept", "application/xml, application/json")




        return request
            .sendBuffer(responseBody(order))
            .map {
                val apiResponse: ApiResponse<Order?> = handleResponse(it)
                apiResponse
            }
    }


    private inline fun <reified T: Any?> responseBody(body: T): Buffer {
        return Buffer.buffer(Serializer.jacksonObjectMapper.writeValueAsBytes(body))
    }

}
