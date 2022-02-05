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
import com.chat_soon_e.chat_soon_e.data.entities.Folder;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FolderDao_Impl implements FolderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Folder> __insertionAdapterOfFolder;

  private final EntityDeletionOrUpdateAdapter<Folder> __updateAdapterOfFolder;

<<<<<<< HEAD
  private final SharedSQLiteStatement __preparedStmtOfUpdateFolderName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFolderImg;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFolderHidden;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFolderActive;

  private final SharedSQLiteStatement __preparedStmtOfDelete;
=======
  private final SharedSQLiteStatement __preparedStmtOfUpdateStatusByIdx;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFolderImgByIdx;
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb

  public FolderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFolder = new EntityInsertionAdapter<Folder>(__db) {
      @Override
      public String createQuery() {
<<<<<<< HEAD
        return "INSERT OR ABORT INTO `FolderTable` (`folderName`,`kakaoUserIdx`,`parentFolderIdx`,`folderImg`,`status`,`folderIdx`) VALUES (?,?,?,?,?,nullif(?, 0))";
=======
        return "INSERT OR ABORT INTO `FolderTable` (`idx`,`kakaoUserIdx`,`parentFolderIdx`,`folderName`,`folderImg`,`status`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?)";
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Folder value) {
<<<<<<< HEAD
        if (value.getFolderName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFolderName());
        }
=======
        stmt.bindLong(1, value.getIdx());
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        stmt.bindLong(2, value.getKakaoUserIdx());
        if (value.getParentFolderIdx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getParentFolderIdx());
<<<<<<< HEAD
=======
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
        if (value.getCreatedAt() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCreatedAt());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUpdatedAt());
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        }
        if (value.getFolderImg() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFolderImg());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getStatus());
        }
        stmt.bindLong(6, value.getFolderIdx());
      }
    };
    this.__updateAdapterOfFolder = new EntityDeletionOrUpdateAdapter<Folder>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `FolderTable` SET `folderName` = ?,`kakaoUserIdx` = ?,`parentFolderIdx` = ?,`folderImg` = ?,`status` = ?,`folderIdx` = ? WHERE `folderIdx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Folder value) {
        if (value.getFolderName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFolderName());
        }
        stmt.bindLong(2, value.getKakaoUserIdx());
        if (value.getParentFolderIdx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getParentFolderIdx());
        }
        if (value.getFolderImg() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFolderImg());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getStatus());
        }
        stmt.bindLong(6, value.getFolderIdx());
        stmt.bindLong(7, value.getFolderIdx());
      }
    };
    this.__preparedStmtOfUpdateFolderName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
<<<<<<< HEAD
        final String _query = "UPDATE FolderTable SET folderName = ? WHERE folderIdx =?";
        return _query;
=======
        return "UPDATE OR ABORT `FolderTable` SET `idx` = ?,`kakaoUserIdx` = ?,`parentFolderIdx` = ?,`folderName` = ?,`folderImg` = ?,`status` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `idx` = ?";
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
      }
    };
    this.__preparedStmtOfUpdateFolderImg = new SharedSQLiteStatement(__db) {
      @Override
<<<<<<< HEAD
      public String createQuery() {
        final String _query = "UPDATE FolderTable SET folderImg = ? WHERE folderIdx =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFolderHidden = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE FolderTable SET status =\"HIDDEN\" WHERE folderIdx =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFolderActive = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE FolderTable SET status =\"ACTIVE\" WHERE folderIdx= ?";
        return _query;
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM FOlderTable WHERE folderIdx = ?";
=======
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
        if (value.getCreatedAt() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCreatedAt());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUpdatedAt());
        }
        stmt.bindLong(9, value.getIdx());
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
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
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
  public void updateFolderName(final int folderIdx, final String folderName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFolderName.acquire();
    int _argIndex = 1;
    if (folderName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, folderName);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, folderIdx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFolderName.release(_stmt);
    }
  }

  @Override
  public void updateFolderImg(final int folderIdx, final String image) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFolderImg.acquire();
    int _argIndex = 1;
    if (image == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, image);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, folderIdx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFolderImg.release(_stmt);
    }
  }

  @Override
  public void updateFolderHidden(final int folderIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFolderHidden.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderIdx);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFolderHidden.release(_stmt);
    }
  }

  @Override
<<<<<<< HEAD
  public void updateFolderActive(final int folderIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFolderActive.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderIdx);
=======
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
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
<<<<<<< HEAD
      __preparedStmtOfUpdateFolderActive.release(_stmt);
=======
      __preparedStmtOfUpdateStatusByIdx.release(_stmt);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    }
  }

  @Override
<<<<<<< HEAD
  public void delete(final int folderIdx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderIdx);
=======
  public void updateFolderImgByIdx(final int folderImg, final int idx) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFolderImgByIdx.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, folderImg);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, idx);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
<<<<<<< HEAD
      __preparedStmtOfDelete.release(_stmt);
=======
      __preparedStmtOfUpdateFolderImgByIdx.release(_stmt);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
    }
  }

  @Override
<<<<<<< HEAD
  public List<Folder> getFolderList(final long userIdx) {
    final String _sql = "SELECT * FROM FolderTable WHERE kakaoUserIdx = ? AND status != \"HIDDEN\"";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userIdx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final List<Folder> _result = new ArrayList<Folder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Folder _item;
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
        final String _tmpFolderImg;
        if (_cursor.isNull(_cursorIndexOfFolderImg)) {
          _tmpFolderImg = null;
        } else {
          _tmpFolderImg = _cursor.getString(_cursorIndexOfFolderImg);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new Folder(_tmpFolderName,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderImg,_tmpStatus);
        final int _tmpFolderIdx;
        _tmpFolderIdx = _cursor.getInt(_cursorIndexOfFolderIdx);
        _item.setFolderIdx(_tmpFolderIdx);
=======
  public List<Folder> getFolderList() {
    final String _sql = "SELECT * FROM FolderTable";
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
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final List<Folder> _result = new ArrayList<Folder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Folder _item;
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final int _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getInt(_cursorIndexOfKakaoUserIdx);
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
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        final String _tmpUpdatedAt;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmpUpdatedAt = null;
        } else {
          _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
        }
        _item = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Folder getFolderByIdx(final long userIdx, final int folderIdx) {
    final String _sql = "SELECT * FROM FolderTable WHERE folderIdx = ? AND kakaoUserIdx = ? AND status != \"HIDDEN\"";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, folderIdx);
    _argIndex = 2;
    _statement.bindLong(_argIndex, userIdx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
<<<<<<< HEAD
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final Folder _result;
      if(_cursor.moveToFirst()) {
=======
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final Folder _result;
      if(_cursor.moveToFirst()) {
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final int _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getInt(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
<<<<<<< HEAD
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
        final String _tmpFolderImg;
        if (_cursor.isNull(_cursorIndexOfFolderImg)) {
          _tmpFolderImg = null;
        } else {
          _tmpFolderImg = _cursor.getString(_cursorIndexOfFolderImg);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result = new Folder(_tmpFolderName,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderImg,_tmpStatus);
        final int _tmpFolderIdx;
        _tmpFolderIdx = _cursor.getInt(_cursorIndexOfFolderIdx);
        _result.setFolderIdx(_tmpFolderIdx);
=======
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        final String _tmpUpdatedAt;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmpUpdatedAt = null;
        } else {
          _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
        }
        _result = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
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
<<<<<<< HEAD
  public List<Folder> getHiddenFolder(final long kakaoUserIdx) {
    final String _sql = "SELECT * FROM FolderTable WHERE kakaoUserIdx = ? AND status = \"HIDDEN\"";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, kakaoUserIdx);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folderName");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfParentFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "parentFolderIdx");
      final int _cursorIndexOfFolderImg = CursorUtil.getColumnIndexOrThrow(_cursor, "folderImg");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfFolderIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "folderIdx");
      final List<Folder> _result = new ArrayList<Folder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Folder _item;
=======
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
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final Folder _result;
      if(_cursor.moveToFirst()) {
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final int _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getInt(_cursorIndexOfKakaoUserIdx);
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
<<<<<<< HEAD
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
=======
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        final String _tmpUpdatedAt;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmpUpdatedAt = null;
        } else {
          _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
        }
        _result = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
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
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final List<Folder> _result = new ArrayList<Folder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Folder _item;
        final int _tmpIdx;
        _tmpIdx = _cursor.getInt(_cursorIndexOfIdx);
        final int _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getInt(_cursorIndexOfKakaoUserIdx);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        final Integer _tmpParentFolderIdx;
        if (_cursor.isNull(_cursorIndexOfParentFolderIdx)) {
          _tmpParentFolderIdx = null;
        } else {
          _tmpParentFolderIdx = _cursor.getInt(_cursorIndexOfParentFolderIdx);
        }
<<<<<<< HEAD
        final String _tmpFolderImg;
        if (_cursor.isNull(_cursorIndexOfFolderImg)) {
          _tmpFolderImg = null;
        } else {
          _tmpFolderImg = _cursor.getString(_cursorIndexOfFolderImg);
        }
=======
        final String _tmpFolderName;
        if (_cursor.isNull(_cursorIndexOfFolderName)) {
          _tmpFolderName = null;
        } else {
          _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
        }
        final int _tmpFolderImg;
        _tmpFolderImg = _cursor.getInt(_cursorIndexOfFolderImg);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
<<<<<<< HEAD
        _item = new Folder(_tmpFolderName,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderImg,_tmpStatus);
        final int _tmpFolderIdx;
        _tmpFolderIdx = _cursor.getInt(_cursorIndexOfFolderIdx);
        _item.setFolderIdx(_tmpFolderIdx);
=======
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        final String _tmpUpdatedAt;
        if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
          _tmpUpdatedAt = null;
        } else {
          _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
        }
        _item = new Folder(_tmpIdx,_tmpKakaoUserIdx,_tmpParentFolderIdx,_tmpFolderName,_tmpFolderImg,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
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
