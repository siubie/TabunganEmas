package id.putraprima.mygoldtracker.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;

import id.putraprima.mygoldtracker.dao.ProfileDao;
import id.putraprima.mygoldtracker.models.Profile;

@Database(entities = {Profile.class},version = 1,exportSchema = false)
public abstract class GoldAppDb extends RoomDatabase {
    public abstract ProfileDao profileDao();
    private static GoldAppDb INSTANCE;
    private static Context ctx;

    public static GoldAppDb getDatabase(Context context){
        if(INSTANCE == null){
            ctx = context;
            synchronized (GoldAppDb.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),GoldAppDb.class,"gold_app_db")
                            .fallbackToDestructiveMigration()
                            .addCallback(dbCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback dbCallback = new RoomDatabase.Callback() {
        public void onCreate(@NotNull SupportSQLiteDatabase db) {

            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    getDatabase(ctx).profileDao().insert(new Profile("Putra Prima A","putraprima@gmail.com",""));
                }
            });
        }
    };
}
