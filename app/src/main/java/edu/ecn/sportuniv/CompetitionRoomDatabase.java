package edu.ecn.sportuniv;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Competition.class}, version = 1, exportSchema = false)
public abstract class CompetitionRoomDatabase extends RoomDatabase {
    public abstract CompetitionDao competitionDao();

    private static volatile CompetitionRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CompetitionRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CompetitionRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CompetitionRoomDatabase.class, "competition_database")
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
                CompetitionDao dao = INSTANCE.competitionDao();
                dao.deleteAllCompetitions();

                Competition competition = new Competition("16/03/2023",
                        "16:30",
                        "18:30",
                        "Coupe des Écoles d’Ingénieur",
                        "La Rochelle");
                dao.insert(competition);
                competition = new Competition("16/03/2023",
                        "14:00",
                        "18:00",
                        "Coupe de France Universitaire",
                        "Nantes");
                dao.insert(competition);

                competition = new Competition("18/03/2023",
                        "9:00",
                        "19:00",
                        "Challenge Centrale Lyon",
                        "Lyon");
                dao.insert(competition);

                competition = new Competition("23/03/2023",
                        "15:15",
                        "16:30",
                        "Tournoi Seven",
                        "Brest");
                dao.insert(competition);
            });
        }
    };
}
