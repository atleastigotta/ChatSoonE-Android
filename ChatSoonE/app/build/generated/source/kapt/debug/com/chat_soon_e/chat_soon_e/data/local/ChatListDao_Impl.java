package com.chat_soon_e.chat_soon_e.data.local;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.chat_soon_e.chat_soon_e.data.entities.ChatList;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatListDao_Impl implements ChatListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChatList> __insertionAdapterOfChatList;

  private final Converter __converter = new Converter();

  private final EntityDeletionOrUpdateAdapter<ChatList> __deletionAdapterOfChatList;

  private final EntityDeletionOrUpdateAdapter<ChatList> __updateAdapterOfChatList;

  private final SharedSQLiteStatement __preparedStmtOfUpdateIsNew;

  public ChatListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChatList = new EntityInsertionAdapter<ChatList>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ChatListTable` (`chatIdx`,`chat_name`,`profileImg`,`latest_time`,`latest_message`,`isNew`,`isChecked`,`id`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatList value) {
        stmt.bindLong(1, value.getChatIdx());
        if (value.getChat_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChat_name());
        }
        if (value.getProfileImg() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProfileImg());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getLatest_time());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        if (value.getLatest_message() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLatest_message());
        }
        stmt.bindLong(6, value.isNew());
        final Integer _tmp_1;
        _tmp_1 = value.isChecked() == null ? null : (value.isChecked() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
        if (value.getId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getId());
        }
      }
    };
    this.__deletionAdapterOfChatList = new EntityDeletionOrUpdateAdapter<ChatList>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ChatListTable` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatList value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfChatList = new EntityDeletionOrUpdateAdapter<ChatList>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ChatListTable` SET `chatIdx` = ?,`chat_name` = ?,`profileImg` = ?,`latest_time` = ?,`latest_message` = ?,`isNew` = ?,`isChecked` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatList value) {
        stmt.bindLong(1, value.getChatIdx());
        if (value.getChat_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChat_name());
        }
        if (value.getProfileImg() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProfileImg());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getLatest_time());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        if (value.getLatest_message() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLatest_message());
        }
        stmt.bindLong(6, value.isNew());
        final Integer _tmp_1;
        _tmp_1 = value.isChecked() == null ? null : (value.isChecked() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
        if (value.getId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getId());
        }
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateIsNew = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE ChatListTable SET isNew= ? WHERE chatIdx= ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ChatList chatList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatList.insert(chatList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ChatList chatList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChatList.handle(chatList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ChatList chatList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChatList.handle(chatList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateIsNew(final int chatIdx, final int status) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateIsNew.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, status);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, chatIdx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateIsNew.release(_stmt);
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
