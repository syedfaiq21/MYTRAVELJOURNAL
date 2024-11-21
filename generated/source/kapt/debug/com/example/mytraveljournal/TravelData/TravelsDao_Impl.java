package com.example.mytraveljournal.TravelData;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TravelsDao_Impl implements TravelsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Travel> __insertionAdapterOfTravel;

  private final EntityDeletionOrUpdateAdapter<Travel> __deletionAdapterOfTravel;

  private final EntityDeletionOrUpdateAdapter<Travel> __updateAdapterOfTravel;

  public TravelsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTravel = new EntityInsertionAdapter<Travel>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Travel` (`location`,`latitude`,`longitude`,`userId`,`name`,`date`,`favorite`,`travelType`,`travelMood`,`travelNotes`,`id`) VALUES (?,?,?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Travel entity) {
        if (entity.getLocation() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getLocation());
        }
        statement.bindDouble(2, entity.getLatitude());
        statement.bindDouble(3, entity.getLongitude());
        statement.bindLong(4, entity.getUserId());
        if (entity.getName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getName());
        }
        if (entity.getDate() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDate());
        }
        final int _tmp = entity.getFavorite() ? 1 : 0;
        statement.bindLong(7, _tmp);
        if (entity.getTravelType() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTravelType());
        }
        statement.bindLong(9, entity.getTravelMood());
        if (entity.getTravelNotes() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTravelNotes());
        }
        statement.bindLong(11, entity.getId());
      }
    };
    this.__deletionAdapterOfTravel = new EntityDeletionOrUpdateAdapter<Travel>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Travel` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Travel entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfTravel = new EntityDeletionOrUpdateAdapter<Travel>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Travel` SET `location` = ?,`latitude` = ?,`longitude` = ?,`userId` = ?,`name` = ?,`date` = ?,`favorite` = ?,`travelType` = ?,`travelMood` = ?,`travelNotes` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Travel entity) {
        if (entity.getLocation() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getLocation());
        }
        statement.bindDouble(2, entity.getLatitude());
        statement.bindDouble(3, entity.getLongitude());
        statement.bindLong(4, entity.getUserId());
        if (entity.getName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getName());
        }
        if (entity.getDate() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDate());
        }
        final int _tmp = entity.getFavorite() ? 1 : 0;
        statement.bindLong(7, _tmp);
        if (entity.getTravelType() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTravelType());
        }
        statement.bindLong(9, entity.getTravelMood());
        if (entity.getTravelNotes() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTravelNotes());
        }
        statement.bindLong(11, entity.getId());
        statement.bindLong(12, entity.getId());
      }
    };
  }

  @Override
  public Object insertTravel(final Travel travel, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTravel.insert(travel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTravel(final Travel travel, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTravel.handle(travel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTravel(final Travel travel, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTravel.handle(travel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Travel>> getAllTravels() {
    final String _sql = "SELECT * FROM travel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"travel"}, false, new Callable<List<Travel>>() {
      @Override
      @Nullable
      public List<Travel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "favorite");
          final int _cursorIndexOfTravelType = CursorUtil.getColumnIndexOrThrow(_cursor, "travelType");
          final int _cursorIndexOfTravelMood = CursorUtil.getColumnIndexOrThrow(_cursor, "travelMood");
          final int _cursorIndexOfTravelNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "travelNotes");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Travel> _result = new ArrayList<Travel>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Travel _item;
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final boolean _tmpFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorite);
            _tmpFavorite = _tmp != 0;
            final String _tmpTravelType;
            if (_cursor.isNull(_cursorIndexOfTravelType)) {
              _tmpTravelType = null;
            } else {
              _tmpTravelType = _cursor.getString(_cursorIndexOfTravelType);
            }
            final int _tmpTravelMood;
            _tmpTravelMood = _cursor.getInt(_cursorIndexOfTravelMood);
            final String _tmpTravelNotes;
            if (_cursor.isNull(_cursorIndexOfTravelNotes)) {
              _tmpTravelNotes = null;
            } else {
              _tmpTravelNotes = _cursor.getString(_cursorIndexOfTravelNotes);
            }
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new Travel(_tmpLocation,_tmpLatitude,_tmpLongitude,_tmpUserId,_tmpName,_tmpDate,_tmpFavorite,_tmpTravelType,_tmpTravelMood,_tmpTravelNotes,_tmpId);
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
  public LiveData<List<Travel>> getUserTravel(final int iduser) {
    final String _sql = "SELECT * FROM travel WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, iduser);
    return __db.getInvalidationTracker().createLiveData(new String[] {"travel"}, false, new Callable<List<Travel>>() {
      @Override
      @Nullable
      public List<Travel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "favorite");
          final int _cursorIndexOfTravelType = CursorUtil.getColumnIndexOrThrow(_cursor, "travelType");
          final int _cursorIndexOfTravelMood = CursorUtil.getColumnIndexOrThrow(_cursor, "travelMood");
          final int _cursorIndexOfTravelNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "travelNotes");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Travel> _result = new ArrayList<Travel>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Travel _item;
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final int _tmpUserId;
            _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final boolean _tmpFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorite);
            _tmpFavorite = _tmp != 0;
            final String _tmpTravelType;
            if (_cursor.isNull(_cursorIndexOfTravelType)) {
              _tmpTravelType = null;
            } else {
              _tmpTravelType = _cursor.getString(_cursorIndexOfTravelType);
            }
            final int _tmpTravelMood;
            _tmpTravelMood = _cursor.getInt(_cursorIndexOfTravelMood);
            final String _tmpTravelNotes;
            if (_cursor.isNull(_cursorIndexOfTravelNotes)) {
              _tmpTravelNotes = null;
            } else {
              _tmpTravelNotes = _cursor.getString(_cursorIndexOfTravelNotes);
            }
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new Travel(_tmpLocation,_tmpLatitude,_tmpLongitude,_tmpUserId,_tmpName,_tmpDate,_tmpFavorite,_tmpTravelType,_tmpTravelMood,_tmpTravelNotes,_tmpId);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
