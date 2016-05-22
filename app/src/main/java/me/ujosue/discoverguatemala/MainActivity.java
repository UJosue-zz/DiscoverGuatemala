package me.ujosue.discoverguatemala;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ByteArrayPool;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

import me.ujosue.discoverguatemala.bean.Usuario;
import me.ujosue.discoverguatemala.volley.VolleyController;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin = null;
    private EditText etNick, etContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        etNick = (EditText) findViewById(R.id.etNick);
        etContrasena = (EditText) findViewById(R.id.etContrasena);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!etNick.getText().toString().equals("") && !etContrasena.getText().toString().equals("")){
                    String loginUrl = VolleyController.login + "?nick="+etNick.getText().toString()+"&contrasena="+etContrasena.getText().toString();
                JsonObjectRequest peticion = new JsonObjectRequest(Request.Method.GET, loginUrl, new JSONObject(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray listausuario = response.getJSONArray("usuario");
                            Usuario.deleteAll(Usuario.class);
                            if(listausuario.length()>0){
                                JSONObject jusuario = listausuario.getJSONObject(0);
                                Log.d("Usuario ", jusuario.toString());
                                Usuario usuarioLogeado = new Usuario(
                                        jusuario.getInt("id_Usuario"),
                                        jusuario.getString("nombre"),
                                        jusuario.getString("nacionalidad"),
                                        jusuario.getString("correo"),
                                        jusuario.getString("nick"),
                                        "", //Ruta de la foto (aún no se como guardar imágenes)
                                        response.getString("token"),
                                        response.getString("exp"),
                                        jusuario.getInt("id_Rol")
                                );
                                usuarioLogeado.save();
                                startActivity(new Intent(MainActivity.this,Home.class));
                            }else{
                                Toast.makeText(getApplicationContext(),"Verifique sus Credenciales", Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception ex) {
                            Log.e("1Error en la peticion ", ex.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error en la peticion ", error.getMessage());
                    }
                }
                );
                VolleyController.getInstance(v.getContext()).addToRequestQueue(peticion);
                }else{
                    Toast.makeText(getApplicationContext(),"No ha ingresado usuario y contraseña", Toast.LENGTH_LONG);
                }
            }
        });
    }

}
