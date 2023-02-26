package com.guy.class23b_andb_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

public class Activity_Stats extends AppCompatActivity {

    private MaterialTextView stats_LBL_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        findViews();

        updateUI();
    }

    private void updateUI() {

        int numOfNoCigarettes = MSP.getInstance().getInt("KEY_NO", 0);
        double packets = 0;
        try {
            packets = 20.0 / (numOfNoCigarettes * 1.0);
            packets += 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        final int PCT = (int) packets;
        long price = 30;
        double saves = PCT * price;

        int numOfYesCigarettes = MSP.getInstance().getInt("KEY_YES", 0);


        stats_LBL_save.setText(saves + " NIS saved\n" + numOfYesCigarettes + " smoked");
    }

    private void findViews() {
        stats_LBL_save = findViewById(R.id.stats_LBL_save);
    }
}