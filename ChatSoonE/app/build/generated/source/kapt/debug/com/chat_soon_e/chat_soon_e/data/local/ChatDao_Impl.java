package com.chat_soon_e.chat_soon_e.data.local;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.chat_soon_e.chat_soon_e.data.entities.Chat;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatDao_Impl implements ChatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Chat> __insertionAdapterOfChat;

  private final Converter __converter = new Converter();

  private final EntityDeletionOrUpdateAdapter<Chat> __deletionAdapterOfChat;

  private final EntityDeletionOrUpdateAdapter<Chat> __updateAdapterOfChat;

  public ChatDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChat = new EntityInsertionAdapter<Chat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ChatTable` (`user_idx`,`other_user_idx`,`groupName`,`message`,`postTime`,`folderIdx`,`status`,`viewType`,`isChecked`,`idx`) VALUES (?,?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        stmt.bindLong(1, value.getUser_idx());
        stmt.bindLong(2, value.getOther_user_idx());
        if (value.getGroupName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGroupName());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMessage());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getPostTime());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        stmt.bindLong(6, value.getFolderIdx());
        if (value.getStatus() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStatus());
        }
        stmt.bindLong(8, value.getViewType());
        final int _tmp_1;
        _tmp_1 = value.isChecked() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
        stmt.bindLong(10, value.getIdx());
      }
    };
    this.__deletionAdapterOfChat = new EntityDeletionOrUpdateAdapter<Chat>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ChatTable` WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        stmt.bindLong(1, value.getIdx());
      }
    };
    this.__updateAdapterOfChat = new EntityDeletionOrUpdateAdapter<Chat>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ChatTable` SET `user_idx` = ?,`other_user_idx` = ?,`groupName` = ?,`message` = ?,`postTime` = ?,`folderIdx` = ?,`status` = ?,`viewType` = ?,`isChecked` = ?,`idx` = ? WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        stmt.bindLong(1, value.getUser_idx());
        stmt.bindLong(2, value.getOther_user_idx());
        if (value.getGroupName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGroupName());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMessage());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getPostTime());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        stmt.bindLong(6, value.getFolderIdx());
        if (value.getStatus() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStatus());
        }
        stmt.bindLong(8, value.getViewType());
        final int _tmp_1;
        _tmp_1 = value.isChecked() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
        stmt.bindLong(10, value.getIdx());
        stmt.bindLong(11, value.getIdx());
      }
    };
  }

  @Override
  public void insert(final Chat chat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChat.insert(chat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Chat chat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChat.handle(chat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Chat chat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChat.handle(chat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Chat> getChatByIdx(final int idx) {
    final String _sql = "SELECT * FROM ChatTable WHERE other_user_idx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "user_idx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "other_user_idx");
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Chat _item;
        final long _tmpUser_idx;
        _tmpUser_idx = _cursor.getLong(_cursorIndexOfUserIdx);
        final int _tmpOther_user_idx;
        _tmpOther_user_idx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        final String _tmpGroupName;
        if (_cursor.isNull(_cursorIndexOfGroupName)) {
          _tmpGroupName = null;
        } else {
          _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
        }
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        final Date _tmpPostTime;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPostTime)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPostTime);
        }
        _tmpPostTime = __converter.fromTimestamp(_tmp);
        final int _tmpFolderIdx;
        _tmpFolderIdx = _cursor.getInt(_cursorIndexOfFolderIdx);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final int _tmpViewType;
        _tmpViewType = _cursor.getInt(_cursorIndexOfViewType);
        final boolean _tmpIsChecked;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp_1 != 0;
        _item = new Chat(_tmpUser_idx,_tmpOther_user_idx,_tmpGroupName,_tmpMessage,_tmpPostTime,_tmpFolderIdx,_tmpStatus,_tmpViewType,_tmpIsChecked);
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        _item.setIdx(_tmpIdx);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Chat> getRecentChat(final long id) {
    final String _sql = "SELECT * FROM ChatTable WHERE user_idx= ? GROUP BY other_user_idx ORDER BY postTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "user_idx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "other_user_idx");
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Chat _item;
        final long _tmpUser_idx;
        _tmpUser_idx = _cursor.getLong(_cursorIndexOfUserIdx);
        final int _tmpOther_user_idx;
        _tmpOther_user_idx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        final String _tmpGroupName;
        if (_cursor.isNull(_cursorIndexOfGroupName)) {
          _tmpGroupName = null;
        } else {
          _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
        }
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        final Date _tmpPostTime;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPostTime)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPostTime);
        }
        _tmpPostTime = __converter.fromTimestamp(_tmp);
        final int _tmpFolderIdx;
        _tmpFolderIdx = _cursor.getInt(_cursorIndexOfFolderIdx);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final int _tmpViewType;
        _tmpViewType = _cursor.getInt(_cursorIndexOfViewType);
        final boolean _tmpIsChecked;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp_1 != 0;
        _item = new Chat(_tmpUser_idx,_tmpOther_user_idx,_tmpGroupName,_tmpMessage,_tmpPostTime,_tmpFolderIdx,_tmpStatus,_tmpViewType,_tmpIsChecked);
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        _item.setIdx(_tmpIdx);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Chat> getChatList() {
    final String _sql = "SELECT * FROM ChatTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "user_idx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "other_user_idx");
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Chat _item;
        final long _tmpUser_idx;
        _tmpUser_idx = _cursor.getLong(_cursorIndexOfUserIdx);
        final int _tmpOther_user_idx;
        _tmpOther_user_idx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        final String _tmpGroupName;
        if (_cursor.isNull(_cursorIndexOfGroupName)) {
          _tmpGroupName = null;
        } else {
          _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
        }
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        final Date _tmpPostTime;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPostTime)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPostTime);
        }
        _tmpPostTime = __converter.fromTimestamp(_tmp);
        final int _tmpFolderIdx;
        _tmpFolderIdx = _cursor.getInt(_cursorIndexOfFolderIdx);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final int _tmpViewType;
        _tmpViewType = _cursor.getInt(_cursorIndexOfViewType);
        final boolean _tmpIsChecked;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp_1 != 0;
        _item = new Chat(_tmpUser_idx,_tmpOther_user_idx,_tmpGroupName,_tmpMessage,_tmpPostTime,_tmpFolderIdx,_tmpStatus,_tmpViewType,_tmpIsChecked);
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        _item.setIdx(_tmpIdx);
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
