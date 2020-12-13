package id.putraprima.mygoldtracker.screen.tabungan;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TabunganViewModelFactory implements ViewModelProvider.Factory {
    private Application application;

    public TabunganViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TabunganViewModel.class)) {
            return (T) new TabunganViewModel(application);
        }
        throw new IllegalArgumentException("Wrong View Model Class");
    }
}
