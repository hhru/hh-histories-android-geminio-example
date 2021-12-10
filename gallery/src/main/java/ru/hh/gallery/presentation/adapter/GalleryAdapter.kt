package ru.hh.gallery.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.hh.core.network.ApiFactory
import ru.hh.gallery.R
import ru.hh.gallery.data.model.GalleryModel

internal class GalleryAdapter : PagingDataAdapter<GalleryModel, GalleryAdapter.ViewHolder>(DiffUtilCallback) {

    companion object {
        private val DiffUtilCallback = object : DiffUtil.ItemCallback<GalleryModel>() {
            override fun areItemsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        if (item != null) {
            holder.description.text = item.name
            Glide.with(holder.image.context)
                .load(ApiFactory.createImageUrl(item.url))
                .fitCenter()
                .placeholder(R.drawable.spinner_ring)
                .into(holder.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_gallery_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val description: TextView = view.findViewById(R.id.view_gallery_description)
        val image: ImageView = view.findViewById(R.id.view_gallery_image)
    }
}
