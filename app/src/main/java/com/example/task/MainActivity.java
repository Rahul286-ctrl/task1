package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
 private TextView informative,name,article;
 ImageView imageView;
 String url,uname,aname,uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        informative=(TextView)findViewById(R.id.textView7);
        name=(TextView)findViewById(R.id.name);
        article=(TextView)findViewById(R.id.textView2);
        imageView=(ImageView) findViewById(R.id.imageView);
        Intent intent= getIntent();
        uname=intent.getStringExtra("name");
        //aname= intent.getStringExtra("article");
       // uri=intent.getStringExtra("image");
        Log.d("success: ","is "+uname);
       // Glide.with(this).load(uri).into(imageView);
        name.setText(uname);
       // article.setText(aname);
        url="http://luneblaze.com/new/Luneblaze-API/api/app/react.jason";
        informative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                        new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("LuneblazeResponse", response.toString());
                        Toast.makeText(MainActivity.this, "Luneblaze Api hit successfully", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "ERROR: "+ error, Toast.LENGTH_SHORT).show();
                    }

                });

                queue.add(objectRequest);
            }
            });
    }

}