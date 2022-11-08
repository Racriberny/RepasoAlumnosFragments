package com.cristobalbernal.repasoalumnosfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentListado extends Fragment {
    private Contacto[] contactos;
    IClickListener listener;
    /*
    public interface IOnAttachListener{
        Contacto[] getContactos();
    }

     */


    public FragmentListado(){
        super(R.layout.fragment_listado);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rVListado = view.findViewById(R.id.rVListado);
        rVListado.setAdapter(new AdaptadorContacto(contactos,listener));
        rVListado.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }
    public void setContactosListener(Contacto[] contactos, IClickListener listener){
        this.contactos= contactos;
        this.listener = listener;
    }
    /*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IClickListener) context;
        IOnAttachListener attachListener = (IOnAttachListener) context;
        contactos = attachListener.getContactos();
    }

     */
}
