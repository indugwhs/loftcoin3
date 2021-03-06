package com.indugwhs.loftcoin3.ui.activity.converter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.indugwhs.loftcoin3.BuildConfig;
import com.indugwhs.loftcoin3.data.Coin;
import com.indugwhs.loftcoin3.databinding.LiCoinSheetBinding;
import com.indugwhs.loftcoin3.util.ImageLoader;
import com.indugwhs.loftcoin3.util.OutlineCircle;

import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

class CoinsSheetAdapter extends ListAdapter<Coin, CoinsSheetAdapter.ViewHolder> {

    private final ImageLoader imageLoader;
    private LayoutInflater inflater;

    @Inject
    CoinsSheetAdapter(ImageLoader imageLoader) {
        super(new DiffUtil.ItemCallback<Coin>() {
            @Override
            public boolean areItemsTheSame(@NonNull Coin oldItem, @NonNull Coin newItem) {
                return oldItem.id() == newItem.id();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Coin oldItem, @NonNull Coin newItem) {
                return Objects.equals(oldItem, newItem);
            }
        });
        this.imageLoader = imageLoader;
    }

    @Override
    public Coin getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LiCoinSheetBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Coin coin = getItem(position);
        holder.binding.name.setText(coin.symbol() + " | " + coin.name());
        imageLoader
                .load(BuildConfig.IMG_ENDPOINT + coin.id() + ".png")
                .into(holder.binding.logo);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        inflater = LayoutInflater.from(recyclerView.getContext());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final LiCoinSheetBinding binding;

        ViewHolder(@NonNull LiCoinSheetBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            OutlineCircle.apply(binding.logo);
        }
    }
}