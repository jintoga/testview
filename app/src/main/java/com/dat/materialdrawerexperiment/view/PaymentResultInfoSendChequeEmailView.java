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

public class PaymentResultInfoSendChequeEmailView extends FrameLayout {

    @Bind(R.id.email)
    protected EditText email;
    @Bind(R.id.emailContacts)
    protected ImageView emailContacts;

    public PaymentResultInfoSendChequeEmailView(Context context) {
        super(context);
        init();
    }

    public PaymentResultInfoSendChequeEmailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.payment_result_info_view_send_cheque_email, this, true);
        ButterKnife.bind(this);
    }
}
