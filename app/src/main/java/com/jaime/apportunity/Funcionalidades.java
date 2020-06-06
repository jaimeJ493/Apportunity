package com.jaime.apportunity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Funcionalidades extends AppCompatActivity {
    TextView text;
    static ListView listView;
    static ArrayList<Info> listWeb = new ArrayList<Info>();
    static ArrayList<Info> lista_info_Saliente = new ArrayList<Info>();
    static ArrayList<String> lista_funcion = new ArrayList<String>();
    static Context mcontext;
    static String app;
    WebScrapping.Llamada llamada;
    String url = null;
    String url1 = null;
    ArrayList<String> urls = new ArrayList<>();
    static ArrayList<String> urlFuncionalidades = new ArrayList<>();
    ArrayList<String> lista_funcionalidades = new ArrayList<>();
    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionalidades);

        app = (String) getIntent().getSerializableExtra("App");
        text = (TextView) findViewById(R.id.txt);
        listView = (ListView) findViewById(R.id.listview);
        mcontext = getApplicationContext();
        text.setText(app);

        //Cogemos la url segun la app y se la pasamos al webscrapping


        url = getUrl(app);


        lista_funcion = listaFuncionalidades(app);//añadimos la funcionalidades de los botones
        WebScrapping.setUrl_howToUse(url);
        //Lamada la metodo asincrono para sacar la info de la url
        llamada = new WebScrapping.Llamada(getApplicationContext());
        llamada.execute();


    }


    public ArrayList<String> listaFuncionalidades(String app) {


        switch (app) {
            case "WhatsApp":
                url = "";

                break;
            case "Zoom":
                lista_funcionalidades.add("Instalar y registrarse");
                lista_funcionalidades.add("Empezar una reunion");
                lista_funcionalidades.add("Programar una reunion");
                lista_funcionalidades.add("Unirse a una reunion");
                lista_funcionalidades.add("Invitar participantes");
                lista_funcionalidades.add("Compartir pantalla durante una reunion");
                break;

            case "Telegram":
                lista_funcionalidades.add("Instalar Telegram");
                lista_funcionalidades.add("Añadir Contactos");
                lista_funcionalidades.add("Enviar y recibir mensajes");
                lista_funcionalidades.add("Llamadas de voz");
                lista_funcionalidades.add("Canales y grupos");
                break;

            case "Skype":
                lista_funcionalidades.add("Descargar e instalar Skype");
                lista_funcionalidades.add("Iniciar un chat");
                lista_funcionalidades.add("Crear un grupo");
                lista_funcionalidades.add("Llamar a un contacto o grupo");
                lista_funcionalidades.add("Agregar dinero a tu cuenta");
                break;
            case "Google Meet":
                lista_funcionalidades.add("Ubicar y abrir Google Meet");
                lista_funcionalidades.add("Unirse a una reunión de Google Meet");
                lista_funcionalidades.add("Navegar por la sesión de Google Meet");
                break;
            case "HBO":
                lista_funcionalidades.add("Obtener HBO Now a través de la aplicación HBO Now");
                lista_funcionalidades.add("Obtener HBO ahora a través de su proveedor de Internet");
                lista_funcionalidades.add("Obtener HBO ahora a través de otro servicio de streaming");
                break;
            case "Netflix":
                lista_funcionalidades.add("Registrarse en Netflix");
                lista_funcionalidades.add("Agregar un plan de DVD");
                break;
            case "Youtube":
                lista_funcionalidades.add("Ver videos");
                lista_funcionalidades.add("Subir un video");
                lista_funcionalidades.add("Crear un canal");

                break;
            case "Twitch":
                lista_funcionalidades.add("Introduccion a Twitch");
                lista_funcionalidades.add("Streaming en Twitch");
                break;
            case "Amazon Prime Video":
                lista_funcionalidades.add("Introduccion");
                break;
            case "Spotify":
                lista_funcionalidades.add("Encontrar y escuchar música");
                lista_funcionalidades.add("Usar tu biblioteca");
                lista_funcionalidades.add("Crear y editar listas de reproducción");
                lista_funcionalidades.add("Escuchar podcast");
                lista_funcionalidades.add("Actualizar a Spotify Premium");
                lista_funcionalidades.add("Utilizar modo ahorro de datos");
                lista_funcionalidades.add("Usar modo sin conexión");
                break;
            case "Amazon Prime Music":
                lista_funcionalidades.add("Escuchar Amazon Prime Music en móviles");
                lista_funcionalidades.add("Escuchar Amazon Prime Music en Windows");
                lista_funcionalidades.add("Escuchar Amazon Prime Music en Mac");
                lista_funcionalidades.add("Escuchar Amazon Prime Music en un navegador");
                break;
            case "Shazam":
                lista_funcionalidades.add("Instalar Shazam");
                lista_funcionalidades.add("Sincronizando la aplicación Shazam para 'Beat Shazam'");
                break;
            case "YouTube Music":
                lista_funcionalidades.add("Configurar YouTube Music");
                lista_funcionalidades.add("Encontrar y poner música");
                lista_funcionalidades.add("Creando una radio");
                lista_funcionalidades.add("Usando la biblioteca");
                break;
            case "Pandora":
                lista_funcionalidades.add("Introducción");
                break;
            case "Waze":
                lista_funcionalidades.add("Obtener e inscribirse en Waze");
                lista_funcionalidades.add("Usando el Tablero de Waze");
                break;
            case "Uber":
                lista_funcionalidades.add("Instalar Uber (iPhone)");
                lista_funcionalidades.add("Instalar Uber (Android)");
                lista_funcionalidades.add("Pedir un uber");
                break;
            case "LinkedIn":
                lista_funcionalidades.add("Pulir su perfil de LinkedIn");
                lista_funcionalidades.add("Redes e interacción con contactos");
                lista_funcionalidades.add("Buscar trabajo");
                break;
            case "Instagram":
                lista_funcionalidades.add("Instalar Instagram");
                lista_funcionalidades.add("Usar las pestañas de Instagram");
                lista_funcionalidades.add("Subir fotos en Instagram");
                break;
            case "Lyft":
                lista_funcionalidades.add("Registrarse en Lyft");
                lista_funcionalidades.add("Agregar un método de pago");
                lista_funcionalidades.add("Solicitar un viaje");
                lista_funcionalidades.add("Pagar el viaje");
                break;
            case "Twitter":
                lista_funcionalidades.add("Registrarse en Twitter");
                lista_funcionalidades.add("Configurando su perfil");
                lista_funcionalidades.add("Seguir usuarios");
                lista_funcionalidades.add("Twittear");
                lista_funcionalidades.add("Retwitteando las publicaciones de otras personas");
                lista_funcionalidades.add("Enviar mensajes");
                lista_funcionalidades.add("Usar Twitter en el móvil");
                break;
            case "Wish":
                lista_funcionalidades.add("Creando una cuenta");
                lista_funcionalidades.add("Hacer un pedido");
                lista_funcionalidades.add("Seguimiento de su pedido");
                lista_funcionalidades.add("Crear una lista de pedidos");
                lista_funcionalidades.add("Agregar elementos a la lista de deseos");
                lista_funcionalidades.add("Administrar la lista de deseos");
                break;
            case "Alibaba":
                lista_funcionalidades.add("Buscando productos");
                lista_funcionalidades.add("Comunicación con proveedores");
                lista_funcionalidades.add("Completando una transacción segura");
                break;
            case "Ebay":
                lista_funcionalidades.add("Encontrar el artículo correcto");
                lista_funcionalidades.add("Pujar por el artículo");
                lista_funcionalidades.add("Completando la transacción");
                break;
            case "Amazon":
                lista_funcionalidades.add("Creando una cuenta");
                lista_funcionalidades.add("Usar la barra de búsqueda");
                lista_funcionalidades.add("Navegación por categoría");
                lista_funcionalidades.add("Seleccionar un artículo");
                lista_funcionalidades.add("Completando su pedido");
                lista_funcionalidades.add("Configuración de pedidos con 1 click");
                break;
            case "Facebook":
                lista_funcionalidades.add("Introducción");
                lista_funcionalidades.add("Añadir amigos");
                lista_funcionalidades.add("Subir publicaciones desde el ordenador");
                lista_funcionalidades.add("Subir publicaciones desde el móvil");
                lista_funcionalidades.add("Subir fotos y videos desde el ordenador");
                lista_funcionalidades.add("Subir fotos y videos desde el móvil");
                break;
            case "Google Maps":
                lista_funcionalidades.add("Obtener direcciones");
                lista_funcionalidades.add("Agregar paradas adicionales");
                lista_funcionalidades.add("Evitar peajes, autopistas y ferries");
                lista_funcionalidades.add("Compartir ubicaciones y direcciones");
                lista_funcionalidades.add("Encontrar negocios locales y atracciones");
                lista_funcionalidades.add("Cambio de tipos de mapas");
                lista_funcionalidades.add("Usar Street View");
                break;


        }
        return lista_funcionalidades;
    }

    public String getUrl(String app) {

        switch (app) {
            case "WhatsApp":
                url = "";
                break;

            case "Zoom":
                url = "https://www.wikihow.com/Use-the-Zoom-App";
                break;

            case "Telegram":
                url = "https://www.wikihow.com/Use-Telegram";
                break;

            case "Skype":
                url = "https://www.wikihow.com/Skype";
                break;

            case "Google Meet":
                url = "https://www.wikihow.com/Use-Google-Meet";
                break;

            case "HBO":
                url = "https://www.wikihow.com/Get-HBO-Now";
                break;

            case "Netflix":
                url = "https://www.wikihow.com/Get-Netflix";
                break;
            case "Youtube":
                url = "https://www.wikihow.tech/Use-YouTube";
                break;
            case "Twitch":
                url = "https://www.wikihow.com/Use-Twitch-on-Android";
                break;
            case "Amazon Prime Video":
                url = "https://www.wikihow.com/Watch-Amazon-Prime-on-Android";
                break;
            case "Amazon Prime Music":
                url = "https://www.wikihow.com/Listen-to-Amazon-Prime-Music";
                break;
            case "Shazam":
                url = "https://www.wikihow.com/Play-Beat-Shazam-on-Android";
                break;
            case "YouTube Music":
                url = "https://www.wikihow.com/Use-YouTube-Music-on-Android";
                break;
            case "Pandora":
                url = "https://www.wikihow.com/Use-Pandora-on-Android";
                break;
            case "Waze":
                url = "https://www.wikihow.com/Navigate-the-Dashboard-on-Waze";
                break;
            case "Uber":
                url = "https://www.wikihow.com/Download-and-Use-the-Uber-App";
                break;
            case "LinkedIn":
                url = "https://www.wikihow.com/Use-LinkedIn-to-Find-a-Job";
                break;
            case "Instagram":
                url = "https://www.wikihow.com/Use-Instagram";
                break;
            case "Lyft":
                url = "https://www.wikihow.com/Use-Lyft";
                break;
            case "Twitter":
                url = "https://www.wikihow.com/Use-Twitter";
                break;
            case "Wish":
                url = "https://www.wikihow.com/Use-the-Wish-Shopping-Made-Fun-App-on-Android";
                break;
            case "Alibaba":
                url = "https://www.wikihow.com/Buy-from-Alibaba";
                break;
            case "Ebay":
                url = "https://www.wikihow.com/Buy-on-eBay";
                break;
            case "Amazon":
                url = "https://www.wikihow.com/Buy-on-Amazon";
                break;
            case "Google Maps":
                url = "https://www.wikihow.com/Use-Google-Maps";
                break;
            case "Facebook":
                url = "https://es.wikihow.com/usar-Facebook";
                break;


        }


        return url;
    }

    //Recibe la lista con la info dle webscrapping
    static public ArrayList<Info> list(ArrayList<Info> listaEntrante) {

        listWeb=listaEntrante;
        return listWeb;
    }

    public static void cargar() {


        listView.setDivider(null);
        listView.setDividerHeight(0);
        FuncionalidadListAdapter adapter = new FuncionalidadListAdapter(mcontext, R.layout.adapter_view_layout, listWeb, app, lista_funcion);
        listView.setAdapter(adapter);


    }


}
