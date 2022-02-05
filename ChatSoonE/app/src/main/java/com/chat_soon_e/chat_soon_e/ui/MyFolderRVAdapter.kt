package com.chat_soon_e.chat_soon_e.ui

import android.annotation.SuppressLint
import android.view.*
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.chat_soon_e.chat_soon_e.R
import com.chat_soon_e.chat_soon_e.data.entities.Folder
import com.chat_soon_e.chat_soon_e.databinding.ItemMyFolderBinding

class MyFolderRVAdapter(private val mContext: MyFolderActivity): RecyclerView.Adapter<MyFolderRVAdapter.ViewHolder>() {
    private val folderList = ArrayList<Folder>()
    private lateinit var popup: PopupMenu
    private lateinit var binding: ItemMyFolderBinding
    private var currentPosition: Int = 0

    // 클릭 인터페이스
    interface MyItemClickListener {
        fun onRemoveFolder(idx: Int)
        fun onHideFolder(idx: Int)
        fun onFolderNameLongClick(binding: ItemMyFolderBinding, position: Int)
        fun onFolderClick(view: View, position: Int)
        fun onFolderLongClick(popup: PopupMenu)
    }

    // 리스너 객체를 저장하는 변수
    private lateinit var mItemClickListener: MyItemClickListener

    // 리스너 객체를 외부에서 전달받는 함수
    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    // 뷰홀더를 생성해줘야 할 때 호출되는 함수
    // 아이템 뷰 객체를 만들어서 뷰홀더에 던져준다.
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMyFolderBinding =
            ItemMyFolderBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    // 뷰홀더에 데이터 바인딩을 해줘야 할 때마다 호출되는 함수
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(folderList[position])
        binding = holder.binding

        // 폴더 이름 롱클릭 시 이름 변경할 수 있도록
        holder.binding.itemMyFolderTv.setOnLongClickListener {
            mItemClickListener.onFolderNameLongClick(holder.binding, position)
            return@setOnLongClickListener false
        }

        // 폴더 클릭 시 해당 폴더로 이동할 수 있도록
        holder.binding.itemMyFolderIv.setOnClickListener {
            mItemClickListener.onFolderClick(holder.binding.itemMyFolderIv, position)
        }

        // 폴더 아이템 롱클릭 시 팝업 메뉴 뜨도록
        holder.binding.itemMyFolderIv.setOnLongClickListener {
            // 팝업 메뉴: 이름 바꾸기, 아이콘 바꾸기, 삭제하기, 숨기기
            popup = PopupMenu(mContext, holder.itemView, Gravity.START, 0, R.style.MyFolderOptionPopupMenuTheme)
            popup.menuInflater.inflate(R.menu.popup_folder_option_menu, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item?.itemId) {
                    R.id.popup_folder_edit_menu_1 -> {
                        // 이름 바꾸기
                        mContext.changeFolderName(holder.binding)
                    }

                    R.id.popup_folder_edit_menu_2 -> {
                        // 아이콘 바꾸기
                        mContext.changeIcon(holder.binding, position, folderList)
                    }

                    R.id.popup_folder_edit_menu_3 -> {
                        // 삭제하기
                        mItemClickListener.onRemoveFolder(folderList[position].idx)
                        removeFolder(position)
                    }

                    R.id.popup_folder_edit_menu_4 -> {
                        // 숨기기
                        mItemClickListener.onHideFolder(folderList[position].idx)
                        removeFolder(position)
                    }
                }
                false
            }
            mItemClickListener.onFolderLongClick(popup)
            return@setOnLongClickListener false
        }
    }

    // 데아터셋의 크기 반환
    override fun getItemCount(): Int = folderList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addFolderList(folderList: ArrayList<Folder>) {
        this.folderList.clear()
        this.folderList.addAll(folderList)
        notifyDataSetChanged()
    }

    private fun removeFolder(position: Int) {
        folderList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount);
    }

    // 뷰홀더
    inner class ViewHolder(val binding: ItemMyFolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(folder: Folder) {
            binding.itemMyFolderTv.text = folder.folderName
            binding.itemMyFolderIv.setImageResource(folder.folderImg)
            currentPosition = bindingAdapterPosition
        }
    }
}