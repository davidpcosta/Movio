package me.davidcosta.movio.core.api.model.person

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class PersonModel(
    val adult: Boolean,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("also_known_as") val alsoKnownAs: List<String>,
    @SerializedName("biography") val biography: String,
    @SerializedName("birthday") val birthday: LocalDate?,
    @SerializedName("deathday") val deathday: String?,
    @SerializedName("gender") val gender: Int,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("known_for_department") val knownForDepartment: String,
    @SerializedName("imdb_id") val imdbId: String?,
    @SerializedName("place_of_birth") val placeOfBirth: String?,
    @SerializedName("popularity") val popularity: Double
)