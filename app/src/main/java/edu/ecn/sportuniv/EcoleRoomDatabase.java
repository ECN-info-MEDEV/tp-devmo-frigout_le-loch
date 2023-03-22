package edu.ecn.sportuniv;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Ecole.class}, version = 1, exportSchema = false)
public abstract class EcoleRoomDatabase  extends RoomDatabase {

    public abstract EcoleDao ecoleDao();

    private static volatile EcoleRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static EcoleRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EcoleRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    EcoleRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
