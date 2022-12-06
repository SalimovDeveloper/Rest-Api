package uz.salimovdeveloper.restapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import uz.salimovdeveloper.restapi.models.MyTodo
import uz.salimovdeveloper.restapi.models.MyTodoRequest
import uz.salimovdeveloper.restapi.models.MyTodoResponse
import uz.salimovdeveloper.restapi.retrofit.ApiClient
import uz.salimovdeveloper.restapi.utils.Resource
import uz.salimovdeveloper.restapi.utils.Status

class TodoViewModel : ViewModel() {
    private val liveData = MutableLiveData<Resource<List<MyTodo>>>()
    private val apiService = ApiClient.getApiService()
    fun getAllTodo(): MutableLiveData<Resource<List<MyTodo>>> {

        viewModelScope.launch {
            liveData.postValue(Resource.loading("loading"))
            try {

                coroutineScope {
                    val list = async {

                        apiService.getAllTodo()

                    }.await()

                    liveData.postValue(Resource.success(list))
                }

            } catch (e: Exception) {
                liveData.postValue(Resource.error(e.message))
            }
        }
        return liveData
    }

    private var postLiveData = MutableLiveData<Resource<MyTodoResponse>>()
    fun addMyTodo(myTodoRequest: MyTodoRequest) {
        viewModelScope.launch {
            postLiveData.postValue(Resource.loading("Loading post"))
            try {

                coroutineScope {
                    val response = async {

                        apiService.addTodo(myTodoRequest)

                    }.await()
                    postLiveData.postValue(Resource.success(response))
                    getAllTodo()
                }

            } catch (e: Exception) {
                postLiveData.postValue(Resource.error(e.message))

            }
        }
    }
}