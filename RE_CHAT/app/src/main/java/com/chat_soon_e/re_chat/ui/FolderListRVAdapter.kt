package com.chat_soon_e.re_chat.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.re_chat.data.entities.Folder
import com.chat_soon_e.re_chat.databinding.ItemFolderListBinding

class FolderListRVAdapter(): RecyclerView.Adapter<FolderListRVAdapter.ViewHolder>() {
    private val folderList = ArrayList<Folder>()

    // 클릭 인터페이스
    interface MyItemClickListener {
        fun onFolderClick(itemBinding: ItemFolderListBinding, itemPosition: Int)
    }

    // 리스너 객체를 저장하는 변수
    private lateinit var mItemClickListener: MyItemClickListener

    // 리스너 객체를 외부에서 전달받는 함수
    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
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

    // RecyclerView에 데이터 연결
    @SuppressLint("NotifyDataSetChanged")
    fun addFolderList(folderList: ArrayList<Folder>) {
        this.folderList.clear()
        this.folderList.addAll(folderList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = folderList.size

    inner class ViewHolder(val binding: ItemFolderListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(folder: Folder) {
            binding.itemFolderListIv.setImageResource(folder.folderImg)
            binding.itemFolderListTv.text = folder.folderName
        }
    }
}