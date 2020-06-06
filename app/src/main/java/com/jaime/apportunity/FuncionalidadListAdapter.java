package com.jaime.apportunity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FuncionalidadListAdapter extends ArrayAdapter<String> implements java.io.Serializable {
    private Context mcontext;
    int mresource;
    static ArrayList<Info> mlistWeb = new ArrayList<Info>();
    String mapp;


    public FuncionalidadListAdapter(@NonNull Context context, int resource, ArrayList<Info> listWeb, String app, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        mcontext = context;
        mresource = resource;
        mlistWeb = listWeb;
        mapp = app;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String titulo = getItem(position);


        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView = inflater.inflate(mresource, parent, false);


        final Button btnFuncionalidad = (Button) convertView.findViewById(R.id.btnFuncionalidad);
        btnFuncionalidad.setText(titulo);

        btnFuncionalidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> numeroLista = new ArrayList<Integer>();
                int variableNoRepetición = 0;
                String vs = btnFuncionalidad.getText().toString();
                if (mapp.equalsIgnoreCase("Telegram")) {

                    switch (vs) {
                        case "Instalar Telegram":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición = 1;
                            break;
                        case "Añadir Contactos":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición = 2;
                            break;
                        case "Enviar y recibir mensajes":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición = 3;
                            break;
                        case "Llamadas de voz":
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            variableNoRepetición = 4;
                            break;
                        case "Canales y grupos":
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            variableNoRepetición = 5;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Zoom")) {

                    switch (vs) {
                        case "Instalar y registrarse":
                            for (int i = 0; i <= 14; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 6;
                            break;
                        case "Empezar una reunion":
                            for (int i = 15; i <=20; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 7;
                            break;
                        case "Programar una reunion":
                            for (int i = 21; i <=32; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición = 8;

                            break;
                        case "Unirse a una reunion":

                            for (int i = 33; i <=41; i++) {
                                numeroLista.add(i);
                            }

                            variableNoRepetición = 9;
                            break;
                        case "Invitar participantes":
                            for (int i = 42; i <=50; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición =10;
                            break;
                        case "Compartir pantalla durante una reunion":
                            for (int i = 51; i <=56; i++) {
                                numeroLista.add(i);
                            }
                            variableNoRepetición =11;
                            break;

                    }
                }
                if(mapp.equalsIgnoreCase("Skype")) {
                    switch (vs) {
                        case "Descargar e instalar Skype":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=12;
                            break;
                        case "Iniciar un chat":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            variableNoRepetición=13;
                            break;
                        case "Crear un grupo":
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            variableNoRepetición=14;
                            break;
                        case "Llamar a un contacto o grupo":
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=15;
                            break;
                        case "Agregar dinero a tu cuenta":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            variableNoRepetición=16;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Google Meet")){
                    switch (vs){
                        case "Ubicar y abrir Google Meet":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            variableNoRepetición=17;
                            break;
                        case "Unirse a una reunión de Google Meet":
                            numeroLista.add(2);
                            variableNoRepetición=18;
                            break;
                        case "Navegar por la sesión de Google Meet":
                            for (int i=3;i<=12;i++){
                                numeroLista.add(i);
                            }
                            variableNoRepetición=19;
                            break;

                    }
                }
                if(mapp.equalsIgnoreCase("HBO")) {
                    switch (vs){
                        case"Obtener HBO Now a través de la aplicación HBO Now":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=20;
                            break;

                        case "Obtener HBO ahora a través de su proveedor de Internet":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=21;
                            break;

                        case "Obtener HBO ahora a través de otro servicio de streaming":
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            variableNoRepetición=22;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Netflix")){
                    switch (vs){
                        case "Registrarse en Netflix":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=23;
                            break;
                        case "Agregar un plan de DVD":
                            numeroLista.add(10);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=24;
                            break;

                    }
                }
                if(mapp.equalsIgnoreCase("Youtube")){
                    switch (vs){
                        case "Ver videos":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=25;
                            break;
                        case "Subir un video":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=26;
                            break;
                        case "Crear un canal":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=27;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Twitch")){
                    switch (vs){
                        case "Introduccion a Twitch":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=28;
                            break;
                        case "Streaming en Twitch":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            variableNoRepetición=29;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Amazon Prime Video")){
                    switch (vs){
                        case "Introduccion":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=30;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Spotify")){
                    switch (vs){
                        case "Encontrar y escuchar música":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=31;
                            break;
                        case "Usar tu biblioteca":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            variableNoRepetición=32;
                            break;
                        case "Crear y editar listas de reproducción":
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=33;
                            break;
                        case "Escuchar podcast":
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            variableNoRepetición=34;
                            break;
                        case "Actualizar a Spotify Premium":
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            variableNoRepetición=35;
                            break;
                        case "Utilizar modo ahorro de datos":
                            numeroLista.add(41);
                            numeroLista.add(42);
                            numeroLista.add(43);
                            variableNoRepetición=36;
                            break;
                        case "Usar modo sin conexión":
                            numeroLista.add(44);
                            numeroLista.add(45);
                            numeroLista.add(46);
                            numeroLista.add(47);
                            variableNoRepetición=37;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Amazon Prime Music")){
                    switch (vs){
                        case "Escuchar Amazon Prime Music en móviles":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=38;
                            break;
                        case "Escuchar Amazon Prime Music en Windows":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=39;
                            break;
                        case "Escuchar Amazon Prime Music en Mac":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            variableNoRepetición=40;
                            break;
                        case "Escuchar Amazon Prime Music en un navegador":
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=41;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Shazam")){
                    switch (vs){
                        case "Instalar Shazam":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            variableNoRepetición=42;
                            break;
                        case "Sincronizando la aplicación Shazam para 'Beat Shazam'":
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=43;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("YouTube Music")){
                    switch (vs){
                        case "Configurar YouTube Music":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            variableNoRepetición=44;
                            break;
                        case "Encontrar y poner música":
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=45;
                            break;
                        case "Creando una radio":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            variableNoRepetición=46;
                            break;
                        case "Usando la biblioteca":
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            variableNoRepetición=47;
                            break;
                    }
                }
                if(mapp.equalsIgnoreCase("Pandora")){
                    switch (vs){
                        case "Introducción":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=48;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Waze")){
                    switch (vs){
                        case "Obtener e inscribirse en Waze":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=49;
                            break;
                        case "Usando el Tablero de Waze":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=50;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Uber")){
                    switch (vs){
                        case "Instalar Uber (iPhone)":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=51;
                            break;
                        case "Instalar Uber (Android)":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=52;
                            break;
                        case "Pedir un uber":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            variableNoRepetición=53;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("LinkedIn")){
                    switch (vs){
                        case "Pulir su perfil de LinkedIn":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            variableNoRepetición=54;
                            break;
                        case "Redes e interacción con contactos":
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=55;
                            break;
                        case "Buscar trabajo":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=56;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Instagram")){
                    switch (vs){
                        case "Instalar Instagram":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=57;
                            break;
                        case "Usar las pestañas de Instagram":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=58;
                            break;
                        case "Subir fotos en Instagram":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=58;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Lyft")){
                    switch (vs){
                        case "Registrarse en Lyft":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            variableNoRepetición=59;
                            break;
                        case "Agregar un método de pago":
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=60;
                            break;
                        case "Solicitar un viaje":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=61;
                            break;
                        case "Pagar el viaje":
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=62;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Twitter")){
                    switch (vs){
                        case "Registrarse en Twitter":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=63;
                            break;
                        case "Configurando su perfil":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=64;
                            break;
                        case "Seguir usuarios":
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            variableNoRepetición=65;
                            break;
                        case "Twittear":
                            numeroLista.add(29);
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            variableNoRepetición=66;
                            break;
                        case "Retwitteando las publicaciones de otras personas":
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            numeroLista.add(41);
                            numeroLista.add(42);
                            variableNoRepetición=67;
                            break;
                        case "Enviar mensajes":
                            numeroLista.add(43);
                            numeroLista.add(44);
                            numeroLista.add(45);
                            numeroLista.add(46);
                            numeroLista.add(47);
                            numeroLista.add(48);
                            numeroLista.add(49);
                            variableNoRepetición=68;
                            break;
                        case "Usar Twitter en el móvil":
                            numeroLista.add(50);
                            numeroLista.add(51);
                            numeroLista.add(52);
                            numeroLista.add(53);
                            numeroLista.add(54);
                            numeroLista.add(55);
                            numeroLista.add(56);
                            numeroLista.add(57);
                            numeroLista.add(58);
                            variableNoRepetición=69;
                            break;
                    }
                }
                if (mapp.equalsIgnoreCase("Wish")){
                    switch (vs){
                        case "Creando una cuenta":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            variableNoRepetición=70;
                            break;
                        case "Hacer un pedido":
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            variableNoRepetición=71;
                            break;
                        case "Seguimiento de su pedido":
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            variableNoRepetición=72;
                            break;
                        case "Crear una lista de pedidos":
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            variableNoRepetición=73;
                            break;
                        case "Agregar elementos a la lista de deseos":
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            variableNoRepetición=74;
                            break;
                        case "Administrar la lista de deseos":
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            variableNoRepetición=75;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Alibaba")){
                    switch (vs){
                        case "Buscando productos":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            variableNoRepetición=76;
                            break;
                        case "Comunicación con proveedores":
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=77;
                            break;
                        case "Completando una transacción segura":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            variableNoRepetición=78;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Ebay")){
                    switch (vs){
                        case "Encontrar el artículo correcto":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            variableNoRepetición=79;
                            break;
                        case "Pujar por el artículo":
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=80;
                            break;
                        case "Completando la transacción":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            variableNoRepetición=81;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Amazon")){
                    switch (vs){
                        case "Creando una cuenta":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=82;
                            break;
                        case "Usar la barra de búsqueda":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            variableNoRepetición=83;
                            break;
                        case "Navegación por categoría":
                            numeroLista.add(10);
                            numeroLista.add(11);
                            numeroLista.add(12);
                            variableNoRepetición=84;
                            break;
                        case "Seleccionar un artículo":
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            variableNoRepetición=85;
                            break;
                        case "Completando su pedido":
                            numeroLista.add(16);
                            numeroLista.add(17);
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            variableNoRepetición=86;
                            break;
                        case "Configuración de pedidos con 1 click":
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=87;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Facebook")){
                    switch (vs){
                        case "Introducción":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=88;
                            break;
                        case "Añadir amigos":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=89;
                            break;
                        case "Subir publicaciones desde el ordenador":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=90;
                            break;
                        case "Subir publicaciones desde el móvil":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            variableNoRepetición=91;
                            break;
                        case "Subir fotos y videos desde el ordenador":
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            variableNoRepetición=92;
                            break;
                        case "Subir fotos y videos desde el móvil":
                            numeroLista.add(30);
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            variableNoRepetición=93;
                            break;

                    }
                }
                if (mapp.equalsIgnoreCase("Google Maps")){
                    switch (vs){
                        case "Obtener direcciones":
                            numeroLista.add(0);
                            numeroLista.add(1);
                            numeroLista.add(2);
                            numeroLista.add(3);
                            numeroLista.add(4);
                            numeroLista.add(5);
                            variableNoRepetición=94;
                            break;
                        case "Agregar paradas adicionales":
                            numeroLista.add(6);
                            numeroLista.add(7);
                            numeroLista.add(8);
                            numeroLista.add(9);
                            numeroLista.add(10);
                            numeroLista.add(11);
                            variableNoRepetición=95;
                            break;
                        case "Evitar peajes, autopistas y ferries":
                            numeroLista.add(12);
                            numeroLista.add(13);
                            numeroLista.add(14);
                            numeroLista.add(15);
                            numeroLista.add(16);
                            numeroLista.add(17);
                            variableNoRepetición=96;
                            break;
                        case "Compartir ubicaciones y direcciones":
                            numeroLista.add(18);
                            numeroLista.add(19);
                            numeroLista.add(20);
                            numeroLista.add(21);
                            numeroLista.add(22);
                            numeroLista.add(23);
                            numeroLista.add(24);
                            numeroLista.add(25);
                            numeroLista.add(26);
                            variableNoRepetición=97;
                            break;
                        case "Encontrar negocios locales y atracciones":
                            numeroLista.add(27);
                            numeroLista.add(28);
                            numeroLista.add(29);
                            numeroLista.add(30);
                            variableNoRepetición=98;
                            break;
                        case "Cambio de tipos de mapas":
                            numeroLista.add(31);
                            numeroLista.add(32);
                            numeroLista.add(33);
                            numeroLista.add(34);
                            variableNoRepetición=99;
                            break;
                        case "Usar Street View":
                            numeroLista.add(35);
                            numeroLista.add(36);
                            numeroLista.add(37);
                            numeroLista.add(38);
                            numeroLista.add(39);
                            numeroLista.add(40);
                            numeroLista.add(41);
                            numeroLista.add(42);
                            variableNoRepetición=100;
                            break;

                    }
                }
                Intent intent = new Intent(mcontext, SlideFuncionalidades.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("numerosLista", numeroLista);
                intent.putExtra("infoLista", mlistWeb);
                intent.putExtra("numeroVariable", variableNoRepetición);
                intent.putExtra("app", mapp);
                v.getContext().startActivity(intent);
            }


        });
        return convertView;
    }


}
