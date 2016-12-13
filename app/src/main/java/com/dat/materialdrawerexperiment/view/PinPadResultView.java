package com.dat.materialdrawerexperiment.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dat.materialdrawerexperiment.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dat on 12/12/2016.
 */

public class PinPadResultView extends LinearLayout implements PinPadResultAnimationHelper.PidPadResultAnimationListener {

    private static final String TAG = PinPadResultView.class.getName();

    private static final int STAGE1 = 1;
    private static final int STAGE2 = 2;
    private static final int STAGE3 = 3;

    private PinPadResultAnimationHelper animationHelper;

    enum STATES {enabled, disabled, selected, finished}

    //Indicator
    @Bind(R.id.stage1TextNumber)
    protected TextView stage1TextNumber;
    @Bind(R.id.stage2TextNumber)
    protected TextView stage2TextNumber;
    @Bind(R.id.stage3TextNumber)
    protected TextView stage3TextNumber;
    @Bind(R.id.stage1Icon)
    protected ImageView stage1Icon;
    @Bind(R.id.stage2Icon)
    protected ImageView stage2Icon;
    @Bind(R.id.stage3Icon)
    protected ImageView stage3Icon;

    @Bind(R.id.stage1Text)
    protected TextView stage1Text;
    @Bind(R.id.stage2Text)
    protected TextView stage2Text;
    @Bind(R.id.stage3Text)
    protected TextView stage3Text;

    private int currentStage = 0;

    //Content
    @Bind(R.id.contentContainer)
    protected View contentContainer;
    @Bind(R.id.statusIcon)
    protected ImageView statusIcon;


    public PinPadResultView(Context context) {
        super(context);
        init();
    }

    public PinPadResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.stepper_view, this, true);
        ButterKnife.bind(this);

        animationHelper = new PinPadResultAnimationHelper(getContext(), this);

        //hide all stageIcons
        stage1Icon.setVisibility(GONE);
        stage2Icon.setVisibility(GONE);
        stage3Icon.setVisibility(GONE);

        //show all stageTextNumbers
        stage1TextNumber.setVisibility(VISIBLE);
        stage2TextNumber.setVisibility(VISIBLE);
        stage3TextNumber.setVisibility(VISIBLE);

        //set all stageFinishIcons background to enabled
        stage1Icon.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
        stage2Icon.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
        stage3Icon.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));

        //set all stageTextNumberIcons background to disabled
        stage1TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_disabled));
        stage2TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_disabled));
        stage3TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_disabled));

        setStageEnabled(STATES.selected, STAGE1);
        setStageEnabled(STATES.disabled, STAGE2);
        setStageEnabled(STATES.disabled, STAGE3);

        currentStage = 1;
    }

    private void setStageEnabled(STATES states, int stageNumber) {
        switch (stageNumber) {
            case STAGE1:
                stage1Icon.setVisibility(GONE);
                stage1TextNumber.setVisibility(VISIBLE);
                if (states == STATES.enabled) {
                    stage1Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextEnabledTheme);
                    stage1TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                } else if (states == STATES.disabled) {
                    stage1Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextDisabledTheme);
                    stage1TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_disabled));
                } else if (states == STATES.selected) {
                    stage1Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextSelectedTheme);
                    stage1TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                } else {
                    stage1Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextEnabledTheme);
                    stage1TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                    stage1TextNumber.setVisibility(GONE);
                    stage1Icon.setVisibility(VISIBLE);
                }
                break;
            case STAGE2:
                stage2Icon.setVisibility(GONE);
                stage2TextNumber.setVisibility(VISIBLE);
                if (states == STATES.enabled) {
                    stage2Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextEnabledTheme);
                    stage2TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                } else if (states == STATES.disabled) {
                    stage2Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextDisabledTheme);
                    stage2TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_disabled));
                } else if (states == STATES.selected) {
                    stage2Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextSelectedTheme);
                    stage2TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                } else {
                    stage2Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextEnabledTheme);
                    stage2TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                    stage2TextNumber.setVisibility(GONE);
                    stage2Icon.setVisibility(VISIBLE);
                }
                break;
            case STAGE3:
                stage3Icon.setVisibility(GONE);
                stage3TextNumber.setVisibility(VISIBLE);
                if (states == STATES.enabled) {
                    stage3Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextEnabledTheme);
                    stage3TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                } else if (states == STATES.disabled) {
                    stage3Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextDisabledTheme);
                    stage3TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_disabled));
                } else if (states == STATES.selected) {
                    stage3Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextSelectedTheme);
                    stage3TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                } else {
                    stage3Text.setTextAppearance(getContext(), R.style.StepperIndicatorTextEnabledTheme);
                    stage3TextNumber.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_circular_enabled));
                    stage3TextNumber.setVisibility(GONE);
                    stage3Icon.setVisibility(VISIBLE);
                }
                break;
        }
    }

    @OnClick(R.id.repeat)
    protected void repeatClicked() {
        Log.i("repeat", "Clicked");
    }

    @OnClick(R.id.finish)
    protected void finishClicked() {
        Log.i("finish", "Clicked");
    }

    public void moveToNextStage() {
        if (currentStage < STAGE1 || currentStage > STAGE2) {
            Log.d(TAG, "invalid stage number or already on final Stage");
            return;
        }
        if (currentStage == STAGE1) {
            animationHelper.moveToNextAnimation(contentContainer);
        } else if (currentStage == STAGE2) {
            animationHelper.moveToNextAnimation(contentContainer);
        }
    }

    public void moveToPreviousPage() {
        if (currentStage <= STAGE1 || currentStage > STAGE3) {
            Log.d(TAG, "invalid stage number");
            return;
        }
        if (currentStage == STAGE2) {
            animationHelper.moveToPreviousAnimation(contentContainer);
        } else if (currentStage == STAGE3) {
            animationHelper.moveToPreviousAnimation(contentContainer);
        }
    }

    @Override
    public void moveToNextAnimationEnd() {
        if (currentStage == STAGE1) {
            setStageEnabled(STATES.finished, STAGE1);
            setStageEnabled(STATES.selected, STAGE2);
            setStageEnabled(STATES.disabled, STAGE3);


            currentStage = STAGE2;
        } else if (currentStage == STAGE2) {
            setStageEnabled(STATES.finished, STAGE1);
            setStageEnabled(STATES.finished, STAGE2);
            setStageEnabled(STATES.selected, STAGE3);

            currentStage = STAGE3;
        }
    }

    @Override
    public void moveToPreviousAnimationEnd() {
        if (currentStage == STAGE3) {
            setStageEnabled(STATES.finished, STAGE1);
            setStageEnabled(STATES.selected, STAGE2);
            setStageEnabled(STATES.disabled, STAGE3);

            currentStage = STAGE2;
        } else if (currentStage == STAGE2) {
            setStageEnabled(STATES.selected, STAGE1);
            setStageEnabled(STATES.disabled, STAGE2);
            setStageEnabled(STATES.disabled, STAGE3);

            currentStage = STAGE1;
        }
    }

}
