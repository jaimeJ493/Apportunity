package com.jaime.apportunity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppsCategoriasFragment extends Fragment implements View.OnClickListener {
    CardView cardComu, cardMusica, cardNavega, cardEntre, cardSocial, cardCompras;//carviews
    Context mcontext;
    Intent intent;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    View rootView;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_apps, container, false);

        // Inicializamos todas las variables y las hacemos clickeables
        mcontext = getActivity().getApplicationContext();
        intent = new Intent(mcontext, Secciones.class);

        cardComu = (CardView) rootView.findViewById(R.id.cd_comu);
        cardMusica = (CardView) rootView.findViewById(R.id.cd_musica);
        cardNavega = (CardView) rootView.findViewById(R.id.cd_navegacion);
        cardEntre = (CardView) rootView.findViewById(R.id.cd_entre);
        cardSocial = (CardView) rootView.findViewById(R.id.cd_social);
        cardCompras = (CardView) rootView.findViewById(R.id.cd_compras);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerviewTopApps);

        cardComu.setOnClickListener(this);
        cardMusica.setOnClickListener(this);
        cardNavega.setOnClickListener(this);
        cardEntre.setOnClickListener(this);
        cardSocial.setOnClickListener(this);
        cardCompras.setOnClickListener(this);
        initImageHitmaps();
        return rootView;
    }


    /*----------------------------------------Arrays inicializadores------------------------------------------*/

    //Arrays Comunicacion

    public int[] slide_Images = {
            R.drawable.whatsapp,
            R.drawable.zoom,
            R.drawable.telegram,
            R.drawable.skype,
            R.drawable.googlemeet
    };
    public String[] slide_headings = {
            "WhatsApp",
            "Zoom",
            "Telegram",
            "Skype",
            "Google Meet",
    };

    public String[] slide_description = {
            "WhatsApp es una aplicación de chat para teléfonos móviles.Permite el envío de mensajes de texto, fotos y vídeos a través de sus usuarios. " +
                    "Su funcionamiento es idéntico al de los programas de mensajería instantánea para ordenador más comunes.",

            "Zoom Video Communications es una herramienta de videoconferencias. ... El programa Zoom no solamente ofrece llamadas a través de video sino" +
                    " además permite escribir mensajes al mismo tiempo y compartir cualquier archivo con los demás usuarios.",

            "Telegram es un servicio de mensajería instantáneo que se utiliza, fundamentalmente, para mantener conversaciones " +
                    "de persona a persona o en grupo. Al igual que en WhatsApp se pueden enviar mensajes por texto, audio e incluso realizar videollamadas",

            "Skype es una aplicación o programa que puedes instalar en tu computador, ordenador o teléfono móvil para comunicarte con personas de cualquier" +
                    " parte del mundo por medio de llamadas, video conferencias y mensajería instantánea.",

            "Google Meet es la nueva versión orientada a los negocios de Hangouts de Google utilizada para videoconferencias. Google Meet se puede utilizar para empresas de cualquier tamaño, ya sea para el " +
                    "trabajo o la escuela, y permite a los usuarios hacer videollamadas con hasta 30 personas diferentes."
    };


    public String[] slide_url = {
            "https://play.google.com/store/apps/details?id=com.whatsapp",
            "https://play.google.com/store/apps/details?id=us.zoom.videomeetings",
            "https://play.google.com/store/apps/details?id=org.telegram.messenger",
            "https://play.google.com/store/apps/details?id=com.skype.raider",
            "https://play.google.com/store/apps/details?id=com.google.android.apps.meetings&gl=ES"
    };

    //Arrays Entretenimiento


    public int[] slide_Images_e = {
            R.drawable.youtube,
            R.drawable.twitch,
            R.drawable.netflix,
            R.drawable.hbo,
            R.drawable.primevideo

    };
    public String[] slide_headings_e = {
            "Youtube",
            "Twitch",
            "Netflix",
            "HBO",
            "Amazon Prime Video"
    };

    public String[] slide_description_e = {
            "YouTube es una plataforma a través de la que reproducir vídeos, subir contenido a " +
                    "un canal propio e interactuar con el resto de usuarios mediante likes, comentarios o ‘compartir’.",

            "Twitch es una plataforma que ofrece un servicio de Streaming de video en vivo propiedad de Amazon, Inc., " +
                    "siendo una de sus principales funciones la retransmisión de videojuegos en directo.",

            "Netflix Es un servicio de transmisión o 'streaming' que permite ver una gran variedad de series, " +
                    "documentales y películas en cualquier dispositivo con acceso a internet como celulares, computadoras, tabletas o 'smart tv' mediante el pago de una tarifa fija mensual.",


            "HBO es una plataforma de streaming que te permite ver las series y películas exclusivas de HBO en cualquier dispositivo con internet. De esta manera, lo único que tienes que hacer es pagar una suscripción mensual" +
                    " para tener acceso a todo el catálogo de películas de la compañía.",

            "Siendo miembro de Amazon Prime tienes acceso gratis a Prime Video. Se trata del servicio de streaming de series y películas de Amazon, que cuenta con su propio contenido exclusivo de Amazon Originals así como un" +
                    " interesante catálogo de series y películas. Es como Netflix, pero te viene incluido en tu suscripción."
    };
    public String[] slide_url_e = {
            "https://play.google.com/store/apps/details?id=com.google.android.youtube&gl=ES",
            "https://play.google.com/store/apps/details?id=tv.twitch.android.app&gl=ES",
            "https://play.google.com/store/apps/details?id=com.netflix.mediaclient&gl=ES",
            "https://play.google.com/store/apps/details?id=com.hbo.android.app&gl=ES",
            "https://play.google.com/store/apps/details?id=com.amazon.avod.thirdpartyclient&gl=ES"
    };

    //Arrays Social

    public int[] slide_Images_s = {
            R.drawable.instagram,
            R.drawable.facebook,
            R.drawable.snapchat,
            R.drawable.twitter,
            R.drawable.linkedin
    };
    public String[] slide_headings_s = {
            "Instagram",
            "Facebook",
            "Snapchat",
            "Twitter",
            "LinkedIn"
    };

    public String[] slide_description_s = {
            "Instagram es una red social y una aplicación móvil al mismo tiempo. Ésta permite a sus usuarios subir imágenes y " +
                    "vídeos con múltiples efectos fotográficos como filtros, marcos, colores retro, etc. para posteriormente compartir esas imágenes en la misma plataforma o en otras redes sociales.",

            "Facebook es una red social que conecta personas con personas. Cuando abres una cuenta en Facebook, entras en una red social que conecta a amigos, familiares y socios de negocios.",

            "Snapchat permite añadir contactos y enviarles mensajes en forma de fotos o vídeos de forma individual o a " +
                    "grupos. La principal diferencia es que tú seleccionas el tiempo que el receptor podrá ver ese mensaje (de 1 a 10 segundos) antes de que se destruya.",

            "Twitter permite enviar mensajes cortos para decirle al mundo lo que estás haciendo, pensando, leyendo, o cualquier otra cosa que quieras comunicar. Puedes también " +
                    "incluir y enviar fotos, vídeos y cualquier enlace a un post de un blog, una página web, etc. El servicio te permite seguir y ser seguido por otros usuarios.",

            "LinkedIn es una red social profesional, es decir, está orientada más a relaciones comerciales y profesionales que a relaciones personales y por tanto en esta red social" +
                    " lo que encontrarás son empresas y profesionales que buscan promocionarse, hacer networking y negocio"
    };
    public String[] slide_url_s = {
            "https://play.google.com/store/apps/details?id=com.instagram.android&gl=ES",
            "https://play.google.com/store/search?q=facebook&c=apps&gl=ES",
            "https://play.google.com/store/apps/details?id=com.snapchat.android&gl=ES",
            "https://play.google.com/store/apps/details?id=com.twitter.android&gl=ES",
            "https://play.google.com/store/apps/details?id=com.linkedin.android&gl=ES"
    };

    //Arrays Musica

    public int[] slide_Images_m = {
            R.drawable.spotify,
            R.drawable.amazonmusic,
            R.drawable.youtubemusic,
            R.drawable.shazam,
            R.drawable.pandora
    };
    public String[] slide_headings_m = {
            "Spotify",
            "Amazon Prime Music",
            "Youtube Music",
            "Shazam",
            "Pandora"
    };

    public String[] slide_description_m = {
            "Spotify es un servicio de música, podcasts y vídeos digitales en streaming que te da acceso" +
                    "a millones de canciones y otros contenidos de artistas de todo el mundo.",

            "Amazon Prime Music es el servicio de música de Amazon, con la suscripción a Amazon Prime " +
                    "se permite el acceso a más de 2 millones de canciones y más de mil playlists Emisoras programadas por expertos en música de Amazon sin tener que pagar coste adicional alguno.",

            "YouTube Music es un servicio de transmisión de música desarrollado por YouTube; proporciona una interfaz personalizada para el servicio orientado" +
                    " a la transmisión de música, lo que permite a los usuarios explorar videos musicales en YouTube según los géneros, las listas de reproducción y las recomendaciones.",

            "Shazam es un servicio musical disponible para el móvil que tiene una funcionalidad muy concreta, la de reconocer canciones con solo escucharla unos segundos, es decir, Shazam es capaz de saber que canción está sonando en cualquier momento.",

            "Pandora es una aplicación músical, cuyo propósito es capturar la esencia de la música en su nivel más fundamental." +
                    " Puede ofrecer emisoras de radio personalizadas a través de Internet: el usuario sugiere el nombre de una canción y la página genera una estación de radio con una lista de música parecida a la que se solicitó en la consulta"
    };
    public String[] slide_url_m = {
            "https://play.google.com/store/apps/details?id=com.spotify.music",
            "https://play.google.com/store/apps/details?id=com.amazon.mp3",
            "https://play.google.com/store/apps/details?id=com.google.android.apps.youtube.music",
            "https://play.google.com/store/apps/details?id=com.shazam.android",
            "https://play.google.com/store/apps/details?id=com.pandora.android"
    };
    //Arrays Navegacion

    public int[] slide_Images_n = {
            R.drawable.waze,
            R.drawable.uber,
            R.drawable.lyft,
            R.drawable.googlemaps
    };
    public String[] slide_headings_n = {
            "Waze",
            "Uber",
            "Lyft",
            "Google Maps"
    };

    public String[] slide_description_n = {
            "Waze es una app de navegación perfecta para el automóvil, la cual te informa sobre tráfico, obras, policia, accidentes y mucho más en tiempo real." +
                    " Si el tráfico es malo en tu ruta, Waze la cambiará para ahorrarte tiempo.",

            "Con Uber, tienes tu destino al alcance de la mano. Solo tienes que abrir la app, indicar dónde quieres ir y un conductor que esté cerca te llevará hasta allí de forma segura. También puedes alquilar patinetes y bicis JUMP." +
                    "Llega a tu destino prácticamente desde cualquier lugar."
            ,

            "¿Necesitas que te lleven a un lugar? Usa Lyft para llegar a tu destino de manera económica en solo minutos. En lugar de esperar un taxi o el autobús, pide que te recoja un coche con tan solo tocar un botón." +
                    " Un conductor amigable cerca de ti vendrá a buscarte y te llevará a tu destino de inmediato. Disfruta hoy mismo de un viaje cálido, económico y digno de recordar.",

            "Navega por el mundo de manera más fácil y rápida con Google Maps. Hay mapas de más de 220 países y territorios con millones de empresas y lugares señalados." +
                    " Consigue información sobre el tráfico y el transporte público y navega con GPS en tiempo real."

    };
    public String[] slide_url_n = {
            "https://play.google.com/store/apps/details?id=com.waze",
            "https://play.google.com/store/apps/details?id=com.ubercab",
            "https://play.google.com/store/apps/details?id=me.lyft.android",
            "https://play.google.com/store/apps/details?id=com.google.android.apps.maps"
    };

    //Arrays Compras

    public int[] slide_Images_c = {
            R.drawable.wish,
            R.drawable.amazon,
            R.drawable.ebay,
            R.drawable.alibaba
    };
    public String[] slide_headings_c = {
            "Wish",
            "Amazon",
            "Ebay",
            "Alibaba"
    };

    public String[] slide_description_c = {
            "Más de 200 millones de personas usan Wish para conseguir productos de tendencia a un 50-80% menos de lo que pagarías en tu centro comercial. Únete y consigue los mejores productos a precios increíbles, entregados directamente en tu puerta.",

            "Amazon es una de las mayores compañías de comercio electónico del mundo, donde permite a los usuarios buscar," +
                    " comparar precios, leer opiniones y realizar pedidos." +
                    "Tiene su propia aplicación que permite al cliente escanear códigos de barras para conseguir información inmediata sobre el precio y la disponibilidad de los productos",

            "Ebay es un sitio destinado a la subasta y comercio electrónico de productos a través de Internet." +
                    " El vendedor pone un precio de salida y una duración determinada para el anuncio y mientras dure ese período de tiempo, los compradores pujarán por ella.",

            "Alibaba es un consorcio privado chino que posee 18 subsidiarias con sede en Hangzhou dedicado al comercio electrónico en Internet," +
                    " incluyendo portales de ventas business-to-business, de venta al por menor, y de venta entre consumidores; también ofrece servicios de pago en línea."


    };
    public String[] slide_url_c = {
            "https://play.google.com/store/apps/details?id=com.contextlogic.wish",
            "https://play.google.com/store/apps/details?id=com.amazon.mShop.android.shopping",
            "https://play.google.com/store/apps/details?id=com.ebay.mobile",
            "https://play.google.com/store/apps/details?id=com.alibaba.intl.android.apps.poseidon"
    };

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cd_comu:
                Cambiar_Secciones_Comu();
                break;
            case R.id.cd_entre:
                Cambiar_Secciones_entre();
                break;
            case R.id.cd_social:
                Cambiar_Secciones_social();
                break;
            case R.id.cd_musica:
                Cambiar_Secciones_musica();
                break;
            case R.id.cd_navegacion:
                Cambiar_Secciones_navegacion();
                break;
            case R.id.cd_compras:
                Cambiar_Secciones_compras();
                break;

        }
    }

    private void Cambiar_Secciones_compras() {

        intent.putExtra("listaImagenes", slide_Images_c);
        intent.putExtra("listaHeaders", slide_headings_c);
        intent.putExtra("listaDescripciones", slide_description_c);
        intent.putExtra("listaUrls", slide_url_c);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_navegacion() {

        intent.putExtra("listaImagenes", slide_Images_n);
        intent.putExtra("listaHeaders", slide_headings_n);
        intent.putExtra("listaDescripciones", slide_description_n);
        intent.putExtra("listaUrls", slide_url_n);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_musica() {

        intent.putExtra("listaImagenes", slide_Images_m);
        intent.putExtra("listaHeaders", slide_headings_m);
        intent.putExtra("listaDescripciones", slide_description_m);
        intent.putExtra("listaUrls", slide_url_m);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_Comu() {

        intent.putExtra("listaImagenes", slide_Images);
        intent.putExtra("listaHeaders", slide_headings);
        intent.putExtra("listaDescripciones", slide_description);
        intent.putExtra("listaUrls", slide_url);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_entre() {

        intent.putExtra("listaImagenes", slide_Images_e);
        intent.putExtra("listaHeaders", slide_headings_e);
        intent.putExtra("listaDescripciones", slide_description_e);
        intent.putExtra("listaUrls", slide_url_e);

        startActivityForResult(intent, 0);
    }

    private void Cambiar_Secciones_social() {

        intent.putExtra("listaImagenes", slide_Images_s);
        intent.putExtra("listaHeaders", slide_headings_s);
        intent.putExtra("listaDescripciones", slide_description_s);
        intent.putExtra("listaUrls", slide_url_s);

        startActivityForResult(intent, 0);
    }

    private void initImageHitmaps() {
        mImageUrls.add(R.drawable.instagram);
        mNames.add("Instagram");
        mImageUrls.add(R.drawable.whatsapp);
        mNames.add("WhatsApp");
        mImageUrls.add(R.drawable.skype);
        mNames.add("Skype");
        mImageUrls.add(R.drawable.netflix);
        mNames.add("Netflix");
        mImageUrls.add(R.drawable.telegram);
        mNames.add("Twitter");
        initRecyclerView();
    }

    private void initRecyclerView() {

   /*   String orientacion = getRotation(mcontext);
        if (orientacion.equalsIgnoreCase("vertical")) {
            layoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL, false);

        } else if (orientacion.equalsIgnoreCase("horizontal")) {
            layoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.VERTICAL, false);

        }
*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterTopApps adapterTopApps = new RecyclerViewAdapterTopApps(mNames, mImageUrls, mcontext);
        recyclerView.setAdapter(adapterTopApps);
        recyclerView.setHasFixedSize(true);
    }

    /*
    public String getRotation(Context context) {
        final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
        switch (rotation) {
            case Surface.ROTATION_0:
            case Surface.ROTATION_180:
                return "vertical";
            case Surface.ROTATION_90:
            default:
                return "horizontal";
        }
    }

     */
}
