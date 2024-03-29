package com.deepmodi.firebaserecyclerviewp1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepmodi.firebaserecyclerviewp1.Model.Remedio;
import com.deepmodi.firebaserecyclerviewp1.ViewHolder.RemedioViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerAdapter<Remedio, RemedioViewHolder> recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase init
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Remedio");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadData();
    }

    private void loadData()
    {
        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<Remedio>()
                .setQuery(databaseReference,Remedio.class)
                .build();

        recyclerAdapter = new FirebaseRecyclerAdapter<Remedio, RemedioViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull RemedioViewHolder holder, int position, @NonNull Remedio model) {

                holder.txtNome.setText(model.getNome());
                holder.txtDescricao.setText(model.getDescricao());

            }

            @NonNull
            @Override
            public RemedioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_view,viewGroup,false);
                return new RemedioViewHolder(view);
            }
        };
       recyclerAdapter.notifyDataSetChanged();
       recyclerAdapter.startListening();
       recyclerView.setAdapter(recyclerAdapter);
    }
}
