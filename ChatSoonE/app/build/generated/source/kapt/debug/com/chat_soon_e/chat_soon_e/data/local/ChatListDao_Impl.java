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
        return "INSERT OR ABORT INTO `ChatListTable` (`chatIdx`,`nickName`,`groupName`,`profileImg`,`postTime`,`message`,`isNew`,`id`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatList value) {
        stmt.bindLong(1, value.getChatIdx());
        if (value.getNickName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNickName());
        }
        if (value.getGroupName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGroupName());
        }
        if (value.getProfileImg() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProfileImg());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getPostTime());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.getMessage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMessage());
        }
        stmt.bindLong(7, value.isNew());
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
        return "UPDATE OR ABORT `ChatListTable` SET `chatIdx` = ?,`nickName` = ?,`groupName` = ?,`profileImg` = ?,`postTime` = ?,`message` = ?,`isNew` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatList value) {
        stmt.bindLong(1, value.getChatIdx());
        if (value.getNickName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNickName());
        }
        if (value.getGroupName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGroupName());
        }
        if (value.getProfileImg() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProfileImg());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getPostTime());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.getMessage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMessage());
        }
        stmt.bindLong(7, value.isNew());
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

  @Override
  public List<ChatList> getChatList() {
    final String _sql = "SELECT * FROM ChatListTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
      final int _cursorIndexOfNickName = CursorUtil.getColumnIndexOrThrow(_cursor, "nickName");
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfProfileImg = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImg");
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<ChatList> _result = new ArrayList<ChatList>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ChatList _item;
        final int _tmpChatIdx;
        _tmpChatIdx = _cursor.getInt(_cursorIndexOfChatIdx);
        final String _tmpNickName;
        if (_cursor.isNull(_cursorIndexOfNickName)) {
          _tmpNickName = null;
        } else {
          _tmpNickName = _cursor.getString(_cursorIndexOfNickName);
        }
        final String _tmpGroupName;
        if (_cursor.isNull(_cursorIndexOfGroupName)) {
          _tmpGroupName = null;
        } else {
          _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
        }
        final String _tmpProfileImg;
        if (_cursor.isNull(_cursorIndexOfProfileImg)) {
          _tmpProfileImg = null;
        } else {
          _tmpProfileImg = _cursor.getString(_cursorIndexOfProfileImg);
        }
        final Date _tmpPostTime;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPostTime)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPostTime);
        }
        _tmpPostTime = __converter.fromTimestamp(_tmp);
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        final int _tmpIsNew;
        _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
        _item = new ChatList(_tmpChatIdx,_tmpNickName,_tmpGroupName,_tmpProfileImg,_tmpPostTime,_tmpMessage,_tmpIsNew);
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
