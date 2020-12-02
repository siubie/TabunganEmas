package id.putraprima.mygoldtracker.screen.portfolio;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PortfolioViewModelFactory implements ViewModelProvider.Factory {
    private Application application;

    public PortfolioViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(PortfolioViewModel.class)){
            return (T) new PortfolioViewModel(application);
        }
        throw new IllegalArgumentException("Wrong View Model Class");    }
}
