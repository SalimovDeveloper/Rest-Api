package uz.salimovdeveloper.restapi.retrofit

import retrofit2.http.GET
import uz.salimovdeveloper.restapi.models.MyTodo

interface ApiService {

    @GET
    suspend fun getAllTodo():List<MyTodo>
}