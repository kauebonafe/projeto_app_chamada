package com.example.appchamada.chamada;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class FragmentChamadaCode extends Fragment {

    View view;
     Context context;
    AdapterChamadas  adapter;
    RecyclerView recyclerView;
    List<Chamada> lista = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_chamadas_codigo, container, false);
        context = view.getContext();

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setImageResource(R.drawable.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Nova Chamada");

                Fragment newFragment = new FragmentNewChamada();
                FragmentTransaction transaction =getFragmentManager().beginTransaction();


                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();
            }
        });

        recyclerView= view.findViewById(R.id.recycler_chamadas);
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
}
