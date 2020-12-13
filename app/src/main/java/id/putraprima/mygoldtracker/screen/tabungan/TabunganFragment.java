package id.putraprima.mygoldtracker.screen.tabungan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import id.putraprima.mygoldtracker.R;
import id.putraprima.mygoldtracker.api.models.AppPrice;
import id.putraprima.mygoldtracker.databinding.FragmentTabunganBinding;
import id.putraprima.mygoldtracker.db.models.Tabungan;
import id.putraprima.mygoldtracker.screen.harga.HargaAdapter;

public class TabunganFragment extends Fragment {

    FragmentTabunganBinding binding;
    TabunganViewModel viewModel;

    public TabunganFragment() {
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tabungan, container, false);
        TabunganViewModelFactory tabunganViewModelFactory = new TabunganViewModelFactory(requireActivity().getApplication());
        viewModel = new ViewModelProvider(this,tabunganViewModelFactory).get(TabunganViewModel.class);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.listTabunganMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<Tabungan>>() {
            @Override
            public void onChanged(List<Tabungan> tabungans) {
                Toast.makeText(getContext(), "Tabungan "+ tabungans.get(0).getTanggalBeli(), Toast.LENGTH_SHORT).show();
            }
        });
        setupRvTabungan();
    }

    private void setupRvTabungan() {
        RecyclerView recyclerView = binding.rvTabungan;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        TabunganAdapter adapter = new TabunganAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.listTabunganMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<Tabungan>>() {
            @Override
            public void onChanged(List<Tabungan> tabungans) {
                adapter.setList(tabungans);
            }
        });
    }
}