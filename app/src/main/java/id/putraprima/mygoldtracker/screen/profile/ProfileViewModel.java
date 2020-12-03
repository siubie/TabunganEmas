package id.putraprima.mygoldtracker.screen.profile;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mygoldtracker.models.Profile;
import id.putraprima.mygoldtracker.repository.ProfileRepository;

public class ProfileViewModel extends ViewModel {

    private ProfileRepository profileRepository;

    public ProfileViewModel(Application application){
        super();
        profileRepository = new ProfileRepository(application);
    }

    public void onSaveProfile(String username,String email){
        Profile profile = new Profile(username,email,"");
        profileRepository.deleteAll();
        profileRepository.insert(profile);
    }
}
