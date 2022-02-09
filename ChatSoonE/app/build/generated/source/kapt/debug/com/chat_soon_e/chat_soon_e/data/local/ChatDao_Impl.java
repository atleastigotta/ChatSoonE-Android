package com.chat_soon_e.chat_soon_e.data.local;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.chat_soon_e.chat_soon_e.data.entities.Chat;
import com.chat_soon_e.chat_soon_e.data.entities.ChatList;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatDao_Impl implements ChatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Chat> __insertionAdapterOfChat;

  private final Converter __converter = new Converter();

  private final EntityDeletionOrUpdateAdapter<Chat> __deletionAdapterOfChat;

  private final EntityDeletionOrUpdateAdapter<Chat> __updateAdapterOfChat;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByChatIdx;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOneChat;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOrgChat;

  private final SharedSQLiteStatement __preparedStmtOfUpdateIsNew;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFolder;

  public ChatDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChat = new EntityInsertionAdapter<Chat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ChatTable` (`otherUserIdx`,`groupName`,`message`,`postTime`,`folderIdx`,`status`,`viewType`,`isChecked`,`isNew`,`chatIdx`) VALUES (?,?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        stmt.bindLong(1, value.getOtherUserIdx());
        if (value.getGroupName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGroupName());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getPostTime());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        stmt.bindLong(5, value.getFolderIdx());
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
        stmt.bindLong(7, value.getViewType());
        final int _tmp_1;
        _tmp_1 = value.isChecked() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        if (value.isNew() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.isNew());
        }
        stmt.bindLong(10, value.getChatIdx());
      }
    };
    this.__deletionAdapterOfChat = new EntityDeletionOrUpdateAdapter<Chat>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ChatTable` WHERE `chatIdx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        stmt.bindLong(1, value.getChatIdx());
      }
    };
    this.__updateAdapterOfChat = new EntityDeletionOrUpdateAdapter<Chat>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ChatTable` SET `otherUserIdx` = ?,`groupName` = ?,`message` = ?,`postTime` = ?,`folderIdx` = ?,`status` = ?,`viewType` = ?,`isChecked` = ?,`isNew` = ?,`chatIdx` = ? WHERE `chatIdx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chat value) {
        stmt.bindLong(1, value.getOtherUserIdx());
        if (value.getGroupName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGroupName());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        final Long _tmp;
        _tmp = __converter.dateToTimestamp(value.getPostTime());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        stmt.bindLong(5, value.getFolderIdx());
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
        stmt.bindLong(7, value.getViewType());
        final int _tmp_1;
        _tmp_1 = value.isChecked() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        if (value.isNew() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.isNew());
        }
        stmt.bindLong(10, value.getChatIdx());
        stmt.bindLong(11, value.getChatIdx());
      }
    };
    this.__preparedStmtOfDeleteByChatIdx = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ChatTable WHERE chatIdx = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOneChat = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ChatTable WHERE OtherUserIdx= ? AND groupName is 'null'";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOrgChat = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ChatTable WHERE groupName = ? AND otherUserIdx IN (SELECT CD.otherUserIdx FROM (SELECT C.otherUserIdx fROM ChatTable C INNER JOIN OtherUserTable OU ON C.otherUserIdx=OU.otherUserIdx WHERE OU.kakaoUserIdx = ? AND C.groupName = ?) CD)";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateIsNew = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE ChatTable SET isNew= ? WHERE chatIdx= ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFolder = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE ChatTable SET folderIdx= ? WHERE chatIdx= ?";
        return _query;
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
  public void deleteByChatIdx(final int chatIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByChatIdx.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, chatIdx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByChatIdx.release(_stmt);
    }
  }

  @Override
  public void deleteOneChat(final int otherUserIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOneChat.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, otherUserIdx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteOneChat.release(_stmt);
    }
  }

  @Override
  public void deleteOrgChat(final long use_id, final String groupName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOrgChat.acquire();
    int _argIndex = 1;
    if (groupName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, groupName);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, use_id);
    _argIndex = 3;
    if (groupName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, groupName);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteOrgChat.release(_stmt);
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
  public void updateFolder(final int chatIdx, final int folderIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFolder.acquire();
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
      __preparedStmtOfUpdateFolder.release(_stmt);
    }
  }

  @Override
  public Chat getChatByChatIdx(final int chatIdx) {
    final String _sql = "SELECT * FROM ChatTable WHERE chatIdx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, chatIdx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserIdx");
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
      final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
      final Chat _result;
      if(_cursor.moveToFirst()) {
        final int _tmpOtherUserIdx;
        _tmpOtherUserIdx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
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
        final Integer _tmpIsNew;
        if (_cursor.isNull(_cursorIndexOfIsNew)) {
          _tmpIsNew = null;
        } else {
          _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
        }
        _result = new Chat(_tmpOtherUserIdx,_tmpGroupName,_tmpMessage,_tmpPostTime,_tmpFolderIdx,_tmpStatus,_tmpViewType,_tmpIsChecked,_tmpIsNew);
        final int _tmpChatIdx;
        _tmpChatIdx = _cursor.getInt(_cursorIndexOfChatIdx);
        _result.setChatIdx(_tmpChatIdx);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Chat> getChatByIdx(final int idx) {
    final String _sql = "SELECT * FROM ChatTable WHERE otherUserIdx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserIdx");
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
      final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
      final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Chat _item;
        final int _tmpOtherUserIdx;
        _tmpOtherUserIdx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
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
        final Integer _tmpIsNew;
        if (_cursor.isNull(_cursorIndexOfIsNew)) {
          _tmpIsNew = null;
        } else {
          _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
        }
        _item = new Chat(_tmpOtherUserIdx,_tmpGroupName,_tmpMessage,_tmpPostTime,_tmpFolderIdx,_tmpStatus,_tmpViewType,_tmpIsChecked,_tmpIsNew);
        final int _tmpChatIdx;
        _tmpChatIdx = _cursor.getInt(_cursorIndexOfChatIdx);
        _item.setChatIdx(_tmpChatIdx);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ChatList>> getRecentChat(final long userIdx) {
    final String _sql = "SELECT CM.chatIdx, CL.chatName AS nickName, CL.profileImg AS profileImg, CL.latestTime AS postTime, CM.message, CM.groupName, CM.isNew\n"
            + "FROM\n"
            + "    (SELECT (CASE WHEN C.groupName == 'null' THEN OU.nickname ELSE C.groupName END) AS chatName,\n"
            + "            (CASE WHEN C.groupName == 'null' THEN OU.image ELSE NULL END) AS profileImg,\n"
            + "            MAX(C.postTime) as latestTime\n"
            + "    FROM ChatTable C INNER JOIN OtherUserTable OU on C.otherUserIdx = OU.otherUserIdx\n"
            + "    WHERE OU.kakaoUserIdx = ? AND C.status != 'DELETED'\n"
            + "    GROUP BY chatName, profileImg) CL\n"
            + "    INNER JOIN\n"
            + "    (SELECT DISTINCT (CASE WHEN C.groupName == 'null' THEN OU.nickname ELSE C.groupName END) AS chatName, C.chatIdx, C.message, C.postTime, C.groupName, C.isNew\n"
            + "    FROM ChatTable C INNER JOIN OtherUserTable OU on C.otherUserIdx = OU.otherUserIdx\n"
            + "    WHERE OU.kakaoUserIdx = ? AND C.status != 'DELETED') CM\n"
            + "    ON CL.chatName = CM.chatName AND CL.latestTime = CM.postTime\n"
            + " ORDER BY postTime DESC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userIdx);
    _argIndex = 2;
    _statement.bindLong(_argIndex, userIdx);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ChatTable","OtherUserTable"}, false, new Callable<List<ChatList>>() {
      @Override
      public List<ChatList> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
          final int _cursorIndexOfNickName = CursorUtil.getColumnIndexOrThrow(_cursor, "nickName");
          final int _cursorIndexOfProfileImg = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImg");
          final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
          final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
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
            final String _tmpGroupName;
            if (_cursor.isNull(_cursorIndexOfGroupName)) {
              _tmpGroupName = null;
            } else {
              _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
            }
            final int _tmpIsNew;
            _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
            _item = new ChatList(_tmpChatIdx,_tmpNickName,_tmpGroupName,_tmpProfileImg,_tmpPostTime,_tmpMessage,_tmpIsNew);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<ChatList>> getOneChatList(final long userIdx, final int chatIdx) {
    final String _sql = "SELECT C.chatIdx, OU.nickname as nickName, C.groupName, OU.image as profileImg, C.message, C.postTime, C.isNew\n"
            + "    FROM ChatTable AS C INNER JOIN OtherUserTable AS OU on C.otherUserIdx = OU.otherUserIdx\n"
            + "    WHERE OU.kakaoUserIdx = ? AND C.status != 'DELETED' AND C.otherUserIdx IN (SELECT otherUserIdx FROM ChatTable WHERE chatIdx = ?) AND groupName is 'null'\n"
            + "ORDER BY C.postTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userIdx);
    _argIndex = 2;
    _statement.bindLong(_argIndex, chatIdx);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ChatTable","OtherUserTable"}, false, new Callable<List<ChatList>>() {
      @Override
      public List<ChatList> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
          final int _cursorIndexOfNickName = CursorUtil.getColumnIndexOrThrow(_cursor, "nickName");
          final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
          final int _cursorIndexOfProfileImg = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImg");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
          final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
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
            final int _tmpIsNew;
            _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
            _item = new ChatList(_tmpChatIdx,_tmpNickName,_tmpGroupName,_tmpProfileImg,_tmpPostTime,_tmpMessage,_tmpIsNew);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<ChatList>> getOrgChatList(final long userIdx, final int chatIdx) {
    final String _sql = "SELECT C.chatIdx, OU.nickname as nickName, C.groupName, OU.image as profileImg, C.message, C.postTime, C.isNew FROM ChatTable C INNER JOIN OtherUserTable OU on C.otherUserIdx = OU.otherUserIdx WHERE OU.kakaoUserIdx = ? AND C.status != 'DELETED' AND groupName = (SELECT groupName FROM ChatTable WHERE chatIdx = ?) ORDER BY C.postTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userIdx);
    _argIndex = 2;
    _statement.bindLong(_argIndex, chatIdx);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ChatTable","OtherUserTable"}, false, new Callable<List<ChatList>>() {
      @Override
      public List<ChatList> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
          final int _cursorIndexOfNickName = CursorUtil.getColumnIndexOrThrow(_cursor, "nickName");
          final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
          final int _cursorIndexOfProfileImg = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImg");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
          final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
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
            final int _tmpIsNew;
            _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
            _item = new ChatList(_tmpChatIdx,_tmpNickName,_tmpGroupName,_tmpProfileImg,_tmpPostTime,_tmpMessage,_tmpIsNew);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Chat> getChatList() {
    final String _sql = "SELECT * FROM ChatTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserIdx");
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
      final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
      final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Chat _item;
        final int _tmpOtherUserIdx;
        _tmpOtherUserIdx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
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
        final Integer _tmpIsNew;
        if (_cursor.isNull(_cursorIndexOfIsNew)) {
          _tmpIsNew = null;
        } else {
          _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
        }
        _item = new Chat(_tmpOtherUserIdx,_tmpGroupName,_tmpMessage,_tmpPostTime,_tmpFolderIdx,_tmpStatus,_tmpViewType,_tmpIsChecked,_tmpIsNew);
        final int _tmpChatIdx;
        _tmpChatIdx = _cursor.getInt(_cursorIndexOfChatIdx);
        _item.setChatIdx(_tmpChatIdx);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Chat>> getUserAllChat(final long user_id) {
    final String _sql = "SELECT C.otherUserIdx,C.groupName,C.message,C.postTime,C.folderIdx,C.status,C.viewType,C.isChecked,C.chatIdx  FROM ChatTable C INNER JOIN OtherUserTable OU ON OU.otherUserIdx=C.otherUserIdx AND OU.kakaoUserIdx= ? ORDER BY C.postTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, user_id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ChatTable","OtherUserTable"}, false, new Callable<List<Chat>>() {
      @Override
      public List<Chat> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserIdx");
          final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
          final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
          final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
          final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Chat _item;
            final int _tmpOtherUserIdx;
            _tmpOtherUserIdx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
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
            _item = new Chat(_tmpOtherUserIdx,_tmpGroupName,_tmpMessage,_tmpPostTime,_tmpFolderIdx,_tmpStatus,_tmpViewType,_tmpIsChecked,null);
            final int _tmpChatIdx;
            _tmpChatIdx = _cursor.getInt(_cursorIndexOfChatIdx);
            _item.setChatIdx(_tmpChatIdx);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Chat> getFolderChat(final long user_id, final int folder_id) {
    final String _sql = "SELECT C.postTime, C.folderIdx, C.chatIdx, C.otherUserIdx, C.isChecked, C.message, C.groupName, C.status, C.isNew, C.viewType FROM ChatTable C INNER JOIN OtherUserTable OU ON C.otherUserIdx=OU.otherUserIdx INNER JOIN FolderContentTable FC ON C.chatIdx=FC.chatIdx INNER JOIN FolderTable F ON FC.folderIdx=F.idx WHERE OU.kakaoUserIdx= ? AND FC.folderIdx=? ORDER BY C.postTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, user_id);
    _argIndex = 2;
    _statement.bindLong(_argIndex, folder_id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPostTime = CursorUtil.getColumnIndexOrThrow(_cursor, "postTime");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final int _cursorIndexOfChatIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "chatIdx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserIdx");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "isChecked");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "groupName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsNew = CursorUtil.getColumnIndexOrThrow(_cursor, "isNew");
      final int _cursorIndexOfViewType = CursorUtil.getColumnIndexOrThrow(_cursor, "viewType");
      final List<Chat> _result = new ArrayList<Chat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Chat _item;
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
        final int _tmpOtherUserIdx;
        _tmpOtherUserIdx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        final boolean _tmpIsChecked;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp_1 != 0;
        final String _tmpMessage;
        if (_cursor.isNull(_cursorIndexOfMessage)) {
          _tmpMessage = null;
        } else {
          _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
        }
        final String _tmpGroupName;
        if (_cursor.isNull(_cursorIndexOfGroupName)) {
          _tmpGroupName = null;
        } else {
          _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final Integer _tmpIsNew;
        if (_cursor.isNull(_cursorIndexOfIsNew)) {
          _tmpIsNew = null;
        } else {
          _tmpIsNew = _cursor.getInt(_cursorIndexOfIsNew);
        }
        final int _tmpViewType;
        _tmpViewType = _cursor.getInt(_cursorIndexOfViewType);
        _item = new Chat(_tmpOtherUserIdx,_tmpGroupName,_tmpMessage,_tmpPostTime,_tmpFolderIdx,_tmpStatus,_tmpViewType,_tmpIsChecked,_tmpIsNew);
        final int _tmpChatIdx;
        _tmpChatIdx = _cursor.getInt(_cursorIndexOfChatIdx);
        _item.setChatIdx(_tmpChatIdx);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Integer> getChatIdxList() {
    final String _sql = "SELECT chatIdx FROM ChatTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getChatOtherIdx(final int chatIdx) {
    final String _sql = "SELECT otherUserIdx FROM ChatTable WHERE chatIdx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, chatIdx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
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
