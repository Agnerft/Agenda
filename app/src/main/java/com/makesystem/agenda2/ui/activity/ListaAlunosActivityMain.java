package com.makesystem.agenda2.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.makesystem.agenda2.R;
import com.makesystem.agenda2.dao.AlunoDAO;
import com.makesystem.agenda2.model.Aluno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAlunosActivityMain extends AppCompatActivity {

    protected FloatingActionButton criarAluno;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        criarAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);

        final AlunoDAO dao = new AlunoDAO();


        criarAluno.setOnClickListener(view -> {
            Intent i = new Intent(this, FormularioAluno.class);
            startActivity(i);

        });


    }

        @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        final AlunoDAO dao = new AlunoDAO();
        ListView listaDeAlunos = findViewById(R.id.activity_lista_listagem_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<Aluno>(this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int posição,
                                    long id) {
                Log.i("TAG", "onItemClick: ");;

            }
        });

    }




}