package uz.salimovdeveloper.restapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import uz.salimovdeveloper.restapi.models.MyTodo
import uz.salimovdeveloper.restapi.retrofit.ApiClient
import uz.salimovdeveloper.restapi.utils.Resource

class TodoViewModel : ViewModel() {
    private val liveData = MutableLiveData<Resource<List<MyTodo>>>()

    fun getAllTodo(): MutableLiveData<Resource<List<MyTodo>>> {
        val apiService = ApiClient.getApiService()
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
}