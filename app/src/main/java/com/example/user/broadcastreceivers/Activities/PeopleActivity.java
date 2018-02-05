package com.example.user.broadcastreceivers.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.broadcastreceivers.Adapter.PersonAdapter;
import com.example.user.broadcastreceivers.R;
import com.example.user.broadcastreceivers.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PeopleActivity extends AppCompatActivity {


    private List<Person> PersonList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersonAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);


        PersonList = MainActivity.personList;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new PersonAdapter(this,PersonList );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
