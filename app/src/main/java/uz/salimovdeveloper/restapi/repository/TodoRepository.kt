package uz.salimovdeveloper.restapi.repository

import uz.salimovdeveloper.restapi.retrofit.ApiService

class TodoRepository(val apiService: ApiService) {
    suspend fun getAllTodo() = apiService.getAllTodo()
}