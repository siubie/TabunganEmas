package id.putraprima.mygoldtracker.screen.tabunganadd;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mygoldtracker.screen.profile.ProfileViewModel;

public class TambahTabunganViewModelFactory implements ViewModelProvider.Factory {
    private Application application;

    public TambahTabunganViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TambahTabunganFragmentViewModel.class)) {
            return (T) new TambahTabunganFragmentViewModel(application);
        }
        throw new IllegalArgumentException("Wrong View Model Class");
    }
}
