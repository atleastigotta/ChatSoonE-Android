package com.chat_soon_e.chat_soon_e.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding

class MyFolderRVAdapter(private val folderList: ArrayList<Folder>): RecyclerView.Adapter<MyFolderRVAdapter.ViewHolder>() {
    // 클릭 인터페이스
    interface MyItemClickListener {
        fun onFolderClick(view: View, position: Int)
        fun onFolderLongClick(view: View, position: Int)
    }

    // 리스너 객체를 저장하는 변수수
   private lateinit var mItemClickListener: MyItemClickListener

   // 리스너 객체를 외부에서 전달받는 함수
   fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
       mItemClickListener = itemClickListener
   }

    // 뷰홀더를 생성해줘야 할 때 호출되는 함수
    // 아이템 뷰 객체를 만들어서 뷰홀더에 던져준다.
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMyFolderBinding = ItemMyFolderBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    // 뷰홀더에 데이터 바인딩을 해줘야 할 때마다 호출되는 함수
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(folderList[position])
        holder.binding.itemMyFolderIv.setOnClickListener {
            mItemClickListener.onFolderClick(holder.binding.itemMyFolderIv, position)
        }

        holder.binding.itemMyFolderIv.setOnLongClickListener {
            mItemClickListener.onFolderLongClick(holder.binding.itemMyFolderIv, position)
            return@setOnLongClickListener false
        }
    }

    // 데아터셋의 크기 반환
    override fun getItemCount(): Int = folderList.size

    // 뷰홀더
    inner class ViewHolder(val binding: ItemMyFolderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(folder: Folder) {
            binding.itemMyFolderTv.text = folder.name
        }
    }
}