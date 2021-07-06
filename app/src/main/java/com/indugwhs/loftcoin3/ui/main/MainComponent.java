package com.indugwhs.loftcoin3.ui.main;

import android.content.SharedPreferences;

import com.indugwhs.loftcoin3.BaseComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        MainModule.class
}, dependencies = {
        BaseComponent.class
})
public abstract class MainComponent {

    abstract void inject(MainActivity activity);

}