package com.example.athletes_net_worth
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.high_recyclerview_layout.view.*
import kotlinx.android.synthetic.main.low_recyclerview_layout.view.*

class RecyclerViewAdapter(private val items: ArrayList<ItemModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val LOW_ITEMS = 0
        const val HIGH_ITEMS = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == LOW_ITEMS)
            return LowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.low_recyclerview_layout, parent, false))
        else
            return HighViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.high_recyclerview_layout, parent, false))
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LowViewHolder)
            holder.onBind()
        else if(holder is HighViewHolder)
            holder.onBind()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class LowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var model: ItemModel

        fun onBind() {
            model = items[adapterPosition]
            itemView.lowImageView.setImageResource(model.image)
            itemView.lowTextView.text = model.title
            itemView.lowName.text = model.name
        }
    }

    inner class HighViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private lateinit var model: ItemModel

        fun onBind() {
            model = items[adapterPosition]
            itemView.highImageView.setImageResource(model.image)
            itemView.highTextView.text = model.title
            itemView.highName.text = model.name
        }
    }

    override fun getItemViewType(position: Int): Int {
        val model = items[position]

        if(model.type == 0) {
            return LOW_ITEMS
        }

        return HIGH_ITEMS
    }
}