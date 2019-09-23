package com.example.androidmenucontextosimples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View vMenu;

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

        this.vMenu = v;

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
        Log.e("item getItemId:", String.valueOf(item.getItemId()));
        Log.e("item getTitle:", item.getTitle().toString());
        Log.e("view", String.valueOf(vMenu.getId()));

        switch (vMenu.getId()) {
            case R.id.lista:
                switch (item.getItemId()){
                    case R.id.texto_deletar:
                        Toast.makeText(this, "Deletar Texto", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.texto_editar:
                        Toast.makeText(this, "Editar Texto", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
            case R.id.lista_botoes:
                switch (item.getItemId()){
                    case R.id.botoes_cor:
                        Toast.makeText(this, "Botão Cor", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.botoes_teste:
                        Toast.makeText(this, "Botoes Teste", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
        }

        return true;
    }


}
