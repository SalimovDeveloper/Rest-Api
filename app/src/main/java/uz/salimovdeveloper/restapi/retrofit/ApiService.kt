package uz.salimovdeveloper.restapi.retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import uz.salimovdeveloper.restapi.models.MyTodo
import uz.salimovdeveloper.restapi.models.MyTodoRequest
import uz.salimovdeveloper.restapi.models.MyTodoResponse

interface ApiService {

    @GET("plan")
    suspend fun getAllTodo():List<MyTodo>

    @POST("plan/")
    suspend fun addTodo(@Body myTodoRequest: MyTodoRequest):MyTodoResponse
}