package edu.ecn.sportuniv;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FeuilleMatch.class}, version = 1, exportSchema = false)
public abstract class FeuilleRoomDatabase extends RoomDatabase {

    public abstract FeuilleMatchDao feuilleMatchDao();

    private static FeuilleRoomDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static FeuilleRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FeuilleRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    FeuilleRoomDatabase.class, "feuille_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}

