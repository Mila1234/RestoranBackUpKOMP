package com.example.marijaradisavljevic.restoran.activiry;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.actionBar.LocationFound;
import com.example.marijaradisavljevic.restoran.actionBar.SpinnerNavItem;
import com.example.marijaradisavljevic.restoran.actionBar.TitleNavigationAdapter;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/12/2016.
 */
public class ActivityGUI extends FragmentActivity implements ActionBar.OnNavigationListener{  //work with all fragments in app

    // action bar
    private ActionBar actionBar;


    // Refresh menu item
    private MenuItem refreshMenuItem;

    // Title navigation Spinner data
    private ArrayList<SpinnerNavItem> navSpinner;

    // Navigation adapter
    private TitleNavigationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getActionBar();

        // Hide the action bar title
        actionBar.setDisplayShowTitleEnabled(false);



        // Enabling Spinner dropdown navigation
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Spinner title navigation data
        navSpinner = new ArrayList<SpinnerNavItem>();
        navSpinner.add(new SpinnerNavItem("Local", R.drawable.ic_location));
        navSpinner
                .add(new SpinnerNavItem("My Places", R.drawable.ic_my_places));
        navSpinner.add(new SpinnerNavItem("Checkins", R.drawable.ic_checkin));
        navSpinner.add(new SpinnerNavItem("Latitude", R.drawable.ic_latitude));

        // title drop down adapter
        adapter = new TitleNavigationAdapter(getApplicationContext(),
                navSpinner);

        // assigning the spinner navigation
        actionBar.setListNavigationCallbacks(adapter, this);

        // Changing the action bar icon
        // actionBar.setIcon(R.drawable.ico_actionbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);


        return super.onCreateOptionsMenu(menu);
    }


    /**
     * On selecting action bar icons
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_search:
                // search action
                return true;
            case R.id.action_location_found:
                // location found
                LocationFound();
                return true;
            case R.id.action_refresh:
                // refresh
                refreshMenuItem = item;
                // load the data from server
                new SyncData().execute();
                return true;
            case R.id.action_help:
                // help action
                return true;
            case R.id.action_check_updates:
                // check for updates action
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
	 * Actionbar navigation item select listener
	 */
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        // Action to be taken after selecting a spinner item
        return false;
    }


    /**
     * Launching new activity
     * */
    private void LocationFound() {
        Intent i = new Intent(ActivityGUI.this, LocationFound.class);
        startActivity(i);
    }


    /**
     * Async task to load the data from server
     * **/
    private class SyncData extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            // set the progress bar view
            refreshMenuItem.setActionView(R.layout.action_progressbar);

            refreshMenuItem.expandActionView();
        }

        @Override
        protected String doInBackground(String... params) {
            // not making real request in this demo
            // for now we use a timer to wait for sometime
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            refreshMenuItem.collapseActionView();
            // remove the progress bar view
            refreshMenuItem.setActionView(null);
        }
    };

}
