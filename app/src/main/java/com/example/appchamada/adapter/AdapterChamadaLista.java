package com.example.appchamada.adapter;



import android.content.Context;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appchamada.R;
import com.example.appchamada.model.Aluno;





import java.util.ArrayList;


import java.util.List;


public class AdapterChamadaLista extends RecyclerView.Adapter {

    private Context context;
    public static List<Aluno> itens = new ArrayList<>();
    private boolean showCheck = false;


    private View view;
    private TextView tvNomeAluno, tvData, tvSituacao;


    //public static ArrayList<CheckModel> checkModelArrayList;


    View leftview;

    public AdapterChamadaLista(Context context, List<Aluno> itens) {
        this.context = context;
        this.itens = itens;


    }


    public void updateData(List<Aluno> itens) {
        this.itens = itens;
        notifyDataSetChanged();


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlunosAdapter(LayoutInflater.from(context).inflate(R.layout.adapter_lista_alunos, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        ((AlunosAdapter) holder).bind(itens.get(position));

        //((AlunosAdapter) holder).checkSelecionada.setChecked(itens.get(position).isSelecionada());
    }


    @Override
    public int getItemCount() {
        return itens.size();
    }

    class AlunosAdapter extends RecyclerView.ViewHolder {
        public CheckBox checkSelecionada;

        AlunosAdapter(View itemView) {

            super(itemView);
            tvNomeAluno = itemView.findViewById(R.id.tv_nome_aluno);
            tvData = itemView.findViewById(R.id.tvData);
            tvSituacao = itemView.findViewById(R.id.tv_situacao);


            checkSelecionada = itemView.findViewById(R.id.checkSelecionada);


        }

        void bind(Aluno aluno) {

            tvNomeAluno.setText(aluno.getNome());
            tvData.setText("11/11/2019");
            tvSituacao.setText(aluno.getSituacao());


        }
    }


}





