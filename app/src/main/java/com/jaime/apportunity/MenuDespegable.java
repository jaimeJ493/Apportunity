package com.jaime.apportunity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MenuDespegable extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private SwitchCompat switcher;
    NavigationView navigationView;
    String[] title;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    int[] icon;
    ListView listView;
    ListaBuscadorAdapter adapter;
    int count = 0;
    Context context;
    Window window;
    Button btn_share;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        configurarApp(); //Llamamos al metodo para ver las preferencias del usuario guardadas y configurar la app en base a estas
        ponerColorModo(); //Llamamos al metodo para poner el tema de la app oscuro/claro

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.window = getWindow();
        context = getApplicationContext();

        Toolbar toolbar = findViewById(R.id.toolbar);


        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        color= navigationView.getItemTextColor().getDefaultColor();
        Menu myMenu = navigationView.getMenu();
        MenuItem tools= myMenu.findItem(R.id.ajustess);
        SpannableString s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.color.blanco), 0, s.length(), 0);
        tools.setTitle(s);
        navigationView.setNavigationItemSelectedListener(this);


        MenuItem menuItem = myMenu.findItem(R.id.dark_mode_switch);
        View actionView = MenuItemCompat.getActionView(menuItem);

        switcher = (SwitchCompat) actionView.findViewById(R.id.switcher);
        if (count > 0) {
            switcher.setChecked(true);
        } else {
            switcher.setChecked(false);
        }

        /* Si el switch esta marcado el modo de la app pasa a oscuro y se guarda en la variable activo "si",
           en caso contrario el modo pasa a claro y la variable a "no" */
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switcher.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferences sharpref = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharpref.edit();
                    editor.putString("activo", "si");
                    editor.commit();

                    restartApp();

                }
                if (!switcher.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferences sharpref = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharpref.edit();
                    editor.putString("activo", "no");
                    editor.commit();
                    restartApp();
                }
            }
        });


        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toogle.getDrawerArrowDrawable().setColor(color);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AppsCategoriasFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_menu);



    }

    //cargamos la pantalla que se haya pinchado en el menu despegable
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AppsCategoriasFragment()).commit();
                break;
            case R.id.nav_Bot:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatBotFragment()).commit();
                break;
            case R.id.nav_share:
                compartirApp();//saca un menu a eleccion del usuario para elegir por que red social comparte la url en playstore  de nuestra app
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void configurarApp() {
        SharedPreferences sharpref = getPreferences(MODE_PRIVATE);
        if (sharpref.getString("activo", "no hay dato").equalsIgnoreCase("si")) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void ponerColorModo() {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
            count++;
        } else setTheme(R.style.AppTheme);
    }


    private void compartirApp() {

        Intent compartir = new Intent(android.content.Intent.ACTION_SEND);
        compartir.setType("text/plain");
        compartir.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
        String app_url = "-----------------------------";//url de la app en playstore
        compartir.putExtra(android.content.Intent.EXTRA_TEXT, app_url);
        startActivity(Intent.createChooser(compartir, "Share via"));
    }


    //Abre el menu despegable
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
        super.onBackPressed();

    }

    //Reinicia la app para poder cambiar configuraciones
    private void restartApp() {
        Intent i = new Intent(getApplicationContext(), MenuDespegable.class);
        startActivity(i);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);




        return true;
    }

    //Abrimos el buscador en otro intent(ListaBuscador)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Intent i = new Intent(context, ListaBuscador.class);
            startActivityForResult(i, 0);
        }
        return super.onOptionsItemSelected(item);
    }


}
