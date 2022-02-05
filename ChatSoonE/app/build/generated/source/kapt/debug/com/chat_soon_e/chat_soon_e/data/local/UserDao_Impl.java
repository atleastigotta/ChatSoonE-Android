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
import com.chat_soon_e.chat_soon_e.data.entities.User;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatus;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
<<<<<<< HEAD
        return "INSERT OR ABORT INTO `UserTable` (`kakaoUserIdx`,`nickname`,`email`,`status`) VALUES (?,?,?,?)";
=======
        return "INSERT OR ABORT INTO `UserTable` (`idx`,`nickname`,`email`,`status`) VALUES (?,?,?,?)";
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getKakaoUserIdx());
        if (value.getNickname() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNickname());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStatus());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `UserTable` WHERE `kakaoUserIdx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getKakaoUserIdx());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
<<<<<<< HEAD
        return "UPDATE OR ABORT `UserTable` SET `kakaoUserIdx` = ?,`nickname` = ?,`email` = ?,`status` = ? WHERE `kakaoUserIdx` = ?";
=======
        return "UPDATE OR ABORT `UserTable` SET `idx` = ?,`nickname` = ?,`email` = ?,`status` = ? WHERE `idx` = ?";
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getKakaoUserIdx());
        if (value.getNickname() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNickname());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStatus());
        }
<<<<<<< HEAD
        stmt.bindLong(5, value.getKakaoUserIdx());
=======
        stmt.bindLong(5, value.getIdx());
>>>>>>> f3b6f2dde75ddd688d0d416880f477ca55112bdb
      }
    };
    this.__preparedStmtOfUpdateStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE UserTable SET status= ? WHERE kakaoUserIdx= ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateStatus(final long id, final String status) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatus.acquire();
    int _argIndex = 1;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateStatus.release(_stmt);
    }
  }

  @Override
  public User getUser(final long id) {
    final String _sql = "SELECT * FROM UserTable WHERE kakaoUserIdx= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfNickname = CursorUtil.getColumnIndexOrThrow(_cursor, "nickname");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        _result.setKakaoUserIdx(_tmpKakaoUserIdx);
        final String _tmpNickname;
        if (_cursor.isNull(_cursorIndexOfNickname)) {
          _tmpNickname = null;
        } else {
          _tmpNickname = _cursor.getString(_cursorIndexOfNickname);
        }
        _result.setNickname(_tmpNickname);
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        _result.setEmail(_tmpEmail);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
<<<<<<< HEAD
        _result.setStatus(_tmpStatus);
=======
        _result = new User(_tmpIdx,_tmpNickname,_tmpEmail,_tmpStatus);
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
  public List<User> getUsers() {
    final String _sql = "SELECT * FROM UserTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfKakaoUserIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "kakaoUserIdx");
      final int _cursorIndexOfNickname = CursorUtil.getColumnIndexOrThrow(_cursor, "nickname");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        final long _tmpKakaoUserIdx;
        _tmpKakaoUserIdx = _cursor.getLong(_cursorIndexOfKakaoUserIdx);
        _item.setKakaoUserIdx(_tmpKakaoUserIdx);
        final String _tmpNickname;
        if (_cursor.isNull(_cursorIndexOfNickname)) {
          _tmpNickname = null;
        } else {
          _tmpNickname = _cursor.getString(_cursorIndexOfNickname);
        }
        _item.setNickname(_tmpNickname);
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        _item.setEmail(_tmpEmail);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
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
