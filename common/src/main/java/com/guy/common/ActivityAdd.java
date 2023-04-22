package com.guy.common;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.reflect.TypeToken;
import com.guy.common.utils.MSP;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class ActivityAdd extends AppCompatActivity {
    protected abstract String SetTitle();
    protected abstract String setName();
    protected abstract String SetTypeOfDataInt();
    protected abstract String setError();
    protected abstract boolean checkValidion(String Data);
    private TextInputEditText name;
    private TextInputEditText amount;
    private TextInputLayout amount_input_text;
    private MaterialTextView date;
    private TextInputEditText desc;
    private MaterialTextView title;
    private MaterialTextView selectDate;
    private MaterialButton save;
    private int mYear, mMonth, mDay;
    private final Calendar c = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        setStartDate();
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }
    private void setStartDate() {
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        int mMonth = c.get(Calendar.MONTH);
        int mYear = c.get(Calendar.YEAR);
        String Sday, Smonth;
        if (mDay < 10) {
            Sday = "0" + mDay;
        } else
            Sday = "" + (mDay);
        if (mMonth < 10) {
            Smonth = "0" + (mMonth + 1);
        } else
            Smonth = "" + (mMonth + 1);
        date.setText(mYear + "-" + Smonth + "-" + Sday);
    }

    private void setDate() {
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        String day, month;
                        if (dayOfMonth < 10) {
                            day = "0" + dayOfMonth;
                        } else
                            day = "" + (dayOfMonth);
                        if (monthOfYear < 10) {
                            month = "0" + (monthOfYear + 1);
                        } else
                            month = "" + (monthOfYear + 1);
                        date.setText(year + "-" + month + "-" + day);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    private void initView() {
        name = findViewById(R.id.name_input);
        name.setHint(setName());
        amount = findViewById(R.id.amount_input);
        amount.setHint(SetTypeOfDataInt());
        date = findViewById(R.id.date_input);
        desc = findViewById(R.id.description_input);
        selectDate = findViewById(R.id.selectDate);
        save = findViewById(R.id.addButton);
        title = findViewById(R.id.titleID);
        title.setText(SetTitle());
        amount_input_text = findViewById(R.id.amount_input_text);
    }

    private void saveNote() {
        String nameText = name.getText().toString();
        String descText = desc.getText().toString();
        String amountText = amount.getText().toString();
        String dateText = date.getText().toString();
        if (nameText.trim().isEmpty() || amountText.trim().isEmpty() || dateText.trim().isEmpty()) {
            Toast.makeText(this, "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!checkValidion(amountText))
            amount_input_text.setError(setError());
        List<DataTable> finalE;
        DataTable data = new DataTable(nameText, amountText, dateText, descText, 1);
        try{
            finalE = MSP.getInstance().getArray("Array data",new TypeToken<ArrayList<DataTable>>(){});
            if(finalE==null)
                finalE = new ArrayList<>();
        }catch (Exception e){
            finalE = new ArrayList<>();
        }
        finalE.add(data);
        MSP.getInstance().putArray("Array data",finalE);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}