package com.indugwhs.loftcoin3.ui.activity.rates;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.indugwhs.loftcoin3.R;
import com.indugwhs.loftcoin3.data.Coin;
import com.indugwhs.loftcoin3.data.CurrencyRepo;
import com.indugwhs.loftcoin3.data.CurrencyRepoImpl;
import com.indugwhs.loftcoin3.databinding.FragmentRatesBinding;
import com.indugwhs.loftcoin3.util.PercentFormatter;
import com.indugwhs.loftcoin3.util.PriceFormatter;

import java.util.List;
import java.util.Timer;

import timber.log.Timber;

public class RatesFragment extends Fragment {

    private FragmentRatesBinding binding;

    private RatesAdapter adapter;

    private RatesViewModel viewModel;

    private CurrencyRepo currencyRepo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RatesViewModel.class);
        adapter = new RatesAdapter(new PriceFormatter(), new PercentFormatter());
        currencyRepo = new CurrencyRepoImpl(requireContext());


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rates, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        binding = FragmentRatesBinding.bind(view);
        binding.recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        binding.recycler.swapAdapter(adapter, false);
        binding.recycler.setHasFixedSize(true);
        viewModel.coins().observe(getViewLifecycleOwner(), adapter::submitList);
        viewModel.isRefreshing().observe(getViewLifecycleOwner(), binding.refresher::setRefreshing);
        currencyRepo.currency().observe(getViewLifecycleOwner(), (currency) -> {
            Timber.d("%s", currency);
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.rates, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (R.id.currency_dialog == item.getItemId()) {
            NavHostFragment
                    .findNavController(this)
                    .navigate(R.id.currency_dialog);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        binding.recycler.swapAdapter(null, false);
        super.onDestroyView();
    }

}