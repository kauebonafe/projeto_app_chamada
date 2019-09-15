package com.example.appchamada.chamada;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appchamada.R;
import com.example.appchamada.adapter.AdapterChamadas;
import com.example.appchamada.model.Chamada;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class FragmentFindChamada extends Fragment {

    View view;
     Context context;
    AdapterChamadas  adapter;
    RecyclerView recyclerView;
    List<Chamada> lista = new ArrayList<>();
    private  EditText etData;

     Calendar myCalendar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_find_chamada, container, false);
        context = view.getContext();


    etData =  view.findViewById(R.id.et_data);


    myCalendar = Calendar.getInstance();

      final   DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }


        };

        etData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(context, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });







        recyclerView= view.findViewById(R.id.recycler_filter_chamada);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        adapter = new AdapterChamadas(context, lista);

        recyclerView.setAdapter(adapter);


        for (int i =0; i <30; i ++){
            Chamada chamada = new Chamada();
            chamada.setId(25654654);
            chamada.setSituacao("ABERTO");
            lista.add(chamada);
            adapter.updateData(lista);
        }

        return view;

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etData.setText(sdf.format(myCalendar.getTime()));
    }
}
