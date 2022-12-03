package uz.salimovdeveloper.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import uz.salimovdeveloper.restapi.adapters.RvAdapter
import uz.salimovdeveloper.restapi.databinding.ActivityMainBinding
import uz.salimovdeveloper.restapi.utils.Status
import uz.salimovdeveloper.restapi.viewmodel.TodoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoViewModel: TodoViewModel
    private val TAG = "MainActivity"
    private lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        rvAdapter = RvAdapter()
        binding.rv.adapter = rvAdapter
        todoViewModel.getAllTodo()
            .observe(this) {
                when (it.status) {
                    Status.LOADING -> {
                        Log.d(TAG, "onCreate: Loading")
                        binding.progress.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        Log.d(TAG, "onCreate: Error ${it.message}")
                        Toast.makeText(this, "Error ${it.message}", Toast.LENGTH_SHORT).show()
                    }
                    Status.SUCCESS -> {
                        Log.d(TAG, "onCreate: Success ${it.data}")
                        rvAdapter.list = it.data!!
                        rvAdapter.notifyDataSetChanged()
                        binding.progress.visibility = View.GONE
                    }
                }
            }
    }
}