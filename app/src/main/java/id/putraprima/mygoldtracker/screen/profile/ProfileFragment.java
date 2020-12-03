package id.putraprima.mygoldtracker.screen.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mygoldtracker.R;
import id.putraprima.mygoldtracker.databinding.FragmentProfileBinding;
import id.putraprima.mygoldtracker.models.Profile;
import id.putraprima.mygoldtracker.screen.portfolio.PortfolioFragmentDirections;
import id.putraprima.mygoldtracker.screen.portfolio.PortfolioViewModel;
import id.putraprima.mygoldtracker.screen.portfolio.PortfolioViewModelFactory;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ProfileViewModel viewModel;

    public ProfileFragment() {
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false);
        ProfileViewModelFactory profileViewModelFactory = new ProfileViewModelFactory(requireActivity().getApplication());
        viewModel = new ViewModelProvider(this,profileViewModelFactory).get(ProfileViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getProfileLiveData().observe(getViewLifecycleOwner(), new Observer<Profile>() {
            @Override
            public void onChanged(Profile profile) {
                if(profile!=null){
                    NavDirections action = ProfileFragmentDirections.actionProfileFragmentToPorfolioFragment();
                    Navigation.findNavController(requireView()).navigate(action);
                    viewModel.onSaveProfileNavigated();
                }
            }
        });
    }
}