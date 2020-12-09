package id.putraprima.mygoldtracker.screen.harga;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import id.putraprima.mygoldtracker.R;
import id.putraprima.mygoldtracker.api.models.Envelope;
import id.putraprima.mygoldtracker.api.models.Price;
import id.putraprima.mygoldtracker.screen.profile.ProfileViewModel;

public class HargaFragment extends Fragment {

    private HargaViewModel viewModel;

    public HargaFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        viewModel = new ViewModelProvider(this).get(HargaViewModel.class);
        return inflater.inflate(R.layout.fragment_harga, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getPrice().observe(getViewLifecycleOwner(), new Observer<Envelope<Price>>() {
            @Override
            public void onChanged(Envelope<Price> priceEnvelope) {
                if(priceEnvelope!=null){
                    Toast.makeText(getContext(), "Harga "+ priceEnvelope.getData().getSell_price(), Toast.LENGTH_SHORT).show();
                }else {
                    Log.d("SOKO","Null");
                }
            }
        });

    }
}