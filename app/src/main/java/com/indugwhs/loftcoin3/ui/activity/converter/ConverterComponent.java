package com.indugwhs.loftcoin3.ui.activity.converter;

import androidx.lifecycle.ViewModelProvider;

import com.indugwhs.loftcoin3.BaseComponent;
import com.indugwhs.loftcoin3.util.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ConverterModule.class,
        ViewModelModule.class
}, dependencies = {
        BaseComponent.class
})
abstract class ConverterComponent {

    abstract ViewModelProvider.Factory viewModelFactory();

    abstract CoinsSheetAdapter coinsSheetAdapter();

}
