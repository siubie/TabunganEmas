package id.putraprima.mygoldtracker.api.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import id.putraprima.mygoldtracker.api.helper.ServiceGenerator;
import id.putraprima.mygoldtracker.api.models.Envelope;
import id.putraprima.mygoldtracker.api.models.Price;
import id.putraprima.mygoldtracker.api.services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PriceRepository {
    private ApiInterface apiInterface;
    private MutableLiveData<Envelope<Price>> price = new MutableLiveData<>();

    private static PriceRepository priceRepository;

    public static PriceRepository getInstance(){
        if(priceRepository == null){
            priceRepository = new PriceRepository();
        }
        return priceRepository;
    }
    public PriceRepository() {
        this.apiInterface = ServiceGenerator.createService(ApiInterface.class);
    }

    public MutableLiveData<Envelope<Price>> getPrice(){
        Log.e("SOKOl","MASUK Repository");
        Call<Envelope<Price>> priceData = this.apiInterface.getPrice();
        priceData.enqueue(new Callback<Envelope<Price>>() {
            @Override
            public void onResponse(Call<Envelope<Price>> call, Response<Envelope<Price>> response) {
                price.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Envelope<Price>> call, Throwable t) {
                price.setValue(null);
            }
        });
        return price;
    }


}
