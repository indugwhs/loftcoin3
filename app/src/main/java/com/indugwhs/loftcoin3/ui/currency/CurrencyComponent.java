package com.indugwhs.loftcoin3.ui.currency;

import androidx.lifecycle.ViewModelProvider;

import com.indugwhs.loftcoin3.BaseComponent;
import com.indugwhs.loftcoin3.util.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        CurrencyModule.class,
        ViewModelModule.class
}, dependencies = {
        BaseComponent.class
})
abstract class CurrencyComponent {

    abstract ViewModelProvider.Factory viewModelFactory();

}