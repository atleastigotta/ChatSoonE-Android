package com.chat_soon_e.chat_soon_e.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.databinding.ItemChatListBinding

class MainRVAdapter(private val chatList: ArrayList<Chat>): RecyclerView.Adapter<MainRVAdapter.ViewHolder>() {

    // 클릭 인터페이스
    interface MyItemClickListener {
        fun onChatLongClick(view: View, position: Int)
    }

    // 리스너 객체를 저장하는 변수
    private lateinit var mItemClickListener: MyItemClickListener

    // 리스너 객체를 외부에서 전달받는 함수
    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    // 뷰홀더를 생성해줘야 할 때 호출되는 함수로, 아이템 뷰 객체를 만들어서 뷰 홀더에 던져준다.
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemChatListBinding = ItemChatListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    // 뷰홀더에 데이터 바인딩을 해줘야 할 때마다 호출되는 함수
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatList[position])
        holder.itemView.setOnLongClickListener {
            mItemClickListener.onChatLongClick(holder.itemView, position)
            return@setOnLongClickListener true
        }
    }

    // 데이터셋의 크기를 알려주는 함수
    override fun getItemCount(): Int = chatList.size

    // 뷰홀더
    inner class ViewHolder(private val binding: ItemChatListBinding): RecyclerView.ViewHolder(binding.root) {
//        init {
//            itemView.setOnLongClickListener {
//                mItemClickListener.onChatLongClick(this, adapterPosition)
//                return@setOnLongClickListener true
//            }
//        }

        // 뷰 객체가 담겨있는 binding에 데이터 리스트에서 받아온 데이터들을 넣어준다.
        fun bind(chat: Chat) {
            // 프로필 사진 어떻게 처리할 건지
            binding.itemChatListNameTv.text = chat.name
            binding.itemChatListContentTv.text = chat.content
            binding.itemChatListDateTimeTv.text = chat.dateTime
        }
    }
}