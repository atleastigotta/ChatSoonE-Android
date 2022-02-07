// Generated by view binder compiler. Do not edit!
package com.chat_soon_e.chat_soon_e.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.chat_soon_e.chat_soon_e.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainContentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final View mainBackgroundView;

  @NonNull
  public final ImageView mainBlockIv;

  @NonNull
  public final View mainBottomBarView;

  @NonNull
  public final ImageView mainCancelIv;

  @NonNull
  public final ImageView mainChatIv;

  @NonNull
  public final RecyclerView mainChatListRecyclerView;

  @NonNull
  public final ConstraintLayout mainContent;

  @NonNull
  public final ImageView mainDeleteIv;

  @NonNull
  public final ImageView mainFolderIv;

  @NonNull
  public final ImageView mainFolderModeIv;

  @NonNull
  public final ImageView mainMyFolderIv;

  @NonNull
  public final ImageView mainSettingMenuIv;

  @NonNull
  public final TextView mainTitleTv;

  @NonNull
  public final ImageView mainUpdateIv;

  private ActivityMainContentBinding(@NonNull ConstraintLayout rootView,
      @NonNull View mainBackgroundView, @NonNull ImageView mainBlockIv,
      @NonNull View mainBottomBarView, @NonNull ImageView mainCancelIv,
      @NonNull ImageView mainChatIv, @NonNull RecyclerView mainChatListRecyclerView,
      @NonNull ConstraintLayout mainContent, @NonNull ImageView mainDeleteIv,
      @NonNull ImageView mainFolderIv, @NonNull ImageView mainFolderModeIv,
      @NonNull ImageView mainMyFolderIv, @NonNull ImageView mainSettingMenuIv,
      @NonNull TextView mainTitleTv, @NonNull ImageView mainUpdateIv) {
    this.rootView = rootView;
    this.mainBackgroundView = mainBackgroundView;
    this.mainBlockIv = mainBlockIv;
    this.mainBottomBarView = mainBottomBarView;
    this.mainCancelIv = mainCancelIv;
    this.mainChatIv = mainChatIv;
    this.mainChatListRecyclerView = mainChatListRecyclerView;
    this.mainContent = mainContent;
    this.mainDeleteIv = mainDeleteIv;
    this.mainFolderIv = mainFolderIv;
    this.mainFolderModeIv = mainFolderModeIv;
    this.mainMyFolderIv = mainMyFolderIv;
    this.mainSettingMenuIv = mainSettingMenuIv;
    this.mainTitleTv = mainTitleTv;
    this.mainUpdateIv = mainUpdateIv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainContentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_content, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainContentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.main_background_view;
      View mainBackgroundView = ViewBindings.findChildViewById(rootView, id);
      if (mainBackgroundView == null) {
        break missingId;
      }

      id = R.id.main_block_iv;
      ImageView mainBlockIv = ViewBindings.findChildViewById(rootView, id);
      if (mainBlockIv == null) {
        break missingId;
      }

      id = R.id.main_bottom_bar_view;
      View mainBottomBarView = ViewBindings.findChildViewById(rootView, id);
      if (mainBottomBarView == null) {
        break missingId;
      }

      id = R.id.main_cancel_iv;
      ImageView mainCancelIv = ViewBindings.findChildViewById(rootView, id);
      if (mainCancelIv == null) {
        break missingId;
      }

      id = R.id.main_chat_iv;
      ImageView mainChatIv = ViewBindings.findChildViewById(rootView, id);
      if (mainChatIv == null) {
        break missingId;
      }

      id = R.id.main_chat_list_recycler_view;
      RecyclerView mainChatListRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (mainChatListRecyclerView == null) {
        break missingId;
      }

      ConstraintLayout mainContent = (ConstraintLayout) rootView;

      id = R.id.main_delete_iv;
      ImageView mainDeleteIv = ViewBindings.findChildViewById(rootView, id);
      if (mainDeleteIv == null) {
        break missingId;
      }

      id = R.id.main_folder_iv;
      ImageView mainFolderIv = ViewBindings.findChildViewById(rootView, id);
      if (mainFolderIv == null) {
        break missingId;
      }

      id = R.id.main_folder_mode_iv;
      ImageView mainFolderModeIv = ViewBindings.findChildViewById(rootView, id);
      if (mainFolderModeIv == null) {
        break missingId;
      }

      id = R.id.main_my_folder_iv;
      ImageView mainMyFolderIv = ViewBindings.findChildViewById(rootView, id);
      if (mainMyFolderIv == null) {
        break missingId;
      }

      id = R.id.main_setting_menu_iv;
      ImageView mainSettingMenuIv = ViewBindings.findChildViewById(rootView, id);
      if (mainSettingMenuIv == null) {
        break missingId;
      }

      id = R.id.main_title_tv;
      TextView mainTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (mainTitleTv == null) {
        break missingId;
      }

      id = R.id.main_update_iv;
      ImageView mainUpdateIv = ViewBindings.findChildViewById(rootView, id);
      if (mainUpdateIv == null) {
        break missingId;
      }

      return new ActivityMainContentBinding((ConstraintLayout) rootView, mainBackgroundView,
          mainBlockIv, mainBottomBarView, mainCancelIv, mainChatIv, mainChatListRecyclerView,
          mainContent, mainDeleteIv, mainFolderIv, mainFolderModeIv, mainMyFolderIv,
          mainSettingMenuIv, mainTitleTv, mainUpdateIv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
