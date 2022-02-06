package com.chat_soon_e.chat_soon_e.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.databinding.ItemFolderListBinding

class FolderListRVAdapter(private val folderList: ArrayList<Folder>): RecyclerView.Adapter<FolderListRVAdapter.ViewHolder>() {

    interface MyItemClickListener {
        fun onFolderClick(itemBinding: ItemFolderListBinding, itemPosition: Int)
    }

    // 리스너 객체를 저장하는 변수
    private lateinit var mItemClickListener: FolderListRVAdapter.MyItemClickListener

    // 리스너 객체를 외부에서 전달받는 함수
    fun setMyItemClickListener(itemClickListener: FolderListRVAdapter.MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemFolderListBinding = ItemFolderListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(folderList[position])

        holder.itemView.setOnClickListener {
            mItemClickListener.onFolderClick(holder.binding, position)
        }
    }

    override fun getItemCount(): Int = folderList.size

    inner class ViewHolder(val binding: ItemFolderListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(folder: Folder) {
            binding.itemFolderListIv.setImageResource(folder.folderImg)
            binding.itemFolderListTv.text = folder.folderName
        }
    }
}