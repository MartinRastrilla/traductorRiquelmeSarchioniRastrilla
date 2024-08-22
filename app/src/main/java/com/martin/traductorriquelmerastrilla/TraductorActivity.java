package com.martin.traductorriquelmerastrilla;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.martin.traductorriquelmerastrilla.databinding.ActivityTraductorBinding;

public class TraductorActivity extends AppCompatActivity {

    private TraductorActivityViewModel mv;
    private ActivityTraductorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imagen = findViewById(R.id.imgView);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraductorActivityViewModel.class);
        binding = ActivityTraductorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv.getMutablePalabra().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.etPalabraEng.setText(palabra.getPalabraEng());
                binding.imgView.setImageResource(palabra.getImg());
            }
        });
        mv.obtenerTraduccion(getIntent());
    }
}