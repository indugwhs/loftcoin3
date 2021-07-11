package com.indugwhs.loftcoin3.ui.wallets;

import android.graphics.Color;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.indugwhs.loftcoin3.data.Transaction;
import com.indugwhs.loftcoin3.databinding.LiTransactionBinding;
import com.indugwhs.loftcoin3.util.BalanceFormatter;
import com.indugwhs.loftcoin3.util.PriceFormatter;

import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

class TransactionsAdapter extends ListAdapter<Transaction, TransactionsAdapter.ViewHolder> {

    private final PriceFormatter priceFormatter;

    private LayoutInflater inflater;

    private final BalanceFormatter balanceFormatter;

    private int colorNegative = Color.RED;

    private int colorPositive = Color.GREEN;


    @Inject
    TransactionsAdapter(PriceFormatter priceFormatter, BalanceFormatter balanceFormatter) {
        super(new DiffUtil.ItemCallback<Transaction>() {
            @Override
            public boolean areItemsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
                return Objects.equals(oldItem.uid(), newItem.uid());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
                return Objects.equals(oldItem, newItem);
            }
        });
        this.priceFormatter = priceFormatter;

        this.balanceFormatter = balanceFormatter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LiTransactionBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Transaction transaction = getItem(position);
        holder.binding.amount1.setText(priceFormatter.format(transaction.amount()));
        final double fiatAmount = transaction.amount() * transaction.coin().price();
        if (transaction.amount() > 0) {
            holder.binding.amount2.setTextColor(colorPositive);
        } else {
            holder.binding.amount2.setTextColor(colorNegative);
        }
        holder.binding.amount2.setText(priceFormatter.format(transaction.coin().currencyCode(), fiatAmount));
        holder.binding.timestamp.setText(DateFormat.getDateFormat(inflater.getContext()).format(transaction.createdAt()));
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        inflater = LayoutInflater.from(recyclerView.getContext());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final LiTransactionBinding binding;

        ViewHolder(@NonNull LiTransactionBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setClipToOutline(true);
            this.binding = binding;
        }

    }

}