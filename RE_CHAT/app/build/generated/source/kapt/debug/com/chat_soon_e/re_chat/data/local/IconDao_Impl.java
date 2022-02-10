package com.chat_soon_e.re_chat.data.local;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.chat_soon_e.re_chat.data.entities.Icon;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IconDao_Impl implements IconDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Icon> __insertionAdapterOfIcon;

  private final EntityDeletionOrUpdateAdapter<Icon> __deletionAdapterOfIcon;

  private final EntityDeletionOrUpdateAdapter<Icon> __updateAdapterOfIcon;

  public IconDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIcon = new EntityInsertionAdapter<Icon>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `IconTable` (`iconImage`,`idx`) VALUES (?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Icon value) {
        stmt.bindLong(1, value.getIconImage());
        stmt.bindLong(2, value.getIdx());
      }
    };
    this.__deletionAdapterOfIcon = new EntityDeletionOrUpdateAdapter<Icon>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `IconTable` WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Icon value) {
        stmt.bindLong(1, value.getIdx());
      }
    };
    this.__updateAdapterOfIcon = new EntityDeletionOrUpdateAdapter<Icon>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `IconTable` SET `iconImage` = ?,`idx` = ? WHERE `idx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Icon value) {
        stmt.bindLong(1, value.getIconImage());
        stmt.bindLong(2, value.getIdx());
        stmt.bindLong(3, value.getIdx());
      }
    };
  }

  @Override
  public void insert(final Icon icon) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIcon.insert(icon);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Icon icon) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfIcon.handle(icon);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Icon icon) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfIcon.handle(icon);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Icon> getIconList() {
    final String _sql = "SELECT * FROM IconTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIconImage = CursorUtil.getColumnIndexOrThrow(_cursor, "iconImage");
      final int _cursorIndexOfIdx = CursorUtil.getColumnIndexOrThrow(_cursor, "idx");
      final List<Icon> _result = new ArrayList<Icon>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Icon _item;
        final int _tmpIconImage;
        _tmpIconImage = _cursor.getInt(_cursorIndexOfIconImage);
        _item = new Icon(_tmpIconImage);
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
