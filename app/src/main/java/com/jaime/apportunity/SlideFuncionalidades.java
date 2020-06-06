package com.jaime.apportunity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SlideFuncionalidades extends AppCompatActivity implements java.io.Serializable {
    public static ViewPager slideViewPager;
    static LinearLayout slideDoots;
    static SlideFuncionalidadesAdapter sliderFuncionalidadesAdapter;
    private static TextView[] mDots;
    private static int currentPage;
    static ArrayList<String> slide_Images = new ArrayList<String>();
    static ArrayList<String> slide_description = new ArrayList<String>();
    private static Button mNextBtn;
    private static Button mBackBtn;
    static Context mcontext;
    static int color;
    static int colorAcento;
    TextView coloresTxt;
    ListView listView;
    int count = 0;
    int variableNoRepetiticion;
    int variableComparacion;
    static ArrayList<String> listInfoTraducida = new ArrayList<String>();
    static ArrayList<Info> lista_info_Saliente = new ArrayList<Info>();
    static ArrayList<Integer> numerosSacarInfo = new ArrayList<Integer>();//Para saber que informacion cargar segun la funcionalidad
    static ArrayList<String> lista_info_Traducir = new ArrayList<String>();
    static String app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ponerColorModo(); //Llamamos al metodo para poner el tema de la app oscuro/claro

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_funcionalidades);

        // Inicializamos variables
        mcontext = getApplicationContext();
        slideViewPager = (ViewPager) findViewById(R.id.slide_ViewPager);
        slideDoots = (LinearLayout) findViewById(R.id.Doots);
        mNextBtn = (Button) findViewById(R.id.next_btn);
        mBackBtn = (Button) findViewById(R.id.previus_btn);
        coloresTxt = (TextView) findViewById(R.id.colores_txt);


        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(mNextBtn.getCurrentTextColor(), PorterDuff.Mode.SRC_ATOP);

        Toolbar toolbar = findViewById(R.id.toolbarSecciones);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Estas variable nos sirve para poder cambiar el color a los puntos ya que al ser html no podemos meterles directamente el color del tema(claro/oscuro)
        colorAcento = coloresTxt.getCurrentTextColor();
        color = mNextBtn.getCurrentTextColor();


        //OnclickListner
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage + 1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage - 1);
            }
        });

        numerosSacarInfo = (ArrayList<Integer>) getIntent().getExtras().getIntegerArrayList("numerosLista");
        variableNoRepetiticion = (int) getIntent().getExtras().getInt("numeroVariable");
        lista_info_Saliente = (ArrayList<Info>) getIntent().getSerializableExtra("infoLista");
        app = (String) getIntent().getExtras().getString("app");

        if (slide_description.size() == numerosSacarInfo.size() && variableNoRepetiticion == variableComparacion) {
            cargarDirecto();
            variableComparacion = variableNoRepetiticion;
        } else {
            lista_info_Traducir.clear();
            listInfoTraducida.clear();
            slide_description.clear();
            slide_Images.clear();
            cargar();
            variableComparacion = variableNoRepetiticion;
        }

    }


    //SEGUIR AQUI
    public static void cargar() {


        if(app.equalsIgnoreCase("Facebook")){

            ArrayList<String>listaVariable= new ArrayList<>();

            for (int i = 0; i < numerosSacarInfo.size(); i++) {
                int num = numerosSacarInfo.get(i);
                slide_description.add(arreglos(lista_info_Saliente.get(num).pasos));
                slide_Images.add(lista_info_Saliente.get(num).imagen);
            }
            sliderFuncionalidadesAdapter = new SlideFuncionalidadesAdapter(mcontext, slide_Images, slide_description);
            slideViewPager.setAdapter(sliderFuncionalidadesAdapter);
            addDootsIndicator(0);

            slideViewPager.addOnPageChangeListener(viewListner);

        }
        else{
            for (int i = 0; i < numerosSacarInfo.size(); i++) {
                int num = numerosSacarInfo.get(i);
                String textoSinArreglar = lista_info_Saliente.get(num).pasos;
                String textoArreglado = arreglos(textoSinArreglar);
                lista_info_Traducir.add(textoArreglado);

            }

            Traducir.textoTraducido(lista_info_Traducir);

        }



    }

    static public void probar() {

        ArrayList<String> listaFinal = listInfoTraducida;
        //cambiar para coger la iamgenes que necesita y las traducciones que necesita
        for (int i = 0; i < numerosSacarInfo.size(); i++) {
            int num = numerosSacarInfo.get(i);
            String arreglosTraduccion=arreglosDespuesTraducir(listaFinal.get(i));
            slide_Images.add(lista_info_Saliente.get(num).imagen);
            slide_description.add(arreglosTraduccion);
        }


        sliderFuncionalidadesAdapter = new SlideFuncionalidadesAdapter(mcontext, slide_Images, slide_description);
        slideViewPager.setAdapter(sliderFuncionalidadesAdapter);
        addDootsIndicator(0);

        slideViewPager.addOnPageChangeListener(viewListner);


    }

    public static void cargarDirecto() {

        sliderFuncionalidadesAdapter = new SlideFuncionalidadesAdapter(mcontext, slide_Images, slide_description);
        slideViewPager.setAdapter(sliderFuncionalidadesAdapter);
        addDootsIndicator(0);

        slideViewPager.addOnPageChangeListener(viewListner);
    }


    //Arreglos del texto antes de traducir
    static public String arreglos(String textoSinArreglar) {
        String textoArregladoConFinal = null;
        String textoArregladoSinFinal = null;

        //Quitar [numeros] y Quitar recusros de busqueda
        for (int i = 1; i < 25; i++) {
            String pruebaIngles = "[" + i + "] X Research source";
            String pruebaEspañol = "[" + i + "] X Fuente de investigación";
            int j = textoSinArreglar.indexOf(pruebaIngles);
            int a = textoSinArreglar.indexOf(pruebaEspañol);
            if (j != -1 || a!=-1) {
                String textoSinFinales = textoSinArreglar.substring(0, textoSinArreglar.length() - 1).substring(0, textoSinArreglar.length() - 2).substring(0, textoSinArreglar.length() - 3).substring(0, textoSinArreglar.length() - 4).substring(0, textoSinArreglar.length() - 5).substring(0, textoSinArreglar.length() - 6);//Sirve para elimnar \n \n finales para que solga otro punto mas
                textoArregladoConFinal = textoSinFinales.replace(pruebaEspañol, "").replace(pruebaIngles, "").replace("  ", " ").replace("\n \n \n", "\n \n").replace("\n \n", "\n \n" + Html.fromHtml("&#8226;")).replace(Html.fromHtml("&#8226;")+"",Html.fromHtml("&#8226;")+" ").replace(Html.fromHtml("&#8226;")+"  ",Html.fromHtml("&#8226;")+" ");

                break;
            } else {

                String textoSinFinales = textoSinArreglar.substring(0, textoSinArreglar.length() - 1).substring(0, textoSinArreglar.length() - 2).substring(0, textoSinArreglar.length() - 3).substring(0, textoSinArreglar.length() - 4);//Sirve para elimnar \n \n finales para que solga otro punto mas

                textoArregladoConFinal = textoSinFinales.replace(pruebaEspañol, "").replace(pruebaIngles, "").replace("  ", " ").replace("\n \n \n", "\n \n").replace("\n \n", "\n \n" + Html.fromHtml("&#8226;")).replace(Html.fromHtml("&#8226;")+"",Html.fromHtml("&#8226;")+" ").replace(Html.fromHtml("&#8226;")+"  ",Html.fromHtml("&#8226;")+" ");

            }



        }
        return textoArregladoConFinal;
    }

    //Arreglos del texto antes de traducir
    static public String arreglosDespuesTraducir(String textoSinArreglar) {
        String textoArreglado = null;
        if(app.equals("Telegram")){
          textoArreglado=textoSinArreglar.replace("telegram","Telegram").replace("Telegramas", "Telegram").replace("Telegrams", "Telegram").replace("de ronda", "redondo").replace("haya", "este").replace("abierto",
                  "'Abrir'").replace("Instalar","'Instalar'").replace("lanzar","iniciar").replace("Buscar","'Buscar'").replace("Tyquear Telegram","Escriba 'Telegram'").replace("Telegrame Messenger","'Telegram Messenger'").replace("útil","a mano el movil").replace("A continuación,es posible","A continuación,").replace("Escriba Telegrama","Escriba 'Telegram'").replace("Telegrama","Telegram");
        }
        else{
            textoArreglado=textoSinArreglar;
        }

        return textoArreglado;
    }


    private void ponerColorModo() {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);
            count++;
        } else setTheme(R.style.AppTheme);
    }

    // Este metodo nos sirve para crear y resaltar el color de los puntos segun en que pagina estemos
    static public void addDootsIndicator(int position) {
        mDots = new TextView[slide_Images.size()];
        slideDoots.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(mcontext);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(color);
            slideDoots.addView(mDots[i]);

        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(colorAcento);
        }
    }

    static ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {

        }

        // Ponemos y cambiamos entre Next, Back ,""
        @Override
        public void onPageSelected(int position) {
            addDootsIndicator(position);
            currentPage = position;

            if (position == 0) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("");

            } else if (position == mDots.length - 1) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Finish");
                mBackBtn.setText("Back");
            } else {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    // Ponemos el toolbar con buscador que tienen todas la clases
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_search) {
            Intent i = new Intent(mcontext, ListaBuscador.class);
            startActivityForResult(i, 0);
        }
        return super.onOptionsItemSelected(item);
    }


    static public ArrayList<String> listaTraducida(ArrayList<String> listaEntrante) {

        listInfoTraducida = listaEntrante;
        return listInfoTraducida;
    }
}
