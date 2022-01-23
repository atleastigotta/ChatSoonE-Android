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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatDao_Impl implements ChatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Chat> __insertionAdapterOfChat;

  private final EntityDeletionOrUpdateAdapter<Chat> __deletionAdapterOfChat;

  private final EntityDeletionOrUpdateAdapter<Chat> __updateAdapterOfChat;

  public ChatDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChat = new EntityInsertionAdapter<Chat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ChatTable` (`image_name`,`user_idx`,`name`,`dateTime`,`idx`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        if (value.getImage_name() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getImage_name());
        }
        if (value.getUser_idx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUser_idx());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getDateTime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateTime());
        }
        stmt.bindLong(5, value.getIdx());
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
        return "UPDATE OR ABORT `ChatTable` SET `image_name` = ?,`user_idx` = ?,`name` = ?,`dateTime` = ?,`idx` = ? WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        if (value.getImage_name() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getImage_name());
        }
        if (value.getUser_idx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUser_idx());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getDateTime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateTime());
        }
        stmt.bindLong(5, value.getIdx());
        stmt.bindLong(6, value.getIdx());
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
  public List<Chat> getChatList() {
    final String _sql = "SELECT * FROM ChatTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "image_name");
      final int _cursorIndexOfUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "user_idx");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Chat _item;
        final String _tmpImage_name;
        if (_cursor.isNull(_cursorIndexOfImageName)) {
          _tmpImage_name = null;
        } else {
          _tmpImage_name = _cursor.getString(_cursorIndexOfImageName);
        }
        final String _tmpUser_idx;
        if (_cursor.isNull(_cursorIndexOfUserIdx)) {
          _tmpUser_idx = null;
        } else {
          _tmpUser_idx = _cursor.getString(_cursorIndexOfUserIdx);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpDateTime;
        if (_cursor.isNull(_cursorIndexOfDateTime)) {
          _tmpDateTime = null;
        } else {
          _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
        }
        _item = new Chat(_tmpImage_name,_tmpUser_idx,_tmpName,_tmpDateTime);
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
  public Chat getChatByIdx(final int idx) {
    final String _sql = "SELECT * FROM ChatTable WHERE idx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "image_name");
      final int _cursorIndexOfUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "user_idx");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final Chat _result;
      if(_cursor.moveToFirst()) {
        final String _tmpImage_name;
        if (_cursor.isNull(_cursorIndexOfImageName)) {
          _tmpImage_name = null;
        } else {
          _tmpImage_name = _cursor.getString(_cursorIndexOfImageName);
        }
        final String _tmpUser_idx;
        if (_cursor.isNull(_cursorIndexOfUserIdx)) {
          _tmpUser_idx = null;
        } else {
          _tmpUser_idx = _cursor.getString(_cursorIndexOfUserIdx);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpDateTime;
        if (_cursor.isNull(_cursorIndexOfDateTime)) {
          _tmpDateTime = null;
        } else {
          _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
        }
        _result = new Chat(_tmpImage_name,_tmpUser_idx,_tmpName,_tmpDateTime);
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        _result.setIdx(_tmpIdx);
      } else {
        _result = null;
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
