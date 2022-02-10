package com.chat_soon_e.re_chat.data.local;

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
import com.chat_soon_e.re_chat.data.entities.Chat;
import com.chat_soon_e.re_chat.data.entities.Folder;
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
public final class FolderDao_Impl implements FolderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Folder> __insertionAdapterOfFolder;

  private final EntityDeletionOrUpdateAdapter<Folder> __updateAdapterOfFolder;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatusByIdx;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFolderImgByIdx;

  private final Converter __converter = new Converter();

  public FolderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFolder = new EntityInsertionAdapter<Folder>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `FolderTable` (`idx`,`kakaoUserIdx`,`parentFolderIdx`,`folderName`,`folderImg`,`status`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Folder value) {
        stmt.bindLong(1, value.getIdx());
        stmt.bindLong(2, value.getKakaoUserIdx());
        if (value.getParentFolderIdx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getParentFolderIdx());
        }
        if (value.getFolderName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFolderName());
        }
        stmt.bindLong(5, value.getFolderImg());
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
      }
    };
    this.__updateAdapterOfFolder = new EntityDeletionOrUpdateAdapter<Folder>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `FolderTable` SET `idx` = ?,`kakaoUserIdx` = ?,`parentFolderIdx` = ?,`folderName` = ?,`folderImg` = ?,`status` = ? WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Folder value) {
        stmt.bindLong(1, value.getIdx());
        stmt.bindLong(2, value.getKakaoUserIdx());
        if (value.getParentFolderIdx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getParentFolderIdx());
        }
        if (value.getFolderName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFolderName());
        }
        stmt.bindLong(5, value.getFolderImg());
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
        stmt.bindLong(7, value.getIdx());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM FolderTable WHERE idx = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateStatusByIdx = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE FolderTable SET status = ? WHERE idx = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFolderImgByIdx = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE FolderTable SET folderImg = ? WHERE idx = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Folder folder) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFolder.insert(folder);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Folder folder) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfFolder.handle(folder);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final int folderIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderIdx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public void updateStatusByIdx(final String status, final int idx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatusByIdx.acquire();
    int _argIndex = 1;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, idx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateStatusByIdx.release(_stmt);
    }
  }

  @Override
  public void updateFolderImgByIdx(final int folderImg, final int idx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFolderImgByIdx.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderImg);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, idx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFolderImgByIdx.release(_stmt);
    }
  }

  @Override
  public List<Folder> getFolderList() {
    final String _sql = "SELECT * FROM FolderTable ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Folder> _result = new ArrayList<Folder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Folder _item;
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Folder> getHiddenFolder(final long kakaoUserIdx) {
    final String _sql = "SELECT * FROM FolderTable WHERE kakaoUserIdx = ? AND status = \"HIDDEN\"";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, kakaoUserIdx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Folder> _result = new ArrayList<Folder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Folder _item;
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Folder getFolderByIdx(final int idx) {
    final String _sql = "SELECT * FROM FolderTable WHERE idx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final Folder _result;
      if(_cursor.moveToFirst()) {
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus);
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
  public Folder getFolderByName(final String folderName) {
    final String _sql = "SELECT * FROM FolderTable WHERE folderName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (folderName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, folderName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final Folder _result;
      if(_cursor.moveToFirst()) {
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus);
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
  public List<Folder> getFolderByStatus(final String status) {
    final String _sql = "SELECT * FROM FolderTable WHERE status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Folder> _result = new ArrayList<Folder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Folder _item;
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Chat>> getFolderChats(final long user_id, final int folderIdx) {
    final String _sql = "SELECT C.postTime, C.folderIdx, C.chatIdx, C.otherUserIdx, C.isChecked, C.message, C.groupName, C.status, C.isNew, C.viewType FROM ChatTable C INNER JOIN OtherUserTable OU ON C.otherUserIdx=OU.otherUserIdx INNER JOIN FolderContentTable FC ON C.chatIdx=FC.chatIdx INNER JOIN FolderTable F ON FC.folderIdx=F.idx WHERE OU.kakaoUserIdx= ? AND FC.folderIdx=? ORDER BY C.postTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, user_id);
    _argIndex = 2;
    _statement.bindLong(_argIndex, folderIdx);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ChatTable","OtherUserTable","FolderContentTable","FolderTable"}, false, new Callable<List<Chat>>() {
      @Override
      public List<Chat> call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Folder> getFolderExceptDeletedFolder(final String status) {
    final String _sql = "SELECT * FROM FolderTable WHERE status != ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Folder> _result = new ArrayList<Folder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Folder _item;
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus);
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
