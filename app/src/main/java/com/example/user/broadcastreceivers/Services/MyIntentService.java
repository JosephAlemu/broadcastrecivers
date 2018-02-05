package com.example.user.broadcastreceivers.Services;

import android.app.IntentService;
import android.content.Intent;

import com.example.user.broadcastreceivers.Activities.PeopleActivity;
import com.example.user.broadcastreceivers.R;
import com.example.user.broadcastreceivers.model.Person;

import java.util.Random;

public class MyIntentService extends IntentService {

    public static final String ACTION_MyIntentService = "com.example.androidintentservice.RESPONSE";
    public static final String ACTION_MyUpdate = "com.example.androidintentservice.UPDATE";
    public static final String EXTRA_KEY_IN = "EXTRA_IN";
    public static final String EXTRA_KEY_OUT = "EXTRA_OUT";
    public static final String EXTRA_KEY_UPDATE = "EXTRA_UPDATE";
    String msgFromActivity;
    String extraOut;


    private String title;

    public MyIntentService() {
        super("com.example.androidintentservice.MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    protected void onHandleIntent(Intent intent) {


        Person person = null;
        msgFromActivity = intent.getStringExtra(EXTRA_KEY_IN);
        extraOut = "Hello: " +  msgFromActivity;

        for(int i = 0; i <=10; i++)
        {
            int rand = new Random().nextInt(30);
            try {
                Thread.sleep(1000);

                  String randomName = getRandomName();
                  int randomImage = getRandomImage();

                  title = i%2==0 ? "offense" : "defense";


                person = new Person(i,randomName,title,randomImage,i+rand,"Male");

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            //send update
            Intent intentUpdate = new Intent();
            intentUpdate.setAction(ACTION_MyUpdate);
            intentUpdate.addCategory(Intent.CATEGORY_DEFAULT);
            intentUpdate.putExtra("person_Obj", person);
            intentUpdate.putExtra(EXTRA_KEY_UPDATE, i);
            sendBroadcast(intentUpdate);
        }

        //return result
//        Intent intentResponse = new Intent();
//        intentResponse.setAction(ACTION_MyIntentService);
//        intentResponse.addCategory(Intent.CATEGORY_DEFAULT);
//        intentResponse.putExtra(EXTRA_KEY_OUT, extraOut);
//        sendBroadcast(intentResponse);


        Intent intentA = new Intent(this, PeopleActivity.class);

        startActivity(intentA);
    }


    public  String getRandomName( ) {

        String [] name  ={"Earl Thomas","Russell Wilson","Richard Sherman","Jimmy Graham","Michael Bennett","Doug Baldwin","Tyler Lockett","K. J. Wright",
               "Jon Ryan","Cliff Avril","Thomas Rawls"};


        int rand = new Random().nextInt(name.length);
        return name[rand];
    }
    public  int getRandomImage() {

        int [] image = { R.drawable.bobby_wagner,  R.drawable.cliff_avril,  R.drawable.doug_baldwin,  R.drawable.earl_thomas,
                R.drawable.jimmy_graham,  R.drawable.jon_ryan, R.drawable.kam_chancellor,  R.drawable.kjright,
                R.drawable.michael_bennett, R.drawable.richard_sherman,  R.drawable.russell_wilson,  R.drawable.thomas_rawls,
                R.drawable.tyler_lockett  };


        int rand = new Random().nextInt(image.length);
        return image[rand];
    }
}