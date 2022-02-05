package com.chat_soon_e.chat_soon_e.data.local;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.chat_soon_e.chat_soon_e.data.entities.OtherUser;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OtherUserDao_Impl implements OtherUserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OtherUser> __insertionAdapterOfOtherUser;

  private final EntityDeletionOrUpdateAdapter<OtherUser> __deletionAdapterOfOtherUser;

  private final EntityDeletionOrUpdateAdapter<OtherUser> __updateAdapterOfOtherUser;

  public OtherUserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOtherUser = new EntityInsertionAdapter<OtherUser>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `OtherUserTable` (`nickname`,`image`,`status`,`kakaoUserIdx`,`otherUserIdx`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OtherUser value) {
        if (value.getNickname() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNickname());
        }
        if (value.getImage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImage());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStatus());
        }
        stmt.bindLong(4, value.getKakaoUserIdx());
        stmt.bindLong(5, value.getOtherUserIdx());
      }
    };
    this.__deletionAdapterOfOtherUser = new EntityDeletionOrUpdateAdapter<OtherUser>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `OtherUserTable` WHERE `otherUserIdx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OtherUser value) {
        stmt.bindLong(1, value.getOtherUserIdx());
      }
    };
    this.__updateAdapterOfOtherUser = new EntityDeletionOrUpdateAdapter<OtherUser>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `OtherUserTable` SET `nickname` = ?,`image` = ?,`status` = ?,`kakaoUserIdx` = ?,`otherUserIdx` = ? WHERE `otherUserIdx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OtherUser value) {
        if (value.getNickname() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNickname());
        }
        if (value.getImage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImage());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStatus());
        }
        stmt.bindLong(4, value.getKakaoUserIdx());
        stmt.bindLong(5, value.getOtherUserIdx());
        stmt.bindLong(6, value.getOtherUserIdx());
      }
    };
  }

  @Override
  public void insert(final OtherUser otherUser) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOtherUser.insert(otherUser);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final OtherUser otherUser) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfOtherUser.handle(otherUser);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final OtherUser otherUser) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfOtherUser.handle(otherUser);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public OtherUser getOtherUserByNameId(final String name, final long id) {
    final String _sql = "SELECT * FROM OtherUserTable WHERE nickname =? AND kakaoUserIdx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNickname = CursorUtil.getColumnIndexOrThrow(_cursor, "nickname");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserIdx");
      final OtherUser _result;
      if(_cursor.moveToFirst()) {
        final String _tmpNickname;
        if (_cursor.isNull(_cursorIndexOfNickname)) {
          _tmpNickname = null;
        } else {
          _tmpNickname = _cursor.getString(_cursorIndexOfNickname);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        _result = new OtherUser(_tmpNickname,_tmpImage,_tmpStatus,_tmpKakaoUserIdx);
        final int _tmpOtherUserIdx;
        _tmpOtherUserIdx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        _result.setOtherUserIdx(_tmpOtherUserIdx);
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
  public List<Integer> getOtherUserIdxList(final long id) {
    final String _sql = "SELECT OU.otherUserIdx FROM OtherUserTable as OU WHERE kakaoUserIdx= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
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
  public OtherUser getOtherUserById(final int id) {
    final String _sql = "SELECT * FROM OtherUserTable WHERE otherUserIdx= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNickname = CursorUtil.getColumnIndexOrThrow(_cursor, "nickname");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserIdx");
      final OtherUser _result;
      if(_cursor.moveToFirst()) {
        final String _tmpNickname;
        if (_cursor.isNull(_cursorIndexOfNickname)) {
          _tmpNickname = null;
        } else {
          _tmpNickname = _cursor.getString(_cursorIndexOfNickname);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        _result = new OtherUser(_tmpNickname,_tmpImage,_tmpStatus,_tmpKakaoUserIdx);
        final int _tmpOtherUserIdx;
        _tmpOtherUserIdx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        _result.setOtherUserIdx(_tmpOtherUserIdx);
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
  public List<OtherUser> getAllOtherUser(final long id) {
    final String _sql = "SELECT * FROM OtherUserTable WHERE kakaoUserIdx= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNickname = CursorUtil.getColumnIndexOrThrow(_cursor, "nickname");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserIdx");
      final List<OtherUser> _result = new ArrayList<OtherUser>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OtherUser _item;
        final String _tmpNickname;
        if (_cursor.isNull(_cursorIndexOfNickname)) {
          _tmpNickname = null;
        } else {
          _tmpNickname = _cursor.getString(_cursorIndexOfNickname);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        _item = new OtherUser(_tmpNickname,_tmpImage,_tmpStatus,_tmpKakaoUserIdx);
        final int _tmpOtherUserIdx;
        _tmpOtherUserIdx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        _item.setOtherUserIdx(_tmpOtherUserIdx);
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
