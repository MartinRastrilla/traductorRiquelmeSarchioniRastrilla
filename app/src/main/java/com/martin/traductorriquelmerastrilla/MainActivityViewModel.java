package com.martin.traductorriquelmerastrilla;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private List<Palabra> palabras;
    private MutableLiveData<String> mMensaje;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public void cargarLista() {
        palabras = new ArrayList<>();
        palabras.add(new Palabra("Manzana","Apple", R.drawable.manzana));
        palabras.add(new Palabra("Naranja","Orange",R.drawable.naranja));
        palabras.add(new Palabra("Pera","Pear",R.drawable.pera));
        palabras.add(new Palabra("Frutilla","Strawberry",R.drawable.fresa));
    }


    public LiveData<String> getmMensaje() {

        if (mMensaje==null){
            mMensaje=new MutableLiveData<>();
        }

        return mMensaje;
    }

    public void traducirPalabra(String palabra) {
        if (palabras!=null){
            for(Palabra item:palabras){
                if (item.getPalabraEsp().equals(palabra)){
                    Intent intent = new Intent(getApplication(), TraductorActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("palabra", item);
                    intent.putExtra("palabra", bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    getApplication().startActivity(intent);
                }else{
                    mMensaje.setValue("No conocemos esa palabra");
                }
            }
        }
    }
}
