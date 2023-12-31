package com.example.newsapp;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout; //for referring tab items like home,sports, health etc.
    TabItem mhome, msports, mhealth, mscience, mentertainment, mtechnology;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String api ="5795efa4fac74d6ab70cb70058ed8336";
        //connecting the toolbar through id
        mtoolbar = findViewById(R.id.toolbar);
        //write the use of setSupportActionBar here?
        setSupportActionBar(mtoolbar);
        //connecting all fragments with the help of their respective Id's
        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sports);
        mhealth = findViewById(R.id.health);
        mscience = findViewById(R.id.science);
        mentertainment = findViewById(R.id.entertainment);
        mtechnology = findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.fragmentContainer);
        tabLayout = findViewById(R.id.include);
        /*creating a new instance of PagerAdapter class and passing 2 arguments
        * to parameterized constructor named PagerAdapter see PagerAdapter class.
        * what is Fragment manager? write here
        * this 6 is number of Fragments we are passing.*/
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);

        //write the use of setAdapter here
        viewPager.setAdapter(pagerAdapter);

        /*If someone wants to directly click on a specific tab like-->
        * sports or technology then we have to add click listener for that*/
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() ==0 ||tab.getPosition() ==2|| tab.getPosition()==3 ||
                        tab.getPosition() ==4 || tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        /* This code is written if in case someone wants to swipe to the next tab */
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}