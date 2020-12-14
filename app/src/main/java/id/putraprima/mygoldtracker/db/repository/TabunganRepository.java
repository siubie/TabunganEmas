package id.putraprima.mygoldtracker.db.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.putraprima.mygoldtracker.db.dao.TabunganDao;
import id.putraprima.mygoldtracker.db.database.GoldAppDb;
import id.putraprima.mygoldtracker.db.models.Tabungan;

public class TabunganRepository {
    private TabunganDao tabunganDao;
    private LiveData<Tabungan> tabunganLiveData;
    private LiveData<List<Tabungan>> listTabunganLiveData;
    private LiveData<Float> totalBeratLiveData;
    private LiveData<Float> totalHargaBeliLiveData;

    public TabunganRepository(Application application){
        GoldAppDb db = GoldAppDb.getDatabase(application);
        tabunganDao = db.tabunganDao();
        listTabunganLiveData = tabunganDao.getAllTabungan();
    }


    public LiveData<Float> getTotalBeratLiveData(){
        totalBeratLiveData = tabunganDao.getTotalBerat();
        return totalBeratLiveData;
    }
    public LiveData<Float> getTotalHargaBeliLiveData(){
        totalHargaBeliLiveData = tabunganDao.getTotalHargaBeli();
        return totalHargaBeliLiveData;
    }
    public LiveData<List<Tabungan>> getListTabunganLiveData(){
        return listTabunganLiveData;
    }


    public void insert(Tabungan tabungan){
        new TabunganRepository.insertAsyncTask(tabunganDao).execute(tabungan);
    }

    private class insertAsyncTask extends AsyncTask<Tabungan,Void,Void> {
        private TabunganDao tabunganDao;
        public insertAsyncTask(TabunganDao tabunganDao) {
            this.tabunganDao = tabunganDao;
        }

        @Override
        protected Void doInBackground(Tabungan... tabungans) {
            tabunganDao.insert(tabungans[0]);
            return null;
        }
    }
}
