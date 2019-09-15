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
import com.example.appchamada.model.Chamada;

import java.util.ArrayList;
import java.util.List;


public class AdapterChamadas extends RecyclerView.Adapter {

    private Context context;
    public static List<Chamada> itens = new ArrayList<>();
   // public final List<Aluno> toSelecionado = new ArrayList<>();
    private boolean showCheck = false;


    private View view;
    private TextView tvNomeAluno, tvData, tvSituacao;


    //public static ArrayList<CheckModel> checkModelArrayList;


    View leftview;

    public AdapterChamadas(Context context, List<Chamada> itens) {
        this.context = context;
        this.itens = itens;


    }


    public void updateData(List<Chamada> itens) {
        this.itens = itens;
        notifyDataSetChanged();


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlunosAdapter(LayoutInflater.from(context).inflate(R.layout.adapter_lista_chamadas, parent, false));

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





        }

        void bind(Chamada chamada) {

            tvNomeAluno.setText(String.valueOf(chamada.getId()));
            tvData.setText("11/11/2019");
            tvSituacao.setText(chamada.getSituacao());


        }
    }


}





