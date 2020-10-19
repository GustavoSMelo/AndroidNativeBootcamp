package com.example.exemplo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void gravar1(View v) {   //não será chamado nesta versão (ver o gravar2 ativo)
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.email);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if (n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
            } else {
                bdw.execSQL("INSERT INTO contatos (nome,celular,email) "
                        + "  values ('" + n + "','" + c + "','" + e + "')");
                Toast.makeText(getApplicationContext(),
                        "Inserido com sucesso.", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. Nome duplicado?\n",
                    Toast.LENGTH_LONG).show();
        } finally {
            if (bdw != null) bdw.close();
            if (ch != null) ch.close();
        }
    }

    public void listar(View v) {
        HelperDB ch1 = null;  // classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdr1 = null;
        String str = "\n\nContatos cadastrados:\n\n\n";
        try {
            Context ctx = v.getContext();
            ch1 = new HelperDB(ctx);
            bdr1 = ch1.getReadableDatabase();
            Cursor cursor = bdr1.query("contatos", null, null,
                    null, null, null, "nome");
            // ou Cursor cursor = bdr1.rawQuery("select * from contatos", null);
            while (cursor.moveToNext()) {
                String nom = cursor.getString(0);
                String cel = cursor.getString(1);
                String em = cursor.getString(2);
                str += nom + ", " + cel + ", " + em + "\n\n";
            }
            ((TextView) findViewById(R.id.lista)).setText(str);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD.\n", Toast.LENGTH_LONG).show();
        } finally {
            if (bdr1 != null) bdr1.close();
            if (ch1 != null) ch1.close();
        }
    }


    public void gravar2(View v) {
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.email);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if (n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
            } else {
                ContentValues cv = new ContentValues();
                cv.put("nome", n);
                cv.put("celular", c);
                cv.put("email", e);
                long id = bdw.insert("contatos", null, cv);
                if (id == -1) {
                    Toast.makeText(getApplicationContext(),
                            "\nNão foi possível inserir. Nome duplicado?\n",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Inserido com sucesso.", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                    Toast.LENGTH_LONG).show();
        } finally {
            if (bdw != null) bdw.close();
            if (ch != null) ch.close();
        }
    }

    public void alterar(View v) {
        HelperDB ch = null;
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.email);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if (n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha todos os dados.", Toast.LENGTH_LONG).show();
            } else {
                ContentValues cv = new ContentValues();
                cv.put("celular", c);
                cv.put("email", e);
                long id = bdw.update("contatos", cv, "nome ='" + n + "'", null);
                if (id == 0) {
                    Toast.makeText(getApplicationContext(),
                            "\nNão foi possível alterar o contato. Verifique o nome.\n",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Contato alterado com sucesso.", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                    Toast.LENGTH_LONG).show();
        } finally {
            if (bdw != null) bdw.close();
            if (ch != null) ch.close();
        }
    }

    public void eliminar(View v) {
        HelperDB ch = null;
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            String n = nome.getText().toString();
            if (n.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, digite o nome do contato a eliminar.", Toast.LENGTH_LONG).show();
            } else {
                    long id = bdw.delete("contatos", "nome ='" + n + "'", null);
                if (id == 0) {
                    Toast.makeText(getApplicationContext(),
                            "\nNão foi possível eliminar o contato. Verifique o nome.\n",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Contato eliminado com sucesso.", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                    Toast.LENGTH_LONG).show();
        } finally {
            if (bdw != null) bdw.close();
            if (ch != null) ch.close();
        }
    }


}
