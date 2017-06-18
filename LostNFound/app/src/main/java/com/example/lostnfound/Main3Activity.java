package com.example.lostnfound;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    ArrayList contact,material,place,whatis,catag;
    ArrayList contact2,material2,place2,whatis2,catag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Intent intent= new Intent();
        //String catagg = "1";//intent.getStringExtra("catag");
        String catagg = getIntent().getStringExtra("catag");
        String where = getIntent().getStringExtra("where");
        int catshow = getIntent().getIntExtra("catshow",0);

        contact = new ArrayList();
        material = new ArrayList();
        place = new ArrayList();
        whatis = new ArrayList();
        catag = new ArrayList();

        contact2 = new ArrayList();
        material2 = new ArrayList();
        place2 = new ArrayList();
        whatis2 = new ArrayList();
        catag2 = new ArrayList();

        contact.add("9865876877");
        material.add("gun");
        place.add("canteen");
        whatis.add("found");
        catag.add("3");

        contact.add("755878766");
        material.add("powder");
        place.add("canteen 2");
        whatis.add("lost");
        catag.add("3");

        contact.add("667534876");
        material.add("holder");
        place.add("library");
        whatis.add("found");
        catag.add("2");



        contact.add("8768775");
        material.add("Myself");
        place.add("Ground");
        whatis.add("found");
        catag.add("2");

        contact.add("436676598");
        material.add("Ball");
        place.add("Dubeys");
        whatis.add("lost");
        catag.add("1");

        contact.add("367687590");
        material.add("Mobile");
        place.add("At hostel");
        whatis.add("lost");
        catag.add("1");

        contact.add("4366736598");
        material.add("Ball");
        place.add("Dubeys");
        whatis.add("lost");
        catag.add("3");

        contact.add("3676587590");
        material.add("Mobile");
        place.add("At hostel");
        whatis.add("lost");
        catag.add("1");

        int count = 0;
        int no=0;
        String a = "0";

        while (count < 8) {
            //String a = "0",b="1",c="2",d="3";

            if (catag.get(count).equals(catagg)){
                contact2.add(contact.get(count));
                material2.add(material.get(count));
                place2.add(place.get(count));
                whatis2.add(whatis.get(count));
                catag2.add(catag.get(count));
                no++;

            }
            if(catagg.equals("0")){
                contact2.add(contact.get(count));
                material2.add(material.get(count));
                place2.add(place.get(count));
                whatis2.add(whatis.get(count));
                catag2.add(catag.get(count));
                no++;
            }
            count++;

        }


        Intent intent2 = new Intent(this, MainActivity.class);
        intent2.putStringArrayListExtra("contact", contact2);
        intent2.putStringArrayListExtra("material", material2);
        intent2.putStringArrayListExtra("place", place2);
        intent2.putStringArrayListExtra("whatis", whatis2);
        intent2.putStringArrayListExtra("catag", catag2);
        intent2.putExtra("no",no);
        intent2.putExtra("where",where);
        intent2.putExtra("catshow",catshow);
        startActivity(intent2);
        finish();


    }
}
