package com.jaimefuentesp.tarearecyclerview;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.jaimefuentesp.tarearecyclerview.adapter.MascotaAdaptador;
import com.jaimefuentesp.tarearecyclerview.adapter.PageAdapter;
import com.jaimefuentesp.tarearecyclerview.fragment.FragmentoInicio;
import com.jaimefuentesp.tarearecyclerview.fragment.FragmentoMascota;
import com.jaimefuentesp.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //agregarFloatingButton();

        toolBar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        if (toolBar!=null) {
            setSupportActionBar(toolBar);
        }

    }

    private ArrayList<Fragment> agregarFragments () {
        ArrayList<Fragment> fragmentos = new ArrayList<>();
        fragmentos.add(new FragmentoInicio());
        fragmentos.add(new FragmentoMascota());
        return fragmentos;
    }

    private void setUpViewPager () {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_dog);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.itemFavotito:
                Intent intent = new Intent(this,ActivityFavoritos.class);
                startActivity(intent);
                break;
            case R.id.itemContacto:
                Intent intentContacto = new Intent(this,ActivityContacto.class);
                startActivity(intentContacto);
                break;
            case R.id.itemAcercaDe:
                Intent intentAQbout = new Intent(this,ActivityAbout.class);
                startActivity(intentAQbout);
                break;
        }
        return true;
    }

}