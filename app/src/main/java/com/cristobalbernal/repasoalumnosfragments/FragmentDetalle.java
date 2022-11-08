package com.cristobalbernal.repasoalumnosfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetalle extends Fragment {
    public static final String EXTRA_CONTACTO = "Esto_es_un_extra_texto.EXTRA_CONTACTO";
    private TextView tvName;
    private TextView tvSurnames;
    private TextView tvBirth;
    private TextView tvCompany;
    private TextView tvAddress;
    private TextView tvPhone1;
    private TextView tvPhone2;
    private TextView tvEmail;
    private StringBuilder sb;
    private Contacto contacto;

    public FragmentDetalle(){
        super(R.layout.fragment_detalle);
        sb = new StringBuilder();
        contacto = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() !=null){
            contacto = (Contacto) getArguments().getSerializable(EXTRA_CONTACTO);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName = view.findViewById(R.id.tVNombreDato);
        tvSurnames = view.findViewById(R.id.tVApellidosDato);
        tvBirth = view.findViewById(R.id.tVCumple);
        tvCompany = view.findViewById(R.id.tVEmpresaDato);
        tvAddress = view.findViewById(R.id.tVDireccionDato);
        tvPhone1 = view.findViewById(R.id.tVTelefonoDato);
        tvPhone2 = view.findViewById(R.id.tVTelefono2Dato);
        tvEmail = view.findViewById(R.id.tvEmailDato);
        if (contacto !=null){
            mostrarDetalle(contacto);
        }

    }

    public void mostrarDetalle(Contacto contacto) {
        tvName.setText(contacto.getNombre());
        sb.setLength(0);
        sb.append(contacto.getNombre()).append(" ").append(contacto.getPrimerApellido());
        tvSurnames.setText(sb.toString());
        tvBirth.setText(contacto.getFecha_nacimiento());
        tvCompany.setText(contacto.getEmpresa());
        tvAddress.setText(contacto.getDireccion());
        tvPhone1.setText(contacto.getPhone1());
        tvPhone2.setText(contacto.getPhone2());
        tvEmail.setText(contacto.getEmail());
    }
}
