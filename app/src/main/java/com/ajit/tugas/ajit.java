package com.ajit.tugas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.ajit.tugas.R.id;

public class ajit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajit);

        Intent E = getIntent();
        String email = getIntent().getStringExtra("email");
        String agama = getIntent().getStringExtra("agama");
        String pasword= getIntent().getStringExtra( "pass");
        String ttgl= getIntent().getStringExtra( "ttgl");
        String alamat= getIntent().getStringExtra( "alamat");
        String kode= getIntent().getStringExtra( "pos");
        String phone =getIntent().getStringExtra("phon");
        String jk =getIntent().getStringExtra("jeniskelamin");
        //giv data to textView
                TextView em =(TextView) findViewById(R.id.nama1);
        em.setText(email);
                TextView pass =(TextView) findViewById(R.id.nama2);
        pass.setText(pasword);
                TextView alt =(TextView) findViewById(R.id.nama3);
        alt.setText(alamat);
                TextView phon =(TextView) findViewById(R.id.nama4);
        phon.setText(phone);
                 TextView ttg =(TextView) findViewById(id.nama5);
        ttg.setText(ttgl);
                TextView pos =(TextView) findViewById(id.nama6);
        pos.setText(kode);
                TextView agam =(TextView) findViewById(id.nama7);
        agam.setText(agama);
                TextView jenis =(TextView) findViewById(id.nama8);
        jenis.setText(jk);
    }
}
