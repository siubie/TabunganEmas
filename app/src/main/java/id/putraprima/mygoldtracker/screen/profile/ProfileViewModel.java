package id.putraprima.mygoldtracker.screen.profile;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mygoldtracker.models.Profile;
import id.putraprima.mygoldtracker.repository.ProfileRepository;

public class ProfileViewModel extends ViewModel {

    private ProfileRepository profileRepository;
    private LiveData<Profile> profileLiveData;

    public ProfileViewModel(Application application){
        super();
        profileRepository = new ProfileRepository(application);
        profileLiveData = profileRepository.getProfileLiveData();
    }

    public LiveData<Profile> getProfileLiveData(){
        return profileLiveData;
    }
}
