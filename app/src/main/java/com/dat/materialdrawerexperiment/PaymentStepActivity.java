package com.dat.materialdrawerexperiment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dat.materialdrawerexperiment.view.PinPadResultView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentStepActivity extends AppCompatActivity {

    @Bind(R.id.pinPadview)
    protected PinPadResultView pinPadResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_step);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.next)
    protected void nextClicked() {
        Log.i("next", "clicked");
        pinPadResultView.moveToNextStage();
    }

    @OnClick(R.id.previous)
    protected void previousClicked() {
        Log.i("previous", "clicked");
        pinPadResultView.moveToPreviousPage();
    }
}
