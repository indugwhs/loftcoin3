package com.indugwhs.loftcoin3.ui.wallets;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indugwhs.loftcoin3.databinding.LiWalletBinding;

import org.jetbrains.annotations.NotNull;


class WalletsAdapter extends RecyclerView.Adapter<WalletsAdapter.ViewHolder> {

    private LayoutInflater inflater;

    @Override
    public int getItemCount() {
        return 0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LiWalletBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        inflater = LayoutInflater.from(recyclerView.getContext());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(@NonNull LiWalletBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setClipToOutline(true);
        }

    }

}