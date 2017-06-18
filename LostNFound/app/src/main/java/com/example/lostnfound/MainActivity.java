package com.example.lostnfound;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;static

    ArrayList<String> contact,material,place,whatis,catag;
    static int catshow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);



        contact = new ArrayList();
        material = new ArrayList();
        place = new ArrayList();
        whatis = new ArrayList();
        catag = new ArrayList();


        contact = getIntent().getStringArrayListExtra("contact");
        material = getIntent().getStringArrayListExtra("material");
        place = getIntent().getStringArrayListExtra("place");
        whatis = getIntent().getStringArrayListExtra("whatis");
        catag = getIntent().getStringArrayListExtra("catag");
        int no = getIntent().getIntExtra("no",0);
        catshow = getIntent().getIntExtra("catshow",0);
        String where = getIntent().getStringExtra("where");



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            final Spinner spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);
            List<String> list = new ArrayList<String>();

            list.add("All");
            list.add("Electronics");
            list.add("Books");
            list.add("Goods");

            ListView listViewlost, listViewfound;
            EventAdapter eventAdapter,eventAdapter2;





            if(getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                //list.add("2");
                rootView = inflater.inflate(R.layout.activity_main2, container, false);
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(),
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                final Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
                spinner.setAdapter(dataAdapter);
                spinner.setSelection(catshow);
                eventAdapter = new EventAdapter(this.getActivity(), R.layout.activity_chat_singlemessage);
                listViewlost = (ListView) rootView.findViewById(R.id.listViewlost);
                listViewlost.setAdapter(eventAdapter);
                int count = 0;

                ImageButton imgg = (ImageButton)rootView.findViewById(R.id.filterLost);


                int no = material.size();


                while (count < no) {
                    String b = "lost";
                    if (whatis.get(count).equals(b)){
                        Eventing eventing = new Eventing(contact.get(count), material.get(count), place.get(count), whatis.get(count), catag.get(count));
                        eventAdapter.add(eventing);

                    }
                    count++;
                }

                imgg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String choice = spinner.getSelectedItem().toString();
                        Intent intent = new Intent(getContext(),Main3Activity.class);
                        int ch=0;
                        if(choice.equals("All")){choice="0";ch=0;}
                        if(choice.equals("Electronics")){choice="1";ch=1;}
                        if(choice.equals("Books")){choice="2";ch=2;}
                        if(choice.equals("Goods")){choice="3";ch=3;}
                        intent.putExtra("catag",choice);

                        intent.putExtra("catshow",ch);
                        startActivity(intent);
                    }
                });


            }else{
                //list.add("1");
                //View rootView = inflater.inflate(R.layout.fragment_main, container, false);
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(),
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                eventAdapter2 = new EventAdapter(this.getActivity(),R.layout.activity_chat_singlemessage);
                listViewfound = (ListView)rootView.findViewById(R.id.listViewfound);
                ImageButton imgg = (ImageButton)rootView.findViewById(R.id.filterFound);


                spinner2.setAdapter(dataAdapter);
                spinner2.setSelection(catshow);
                listViewfound.setAdapter(eventAdapter2);
                int count = 0;
                int no = material.size();

                while (count < no) {
                    String b = "found";
                    if (whatis.get(count).equals(b)){
                        Eventing eventing = new Eventing(contact.get(count), material.get(count), place.get(count), whatis.get(count), catag.get(count));
                        eventAdapter2.add(eventing);

                    }

                    count++;

                }
                imgg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String choice = spinner2.getSelectedItem().toString();
                        Intent intent = new Intent(getContext(),Main3Activity.class);
                        int ch=0;
                        if(choice.equals("All")){choice="0";ch=0;}
                        if(choice.equals("Electronics")){choice="1";ch=1;}
                        if(choice.equals("Books")){choice="2";ch=2;}
                        if(choice.equals("Goods")){choice="3";ch=3;}
                        intent.putExtra("catag",choice);

                        intent.putExtra("catshow",ch);
                        startActivity(intent);
                    }
                });

            }

            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }


    }

}
