package me.davidcosta.movio.core.api.services

import me.davidcosta.movio.core.api.model.person.PersonCreditsResultModel
import me.davidcosta.movio.core.api.model.person.PersonModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonApi {
    @GET("person/{person_id}?language=pt-BR")
    suspend fun fetchPersonDetails(
        @Path("person_id") personId: Int
    ) : PersonModel

    @GET("person/{person_id}/combined_credits?language=pt-BR")
    suspend fun fetchPersonCredits(
        @Path("person_id") personId: Int
    ) : PersonCreditsResultModel
}