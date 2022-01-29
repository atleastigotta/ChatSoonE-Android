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
        return "INSERT OR ABORT INTO `OtherUserTable` (`name`,`image`,`status`,`kakao_user_idx`,`other_user_idx`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OtherUser value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
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
        stmt.bindLong(4, value.getKakao_user_idx());
        stmt.bindLong(5, value.getOther_user_idx());
      }
    };
    this.__deletionAdapterOfOtherUser = new EntityDeletionOrUpdateAdapter<OtherUser>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `OtherUserTable` WHERE `other_user_idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OtherUser value) {
        stmt.bindLong(1, value.getOther_user_idx());
      }
    };
    this.__updateAdapterOfOtherUser = new EntityDeletionOrUpdateAdapter<OtherUser>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `OtherUserTable` SET `name` = ?,`image` = ?,`status` = ?,`kakao_user_idx` = ?,`other_user_idx` = ? WHERE `other_user_idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OtherUser value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
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
        stmt.bindLong(4, value.getKakao_user_idx());
        stmt.bindLong(5, value.getOther_user_idx());
        stmt.bindLong(6, value.getOther_user_idx());
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
    final String _sql = "SELECT * FROM OtherUserTable WHERE name =? AND kakao_user_idx =?";
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
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakao_user_idx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "other_user_idx");
      final OtherUser _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
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
        final long _tmpKakao_user_idx;
        _tmpKakao_user_idx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        _result = new OtherUser(_tmpName,_tmpImage,_tmpStatus,_tmpKakao_user_idx);
        final int _tmpOther_user_idx;
        _tmpOther_user_idx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        _result.setOther_user_idx(_tmpOther_user_idx);
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
    final String _sql = "SELECT OU.other_user_idx FROM OtherUserTable as OU WHERE kakao_user_idx= ?";
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
    final String _sql = "SELECT * FROM OtherUserTable WHERE other_user_idx= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakao_user_idx");
      final int _cursorIndexOfOtherUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "other_user_idx");
      final OtherUser _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
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
        final long _tmpKakao_user_idx;
        _tmpKakao_user_idx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        _result = new OtherUser(_tmpName,_tmpImage,_tmpStatus,_tmpKakao_user_idx);
        final int _tmpOther_user_idx;
        _tmpOther_user_idx = _cursor.getInt(_cursorIndexOfOtherUserIdx);
        _result.setOther_user_idx(_tmpOther_user_idx);
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
