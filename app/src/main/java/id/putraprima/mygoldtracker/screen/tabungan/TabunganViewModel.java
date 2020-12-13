package id.putraprima.mygoldtracker.screen.tabungan;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.putraprima.mygoldtracker.db.models.Tabungan;
import id.putraprima.mygoldtracker.db.repository.TabunganRepository;

public class TabunganViewModel extends ViewModel {
    private TabunganRepository tabunganRepository;
    public LiveData<List<Tabungan>> listTabunganMutableLiveData = new MutableLiveData<>();

    public TabunganViewModel(Application application) {
        super();
        tabunganRepository = new TabunganRepository(application);
        listTabunganMutableLiveData = tabunganRepository.getListTabunganLiveData();
    }
}
