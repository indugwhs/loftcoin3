package com.indugwhs.loftcoin3;

import android.content.Context;

import com.indugwhs.loftcoin3.data.CoinsRepo;
import com.indugwhs.loftcoin3.data.CurrencyRepo;
import com.indugwhs.loftcoin3.data.WalletsRepo;
import com.indugwhs.loftcoin3.util.ImageLoader;
import com.indugwhs.loftcoin3.util.Notifier;
import com.indugwhs.loftcoin3.util.RxSchedulers;


public interface BaseComponent {
    Context context();

    CoinsRepo coinsRepo();

    CurrencyRepo currencyRepo();

    ImageLoader imageLoader();

    RxSchedulers schedulers();

    WalletsRepo walletsRepo();

    Notifier notifier();
}