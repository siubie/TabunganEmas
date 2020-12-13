package id.putraprima.mygoldtracker.screen.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import id.putraprima.mygoldtracker.R;
import id.putraprima.mygoldtracker.databinding.FragmentPorfolioBinding;

public class PortfolioFragment extends Fragment {

    FragmentPorfolioBinding binding;
    PortfolioViewModel viewModel;
    public PortfolioFragment() {
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_porfolio, container, false);
        PortfolioViewModelFactory portfolioViewModelFactory = new PortfolioViewModelFactory(requireActivity().getApplication());
        viewModel = new ViewModelProvider(this,portfolioViewModelFactory).get(PortfolioViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.beratLiveData.observe(getViewLifecycleOwner(), new Observer<Float>() {
            @Override
            public void onChanged(Float aFloat) {
                Toast.makeText(getContext(), "Total Simpanan "+ aFloat, Toast.LENGTH_SHORT).show();
            }
        });
    }
}