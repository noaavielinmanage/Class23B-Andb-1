package com.project.contacts;

import com.guy.common.ActivityAdd;

public class AddContactActivity extends ActivityAdd{

    protected String SetTitle() {
        return "Add Contact";
    }

    @Override
    protected String setName() {
        return "Contact Name";
    }

    @Override
    protected String SetTypeOfDataInt() {
        return "Number";
    }

    @Override
    protected String setError() {
        return "Phone number Must be Legal";
    }

    @Override
    protected boolean checkValidion(String mobileNo) {
        return  !(!mobileNo.matches("(00972|0|\\+972)[5][0-9]{8}") && !mobileNo.matches("(00970|0|\\+970)[5][0-9]{8}") && !mobileNo.matches("(05[0-9]|0[12346789])([0-9]{7})") && !mobileNo.matches("(00972|0|\\+972|0|)[2][0-9]{7}"));

    }
}