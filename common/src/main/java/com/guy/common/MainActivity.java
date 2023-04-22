package com.guy.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;
import com.guy.common.utils.MSP;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView no_expense;
    private Button buttonAddNote;
    private RecyclerView recyclerView;
    public static List<DataTable> finalE;
    private LinearLayoutManager HorizontalLayout;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        final DataAdapter adapter = new DataAdapter();
        try{
            finalE = MSP.getInstance().getArray("Array data",new TypeToken<ArrayList<DataTable>>(){});
        }catch (Exception e){
            finalE = new ArrayList<>();
        }
        adapter.setNotes(finalE);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        HorizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),App_Parent.statsClass);
            startActivity(intent);
        });
    }

    private void findViews() {
        buttonAddNote = findViewById(R.id.button_add_note);
        no_expense = findViewById(R.id.no_expense);
        recyclerView = findViewById(R.id.recycler_view);
    }
}
