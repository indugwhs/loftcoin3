package com.indugwhs.loftcoin3.util;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class UtilModule {

    @Binds
    abstract ImageLoader imageLoader(PicassoImageLoader impl);

    @Binds
    abstract RxSchedulers schedulers(RxSchedulersImpl impl);

    @Binds
    abstract Notifier notifier(NotifierImpl impl);

}