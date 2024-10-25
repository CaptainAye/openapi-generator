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

import java.io.File
import org.openapitools.client.models.ModelApiResponse
import org.openapitools.client.models.Pet

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
class PetApi(basePath: kotlin.String = ApiClient.defaultBasePath, accessToken: String? = null, apiKey: MutableMap<String, String> = mutableMapOf(), apiKeyPrefix: MutableMap<String, String> = mutableMapOf(), username: String? = null, password: String? = null, vertx: Vertx): ApiClient(basePath, accessToken, apiKey, apiKeyPrefix, username, password, vertx) {
    /**
     * Add a new pet to the store
     * 
     * @param pet Pet object that needs to be added to the store
     * @return Pet
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun addPet(pet: Pet) : Pet {
        return addPetWithHttpInfo(pet = pet).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as Pet
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
     * Add a new pet to the store
     * 
     * @param pet Pet object that needs to be added to the store
     * @return ApiResponse<Pet?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun addPetWithHttpInfo(pet: Pet) : Future<ApiResponse<Pet?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.POST, UriTemplate.of("$basePath/pet"))

        
        
        
                    request.putHeader("Content-Type", "application/json")
                    request.putHeader("Content-Type", "application/xml")
        
        request.putHeader("Accept", "application/xml, application/json")



        accessToken?.let { accessToken ->
            request.bearerTokenAuthentication(accessToken)
        }

        return request
            .sendBuffer(responseBody(pet))
            .map {
                val apiResponse: ApiResponse<Pet?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * Deletes a pet
     * 
     * @param petId Pet id to delete
     * @param apiKey  (optional)
     * @return void
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun deletePet(petId: Long, apiKey: String? = null) : Unit {
        return deletePetWithHttpInfo(petId = petId, apiKey = apiKey).map { localVarResponse ->
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
     * Deletes a pet
     * 
     * @param petId Pet id to delete
     * @param apiKey  (optional)
     * @return ApiResponse<Unit?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Throws(IllegalStateException::class, IOException::class)
    fun deletePetWithHttpInfo(petId: Long, apiKey: String?) : Future<ApiResponse<Unit?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.DELETE, UriTemplate.of("$basePath/pet/{petId}".replace("{"+"petId"+"}", encodeURIComponent(petId.toString()))))

        
        apiKey?.apply { request.putHeader("api_key", this.toString())}
        
        



        accessToken?.let { accessToken ->
            request.bearerTokenAuthentication(accessToken)
        }

        return request
            .send()
            .map {
                val apiResponse: ApiResponse<Unit?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * enum for parameter status
     */
     enum class StatusFindPetsByStatus(val value: kotlin.String) {
     @JsonProperty(value = "available") available("available"),
     @JsonProperty(value = "pending") pending("pending"),
     @JsonProperty(value = "sold") sold("sold")
     }

    /**
     * Finds Pets by status
     * Multiple status values can be provided with comma separated strings
     * @param status Status values that need to be considered for filter
     * @return List<Pet>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun findPetsByStatus(status: kotlin.collections.List<StatusFindPetsByStatus>) : List<Pet> {
        return findPetsByStatusWithHttpInfo(status = status).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as List<Pet>
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
     * Finds Pets by status
     * Multiple status values can be provided with comma separated strings
     * @param status Status values that need to be considered for filter
     * @return ApiResponse<List<Pet>?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun findPetsByStatusWithHttpInfo(status: kotlin.collections.List<StatusFindPetsByStatus>) : Future<ApiResponse<List<Pet>?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.GET, UriTemplate.of("$basePath/pet/findByStatus"))

        
        
        
        request.putHeader("Accept", "application/xml, application/json")


        status.let { request.queryParams().add("status", toMultiValue(it.toList(), "csv")) }

        accessToken?.let { accessToken ->
            request.bearerTokenAuthentication(accessToken)
        }

        return request
            .send()
            .map {
                val apiResponse: ApiResponse<List<Pet>?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * Finds Pets by tags
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param tags Tags to filter by
     * @return List<Pet>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    @Deprecated(message = "This operation is deprecated.")
    suspend fun findPetsByTags(tags: List<String>) : List<Pet> {
        return findPetsByTagsWithHttpInfo(tags = tags).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as List<Pet>
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
     * Finds Pets by tags
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param tags Tags to filter by
     * @return ApiResponse<List<Pet>?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    @Deprecated(message = "This operation is deprecated.")
    fun findPetsByTagsWithHttpInfo(tags: List<String>) : Future<ApiResponse<List<Pet>?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.GET, UriTemplate.of("$basePath/pet/findByTags"))

        
        
        
        request.putHeader("Accept", "application/xml, application/json")


        tags.let { request.queryParams().add("tags", toMultiValue(it.toList(), "csv")) }

        accessToken?.let { accessToken ->
            request.bearerTokenAuthentication(accessToken)
        }

        return request
            .send()
            .map {
                val apiResponse: ApiResponse<List<Pet>?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * Find pet by ID
     * Returns a single pet
     * @param petId ID of pet to return
     * @return Pet
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun getPetById(petId: Long) : Pet {
        return getPetByIdWithHttpInfo(petId = petId).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as Pet
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
     * Find pet by ID
     * Returns a single pet
     * @param petId ID of pet to return
     * @return ApiResponse<Pet?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getPetByIdWithHttpInfo(petId: Long) : Future<ApiResponse<Pet?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.GET, UriTemplate.of("$basePath/pet/{petId}".replace("{"+"petId"+"}", encodeURIComponent(petId.toString()))))

        
        
        
        request.putHeader("Accept", "application/xml, application/json")



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
                val apiResponse: ApiResponse<Pet?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * Update an existing pet
     * 
     * @param pet Pet object that needs to be added to the store
     * @return Pet
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun updatePet(pet: Pet) : Pet {
        return updatePetWithHttpInfo(pet = pet).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as Pet
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
     * Update an existing pet
     * 
     * @param pet Pet object that needs to be added to the store
     * @return ApiResponse<Pet?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun updatePetWithHttpInfo(pet: Pet) : Future<ApiResponse<Pet?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.PUT, UriTemplate.of("$basePath/pet"))

        
        
        
                    request.putHeader("Content-Type", "application/json")
                    request.putHeader("Content-Type", "application/xml")
        
        request.putHeader("Accept", "application/xml, application/json")



        accessToken?.let { accessToken ->
            request.bearerTokenAuthentication(accessToken)
        }

        return request
            .sendBuffer(responseBody(pet))
            .map {
                val apiResponse: ApiResponse<Pet?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * Updates a pet in the store with form data
     * 
     * @param petId ID of pet that needs to be updated
     * @param name Updated name of the pet (optional)
     * @param status Updated status of the pet (optional)
     * @return void
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun updatePetWithForm(petId: Long, name: String? = null, status: String? = null) : Unit {
        return updatePetWithFormWithHttpInfo(petId = petId, name = name, status = status).map { localVarResponse ->
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
     * Updates a pet in the store with form data
     * 
     * @param petId ID of pet that needs to be updated
     * @param name Updated name of the pet (optional)
     * @param status Updated status of the pet (optional)
     * @return ApiResponse<Unit?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Throws(IllegalStateException::class, IOException::class)
    fun updatePetWithFormWithHttpInfo(petId: Long, name: String?, status: String?) : Future<ApiResponse<Unit?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.POST, UriTemplate.of("$basePath/pet/{petId}".replace("{"+"petId"+"}", encodeURIComponent(petId.toString()))))

        request.putHeader("Content-Type", "application/x-www-form-urlencoded")
        
        
        

        val form = io.vertx.core.MultiMap.caseInsensitiveMultiMap();
        name?.let { form.add("name", name) }
        status?.let { form.add("status", status) }


        accessToken?.let { accessToken ->
            request.bearerTokenAuthentication(accessToken)
        }

        return request
            .send()
            .map {
                val apiResponse: ApiResponse<Unit?> = handleResponse(it)
                apiResponse
            }
    }

    /**
     * uploads an image
     * 
     * @param petId ID of pet to update
     * @param additionalMetadata Additional data to pass to server (optional)
     * @param file file to upload (optional)
     * @return ModelApiResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun uploadFile(petId: Long, additionalMetadata: String? = null, file: File? = null) : ModelApiResponse {
        return uploadFileWithHttpInfo(petId = petId, additionalMetadata = additionalMetadata, file = file).map { localVarResponse ->
            when (localVarResponse.responseType) {
                ResponseType.Success -> (localVarResponse as Success<*>).data as ModelApiResponse
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
     * uploads an image
     * 
     * @param petId ID of pet to update
     * @param additionalMetadata Additional data to pass to server (optional)
     * @param file file to upload (optional)
     * @return ApiResponse<ModelApiResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun uploadFileWithHttpInfo(petId: Long, additionalMetadata: String?, file: File?) : Future<ApiResponse<ModelApiResponse?>> {
        val vertxClient = WebClient.create(vertx)
        val request = vertxClient.requestAbs(HttpMethod.POST, UriTemplate.of("$basePath/pet/{petId}/uploadImage".replace("{"+"petId"+"}", encodeURIComponent(petId.toString()))))

        request.putHeader("Content-Type", "multipart/form-data")
        
        
        request.putHeader("Accept", "application/json")

        val form = io.vertx.core.MultiMap.caseInsensitiveMultiMap();
        additionalMetadata?.let { form.add("additionalMetadata", additionalMetadata) }
        file?.let { form.add("file", file.toString()) }


        accessToken?.let { accessToken ->
            request.bearerTokenAuthentication(accessToken)
        }

        return request
            .send()
            .map {
                val apiResponse: ApiResponse<ModelApiResponse?> = handleResponse(it)
                apiResponse
            }
    }


    private inline fun <reified T: Any?> responseBody(body: T): Buffer {
        return Buffer.buffer(Serializer.jacksonObjectMapper.writeValueAsBytes(body))
    }

}
