package edu.ecn.sportuniv;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Utilisateur.class}, version = 1, exportSchema = false)
public abstract class UtilisateurRoomDatabase extends RoomDatabase {
    public abstract UtilisateurDao utilisateurDao();

    private static volatile UtilisateurRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static UtilisateurRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UtilisateurRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    UtilisateurRoomDatabase.class, "utilisateur_database")
                            .allowMainThreadQueries()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                UtilisateurDao dao = INSTANCE.utilisateurDao();
                dao.deleteAllUtilisateur();

                Utilisateur user = new Utilisateur("John",
                        "DOE",
                        "jdoe",
                        "12345");
                dao.insert(user);
                user = new Utilisateur("Mimi",
                        "DUPONT",
                        "mdupont",
                        "mdp123");
                dao.insert(user);
            });
        }
    };
}
