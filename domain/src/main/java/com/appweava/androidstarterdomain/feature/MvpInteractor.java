package com.appweava.androidstarterdomain.feature;

import java.util.List;

import io.reactivex.Observable;

public interface MvpInteractor {

    Observable<List<MvpData>> getMvpList();
}
