package com.indugwhs.loftcoin3;

import android.app.Application;

import androidx.room.PrimaryKey;

import com.indugwhs.loftcoin3.data.DataModule;
import com.indugwhs.loftcoin3.util.UtilModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;


@Singleton
@Component(
        modules = {
                AppModule.class,
                DataModule.class,
                UtilModule.class
        }
)
abstract class AppComponent implements BaseComponent {

    @Component.Builder
    static abstract class Builder {
        @BindsInstance
        abstract Builder application(Application app);

        abstract AppComponent build();
    }

}