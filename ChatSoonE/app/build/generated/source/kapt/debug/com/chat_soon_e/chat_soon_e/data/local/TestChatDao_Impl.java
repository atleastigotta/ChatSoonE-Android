package com.chat_soon_e.chat_soon_e.data.local;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.chat_soon_e.chat_soon_e.data.entities.TestChat;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TestChatDao_Impl implements TestChatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TestChat> __insertionAdapterOfTestChat;

  private final EntityDeletionOrUpdateAdapter<TestChat> __deletionAdapterOfTestChat;

  private final EntityDeletionOrUpdateAdapter<TestChat> __updateAdapterOfTestChat;

  public TestChatDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTestChat = new EntityInsertionAdapter<TestChat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TestChatTable` (`name`,`message`,`dateTime`,`viewType`,`isChecked`,`idx`) VALUES (?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TestChat value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMessage());
        }
        if (value.getDateTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDateTime());
        }
        stmt.bindLong(4, value.getViewType());
        final int _tmp;
        _tmp = value.isChecked() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.getIdx());
      }
    };
    this.__deletionAdapterOfTestChat = new EntityDeletionOrUpdateAdapter<TestChat>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TestChatTable` WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TestChat value) {
        stmt.bindLong(1, value.getIdx());
      }
    };
    this.__updateAdapterOfTestChat = new EntityDeletionOrUpdateAdapter<TestChat>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TestChatTable` SET `name` = ?,`message` = ?,`dateTime` = ?,`viewType` = ?,`isChecked` = ?,`idx` = ? WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TestChat value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMessage());
        }
        if (value.getDateTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDateTime());
        }
        stmt.bindLong(4, value.getViewType());
        final int _tmp;
        _tmp = value.isChecked() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.getIdx());
        stmt.bindLong(7, value.getIdx());
      }
    };
  }

  @Override
  public void insert(final TestChat testChat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTestChat.insert(testChat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final TestChat testChat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTestChat.handle(testChat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final TestChat testChat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTestChat.handle(testChat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TestChat> getChatList() {
    final String _sql = "SELECT * FROM TestChatTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
      final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final List<TestChat> _result = new ArrayList<TestChat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TestChat _item;
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        final String _tmpDateTime;
        if (_cursor.isNull(_cursorIndexOfDateTime)) {
          _tmpDateTime = null;
        } else {
          _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
        }
        final int _tmpViewType;
        _tmpViewType = _cursor.getInt(_cursorIndexOfViewType);
        final boolean _tmpIsChecked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp != 0;
        _item = new TestChat(_tmpName,_tmpMessage,_tmpDateTime,_tmpViewType,_tmpIsChecked);
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
