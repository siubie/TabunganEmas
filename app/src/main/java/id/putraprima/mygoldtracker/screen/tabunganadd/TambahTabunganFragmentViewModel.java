package id.putraprima.mygoldtracker.screen.tabunganadd;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import id.putraprima.mygoldtracker.db.models.Tabungan;
import id.putraprima.mygoldtracker.db.repository.TabunganRepository;

public class TambahTabunganFragmentViewModel extends ViewModel {
    private TabunganRepository tabunganRepository;
    private MutableLiveData<Tabungan> tabunganMutableLiveData = new MutableLiveData<>();
    public LiveData<List<Tabungan>> listTabunganMutableLiveData = new MutableLiveData<>();
    public LiveData<Tabungan> tabunganLiveData;

    public TambahTabunganFragmentViewModel(Application application){
        super();
        tabunganRepository = new TabunganRepository(application);
        listTabunganMutableLiveData = tabunganRepository.listTabunganLiveData;
    }

    public void onBtnTabunganClicked(String hargaBeli,String berat,String tanggalBeli){
        Date date= null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(tanggalBeli);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Tabungan tabungan = new Tabungan(Float.parseFloat(berat),Float.parseFloat(hargaBeli),date);
        tabunganRepository.insert(tabungan);
    }

    public LiveData<Tabungan> getTabunganLiveData(){
        return tabunganMutableLiveData;
    }
}
