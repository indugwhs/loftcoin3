package com.indugwhs.loftcoin3.util;


import androidx.annotation.NonNull;

import io.reactivex.Scheduler;

public interface RxSchedulers {
    @NonNull
    Scheduler io();

    @NonNull
    Scheduler cmp();

    @NonNull
    Scheduler main();
}
