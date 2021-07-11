package com.indugwhs.loftcoin3.fcm;

import com.indugwhs.loftcoin3.BaseComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        FcmModule.class
}, dependencies = {
        BaseComponent.class
})
abstract class FcmComponent {

    abstract void inject(FcmService service);

}