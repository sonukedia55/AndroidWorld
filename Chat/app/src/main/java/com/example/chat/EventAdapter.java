package com.example.chat;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sonu Kedia on 02/06/2017.
 */
public class EventAdapter extends ArrayAdapter{

    List list = new ArrayList();
    String check;
    private LinearLayout singleMessageContainer,container;

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

            check = eventing.getSide();

            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_chat_singlemessage,parent,false);
            singleMessageContainer = (LinearLayout) row.findViewById(R.id.singleMessageContainer);
            container = (LinearLayout) row.findViewById(R.id.layoutcontainer);
            String b= "lost";

            contactHolder = new ContactHolder();
            contactHolder.tx_eventName = (TextView)row.findViewById(R.id.singleMessage);
            contactHolder.whatto = (TextView)row.findViewById(R.id.whatfound);
            contactHolder.tx_eventStart = (TextView)row.findViewById(R.id.recip);
            row.setTag(contactHolder);

            if(check.equals(b)){
                singleMessageContainer.setBackgroundResource(R.drawable.bubble_a);
                container.setGravity(Gravity.RIGHT);
                contactHolder.whatto.setText("Lost :  ");
            }else {
                singleMessageContainer.setBackgroundResource(R.drawable.blue6);
                container.setGravity(Gravity.LEFT);
            }



        }
        else{
            contactHolder = (ContactHolder)row.getTag();

        }
        Eventing eventing = (Eventing)this.getItem(position);
        contactHolder.tx_eventName.setText(eventing.getRecip());
        contactHolder.tx_eventStart.setText(eventing.getMaterial());



        return row;
    }

    static class ContactHolder{
        TextView tx_eventName,tx_eventStart,whatto;
    }

}
