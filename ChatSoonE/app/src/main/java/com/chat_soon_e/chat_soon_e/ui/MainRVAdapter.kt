package com.chat_soon_e.chat_soon_e.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.databinding.ItemChatListBinding

class MainRVAdapter(private val chatList: ArrayList<Chat>): RecyclerView.Adapter<MainRVAdapter.ViewHolder>() {

    interface MyItemClickListener {
        fun onChatClick(chatIdx: Int)
    }

    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemChatListBinding = ItemChatListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatList[position])
        holder.itemView.setOnClickListener {
            mItemClickListener.onChatClick(chatList[position].idx)
        }
    }

    override fun getItemCount(): Int = chatList.size

    inner class ViewHolder(private val binding: ItemChatListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            // 프로필 사진 어떻게 처리할 건지
            binding.itemChatListNameTv.text = chat.name
            //binding.itemChatListContentTv.text = chat.content
            binding.itemChatListDateTimeTv.text = chat.dateTime
        }
    }
}