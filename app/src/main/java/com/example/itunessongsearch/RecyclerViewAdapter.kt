package com.example.itunessongsearch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itunessongsearch.model.DataModel

class RecyclerViewAdapter(val dataModel: List<DataModel?>?) :
    RecyclerView.Adapter<RecyclerViewAdapter.DataModelVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataModelVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return DataModelVH(view)
    }

    override fun onBindViewHolder(holder: DataModelVH, position: Int) {
        val dataModel = dataModel!!.get(position)
        holder.kind.text = dataModel!!.getKind()
        holder.artistName.text = dataModel.getArtistName()
        holder.collectionName.text = dataModel.getCollectionName()
        holder.trackName.text = dataModel.getTrackName()

    }

    override fun getItemCount(): Int {
        return dataModel!!.size
    }

    class DataModelVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var kind = itemView.findViewById<TextView>(R.id.kind)
        var artistName = itemView.findViewById<TextView>(R.id.artistName)
        var collectionName = itemView.findViewById<TextView>(R.id.collectionName)
        var trackName = itemView.findViewById<TextView>(R.id.trackName)
    }

}