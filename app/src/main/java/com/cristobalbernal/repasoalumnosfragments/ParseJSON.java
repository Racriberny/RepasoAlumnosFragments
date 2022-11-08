package com.cristobalbernal.repasoalumnosfragments;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class ParseJSON {
    private Contacto[] contactos;
    private final InputStream archivosContacto;

    public ParseJSON(Context context){
        this.archivosContacto = context.getResources().openRawResource(R.raw.contacts);
    }

    public boolean parse() throws IOException, JSONException {
        boolean parsed;
        contactos = null;
        String json;
        int size = archivosContacto.available();
        byte[] buffer = new byte[size];
        archivosContacto.read(buffer);
        archivosContacto.close();
        json = new String(buffer,"UTF-8");
        JSONTokener tokener = new JSONTokener(json);
        JSONArray array = new JSONArray(tokener);
        contactos = new Contacto[array.length()];
        for (int i = 0; i <array.length() ; i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            int id  = jsonObject.getInt("id");
            String nombre = jsonObject.getString("name");
            String firstSurname = jsonObject.getString("firstSurname");
            String secondSurname = jsonObject.getString("secondSurname");
            String birth = jsonObject.getString("birth");
            String company = jsonObject.getString("company");
            String email = jsonObject.getString("email");
            String phone1 = jsonObject.getString("phone1");
            String phone2 = jsonObject.getString("phone2");
            String address = jsonObject.getString("address");
            contactos[i] = new Contacto(id,nombre,firstSurname,secondSurname,address,company,birth,phone1,phone2,email);
        }
        parsed = true;
        return parsed;
    }

    public Contacto[] getContactos() {
        return this.contactos;
    }
}
