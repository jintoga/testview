package com.dat.materialdrawerexperiment.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.dat.materialdrawerexperiment.R;

/**
 * Created by Dat on 12/13/2016.
 */

class PinPadResultAnimationHelper {

    private PidPadResultAnimationListener listener;
    private Context context;

    PinPadResultAnimationHelper(Context context, PidPadResultAnimationListener listener) {
        this.context = context;
        this.listener = listener;
    }

    void moveToNextAnimation(@NonNull final View view) {
        final Animation animationOut = AnimationUtils.loadAnimation(context, R.anim.push_out_left);
        animationOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                final Animation animationIn = AnimationUtils.loadAnimation(context, R.anim.pull_in_right);
                view.startAnimation(animationIn);
                listener.moveToNextAnimationEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(animationOut);
    }

    void moveToPreviousAnimation(@NonNull final View view) {
        final Animation animationOut = AnimationUtils.loadAnimation(context, R.anim.push_out_right);
        animationOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                final Animation animationIn = AnimationUtils.loadAnimation(context, R.anim.pull_in_left);
                view.startAnimation(animationIn);
                listener.moveToPreviousAnimationEnd();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(animationOut);
    }

    interface PidPadResultAnimationListener {
        void moveToNextAnimationEnd();

        void moveToPreviousAnimationEnd();
    }
}
