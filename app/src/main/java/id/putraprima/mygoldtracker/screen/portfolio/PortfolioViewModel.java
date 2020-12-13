package id.putraprima.mygoldtracker.screen.portfolio;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mygoldtracker.db.repository.TabunganRepository;

public class PortfolioViewModel extends ViewModel {
    private TabunganRepository tabunganRepository;
    public LiveData<Float> beratLiveData = new MutableLiveData<>();

    public PortfolioViewModel(Application application) {
        super();
        tabunganRepository = new TabunganRepository(application);
        beratLiveData = tabunganRepository.getTotalBeratLiveData();
    }

}
