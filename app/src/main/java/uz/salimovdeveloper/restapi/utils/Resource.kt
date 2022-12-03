package uz.salimovdeveloper.restapi.utils

import android.os.Message
import androidx.lifecycle.LiveData

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object{
        fun <T>success(data: T):Resource<T>{
            return Resource(Status.SUCCESS, data, null)
        }
        fun <T>error(message: String?):Resource<T>{
            return Resource(Status.ERROR, null, message)
        }
        fun <T>loading(message: String?):Resource<T>{
            return Resource(Status.LOADING, null, message)
        }
    }
}

