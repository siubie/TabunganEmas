package id.putraprima.mygoldtracker.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.putraprima.mygoldtracker.models.Profile;

public interface ProfileDao {
    @Insert
    void insert(Profile profile);

    @Update
    void update(Profile profile);

    @Query("DELETE FROM profile")
    void deleteAll();

    @Query("SELECT * from profile limit 1")
    LiveData<Profile> getProfile();

}
