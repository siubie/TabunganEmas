package id.putraprima.mygoldtracker.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import id.putraprima.mygoldtracker.db.models.Profile;

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
