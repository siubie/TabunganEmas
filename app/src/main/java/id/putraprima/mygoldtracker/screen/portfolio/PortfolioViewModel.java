package id.putraprima.mygoldtracker.screen.portfolio;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

import id.putraprima.mygoldtracker.api.models.Envelope;
import id.putraprima.mygoldtracker.api.models.Price;
import id.putraprima.mygoldtracker.api.repository.PriceRepository;
import id.putraprima.mygoldtracker.db.repository.TabunganRepository;

public class PortfolioViewModel extends ViewModel {
    private TabunganRepository tabunganRepository;
    private PriceRepository priceRepository;
    public LiveData<Float> beratLiveData = new MutableLiveData<>();
    private MutableLiveData<Envelope<Price>> priceMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Float> totalPorfolio = new MutableLiveData<>();
    private LiveData<Float> totalHargaBeli;

    public PortfolioViewModel(Application application) {
        super();
        tabunganRepository = new TabunganRepository(application);
        beratLiveData = tabunganRepository.getTotalBeratLiveData();
        priceRepository = PriceRepository.getInstance();
        priceMutableLiveData = priceRepository.getPrice();
        totalHargaBeli = tabunganRepository.getTotalHargaBeliLiveData();
    }

    public LiveData<Envelope<Price>> priceLiveData(){
        return priceMutableLiveData;
    }

    public LiveData<Float> getTotalHargaBeli(){
        return totalHargaBeli;
    }
}
