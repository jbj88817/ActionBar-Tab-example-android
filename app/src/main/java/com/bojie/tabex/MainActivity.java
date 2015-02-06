package com.bojie.tabex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity
        implements android.support.v7.app.ActionBar.TabListener {

    Fragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the Action Bar to use tabs for navigation
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);

        mFragments = new Fragment[3];

        mFragments[0] = new TabFragment1();
        mFragments[1] = new TabFragment2();
        mFragments[2] = new TabFragment3();

        // Add three tabs to the Action Bar for display
        ab.addTab(ab.newTab().setText("Tab 1").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 2").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 3").setTabListener(this));

    }
    // Implemented from ActionBar.TabListener
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        fragmentTransaction.replace(R.id.fragmentContainer, mFragments[tab.getPosition()]);
    }

    // Implemented from ActionBar.TabListener
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // This is called when a previously selected tab is unselected.
        fragmentTransaction.remove(mFragments[tab.getPosition()]);
    }

    // Implemented from ActionBar.TabListener
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // This is called when a previously selected tab is selected again.
    }
}