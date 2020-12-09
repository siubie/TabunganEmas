package id.putraprima.mygoldtracker.api.services;

import id.putraprima.mygoldtracker.api.models.Envelope;
import id.putraprima.mygoldtracker.api.models.Price;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/emas/api/gold/price")
    Call<Envelope<Price>> getPrice();
}
