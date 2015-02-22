package com.uce.asus.universidadinfor_optativa;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.ksoap2.serialization.SoapObject;


public class UniversidadInfo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universidad_info);
    }

    @Override
    protected void EnviarOnclick(View v){






        Thread nt = new Thread(){
            String res;
            final EditText Numero1 = (EditText) findViewById(R.id.et_num1);
            final EditText Numero2 = (EditText) findViewById(R.id.et_num2);

            @Override
            public void run(){
                String NAMESPACE ="http://localhost/";
                String URL="http://localhost:9000/Demo_WS_Android.asmx";
                String METHOD_NAME="Suma";
                String SOAP_ACTION="http://localhost/Suma";

                SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
                request.addProperty("Numero1", Integer.parseInt(Numero1.getText().toString()));
                request.addProperty("Numero2", Integer.parseInt(Numero2.getText().toString()));


            }

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_universidad_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
