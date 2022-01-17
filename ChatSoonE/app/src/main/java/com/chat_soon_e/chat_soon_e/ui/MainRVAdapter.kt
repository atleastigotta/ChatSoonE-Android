package com.chat_soon_e.chat_soon_e.ui

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.databinding.ItemChatListBinding

class MainRVAdapter(private val chatList: ArrayList<Chat>): RecyclerView.Adapter<MainRVAdapter.ViewHolder>() {
    // 현재 선택된 position을 저장할 변수
    // 현재 position과 일치할 경우 배경을 바꾸고, 그 외에는 하얀색 (default) 처리
    var selectedPosition = -1

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

        // RecylcerView 커스텀
        // 클릭된 아이템 뷰일 경우 와이어 프레임에 나온 것처럼 배경 회색 처리
        if(selectedPosition == position) {
            holder.itemView.setBackgroundColor(Color.LTGRAY)
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE)
        }

        holder.itemView.setOnLongClickListener {
            // 아이템 뷰의 항목을 길게 클릭했을 때 selectPosition을 beforePosition에 저장한 후
            // 현재 position으로 바꿔준다.
            val beforePosition = selectedPosition
            selectedPosition = position

            // beforePosition, selectPosition을 전달해줌으로써 해당 항목들의 레이아웃이 다시 생성되고, 스타일이 업데이트 된다.
            notifyItemChanged(beforePosition)
            notifyItemChanged(selectedPosition)
            // notifyDataSetChanged()

            mItemClickListener.onChatLongClick(holder.binding.itemChatListDateTimeTv, position)
            return@setOnLongClickListener true
        }
    }

    // 데이터셋의 크기를 알려주는 함수
    override fun getItemCount(): Int = chatList.size

    // 뷰홀더
    inner class ViewHolder(val binding: ItemChatListBinding): RecyclerView.ViewHolder(binding.root) {
        // 뷰 객체가 담겨있는 binding에 데이터 리스트에서 받아온 데이터들을 넣어준다.
        fun bind(chat: Chat) {
            // 프로필 사진 어떻게 처리할 건지
            binding.itemChatListNameTv.text = chat.name
            binding.itemChatListContentTv.text = chat.content
            binding.itemChatListDateTimeTv.text = chat.dateTime
        }
    }
}