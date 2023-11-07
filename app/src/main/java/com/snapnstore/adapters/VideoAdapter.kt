package com.snapnstore.adapters

import android.content.Context
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.snapnstore.utils.FileData
import com.snapnstore.utils.toReadableDuration
import com.snapnstore.utils.toReadableFileSize
import com.snapnstore.databinding.ItemVideoDataBinding

class VideoAdapter(private val context: Context, private val list: List<FileData>, private val onClick: (Uri) -> Unit): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class VideoViewHolder(private val binding: ItemVideoDataBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: FileData) {
            binding.tvFileName.text = item.fileName
            binding.tvFileSize.text = item.fileSize.toReadableFileSize()
            binding.tvFileType.text = item.fileMimeType

            val retriever = MediaMetadataRetriever()
            retriever.setDataSource(context, item.fileUri)
            val width = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH)
            val height = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT)
            val duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            binding.tvVideoResolution.text = String.format("%s x %s px", width, height)
            binding.tvFileDuration.text = duration?.toLong()?.toReadableDuration() ?: "0s"


            binding.ivThumbnail.setImageBitmap(retriever.getFrameAtTime(1))

            binding.btnPlay.setOnClickListener {
                onClick(item.fileUri)
            }
        }
    }
}