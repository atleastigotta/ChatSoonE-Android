package com.chat_soon_e.chat_soon_e.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.entities.ChatViewType
import com.chat_soon_e.chat_soon_e.databinding.ItemChatListChooseBinding
import com.chat_soon_e.chat_soon_e.databinding.ItemChatListDefaultBinding

class MainRVAdapter(private var chatList: ArrayList<Chat>, private val mItemClickListener: MyItemClickListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var selectedIndex = -1
    private var selectedItemList: SparseBooleanArray = SparseBooleanArray(0)

    // 클릭 인터페이스
    interface MyItemClickListener {
        fun onDefaultChatClick(view: View, position: Int)   // 채팅 대화 화면으로 이동
        fun onChooseChatClick(view: View, position: Int)    // 목록 선택
    }

    // 뷰홀더를 생성해줘야 할 때 호출되는 함수로, 아이템 뷰 객체를 만들어서 뷰 홀더에 던져준다.
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ChatViewType.CHOOSE -> {
                ChooseViewHolder(
                    ItemChatListChooseBinding.inflate(
                    LayoutInflater.from(viewGroup.context), viewGroup, false),
                    mItemClickListener = mItemClickListener)
            }
            else -> {
                DefaultViewHolder(
                    ItemChatListDefaultBinding.inflate(
                    LayoutInflater.from(viewGroup.context), viewGroup, false))
            }
        }
    }

    // 뷰홀더에 데이터 바인딩을 해줘야 할 때마다 호출되는 함수
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(chatList[position].viewType) {
            ChatViewType.CHOOSE -> {
                (holder as ChooseViewHolder).bind(chatList[position])
                (holder as ChooseViewHolder).itemView.isSelected = isItemSelected(position)
            }
            else -> {
                (holder as DefaultViewHolder).bind(chatList[position])
                (holder as DefaultViewHolder).itemView.isSelected = isItemSelected(position)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun removeSelectedItemList() {
        val newChatList = chatList.filter { chat -> !chat.isChecked }
        chatList = newChatList as ArrayList<Chat>
        notifyDataSetChanged()
    }

    // selectedItemList 초기화
    @SuppressLint("NotifyDataSetChanged")
    fun clearSelectedItemList() {
        selectedItemList.clear()
        notifyDataSetChanged()
    }

    // will toggle the selection of items
    private fun toggleItemSelected(view: View?, position: Int) {
        if(selectedItemList.get(position, false)) {
            selectedItemList.delete(position)
//            view?.setBackgroundColor((Color.parseColor("#FFFFFFFF")))
        } else {
            selectedItemList.put(position, true)
//            view?.setBackgroundColor((Color.parseColor("#FED7D3")))
        }
        Log.d("MAIN/SELECTED-LIST", selectedItemList.toString())
        notifyItemChanged(position)
    }

    fun setChecked(position: Int) {
        chatList[position].isChecked = !chatList[position].isChecked
        notifyItemChanged(position)
    }

    // 아이템뷰가 선택되었는지를 알려주는 함수
    private fun isItemSelected(position: Int): Boolean {
        return selectedItemList.get(position, false)
    }

    // 데이터셋의 크기를 알려주는 함수
    override fun getItemCount(): Int = chatList.size

    // 직접 설정한 뷰타입으로 설정되게 만든다.
    override fun getItemViewType(position: Int): Int = chatList[position].viewType

    // 뷰타입 설정
    @SuppressLint("NotifyDataSetChanged")
    fun setViewType(currentMode: Int) {
        val newChatList = ArrayList<Chat>()
        for(i in 0 until chatList.size) {
            if(currentMode == 0) {
                // 일반 모드
                chatList[i].viewType = ChatViewType.DEFAULT
            } else {
                // 선택 모드
                chatList[i].viewType = ChatViewType.CHOOSE
            }
            newChatList.add(chatList[i])
        }
        this.chatList = newChatList
        notifyDataSetChanged()
    }

    // 디폴트 뷰홀더
    inner class DefaultViewHolder(private val binding: ItemChatListDefaultBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.itemChatListDefaultLayout.setOnClickListener {
                toggleItemSelected(null, position = bindingAdapterPosition)
                mItemClickListener.onDefaultChatClick(itemView, position = bindingAdapterPosition)
            }
        }

        fun bind(chat: Chat) {
            // 뷰 바인딩
            binding.itemChatListNameTv.text = chat.name
            binding.itemChatListContentTv.text = chat.message
        }
    }

    // 선택 모드 뷰홀더
    inner class ChooseViewHolder(private val binding: ItemChatListChooseBinding, private val mItemClickListener: MyItemClickListener)
        : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.itemChatListChooseLayout.setOnClickListener {
                toggleItemSelected(itemView, position = bindingAdapterPosition)
                mItemClickListener.onChooseChatClick(itemView, position = bindingAdapterPosition)
            }
        }

        fun bind(chat: Chat) {
            // 뷰 바인딩
            binding.itemChatListNameTv.text = chat.name
            binding.itemChatListContentTv.text = chat.message
        }
    }
}