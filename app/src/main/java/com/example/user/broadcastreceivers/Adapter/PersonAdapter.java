package com.example.user.broadcastreceivers.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.broadcastreceivers.R;
import com.example.user.broadcastreceivers.model.Person;

import java.util.List;

/**
 * Created by Admin on 2/4/2018.
 */


public class PersonAdapter extends  RecyclerView.Adapter<PersonAdapter.MyViewHolder> {

    private List<Person> PersonList;
    private Context context;
    int age= 0;

    public PersonAdapter(Context context, List<Person> PersonList) {
        this.PersonList = PersonList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        Person person = PersonList.get(position);
        holder.person_name.setText(person.getName());
        holder.person_title.setText(person.getTitle());
        holder.person_gender.setText(person.getGender()+",  ");
        age =person.getAge();
        holder.person_age.setText(Integer.toString(person.getAge()));
        holder.ivPerson.setImageResource(person.getImage());
    }

    @Override
    public int getItemCount() {
        return PersonList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView   person_name, person_title,person_gender,person_age;
        public ImageView ivPerson;


        public MyViewHolder(View view) {
            super(view);
            person_name = (TextView) view.findViewById(R.id.person_name);
            person_title = (TextView) view.findViewById(R.id.person_title);
            person_gender = (TextView) view.findViewById(R.id.person_gender);
            person_age = (TextView) view.findViewById(R.id.person_age);
            ivPerson = (ImageView) view.findViewById(R.id.person_photo);


        }
    }
}