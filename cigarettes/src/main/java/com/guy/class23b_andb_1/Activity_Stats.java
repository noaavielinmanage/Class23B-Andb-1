package com.guy.class23b_andb_1;

import com.guy.common.utils.MSP;

public class Activity_Stats extends Activity_StatsParent {

    @Override
    protected String getData() {

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

        return saves + " NIS saved\n" + numOfYesCigarettes + " smoked";
    }
}
