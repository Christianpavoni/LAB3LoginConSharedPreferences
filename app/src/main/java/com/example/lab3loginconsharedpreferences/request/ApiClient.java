package com.example.lab3loginconsharedpreferences.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.lab3loginconsharedpreferences.model.Usuario;

public class ApiClient {
    public static SharedPreferences sp;

    public static SharedPreferences conectar(Context context){
        if(sp==null){
            sp=context.getSharedPreferences("datos",0);
        }
        return sp;
    }

    public static boolean guardar (Context context, Usuario usuario){

        SharedPreferences sp=conectar(context);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("dni",usuario.getDni());
        editor.putString("nombre",usuario.getNombre());
        editor.putString("apellido",usuario.getApellido());
        editor.putString("email",usuario.getEmail());
        editor.putString("password",usuario.getPassword());
        boolean res=editor.commit();

        return res;

    }

    public static Usuario leer (Context context){

        SharedPreferences sp=conectar(context);
        String dni=sp.getString("dni","");
        String nombre=sp.getString("nombre","");
        String apellido=sp.getString("apellido","");
        String email=sp.getString("email","");
        String password=sp.getString("password","");

        Usuario usuario=new Usuario(dni,nombre,apellido,email,password);

        return usuario;

    }

    public static Usuario login(Context context,String email,String password){

        Usuario usuario=leer(context);

        if(email.equals(usuario.getEmail()) && password.equals(usuario.getPassword()) && !email.equals("") &&  !password.equals("")){
            return usuario;
        }
        else{
            return null;
        }

    }
}
