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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btUpdate;
    Button btDelete;
    Button btAdd;
    Button btConsult;
    TextView tviewOrden;
    SQLiteDatabase sqData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //INICIO EL TOOLBAR
     //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

        //Enlazamos Botones

        btUpdate= (Button)findViewById(R.id.btUpdate);
        btDelete= (Button)findViewById(R.id.btDelete);
        btAdd= (Button)findViewById(R.id.btAdd);
        btConsult= (Button)findViewById(R.id.btConsult);

      //  funcion();

        //Escuchamos

        btDelete.setOnClickListener((View.OnClickListener) this);
        btDelete.setOnClickListener((View.OnClickListener) this);
        btAdd.setOnClickListener((View.OnClickListener) this);
        btConsult.setOnClickListener((View.OnClickListener) this);

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


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btAdd:

                Toast toast2 = Toast.makeText(getApplicationContext(),"Toast con gravity", Toast.LENGTH_SHORT);
                toast2.show();
                break;

            case R.id.btDelete:
                break;

            case R.id.btUpdate:
                break;

            case R.id.btConsult:
                break;
        }
    }
}
