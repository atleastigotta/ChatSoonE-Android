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
        return "INSERT OR ABORT INTO `ChatTable` (`user_idx`,`groupName`,`name`,`image_name`,`latestTime`,`postTime`,`message`,`folderIdx`,`createdAt`,`updatedAt`,`status`,`idx`) VALUES (?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        stmt.bindLong(1, value.getUser_idx());
        if (value.getGroupName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGroupName());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getImage_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImage_name());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getLatestTime());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = __converter.dateToTimestamp(value.getPostTime());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
        if (value.getMessage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMessage());
        }
        stmt.bindLong(8, value.getFolderIdx());
        final Long _tmp_2;
        _tmp_2 = __converter.dateToTimestamp(value.getCreatedAt());
        if (_tmp_2 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp_2);
        }
        final Long _tmp_3;
        _tmp_3 = __converter.dateToTimestamp(value.getUpdatedAt());
        if (_tmp_3 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, _tmp_3);
        }
        if (value.getStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getStatus());
        }
        stmt.bindLong(12, value.getIdx());
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
        return "UPDATE OR ABORT `ChatTable` SET `user_idx` = ?,`groupName` = ?,`name` = ?,`image_name` = ?,`latestTime` = ?,`postTime` = ?,`message` = ?,`folderIdx` = ?,`createdAt` = ?,`updatedAt` = ?,`status` = ?,`idx` = ? WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        stmt.bindLong(1, value.getUser_idx());
        if (value.getGroupName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGroupName());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getImage_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImage_name());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getLatestTime());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = __converter.dateToTimestamp(value.getPostTime());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
        if (value.getMessage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMessage());
        }
        stmt.bindLong(8, value.getFolderIdx());
        final Long _tmp_2;
        _tmp_2 = __converter.dateToTimestamp(value.getCreatedAt());
        if (_tmp_2 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp_2);
        }
        final Long _tmp_3;
        _tmp_3 = __converter.dateToTimestamp(value.getUpdatedAt());
        if (_tmp_3 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, _tmp_3);
        }
        if (value.getStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getStatus());
        }
        stmt.bindLong(12, value.getIdx());
        stmt.bindLong(13, value.getIdx());
      }
    };
  }

  @Override
  public void insert(final Chat arg0) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChat.insert(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Chat arg0) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChat.handle(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Chat arg0) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChat.handle(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
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
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "image_name");
      final int _cursorIndexOfLatestTime = CursorUtil.getColumnIndexOrThrow(_cursor, "latestTime");
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Chat _item;
        final int _tmpUser_idx;
        _tmpUser_idx = _cursor.getInt(_cursorIndexOfUserIdx);
        final String _tmpGroupName;
        if (_cursor.isNull(_cursorIndexOfGroupName)) {
          _tmpGroupName = null;
        } else {
          _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpImage_name;
        if (_cursor.isNull(_cursorIndexOfImageName)) {
          _tmpImage_name = null;
        } else {
          _tmpImage_name = _cursor.getString(_cursorIndexOfImageName);
        }
        final Date _tmpLatestTime;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfLatestTime)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfLatestTime);
        }
        _tmpLatestTime = __converter.fromTimestamp(_tmp);
        final Date _tmpPostTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfPostTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfPostTime);
        }
        _tmpPostTime = __converter.fromTimestamp(_tmp_1);
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        final int _tmpFolderIdx;
        _tmpFolderIdx = _cursor.getInt(_cursorIndexOfFolderIdx);
        final Date _tmpCreatedAt;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfCreatedAt);
        }
        _tmpCreatedAt = __converter.fromTimestamp(_tmp_2);
        final Date _tmpUpdatedAt;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfUpdatedAt);
        }
        _tmpUpdatedAt = __converter.fromTimestamp(_tmp_3);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new Chat(_tmpUser_idx,_tmpGroupName,_tmpName,_tmpImage_name,_tmpLatestTime,_tmpPostTime,_tmpMessage,_tmpFolderIdx,_tmpCreatedAt,_tmpUpdatedAt,_tmpStatus);
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
