package com.gillis.idleapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private long mBalance;
    private final int INCREMENTBY = 5;
    private TextView mTvBalance;
    private Button mBtnAddAmount;

    @Override
    protected void myCustomOnCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mTvBalance = findViewById(R.id.tv_balance);
        mBtnAddAmount = findViewById(R.id.btn_add_amount);
        mBtnAddAmount.setOnClickListener(this);
        mBalance = 0;
        setAmountText();
    }

    private void setAmountText() {
        String balance = "XAF " + mBalance;
        mTvBalance.setText(balance);
    }

    @Override
    protected void myCustomOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_amount:
                mBalance += INCREMENTBY;
                setAmountText();
                break;
            default:
                break;
        }
    }



    @Override
    protected void reactToIdleState() {
        mBalance = 0;
        setAmountText();
    }

}
