package com.example.appchamada.activity.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.example.appchamada.PageAdapter.ChamadaPageAdapter;
import com.example.appchamada.R;
import com.example.appchamada.activity.Aula.CadastroAula;
import com.example.appchamada.activity.login.LoginActivity;
import com.example.appchamada.adapter.AdapterChamadaLista;
import com.example.appchamada.adapter.AdapterChamadas;
import com.example.appchamada.aluno.ListaAlunoChamada;
import com.example.appchamada.chamada.FragmentChamadaCode;
import com.example.appchamada.chamada.FragmentFindChamada;
import com.example.appchamada.chamada.FragmentNewChamada;
import com.example.appchamada.model.Aluno;
import com.example.appchamada.model.Chamada;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public static ViewPager viewPager;
    public TabLayout tabLayout;
    FragmentManager fragmentManager = getSupportFragmentManager();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(HomeActivity.this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        setTitle("Inicio");

       Fragment newFragment = new FragmentChamadaCode();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.content_frame, newFragment);
        transaction.addToBackStack(null);


        transaction.commit();










    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.nav_item_one: {
                    Intent intent= new Intent(HomeActivity.this, ListaAlunoChamada.class);
                    startActivity(intent);
                    break;
                }

                case  R.id.nav_item_two: {
                    Fragment newFragment = new FragmentFindChamada();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();


                }

                case R.id.nav_item_three: {

                    break;
                }

                case R.id.nav_item_loggout: {
                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                    break;
                }

                default: {

                    break;
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        Fragment fragment = fragmentManager.findFragmentById(R.id.content_frame);
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            if (fragment instanceof FragmentChamadaCode) {
                setTitle("Inicio");
            }
        }
    }
}
