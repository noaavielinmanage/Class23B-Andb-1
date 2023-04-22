package com.project.expenses;

import com.guy.common.ActivityAdd;
public class AddExpenseActivity extends ActivityAdd{

    protected String SetTitle() {
        return "Add Expense";
    }

    @Override
    protected String setName() {
        return "Expense Name";
    }

    @Override
    protected String SetTypeOfDataInt() {
        return "Amount";
    }

    @Override
    protected String setError() {
        return "Amount Can't Be Negative";
    }

    @Override
    protected boolean checkValidion(String amountText) {
        try {
            if (Integer.parseInt(amountText) < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}