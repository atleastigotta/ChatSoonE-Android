package com.chat_soon_e.chat_soon_e.data.local;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.chat_soon_e.chat_soon_e.data.entities.FolderContent;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FolderContentDao_Impl implements FolderContentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FolderContent> __insertionAdapterOfFolderContent;

  private final SharedSQLiteStatement __preparedStmtOfInsertChat;

  private final SharedSQLiteStatement __preparedStmtOfInsertOtOChat;

  private final SharedSQLiteStatement __preparedStmtOfInsertOrgChat;

  private final SharedSQLiteStatement __preparedStmtOfDeleteChat;

  public FolderContentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFolderContent = new EntityInsertionAdapter<FolderContent>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `FolderContentTable` (`folderIdx`,`chatIdx`,`status`,`folderContentIdx`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FolderContent value) {
        stmt.bindLong(1, value.getFolderIdx());
        stmt.bindLong(2, value.getChatIdx());
        if (value.getStatus() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStatus());
        }
        stmt.bindLong(4, value.getFolderContentIdx());
      }
    };
    this.__preparedStmtOfInsertChat = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO FolderContentTable (folderIdx, chatIdx) VALUES (?, ?)";
        return _query;
      }
    };
    this.__preparedStmtOfInsertOtOChat = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO FolderContentTable (folderIdx, chatIdx) SELECT ?, chatIdx FROM ChatTable WHERE otherUserIdx =? AND groupName IS NULL";
        return _query;
      }
    };
    this.__preparedStmtOfInsertOrgChat = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO FolderContentTable (folderIdx, chatIdx) SELECT ?, chatIdx FROM ChatTable AS C INNER JOIN OtherUserTable AS OU ON C.otherUserIdx =OU.otherUserIdx WHERE OU.kakaoUserIdx= ? AND C.groupName = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteChat = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM FolderContentTable WHERE folderIdx= ? AND chatIdx= ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final FolderContent folderContent) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFolderContent.insert(folderContent);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertChat(final int folderIdx, final int chatIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertChat.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderIdx);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, chatIdx);
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertChat.release(_stmt);
    }
  }

  @Override
  public void insertOtOChat(final int folderIdx, final int otherUserIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertOtOChat.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderIdx);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, otherUserIdx);
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertOtOChat.release(_stmt);
    }
  }

  @Override
  public void insertOrgChat(final int folderIdx, final long userIdx, final String groupName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertOrgChat.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderIdx);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, userIdx);
    _argIndex = 3;
    if (groupName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, groupName);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertOrgChat.release(_stmt);
    }
  }

  @Override
  public void deleteChat(final int folderIdx, final int chatIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteChat.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderIdx);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, chatIdx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteChat.release(_stmt);
    }
  }

  @Override
  public List<FolderContent> getAllfolder() {
    final String _sql = "SELECT * FROM foldercontenttable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfFolderContentIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderContentIdx");
      final List<FolderContent> _result = new ArrayList<FolderContent>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final FolderContent _item;
        final int _tmpFolderIdx;
        _tmpFolderIdx = _cursor.getInt(_cursorIndexOfFolderIdx);
        final int _tmpChatIdx;
        _tmpChatIdx = _cursor.getInt(_cursorIndexOfChatIdx);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new FolderContent(_tmpFolderIdx,_tmpChatIdx,_tmpStatus);
        final int _tmpFolderContentIdx;
        _tmpFolderContentIdx = _cursor.getInt(_cursorIndexOfFolderContentIdx);
        _item.setFolderContentIdx(_tmpFolderContentIdx);
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
