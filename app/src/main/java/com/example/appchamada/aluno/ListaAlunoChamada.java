package com.example.appchamada.aluno;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appchamada.R;
import com.example.appchamada.activity.home.HomeActivity;
import com.example.appchamada.adapter.AdapterChamadaLista;
import com.example.appchamada.model.Aluno;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunoChamada extends AppCompatActivity {

    RecyclerView recyclerView_alunos;
    AdapterChamadaLista adapter;
    List<Aluno> alunos =new ArrayList<>();
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_chamada);

        toolbar = (Toolbar) findViewById(R.id.alunostoolbar);
        setSupportActionBar(toolbar);
        setTitle("Chamada Manual");


        recyclerView_alunos = findViewById(R.id.recycleralunos);
        recyclerView_alunos.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterChamadaLista(this, alunos);

        recyclerView_alunos.setAdapter(adapter);


        for (int i =0; i <30; i ++){
            Aluno aluno = new Aluno();
            aluno.setNome("Aluno Teste");
            aluno.setSituacao("Presente");
            alunos.add(aluno);
            adapter.updateData(alunos);
        }


    }
}
