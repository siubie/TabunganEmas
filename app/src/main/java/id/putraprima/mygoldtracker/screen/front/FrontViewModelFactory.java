package id.putraprima.mygoldtracker.screen.front;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class FrontViewModelFactory implements ViewModelProvider.Factory {
    private Application application;

    public FrontViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FrontViewModel.class)) {
            return (T) new FrontViewModel(application);
        }
        throw new IllegalArgumentException("Wrong View Model Class");
    }
}
