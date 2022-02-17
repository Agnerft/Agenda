package com.makesystem.agenda2.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.makesystem.agenda2.R;
import com.makesystem.agenda2.dao.AlunoDAO;
import com.makesystem.agenda2.model.Aluno;

public class FormularioAluno extends AppCompatActivity {



    protected EditText nomeAluno;
    protected EditText numeroAluno;
    protected EditText emailAluno;
    protected Button salvarAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AlunoDAO dao = new AlunoDAO();


        setContentView(R.layout.activity_formulario_aluno);
        nomeAluno = findViewById(R.id.textView_nome);
        numeroAluno = findViewById(R.id.textView_telefone);
        emailAluno = findViewById(R.id.textView_email);
        Log.e("TESTE", "TESTE");
        salvarAluno = findViewById(R.id.button_salvar);


        salvarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = nomeAluno.getText().toString();
                String numero = numeroAluno.getText().toString();
                String email = emailAluno.getText().toString();

                new Aluno(nome, numero, email);



                Aluno alunoCriado = new Aluno(nome, numero, email);
                dao.salva(alunoCriado);

                Intent i = new Intent(FormularioAluno.this,
                        ListaAlunosActivityMain.class);
                startActivity(i);

                finish();


            }
        });

    }

}