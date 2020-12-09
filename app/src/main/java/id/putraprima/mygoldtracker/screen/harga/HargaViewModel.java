package id.putraprima.mygoldtracker.screen.harga;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mygoldtracker.api.models.Envelope;
import id.putraprima.mygoldtracker.api.models.Price;
import id.putraprima.mygoldtracker.api.repository.PriceRepository;

public class HargaViewModel extends ViewModel {
    private PriceRepository priceRepository;
    private MutableLiveData<Envelope<Price>> priceMutableLiveData = new MutableLiveData<>();

    public HargaViewModel() {
        this.priceRepository = PriceRepository.getInstance();
        priceMutableLiveData = priceRepository.getPrice();
    }

    public LiveData<Envelope<Price>> getPrice(){
        return priceMutableLiveData;
    }
}
