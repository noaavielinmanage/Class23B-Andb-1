package com.guy.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.guy.common.utils.MSP;
import com.guy.common.utils.MySignalV2;

public class Activity_Home extends AppCompatActivity {

    private View home_LAY_no;
    private View home_LAY_yes;
    private MaterialButton home_BTN_stats;
    private MaterialTextView home_LBL_ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViews();
        initViews();

        initAds();

    }

    private void initAds() {
        String id = "dfdfdfsdf";
        home_LBL_ad.setText(id);
    }

    private void initViews() {
        home_LAY_no.setOnClickListener(v -> noClicked());
        home_LAY_yes.setOnClickListener(v -> yesClicked());
        home_BTN_stats.setOnClickListener(v -> statsClicked());
    }

    private void statsClicked() {
        startActivity(new Intent(this, App_Parent.statsClass));
    }

    private void yesClicked() {
        int current = MSP.getInstance().getInt("KEY_YES", 0);
        MSP.getInstance().putInt("KEY_YES", current + 1);
    }

    private void noClicked() {
        MySignalV2.getInstance().showToast("Hi");

        int current = MSP.getInstance().getInt("KEY_NO", 0);
        MSP.getInstance().putInt("KEY_NO", current + 1);
    }

    private void findViews() {
        home_LAY_no = findViewById(R.id.home_LAY_no);
        home_LAY_yes = findViewById(R.id.home_LAY_yes);
        home_BTN_stats = findViewById(R.id.home_BTN_stats);
        home_LBL_ad = findViewById(R.id.home_LBL_ad);
    }
}