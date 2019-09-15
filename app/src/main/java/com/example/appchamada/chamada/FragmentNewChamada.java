package com.example.appchamada.chamada;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appchamada.R;
import com.example.appchamada.activity.home.HomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentNewChamada extends Fragment {

    View view;
     Context context;
     private Spinner spCurso, spDisciplina, spTurma, spTipoChamada;
     private Button btConfirmar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_cad_chamada, container, false);
        context = view.getContext();

        btConfirmar = view.findViewById(R.id.bt_confirmar);
        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStackImmediate();


            }
        });

        spCurso = view.findViewById(R.id.spinner_curso);
        spDisciplina = view.findViewById(R.id.spinner_disciplina);
        spTurma = view.findViewById(R.id.spinner_turma);
        spTipoChamada =view.findViewById(R.id.spinner_tipo_chamada);

        //lista cursos
        List<String> lista = new ArrayList<>();
        lista.add("Sistemas de Informacao");
        lista.add("Medicina");
        lista.add("Direito");

        //lista disciplinas
        List<String> listaDisciplina = new ArrayList<>();
        listaDisciplina.add("Engenharia de Software");
        listaDisciplina.add("Banco de Dados");
        listaDisciplina.add("Orientaçao a Objetos");


        //lista turma
        List<String> listaTurma= new ArrayList<>();
        listaTurma.add("TURMA1");
        listaTurma.add("TURMA2");
        listaTurma.add("TURMA3");
        listaTurma.add("TURMA4");




        //lista tipoChamada

        List<String> listaTipos = new ArrayList<>();
        listaTipos.add("Código de Confirmação");
        listaTipos.add("Confirmação Automática");


        //popula cursos
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,
                lista);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCurso.setAdapter(spinnerArrayAdapter);

        //popula disciplinas
        ArrayAdapter<String> spinnerArrayAdapterDisciplinas = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,
                listaDisciplina);
        spinnerArrayAdapterDisciplinas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDisciplina.setAdapter(spinnerArrayAdapterDisciplinas);


        //popula TipoChamada

        ArrayAdapter<String> spinnerArrayAdapterTipoChamada = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,
                listaTipos);
        spinnerArrayAdapterTipoChamada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoChamada.setAdapter(spinnerArrayAdapterTipoChamada);

        //popula Turmas

        ArrayAdapter<String> spinnerArrayAdapterTurma = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,
                listaTurma);
        spinnerArrayAdapterTurma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTurma.setAdapter(spinnerArrayAdapterTurma);


        return view;

    }
}
