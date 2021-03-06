package id.putraprima.mygoldtracker.screen.front;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mygoldtracker.db.models.Profile;
import id.putraprima.mygoldtracker.db.repository.ProfileRepository;

public class FrontViewModel extends ViewModel {
    private ProfileRepository profileRepository;
    private LiveData<Profile> profileLiveData;

    public FrontViewModel(Application application){
        super();
        profileRepository = new ProfileRepository(application);
        profileLiveData = profileRepository.getProfileLiveData();
    }

    public LiveData<Profile> getProfileLiveData(){
        return profileLiveData;
    }

    public void insert(Profile profile){
        profileRepository.insert(profile);
    }

    public void update(Profile profile){
        profileRepository.update(profile);
    }
}
