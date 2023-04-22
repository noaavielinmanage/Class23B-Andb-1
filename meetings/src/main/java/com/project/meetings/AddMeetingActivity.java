package com.project.meetings;

import com.guy.common.ActivityAdd;
public class AddMeetingActivity extends ActivityAdd{

    protected String SetTitle() {
        return "Add Meeting";
    }

    @Override
    protected String setName() {
        return "Meeting Name";
    }

    @Override
    protected String SetTypeOfDataInt() {
        return "Priority Level";
    }

    @Override
    protected String setError() {
        return "Priority Can't Be Negative";
    }

    @Override
    protected boolean checkValidion(String amountText) {
        try {
            if (Integer.parseInt(amountText) < 0 && Integer.parseInt(amountText) > 5) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}