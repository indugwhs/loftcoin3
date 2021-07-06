package com.indugwhs.loftcoin3;

import android.content.Context;

import com.indugwhs.loftcoin3.data.CoinsRepo;
import com.indugwhs.loftcoin3.data.CurrencyRepo;
import com.indugwhs.loftcoin3.util.ImageLoader;

public interface BaseComponent {
    Context context();
    CoinsRepo coinsRepo();
    CurrencyRepo currencyRepo();
    ImageLoader imageLoader();
}