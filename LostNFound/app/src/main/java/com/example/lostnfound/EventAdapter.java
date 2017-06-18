package com.example.lostnfound;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sonu Kedia on 02/06/2017.
 */
public class EventAdapter extends ArrayAdapter{

    List list = new ArrayList();
    String check;
    ImageView imageView3;

    public EventAdapter(Context context, int resource){
        super(context, resource);
    }


    public void add(Eventing object){
        super.add(object);
        list.add(object);
    }
    @Override
    public int getCount(){
        return list.size();
    }
    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        final ContactHolder contactHolder;
        if(row == null){
            Eventing eventing = (Eventing)this.getItem(position);

            check = eventing.getWhatis();

            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_chat_singlemessage,parent,false);
            //singleMessageContainer = (LinearLayout) row.findViewById(R.id.singleMessageContainer);
            //container = (LinearLayout) row.findViewById(R.id.layoutcontainer);
            String b= "lost";

            contactHolder = new ContactHolder();
            contactHolder.tx_contact = (TextView)row.findViewById(R.id.contact);
            contactHolder.tx_material = (TextView)row.findViewById(R.id.material);
            contactHolder.tx_place = (TextView)row.findViewById(R.id.place);
            contactHolder.imageView2 = (ImageView)row.findViewById(R.id.imageView2);
            contactHolder.tx_category = (TextView)row.findViewById(R.id.catagory);

            row.setTag(contactHolder);

            /*

            if(check.equals(b)){
                //singleMessageContainer.setBackgroundResource(R.drawable.bubble_a);
                //container.setGravity(Gravity.RIGHT);
                //contactHolder.whatto.setText("Lost :  ");
            }else {
                //singleMessageContainer.setBackgroundResource(R.drawable.blue6);
                //container.setGravity(Gravity.LEFT);
            }

        */

        }
        else{
            contactHolder = (ContactHolder)row.getTag();

        }
        Eventing eventing = (Eventing)this.getItem(position);
        contactHolder.tx_material.setText(eventing.getMaterial());
        contactHolder.tx_place.setText("Location : "+eventing.getPlace());
        contactHolder.tx_contact.setText("Contact : "+eventing.getContact());
        String aa="";
        if(eventing.getCatag().equals("0")){aa="All";}
        if(eventing.getCatag().equals("1")){aa="Electronics";}
        if(eventing.getCatag().equals("2")){aa="Books";}
        if(eventing.getCatag().equals("3")){aa="Goods";}
        contactHolder.tx_category.setText("Category : "+aa);


        new ImageLoadTask("https://s-media-cache-ak0.pinimg.com/736x/07/5e/13/075e1398616a3497d8083437f6bdd70c.jpg", contactHolder.imageView2).execute();

        //contactHolder.imageView2.setImageBitmap(getBitmapFromURL());


        return row;
    }

    static class ContactHolder{
        TextView tx_contact,tx_material,tx_place,tx_whatis,tx_category;
        ImageView imageView2;
    }

    public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private ImageView imageView;

        public ImageLoadTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL urlConnection = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }

    }

}
