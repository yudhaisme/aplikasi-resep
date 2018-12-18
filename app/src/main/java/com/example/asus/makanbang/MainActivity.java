package com.example.asus.makanbang;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    //mendeklarasikan variable global dengan tipe akses Private
    private ImageView ayambakar, bakso, nasgor, nasigudeg, rendang;
    Button button;

    private static final String strAyambakar = "Ayam Bakar";
    private static final String strBakso = "Bakso";
    private static final String strNasgor = "Nasi Goreng";
    private static final String strNasigudeg = "Nasi Gudeg";
    private static final String strRendang = "Rendang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mendeklarasikan id tiap View
        ayambakar = (ImageView)findViewById(R.id.ayambakar);
        bakso = (ImageView)findViewById(R.id.bakso);
        nasgor = (ImageView)findViewById(R.id.nasgor);
        nasigudeg = (ImageView)findViewById(R.id.nasigudeg);
        rendang = (ImageView)findViewById(R.id.rendang);

        //memberikan tombol aksi pada tiap Gambar
        ayambakar.setOnClickListener(this);
        bakso.setOnClickListener(this);
        nasgor.setOnClickListener(this);
        nasigudeg.setOnClickListener(this);
        rendang.setOnClickListener(this);

        //memberikan tombol aksi pada tiap Button
        Button button_about = (Button)findViewById(R.id.button_about);
        Button button_exit = (Button)findViewById(R.id.button_exit);
        Button button_me = (Button)findViewById(R.id.about_me);
        button_about.setOnClickListener(this);
        button_exit.setOnClickListener(this);
        button_me.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.ayambakar:
                i = new Intent(MainActivity.this, WebActivity.class);
                i.putExtra("ayambakar_key", strAyambakar);
                startActivity(i);
                break;
            case R.id.bakso:
                i = new Intent(MainActivity.this, WebActivity.class);
                i.putExtra("bakso_key", strBakso);
                startActivity(i);
                break;
            case R.id.nasgor:
                i = new Intent(MainActivity.this, WebActivity.class);
                i.putExtra("nasgor_key", strNasgor);
                startActivity(i);
                break;
            case R.id.nasigudeg:
                i = new Intent(MainActivity.this, WebActivity.class);
                i.putExtra("nasigudeg_key", strNasigudeg);
                startActivity(i);
                break;
            case R.id.rendang:
                i = new Intent(MainActivity.this, WebActivity.class);
                i.putExtra("rendang_key", strRendang);
                startActivity(i);
                break;

            case R.id.button_about:
                AlertDialog.Builder info = new AlertDialog.Builder(MainActivity.this);
                info.setMessage("Dibuat oleh Asdi Prayudha Rahadi\n\n2017").setCancelable(false).setPositiveButton("Lanjut", new AlertDialog.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                    }

                });
                AlertDialog dialog=info.create();
                dialog.setTitle("Tentang Aplikasi");
                dialog.show();
                TextView text=(TextView)dialog.findViewById(android.R.id.message);
                text.setTextSize(15);
                break;

            case R.id.button_exit:
                AlertDialog.Builder keluar = new AlertDialog.Builder(MainActivity.this);
                keluar.setMessage("Anda tampan?").setCancelable(false).setPositiveButton("Ya", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1){
                        finish();
                        System.exit(0);
                    }
                }).setNegativeButton("Tidak", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface dialog, int arg1){
                        dialog.cancel();
                    }
                });
                AlertDialog dialog1 = keluar.create();
                dialog1.setTitle("Keluar");
                dialog1.show();
                break;

            case R.id.about_me:
                i = new Intent(MainActivity.this, AboutMe.class);
                startActivity(i);
                break;

        }
    }
}
