package id.putraprima.mygoldtracker.repository;

import android.app.Application;
import android.app.AsyncNotedAppOp;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import id.putraprima.mygoldtracker.dao.ProfileDao;
import id.putraprima.mygoldtracker.database.GoldAppDb;
import id.putraprima.mygoldtracker.models.Profile;

public class ProfileRepository {
    private ProfileDao profileDao;
    private LiveData<Profile> profileLiveData;

    public ProfileRepository(Application application){
        GoldAppDb db = GoldAppDb.getDatabase(application);
        profileDao = db.profileDao();
        profileLiveData = profileDao.getProfile();
    }

    public LiveData<Profile> getProfileLiveData(){
        return profileLiveData;
    }

    public void insert(Profile profile){
        new insertAsyncTask(profileDao).execute(profile);
    }


    private class insertAsyncTask extends AsyncTask<Profile,Void,Void> {

        private ProfileDao profileDao;

        public insertAsyncTask(ProfileDao dao) {
            profileDao = dao;
        }

        @Override
        protected Void doInBackground(Profile... profiles) {
            profileDao.insert(profiles[0]);
            return null;
        }
    }

    public void deleteAll(){
        new deleteAllAsyncTask(profileDao).execute();
    }

    private class deleteAllAsyncTask extends AsyncTask<Void,Void,Void>{

        private ProfileDao profileDao;

        public deleteAllAsyncTask(ProfileDao dao) {
            profileDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            profileDao.deleteAll();
            return null;
        }
    }
}
