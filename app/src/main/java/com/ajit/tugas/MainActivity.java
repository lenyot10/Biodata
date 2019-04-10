package com.ajit.tugas;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    EditText pasword, email, phone, alamat, editpass, editUser;
    Button loginBtn;
    RadioGroup RGJK;
    RadioButton RBJK;
    private Spinner agama;
    private DatePicker datePicker;
    private Calendar calendar;
    private DatePickerDialog ttgl;
    private SimpleDateFormat dataFormat;
    private TextView dateView;
    private int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agama = (Spinner) findViewById(R.id.agama);
        loginBtn = (Button) findViewById(R.id.login);
        editUser = (EditText) findViewById(R.id.email);
        editpass = (EditText) findViewById(R.id.passw);


        dateView = (TextView) findViewById(R.id.ttgl);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);


        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

       /* agama =(Spinner)findViewById(R.id.agama);
        email = (EditText) findViewById(R.id.email);
        pasword = (EditText) findViewById(R.id.passw);
        login = (Button) findViewById(R.id.login);
        tggll = (EditText) findViewById(R.id.ttgl);
        alamat = (EditText) findViewById(R.id.alamat);
        phone = (EditText) findViewById(R.id.phone);
    */


    public void sendExtra(View view) {
        Spinner agam = (Spinner) findViewById(R.id.agama);
        String agama = agam.getSelectedItem().toString();
        EditText em = (EditText) findViewById(R.id.email);
        String email = em.getText().toString();
        EditText pass = (EditText) findViewById(R.id.passw);
        String pasword = pass.getText().toString();
        EditText ttg = (EditText) findViewById(R.id.ttgl);
        String ttgl = ttg.getText().toString();
        EditText alt = (EditText) findViewById(R.id.alamat);
        String alamat = alt.getText().toString();
        EditText phon = (EditText) findViewById(R.id.phone);
        String phone = phon.getText().toString();
        EditText kode = (EditText) findViewById(R.id.pos);
        String pos = kode.getText().toString();
        RGJK = (RadioGroup) findViewById(R.id.JK);
        RBJK = (RadioButton) findViewById(RGJK.getCheckedRadioButtonId());
        String jk = RBJK.getText().toString();
        Intent intent = new Intent(this, ajit.class);
        intent.putExtra("email", email);
        intent.putExtra("pass", pasword);
        intent.putExtra("ttgl", ttgl);
        intent.putExtra("alamat", alamat);
        intent.putExtra("phon", phone);
        intent.putExtra("kode", pos);
        intent.putExtra("jeniskelamin", jk);
        intent.putExtra("agama", agama);
        startActivity(intent);
    }

    /*
        public void onBackPressend() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("apakah kalian ingin keluar?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }


            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            AlertDialog.Builder alert = new AlertDialog.Builder(
                    MainActivity.this);
            alert.setTitle(getString(R.string.app_name));

            alert.setMessage("Yakin Kamu Ingin Keluar ?");

            alert.setPositiveButton("Ya",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            finish();
                        }
                    });
            alert.setNegativeButton("Tidak",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                        }
                    });
            alert.show();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    }

