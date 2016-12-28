package com.dat.materialdrawerexperiment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dat.materialdrawerexperiment.R;

/**
 * Created by Dat on 12/26/2016.
 */

public class PaymentResultInfoSendChequePhoneView extends FrameLayout {

    @Bind(R.id.phone)
    protected EditText phone;
    @Bind(R.id.phoneContacts)
    protected ImageView phoneContacts;

    public PaymentResultInfoSendChequePhoneView(Context context) {
        super(context);
        init();
    }

    public PaymentResultInfoSendChequePhoneView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.payment_result_info_view_send_cheque_phone, this, true);
        ButterKnife.bind(this);
    }
}
