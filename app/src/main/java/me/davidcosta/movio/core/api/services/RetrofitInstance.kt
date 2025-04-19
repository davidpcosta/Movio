package me.davidcosta.movio.core.api.services

import com.google.gson.GsonBuilder
import me.davidcosta.movio.BuildConfig
import me.davidcosta.movio.core.api.parser.LocalDateParser
import me.davidcosta.movio.core.api.parser.LocalDateTimeParser
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.LocalDateTime

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.TMDB_API)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }
}

private val gson =
    GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateParser())
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeParser())
        .create()

private val  okHttpClient: OkHttpClient
    get() = OkHttpClient().newBuilder()
        .addInterceptor(
            Interceptor { chain ->
                val request: Request = chain.request()
                    .newBuilder()
                    .header("accept", "application/json")
                    .header("Authorization", "Bearer ${BuildConfig.TMDB_TOKEN}")
                    .build()
                chain.proceed(request)
            }
        ).build()