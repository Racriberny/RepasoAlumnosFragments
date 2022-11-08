package com.cristobalbernal.repasoalumnosfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

import android.content.Intent;
import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements IClickListener, FragmentOnAttachListener {
    private FragmentListado frgListado;
    private FragmentDetalle frgDetalle;
    private boolean tabletLayout;
    private Contacto[] contactos;
    private Contacto selectedContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabletLayout = findViewById(R.id.FrgDetalle) !=null;
        ParseJSON parseJSON = new ParseJSON(this);
        try {
            if (parseJSON.parse()){
                this.contactos = parseJSON.getContactos();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.FrgListado,FragmentListado.class,null)
                .commit();
        manager.addFragmentOnAttachListener(this);


    }

    public MainActivity(){
        super(R.layout.activity_main);
        frgListado = null;
        frgDetalle = null;
        tabletLayout = false;
    }
    /*
    private void loadData(){
        ParseJSON parser = new ParseJSON(this);
        try {
            if(parser.parse()) {
                this.contactos = parser.getContactos();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable("hola",contactos);
        outState.putSerializable("adios",selectedContacto);
        super.onSaveInstanceState(outState);
    }

     */

    @Override
    public void onClick(int id) {
        /*
        Contacto contacto = contactos[id];
        if(tabletLayout) {
            frgDetalle.mostrarDetalle(contacto);
        } else {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.FrgListado,FragmentDetalle.class,null)
                    .commit();
        }

         */

        Contacto contacto = contactos[id];
        if (tabletLayout) {
            frgDetalle.mostrarDetalle(contacto);
        } else {
            Intent i = new Intent(this,DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, contacto);
            startActivity(i);
        }
    }

    @Override
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        if (fragment.getId() == R.id.FrgListado) {
            frgListado = (FragmentListado) fragment;
            frgListado.setContactosListener(contactos,this);
            if (tabletLayout) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(FragmentDetalle.EXTRA_CONTACTO, (Serializable) contactos[0]);
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.FrgDetalle, FragmentDetalle.class, bundle)
                        .commit();
            }
        }
        if (fragment.getId() == R.id.FrgDetalle) {
            frgDetalle = (FragmentDetalle) fragment;
        }
    }

    /*
    @Override
    public Contacto[] getContactos() {
        if (contactos == null){
            loadData();
        }
        return contactos;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setTitle("RecyclerViewContactos");
    }

     */
}