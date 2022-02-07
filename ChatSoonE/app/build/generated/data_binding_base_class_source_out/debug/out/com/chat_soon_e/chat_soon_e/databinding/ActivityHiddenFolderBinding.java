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

public final class ActivityHiddenFolderBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final View hiddenFolderBackgroundView;

  @NonNull
  public final ImageView hiddenFolderHiddenFolderIv;

  @NonNull
  public final TextView hiddenFolderHiddenFolderTv;

  @NonNull
  public final View hiddenFolderLineView;

  @NonNull
  public final RecyclerView hiddenFolderListRecyclerView;

  @NonNull
  public final ImageView hiddenFolderMyFolderIv;

  @NonNull
  public final TextView hiddenFolderMyFolderTv;

  private ActivityHiddenFolderBinding(@NonNull ConstraintLayout rootView,
      @NonNull View hiddenFolderBackgroundView, @NonNull ImageView hiddenFolderHiddenFolderIv,
      @NonNull TextView hiddenFolderHiddenFolderTv, @NonNull View hiddenFolderLineView,
      @NonNull RecyclerView hiddenFolderListRecyclerView, @NonNull ImageView hiddenFolderMyFolderIv,
      @NonNull TextView hiddenFolderMyFolderTv) {
    this.rootView = rootView;
    this.hiddenFolderBackgroundView = hiddenFolderBackgroundView;
    this.hiddenFolderHiddenFolderIv = hiddenFolderHiddenFolderIv;
    this.hiddenFolderHiddenFolderTv = hiddenFolderHiddenFolderTv;
    this.hiddenFolderLineView = hiddenFolderLineView;
    this.hiddenFolderListRecyclerView = hiddenFolderListRecyclerView;
    this.hiddenFolderMyFolderIv = hiddenFolderMyFolderIv;
    this.hiddenFolderMyFolderTv = hiddenFolderMyFolderTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHiddenFolderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHiddenFolderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_hidden_folder, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHiddenFolderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.hidden_folder_background_view;
      View hiddenFolderBackgroundView = ViewBindings.findChildViewById(rootView, id);
      if (hiddenFolderBackgroundView == null) {
        break missingId;
      }

      id = R.id.hidden_folder_hidden_folder_iv;
      ImageView hiddenFolderHiddenFolderIv = ViewBindings.findChildViewById(rootView, id);
      if (hiddenFolderHiddenFolderIv == null) {
        break missingId;
      }

      id = R.id.hidden_folder_hidden_folder_tv;
      TextView hiddenFolderHiddenFolderTv = ViewBindings.findChildViewById(rootView, id);
      if (hiddenFolderHiddenFolderTv == null) {
        break missingId;
      }

      id = R.id.hidden_folder_line_view;
      View hiddenFolderLineView = ViewBindings.findChildViewById(rootView, id);
      if (hiddenFolderLineView == null) {
        break missingId;
      }

      id = R.id.hidden_folder_list_recycler_view;
      RecyclerView hiddenFolderListRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (hiddenFolderListRecyclerView == null) {
        break missingId;
      }

      id = R.id.hidden_folder_my_folder_iv;
      ImageView hiddenFolderMyFolderIv = ViewBindings.findChildViewById(rootView, id);
      if (hiddenFolderMyFolderIv == null) {
        break missingId;
      }

      id = R.id.hidden_folder_my_folder_tv;
      TextView hiddenFolderMyFolderTv = ViewBindings.findChildViewById(rootView, id);
      if (hiddenFolderMyFolderTv == null) {
        break missingId;
      }

      return new ActivityHiddenFolderBinding((ConstraintLayout) rootView,
          hiddenFolderBackgroundView, hiddenFolderHiddenFolderIv, hiddenFolderHiddenFolderTv,
          hiddenFolderLineView, hiddenFolderListRecyclerView, hiddenFolderMyFolderIv,
          hiddenFolderMyFolderTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
