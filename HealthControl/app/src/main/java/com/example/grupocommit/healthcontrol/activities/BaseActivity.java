package com.example.grupocommit.healthcontrol.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.grupocommit.healthcontrol.R;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    //private CardView batCard;
    protected DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //batCard = (CardView) findViewById(R.id.cardBat);
        //batCard.setOnClickListener(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.perfil){
            Intent perfil = new Intent(this, ProfileActivity.class);
            startActivity(perfil);
        }else if(id == R.id.emergencia){
            Toast.makeText(this, "Em breve!", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.device){
            Intent device = new Intent(this, DeviceActivity.class);
        }else if(id == R.id.familiares){
            Intent familiares = new Intent(this, FamiliarActivity.class);
            startActivity(familiares);
        }else if(id == R.id.premium){
            Intent premium = new Intent(this, PremiumActivity.class);
            startActivity(premium);
        }else if(id == R.id.config){

        }

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.perfil){
            Intent perfil = new Intent(this, ProfileActivity.class);
            startActivity(perfil);
        }else if(id == R.id.emergencia){
            Toast.makeText(this, "Em breve!", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.device){
            Intent device = new Intent(this, DeviceActivity.class);
            startActivity(device);
        }else if(id == R.id.familiares){
            Intent familiares = new Intent(this, FamiliarActivity.class);
            startActivity(familiares);
        }else if(id == R.id.premium){
            Intent premium = new Intent(this, PremiumActivity.class);
            startActivity(premium);
        }else if(id == R.id.config){
            Intent features = new Intent(this, FeaturesActivity.class);
            startActivity(features);
        }


        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onClick(View v) {
       // Intent batCardiaco = new Intent(this, BatCardActivity.class);
       // startActivity(batCardiaco);
    }
}
