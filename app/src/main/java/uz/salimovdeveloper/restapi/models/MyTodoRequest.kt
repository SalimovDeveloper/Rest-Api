package uz.salimovdeveloper.restapi.models

data class MyTodoRequest(
    val holat: String,
    val matn: String,
    val oxirgi_muddat: String,
    val sarlavha: String
)