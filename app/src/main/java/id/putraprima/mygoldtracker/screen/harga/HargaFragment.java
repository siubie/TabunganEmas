package id.putraprima.mygoldtracker.screen.harga;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.mygoldtracker.R;
import id.putraprima.mygoldtracker.api.models.AppPrice;
import id.putraprima.mygoldtracker.api.models.Envelope;
import id.putraprima.mygoldtracker.api.models.Price;
import id.putraprima.mygoldtracker.databinding.FragmentHargaBinding;

public class HargaFragment extends Fragment {

    private FragmentHargaBinding binding;
    private HargaViewModel viewModel;
    private List<AppPrice> appPriceList = new ArrayList<>();

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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_harga, container, false);
        viewModel = new ViewModelProvider(this).get(HargaViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getPrice().observe(getViewLifecycleOwner(), new Observer<Envelope<Price>>() {
            @Override
            public void onChanged(Envelope<Price> priceEnvelope) {
                if(priceEnvelope!=null){
                    appPriceList.add(new AppPrice(0.5f,priceEnvelope.getData().getSell_price()/2,priceEnvelope.getData().getBuy_price()/2));
                    appPriceList.add(new AppPrice(1f,priceEnvelope.getData().getSell_price(),priceEnvelope.getData().getBuy_price()));
                    appPriceList.add(new AppPrice(2f,priceEnvelope.getData().getSell_price()*2,priceEnvelope.getData().getBuy_price()*2));
                    appPriceList.add(new AppPrice(3f,priceEnvelope.getData().getSell_price()*3,priceEnvelope.getData().getBuy_price()*3));
                    appPriceList.add(new AppPrice(4f,priceEnvelope.getData().getSell_price()*4,priceEnvelope.getData().getBuy_price()*4));
                    appPriceList.add(new AppPrice(5f,priceEnvelope.getData().getSell_price()*5,priceEnvelope.getData().getBuy_price()*5));
                    appPriceList.add(new AppPrice(10f,priceEnvelope.getData().getSell_price()*10,priceEnvelope.getData().getBuy_price()*10));
                    appPriceList.add(new AppPrice(25f,priceEnvelope.getData().getSell_price()*25,priceEnvelope.getData().getBuy_price()*25));
                    appPriceList.add(new AppPrice(50f,priceEnvelope.getData().getSell_price()*50,priceEnvelope.getData().getBuy_price()*50));
                    appPriceList.add(new AppPrice(100f,priceEnvelope.getData().getSell_price()*100,priceEnvelope.getData().getBuy_price()*100));
                    viewModel.setAppPriceListMutableLiveData(appPriceList);
                }else {
                    Toast.makeText(getContext(), "Fail to load data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        setupRvHarga();

    }

    private void setupRvHarga() {
        RecyclerView recyclerView = binding.rvHarga;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        HargaAdapter adapter = new HargaAdapter();
        recyclerView.setAdapter(adapter);
        viewModel.getPriceList().observe(getViewLifecycleOwner(), new Observer<List<AppPrice>>() {
            @Override
            public void onChanged(List<AppPrice> appPrices) {
                adapter.setList(appPrices);
            }
        });
    }
}