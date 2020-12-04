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
    private MutableLiveData<Profile> profileMutableLiveData = new MutableLiveData<>();

    public ProfileViewModel(Application application){
        super();
        profileRepository = new ProfileRepository(application);
        profileLiveData = profileRepository.getProfileLiveData();
    }

    public LiveData<Profile> getProfileLiveData(){
        return profileLiveData;
    }

    public void onBtnUpdateClicked(String username,String email){
        Profile profile = profileLiveData.getValue();
        assert profile != null;
        profile.setUsername(username);
        profile.setEmail(email);
        profileRepository.update(profile);
        profileMutableLiveData.setValue(profile);
    }

    public void onProfileUpdated(){
        profileMutableLiveData.setValue(null);
    }

    public LiveData<Profile> profileLiveData(){
        return profileMutableLiveData;
    }

}
