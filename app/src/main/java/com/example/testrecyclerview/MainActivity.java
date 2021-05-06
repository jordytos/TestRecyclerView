package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler {
    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;
    Donnee donnee = new Donnee(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //Exercice 1 on remplace la ligne créant le LayoutManager
        //mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager=new LinearLayoutManager(this,GridLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);

        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, R.drawable.divider);
        //mRecyclerView.addItemDecoration(itemDecoration);


    }

    private ArrayList<Donnee> getDataSource() {
        ArrayList results = new ArrayList<Donnee>();
        for (int index = 0; index < donnee.taillePlanetes.length; index++) {
            Donnee obj = new Donnee(donnee.planet[index] ,donnee.taillePlanetes[index], donnee.image[index]);
            results.add(index, obj);
        }
        return results;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }


    public void clicSurRecyclerItem(int position, View v) {

        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        Snackbar.make(mcoordinatorLayout, " Clic sur la planète " + donnee.planet[position], Snackbar.LENGTH_LONG).show();
    }
}


