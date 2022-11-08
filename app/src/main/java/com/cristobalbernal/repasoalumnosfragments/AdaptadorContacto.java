package com.cristobalbernal.repasoalumnosfragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorContacto extends RecyclerView.Adapter<AdaptadorContacto.AdaptadorContactoViewHoleder> {
    private final Contacto[] contactos;
    private final IClickListener listener;

    public AdaptadorContacto(Contacto[] contactos, IClickListener listener) {
        this.contactos = contactos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdaptadorContactoViewHoleder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto,parent,false);
        return new AdaptadorContactoViewHoleder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorContactoViewHoleder holder, int position) {
        Contacto contacto = contactos[position];
        holder.bindContacto(contacto);

    }

    @Override
    public int getItemCount() {
        return contactos.length;
    }


    public static class AdaptadorContactoViewHoleder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nombre;
        private final TextView phone1;
        private final IClickListener listener;

        public AdaptadorContactoViewHoleder(@NonNull View itemView, IClickListener listener) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvName);
            phone1 = itemView.findViewById(R.id.tvPhone1);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }
        public void bindContacto(Contacto contacto){
            nombre.setText(contacto.getNombre());
            phone1.setText(contacto.getPhone1());
        }
        @Override
        public void onClick(View view) {
            if (listener !=null){
                listener.onClick(getAdapterPosition());
            }
        }
    }
}
