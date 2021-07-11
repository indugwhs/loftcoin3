package com.indugwhs.loftcoin3.ui.wallets;


import androidx.lifecycle.ViewModelProvider;

import com.indugwhs.loftcoin3.BaseComponent;
import com.indugwhs.loftcoin3.util.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        WalletsModule.class,
        ViewModelModule.class
}, dependencies = {
        BaseComponent.class
})
abstract class WalletsComponent {

    abstract ViewModelProvider.Factory viewModelFactory();

    abstract WalletsAdapter walletsAdapter();

    abstract TransactionsAdapter transactionsAdapter();

}
