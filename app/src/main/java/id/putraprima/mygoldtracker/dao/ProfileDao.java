package id.putraprima.mygoldtracker.dao;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import id.putraprima.mygoldtracker.models.Profile;

@Dao
public interface ProfileDao {
    @Insert
    void insert(Profile profile);

    @Update
    void update(Profile profile);

    @Query("DELETE FROM profile")
    void deleteAll();

    @Query("SELECT * from profile order by profileId desc limit 1")
    LiveData<Profile> getProfile();

    @Query("SELECT count(*) as total from profile")
    LiveData<Integer> countProfile();

}
