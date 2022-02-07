package com.chat_soon_e.chat_soon_e.data.local;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.chat_soon_e.chat_soon_e.data.entities.ChatList;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
        return "INSERT OR ABORT INTO `ChatListTable` (`chatIdx`,`chat_name`,`profileImg`,`latest_time`,`latest_message`,`isGroup`,`isNew`,`isChecked`,`id`) VALUES (?,?,?,?,?,?,?,?,?)";
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
        stmt.bindLong(6, value.isGroup());
        stmt.bindLong(7, value.isNew());
        final Integer _tmp_1;
        _tmp_1 = value.isChecked() == null ? null : (value.isChecked() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_1);
        }
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getId());
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
        return "UPDATE OR ABORT `ChatListTable` SET `chatIdx` = ?,`chat_name` = ?,`profileImg` = ?,`latest_time` = ?,`latest_message` = ?,`isGroup` = ?,`isNew` = ?,`isChecked` = ?,`id` = ? WHERE `id` = ?";
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
        stmt.bindLong(6, value.isGroup());
        stmt.bindLong(7, value.isNew());
        final Integer _tmp_1;
        _tmp_1 = value.isChecked() == null ? null : (value.isChecked() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_1);
        }
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getId());
        }
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getId());
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

  @Override
  public List<ChatList> getChatList() {
    final String _sql = "SELECT * FROM ChatListTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
      final int _cursorIndexOfChatName = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_name");
      final int _cursorIndexOfProfileImg = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImg");
      final int _cursorIndexOfLatestTime = CursorUtil.getColumnIndexOrThrow(_cursor, "latest_time");
      final int _cursorIndexOfLatestMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "latest_message");
      final int _cursorIndexOfIsGroup = CursorUtil.getColumnIndexOrThrow(_cursor, "isGroup");
      final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<ChatList> _result = new ArrayList<ChatList>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ChatList _item;
        final int _tmpChatIdx;
        _tmpChatIdx = _cursor.getInt(_cursorIndexOfChatIdx);
        final String _tmpChat_name;
        if (_cursor.isNull(_cursorIndexOfChatName)) {
          _tmpChat_name = null;
        } else {
          _tmpChat_name = _cursor.getString(_cursorIndexOfChatName);
        }
        final String _tmpProfileImg;
        if (_cursor.isNull(_cursorIndexOfProfileImg)) {
          _tmpProfileImg = null;
        } else {
          _tmpProfileImg = _cursor.getString(_cursorIndexOfProfileImg);
        }
        final Date _tmpLatest_time;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfLatestTime)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfLatestTime);
        }
        _tmpLatest_time = __converter.fromTimestamp(_tmp);
        final String _tmpLatest_message;
        if (_cursor.isNull(_cursorIndexOfLatestMessage)) {
          _tmpLatest_message = null;
        } else {
          _tmpLatest_message = _cursor.getString(_cursorIndexOfLatestMessage);
        }
        final int _tmpIsGroup;
        _tmpIsGroup = _cursor.getInt(_cursorIndexOfIsGroup);
        final int _tmpIsNew;
        _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
        final Boolean _tmpIsChecked;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfIsChecked)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfIsChecked);
        }
        _tmpIsChecked = _tmp_1 == null ? null : _tmp_1 != 0;
        _item = new ChatList(_tmpChatIdx,_tmpChat_name,_tmpProfileImg,_tmpLatest_time,_tmpLatest_message,_tmpIsGroup,_tmpIsNew,_tmpIsChecked);
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
