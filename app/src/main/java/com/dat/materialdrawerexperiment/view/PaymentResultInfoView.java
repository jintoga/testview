package com.dat.materialdrawerexperiment.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewAnimator;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dat.materialdrawerexperiment.R;

/**
 * Created by Dat on 12/26/2016.
 */

public class PaymentResultInfoView extends LinearLayout {

    private static final String TAG = PaymentResultInfoView.class.getName();
    @Bind(R.id.emailOrPhoneAnimator)
    protected ViewAnimator emailOrPhoneAnimator;
    @Bind(R.id.tabLayout)
    protected TabLayout tabLayout;

    public PaymentResultInfoView(Context context) {
        super(context);
        init();
    }

    public PaymentResultInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.payment_result_info_view, this, true);
        ButterKnife.bind(this);
        final Animation inLeft = AnimationUtils.loadAnimation(getContext(), R.anim.pull_in_left);
        final Animation outRight =
            AnimationUtils.loadAnimation(getContext(), R.anim.push_out_right);

        final Animation inRight = AnimationUtils.loadAnimation(getContext(), R.anim.pull_in_right);
        final Animation outLeft = AnimationUtils.loadAnimation(getContext(), R.anim.push_out_left);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    emailOrPhoneAnimator.setInAnimation(inLeft);
                    emailOrPhoneAnimator.setOutAnimation(outRight);
                    emailOrPhoneAnimator.showNext();
                } else {
                    emailOrPhoneAnimator.setInAnimation(inRight);
                    emailOrPhoneAnimator.setOutAnimation(outLeft);
                    emailOrPhoneAnimator.showPrevious();
                }
                Log.d(TAG, "Pos: " + tab.getPosition() + "");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
