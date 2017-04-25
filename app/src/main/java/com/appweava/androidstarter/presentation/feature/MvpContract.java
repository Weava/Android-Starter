package com.appweava.androidstarter.presentation.feature;

import com.appweava.androidstarter.data.feature.MvpData;
import com.appweava.androidstarter.presentation.base.mvp.BasePresenter;

import java.util.List;

public interface MvpContract {

    abstract class Presenter extends BasePresenter<View> {

        /**
         * Retrieve a list of {@link com.appweava.androidstarterdomain.feature.MvpData}.
         */
        abstract void getMvpList();
    }

    interface View {

        /**
         * Enum containing different states for the view.
         */
        enum State {
            LOADING,
            CONTENT
        }

        /**
         * In here for no reason honestly.
         */
        void setMvpListForView(List<MvpData> mvpDataList);

        /**
         * Set the view's {@link State}.
         *
         * @param state {@link State}
         */
        void setState(State state);
    }
}
