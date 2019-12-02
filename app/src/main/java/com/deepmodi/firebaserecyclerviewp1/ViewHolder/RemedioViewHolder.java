package com.deepmodi.firebaserecyclerviewp1.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.deepmodi.firebaserecyclerviewp1.R;

import org.w3c.dom.Text;

public class RemedioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtNome,txtDescricao,txtUserNumber;


    public RemedioViewHolder(@NonNull View itemView) {
        super(itemView);
        txtNome = (TextView)itemView.findViewById(R.id.nome_textView);
        txtDescricao = (TextView)itemView.findViewById(R.id.descricao_textView);
    }

    @Override
    public void onClick(View v) {

    }
}
