package com.chat_soon_e.chat_soon_e.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.data.entities.Chat
import com.chat_soon_e.chat_soon_e.data.entities.ChatList
import com.chat_soon_e.chat_soon_e.data.local.AppDatabase
import com.chat_soon_e.chat_soon_e.data.remote.auth.USER_ID
import com.chat_soon_e.chat_soon_e.databinding.ItemChatListBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainRVAdapter(private val chatList: ArrayList<Chat>, private val isSelectionMode: Boolean, private val context:Context): RecyclerView.Adapter<MainRVAdapter.ViewHolder>() {
//    현재 선택된 position을 저장할 변수
//    현재 position과 일치할 경우 배경을 바꾸고, 그 외에는 하얀색 (default) 처리
//    var selectedPosition = -1

//    선택한 리스트 아이템의 position 번호를 저장
//    private var selectedPosition = arrayListOf<Long>()

//    private val selectionList = mutableListOf<Long>()
//    selectedPosition의 아이템 정보를 출력하기 위한 람다 함수
//    var onItemSelectionChangedListener: ((MutableList<Long>) -> Unit)? = null
    private var selectedIndex = -1
    private var selectedItemList: SparseBooleanArray = SparseBooleanArray(0)

    // 클릭 인터페이스
    interface MyItemClickListener {
        fun onChatClick(view: View, position: Int)
        fun onChatLongClick(view: View, position: Int)
        fun onChatClickForFolder(view: View, position: Int)
    }

    // 리스너 객체를 저장하는 변수
    private lateinit var mItemClickListener: MyItemClickListener

    // 리스너 객체를 외부에서 전달받는 함수
    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    // 뷰홀더를 생성해줘야 할 때 호출되는 함수로, 아이템 뷰 객체를 만들어서 뷰 홀더에 던져준다.
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemChatListBinding = ItemChatListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

//        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_chat_list, viewGroup, false)
//        view.setOnClickListener {
//            val itemId = view?.tag
//            Log.d("MAIN/RV", "itemId: $itemId")
//
//            if(selectionList.contains(itemId)) {
//                selectionList.remove(itemId)
//            } else {
//                selectionList.add(itemId as Long)
//                notifyDataSetChanged()
//                onItemSelectionChangedListener?.let {
//                    it(selectionList)
//                }
//            }
//        }

        return ViewHolder(binding)
    }

    // 뷰홀더에 데이터 바인딩을 해줘야 할 때마다 호출되는 함수
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatList[position])
        holder.itemView.isSelected = isItemSelected(position)

        holder.itemView.setOnClickListener {
            toggleItemSelected(position)
            mItemClickListener.onChatClickForFolder(holder.itemView, position)
        }

        holder.itemView.setOnLongClickListener {
            toggleItemSelected(position)
            mItemClickListener.onChatLongClick(holder.itemView, position)
            return@setOnLongClickListener false
        }

    }

    // 선택한 아이템의 뷰 변경
    private fun toggleIcon(binding: ItemChatListBinding, position: Int) {
        if(selectedItemList.get(position, false)) {
            if(selectedIndex == position) selectedIndex = -1
        } else {
            if(selectedIndex == position) selectedIndex = -1
        }
    }

    // 리스트의 모든 아이템들을 불러와준다.
    fun getSelectedItemList(): List<Int> {
        val itemList: MutableList<Int> = ArrayList(selectedItemList.size())
        for (i in 0 until selectedItemList.size()) {
            itemList.add(selectedItemList.keyAt(i))
        }
        return itemList
    }

    // 리스트에서 삭제하길 원하는 아이템을 지워준다.
    fun removeItem(position: Int) {
        chatList.removeAt(position)
        selectedIndex = -1
    }

    private fun clear() {

    }

    // selectedItemList 초기화
    @SuppressLint("NotifyDataSetChanged")
    fun clearSelectedItemList() {
        selectedItemList.clear()
        notifyDataSetChanged()
    }

//    fun toggleSelection(position: Int) {
////        selectedIndex = position
//
//        if(selectedItemList.get(position, false)) {
//            selectedItemList.delete(position)
//        } else {
//            selectedItemList.put(position, true)
//        }
//        notifyItemChanged(position)
//    }

    // will toggle the selection of items
    private fun toggleItemSelected(position: Int) {
        if(selectedItemList.get(position, false)) {
            selectedItemList.delete(position)
        } else {
            selectedItemList.put(position, true)
        }
        notifyItemChanged(position)
    }

    private fun isItemSelected(position: Int): Boolean {
        return selectedItemList.get(position, false)
    }

    // 데이터셋의 크기를 알려주는 함수
    override fun getItemCount(): Int = chatList.size

//    아이템 아이디 반환
//    override fun getItemId(position: Int): Long = position.toLong()

    // 선택된 아이템의 개수를 반환
    fun selectedItemCount(): Int = selectedItemList.size()

    // 뷰홀더
    inner class ViewHolder(private val binding: ItemChatListBinding): RecyclerView.ViewHolder(binding.root) {
        // 뷰 객체가 담겨있는 binding에 데이터 리스트에서 받아온 데이터들을 넣어준다.
        fun bind(chat: Chat) {

            val db=AppDatabase.getInstance(context)!!
            val otherUser=db.otherUserDao().getOtherUserById(chat.other_user_idx)
            val name=otherUser.name
            if(name!=null){
                binding.itemChatListProfileIv.setImageBitmap(loadBitmap(name))
            }
            if(otherUser.name!=null)
                binding.itemChatListNameTv.text = otherUser.name
            binding.itemChatListContentTv.text = chat.message
            if(chat.postTime!=null)
                binding.itemChatListDateTimeTv.text = DateToString(chat.postTime)
        }
    }
    private fun DateToString(date:Date):String{
        //오늘이 아니라면 날짜만
        var str=""
        val today=Date()
        if(date.year == today.year && date.month == today.month && date.date==today.date){
            val time=SimpleDateFormat("a hh:mm")
            str= time.format(date).toString()
        }
        else{
            val time=SimpleDateFormat("MM월 DD일")
            str=time.format(time).toString()
        }
        return str
    }
    private fun loadBitmap(name: String): Bitmap {
        val file= File(context.cacheDir.toString())
        val files=file.listFiles()
        var list:String=""
        for (tempFile in files) {
            Log.d("MyTag", tempFile.name)
            //name이 들어가 있는 파일 찾기
            if (tempFile.name.contains(name)) {
                list=tempFile.name
            }
        }
        val path=context.cacheDir.toString()+"/"+list
        val bitmap= BitmapFactory.decodeFile(path)
        return bitmap
    }

}