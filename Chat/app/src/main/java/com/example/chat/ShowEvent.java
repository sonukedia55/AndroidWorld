package com.example.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShowEvent extends AppCompatActivity {
    //private GestureDetectorCompat gestureObject;
    ListView listView;
    ArrayList<String> reci,material,side;
    //String json_string;
    //JSONObject jsonObject;
    //JSONArray jsonArray;
    //JSONObject JO;
    EventAdapter eventAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gestureObject = new GestureDetectorCompat(this,new LearnGesture());

        //

        listView = (ListView)findViewById(R.id.listView1);

        reci = new ArrayList();
        material = new ArrayList();
        side = new ArrayList();


        eventAdapter = new EventAdapter(this,R.layout.activity_chat_singlemessage);
        listView.setAdapter(eventAdapter);


        /*
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("response");


            int count = 0;
            while (count<jsonArray.length()){
                JO = jsonArray.getJSONObject(count);
                event_name.add(JO.getString("eventName"));
                time_start.add(JO.getString("timeStart"));
                time_end.add(JO.getString("timeEnd"));
                coordinator.add(JO.getString("coordinator"));
                venue.add(JO.getString("venue"));
                about.add(JO.getString("about"));
                contact.add(JO.getString("contact"));


                count++;
            }

        }catch (JSONException e){
            e.printStackTrace();
            */

        reci.add("sonu");
        material.add("gun");
        side.add("found");

        reci.add("9031554015");
        material.add("A key ring have the upper part of red color with honda key ring.");
        side.add("found");

        reci.add("devesh");
        material.add("pend");
        side.add("lost");

        reci.add("apporv");
        material.add("gun");
        side.add("lost");

        reci.add("sonu");
        material.add("gunpowder");
        side.add("found");

        reci.add("laka");
        material.add("lappy");
        side.add("lost");

            int count =0;
            while(count<6) {
                Eventing eventing = new Eventing(reci.get(count), material.get(count), side.get(count));
                eventAdapter.add(eventing);
                count++;
            }

    }
/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                //Intent i = new Intent(ShowEvent.this, EventDetails.class);



                // Pass all data rank
                //Toast.makeText(getApplicationContext(),"jk"+position,Toast.LENGTH_LONG).show();

                i.putExtra("eventName",event_name.get(position));
                i.putExtra("timeStart",time_start.get(position));
                i.putExtra("timeEnd",time_end.get(position));
                i.putExtra("venue",venue.get(position));
                i.putExtra("coordinator",coordinator.get(position));
                i.putExtra("about",about.get(position));
                i.putExtra("contact",contact.get(position));
                //Open SingleItemView.java Activity
                startActivity(i);
                //Toast.makeText(getApplicationContext(),event_name.get(position),Toast.LENGTH_LONG).show();

            }

        });



    }
*/



}
