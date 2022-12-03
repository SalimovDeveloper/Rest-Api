package uz.salimovdeveloper.restapi.retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL = "hvax.pythonanywhere.com/"

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService():ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}