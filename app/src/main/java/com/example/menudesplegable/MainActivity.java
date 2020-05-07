package com.example.menudesplegable;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
{

    private AppBarConfiguration mAppBarConfiguration;
    private NavigationView navView; // items
    private FrameLayout frameLayout; // ventana principal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_acerca, R.id.nav_circulo, R.id.nav_combinacion, R.id.nav_puntos,
                R.id.nav_lineales, R.id.nav_pitagoras, R.id.nav_rectangulos, R.id.nav_rombo, R.id.nav_seg_grado)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navView = findViewById(R.id.nav_view);
        frameLayout = findViewById(R.id.nav_host_fragment);


        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.removeAllViews();
                Fragment Co = new Ayuda();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, Co).commit();
                fab.hide();
            }
        });
        // Cambiar ventanas
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
                    {
                        boolean fragmentTrans = false;
                        Fragment frag = null;

                        switch (menuItem.getItemId())
                        {
                            case R.id.nav_seg_grado:
                                frag = new segundo_grado();
                                fragmentTrans = true;
                                break;
                            case R.id.nav_lineales:
                                frag = new ec_lineales();
                                fragmentTrans = true;
                                break;
                            case R.id.nav_pitagoras:
                                frag = new pitagoras();
                                fragmentTrans = true;
                                break;
                            case R.id.nav_puntos:
                                frag = new distancia();
                                fragmentTrans = true;
                                break;
                            case R.id.nav_combinacion:
                                frag = new combinacion();
                                fragmentTrans = true;
                                break;
                            case R.id.nav_rectangulos:
                                frag = new rectangulo();
                                fragmentTrans = true;
                                break;
                            case R.id.nav_rombo:
                                frag = new rombo();
                                fragmentTrans = true;
                                break;
                            case R.id.nav_circulo:
                                frag = new circulo();
                                fragmentTrans = true;
                                break;
                            case R.id.nav_acerca:
                                frag = new acerca();
                                fragmentTrans = true;
                                break;
                        }

                        if(fragmentTrans)
                        {
                            frameLayout.removeAllViews();
                            fab.show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, frag).commit();
                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }

                        return true;
                    }
                }
        );
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
