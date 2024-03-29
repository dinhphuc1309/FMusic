package com.example.fmusic.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fmusic.MainActivity
import com.example.fmusic.R
import com.example.fmusic.activity.PlayActivity
import com.example.fmusic.models.BaiHatModel
import com.squareup.picasso.Picasso

class PlayListAdapter(listBaiHat: ArrayList<BaiHatModel>): RecyclerView.Adapter<PlayListAdapter.ViewHold>() {
    private var mListBaiHat: ArrayList<BaiHatModel> = listBaiHat

    fun setFilteredList( filteredList:ArrayList<BaiHatModel>){
        this.mListBaiHat = filteredList
        notifyDataSetChanged()
    }

    inner class ViewHold(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imgBaiHatItem : ImageView = itemView.findViewById(R.id.imgBaiHatItem)
        val txtTenBaiHatItem : TextView = itemView.findViewById(R.id.txtTenBaiHatItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bai_hat, parent, false)
        return ViewHold(view)
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        Picasso.get().load(mListBaiHat[position].hinhbaihat).into(holder.imgBaiHatItem)
        holder.txtTenBaiHatItem.setText(mListBaiHat[position].tenbaihat)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(view!!.context, PlayActivity::class.java)
                intent.putExtra("listBaiHat", mListBaiHat)
                intent.putExtra("viTriBaiHat", holder.adapterPosition)
                view!!.context.startActivity(intent)
            }
        })
    }

    override fun getItemCount(): Int {
        return mListBaiHat.size
    }
}