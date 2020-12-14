package id.putraprima.mygoldtracker.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import id.putraprima.mygoldtracker.db.models.Tabungan;

@Dao
public interface TabunganDao {

    @Insert
    void insert(Tabungan tabungan);

    @Query("Select * from tabungan")
    LiveData<List<Tabungan>> getAllTabungan();

    @Query("Select sum(berat) as totalBerat from tabungan")
    LiveData<Float> getTotalBerat();

    @Query("Select sum(berat) as totalBerat from tabungan where berat =:beratGram")
    LiveData<Float> getTotalBerat(float beratGram);

    @Query("Select sum(harga) as totalHargaBeli from tabungan")
    LiveData<Float> getTotalHargaBeli();
}
