package co.appeasy.www.ordenes;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //BASE DE DATOS
        BdOrdenes misOrdenes= new BdOrdenes(this,"BdOrdenes",null,1);
        SQLiteDatabase db= misOrdenes.getWritableDatabase();

        //INGRESAMOS DATOS A LA BASE


        if(db != null)
        {

            for(int i=1;i<=10;i++){
                int codigo=i;

                String numeroOrden= "Orden No " + i;
                db.execSQL("INSERT INTO ordenes (codigo, nombre)"+
                        "VALUES ("+ codigo +",'"+numeroOrden+"'  )");
            }

            //CIERRO BASE DATOS
            db.close();
        }

        String pathDatabase = getDatabasePath("BdOrdenes.db").getAbsolutePath();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        int id1= item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id1==R.id.add_orden){
            return true;

        }

        return super.onOptionsItemSelected(item);
    }



}
