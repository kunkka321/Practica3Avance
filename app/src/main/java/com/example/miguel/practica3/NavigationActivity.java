package com.example.miguel.practica3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


/**
 * Created by sodm on 6/23/2017.
 */

public class NavigationActivity extends AppCompatActivity {



    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private boolean mDrawerOpened = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                if (item.getItemId() == R.id.equipos){
                    FragmentManager fMan = getSupportFragmentManager();
                    FragmentTransaction ft = fMan.beginTransaction();
                    ft.replace(R.id.flaContenido,new Fragment_Equipos());
                    ft.addToBackStack(null);
                    ft.commit();
                }else if (item.getItemId() == R.id.tablaPosiciones){
                    FragmentManager fMan = getSupportFragmentManager();
                    FragmentTransaction ft = fMan.beginTransaction();
                    ft.replace(R.id.flaContenido,new Fragment_Posiciones());
                    ft.addToBackStack(null);
                    ft.commit();
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });



}

}