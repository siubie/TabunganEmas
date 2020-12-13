package id.putraprima.mygoldtracker.screen.tabunganadd;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.Calendar;
import java.util.List;

import id.putraprima.mygoldtracker.R;
import id.putraprima.mygoldtracker.databinding.FragmentTambahTabunganBinding;
import id.putraprima.mygoldtracker.db.models.Tabungan;

public class TambahTabunganFragment extends Fragment {

    DatePickerDialog picker;
    FragmentTambahTabunganBinding binding;
    TambahTabunganFragmentViewModel viewModel;
    public TambahTabunganFragment() {
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tambah_tabungan, container, false);
        TambahTabunganViewModelFactory tambahTabunganViewModelFactory = new TambahTabunganViewModelFactory(requireActivity().getApplication());
        viewModel = new ViewModelProvider(this,tambahTabunganViewModelFactory).get(TambahTabunganFragmentViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.extDate.setInputType(InputType.TYPE_NULL);
        binding.extDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                binding.extDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        viewModel.getTabunganLiveData().observe(getViewLifecycleOwner(), new Observer<Tabungan>() {
            @Override
            public void onChanged(Tabungan tabungan) {
                Toast.makeText(getContext(), "Tabungan :"+tabungan.getHarga(), Toast.LENGTH_SHORT).show();
            }
        });
        viewModel.listTabunganMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<Tabungan>>() {
            @Override
            public void onChanged(List<Tabungan> tabungans) {
                Toast.makeText(getContext(), "Total Tabungan :"+tabungans.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}