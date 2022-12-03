package uz.salimovdeveloper.restapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.salimovdeveloper.restapi.databinding.ItemRvBinding
import uz.salimovdeveloper.restapi.models.MyTodo

class RvAdapter(var list: List<MyTodo> = emptyList()) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(myTodo: MyTodo) {
            itemRvBinding.itemName.text = myTodo.sarlavha
            itemRvBinding.itemAbout.text = myTodo.matn
            itemRvBinding.itemXolati.text = myTodo.holat
            itemRvBinding.itemMuddati.text = myTodo.oxirgi_muddat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}