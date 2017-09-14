package starwars.app.starwarsse;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import starwars.app.starwarsse.fragments.PlanetsFragment;
import starwars.app.starwarsse.fragments.PeopleFragment;
import starwars.app.starwarsse.fragments.ShipsFragment;
import starwars.app.starwarsse.fragments.SpeciesFragment;
import starwars.app.starwarsse.fragments.VehiclesFragment;


public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        setActionBarTitle("People");
        fm.beginTransaction().replace(R.id.contentFrame, new PeopleFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_people) {
            setActionBarTitle("People");
            fm.beginTransaction().replace(R.id.contentFrame, new PeopleFragment()).commit();
        } else if (id == R.id.nav_planets) {
            setActionBarTitle("Planets");
            fm.beginTransaction().replace(R.id.contentFrame, new PlanetsFragment()).commit();
        } else if (id == R.id.nav_ships) {
            setActionBarTitle("Starships");
            fm.beginTransaction().replace(R.id.contentFrame, new ShipsFragment()).commit();
        } else if (id == R.id.nav_species) {
            setActionBarTitle("Species");
            fm.beginTransaction().replace(R.id.contentFrame, new SpeciesFragment()).commit();
        } else if (id == R.id.nav_vehicles) {
            setActionBarTitle("Vehicles");
            fm.beginTransaction().replace(R.id.contentFrame, new VehiclesFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }


}

