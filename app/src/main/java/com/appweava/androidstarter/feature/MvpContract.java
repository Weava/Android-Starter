package com.appweava.androidstarter.feature;

import com.appweava.androidstarter.base.mvp.PresenterInterface;
import com.appweava.androidstarterdomain.feature.MvpData;

import java.util.List;

public interface MvpContract {

    interface Presenter extends PresenterInterface<View> {
        /**
         * Retrieve a list of {@link com.appweava.androidstarterdomain.feature.MvpData}.
         */
        void getMvpList();
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
         * Set the view's state.
         *
         * @param state {@link State}
         */
        void setState(State state);
    }
}
