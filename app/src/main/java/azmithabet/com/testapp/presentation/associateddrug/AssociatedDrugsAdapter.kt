package azmithabet.com.testapp.presentation.associateddrug

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import azmithabet.com.testapp.R
import azmithabet.com.testapp.data.model.AssociatedDrug
import azmithabet.com.testapp.databinding.ItemDrageBinding

class AssociatedDrugsAdapter(private val itemClick :(AssociatedDrug)-> Unit) : RecyclerView.Adapter<MyViewHolder>() {
    private val associatedDrugList = ArrayList<AssociatedDrug>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(associatedDrugs: List<AssociatedDrug>) {
        associatedDrugList.clear()
        associatedDrugList.addAll(associatedDrugs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemDrageBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_drage,
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return associatedDrugList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(associatedDrugList[position])
        holder.itemView.setOnClickListener {
            itemClick(associatedDrugList[position])
        }
    }
}


class MyViewHolder(private val binding: ItemDrageBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(associatedDrug: AssociatedDrug) {
        binding.associatedDrug = associatedDrug

    }

}