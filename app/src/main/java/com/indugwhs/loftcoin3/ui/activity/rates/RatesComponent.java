package com.indugwhs.loftcoin3.ui.activity.rates;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.indugwhs.loftcoin3.BaseComponent;
import com.indugwhs.loftcoin3.util.ViewModelModule;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RatesModule.class,
        ViewModelModule.class
}, dependencies = {
        BaseComponent.class
})
abstract class RatesComponent {

    abstract ViewModelProvider.Factory viewModelFactory();

    abstract RatesAdapter ratesAdapter();

}