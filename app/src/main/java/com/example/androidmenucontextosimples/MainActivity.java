package com.example.androidmenucontextosimples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout l = findViewById(R.id.lista);

        this.registerForContextMenu(l);

        LinearLayout b = findViewById(R.id.lista_botoes);

        this.registerForContextMenu(b);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()) {
            case R.id.lista_botoes:
                Toast.makeText(this, "Apresenta Menu Contexto BOTÕES", Toast.LENGTH_LONG).show();

                getMenuInflater().inflate(R.menu.menu_botoes, menu);
                break;
            case R.id.lista:
                Toast.makeText(this, "Apresenta Menu Contexto TEXTO", Toast.LENGTH_LONG).show();
                getMenuInflater().inflate(R.menu.menu_lista, menu);
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }


}
