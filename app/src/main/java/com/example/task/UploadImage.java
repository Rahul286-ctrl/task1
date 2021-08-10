package com.example.task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class UploadImage extends AppCompatActivity {
   Button browse,next;
   ImageView imageView;
   EditText text,type;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        imageView=findViewById(R.id.imageView7);
        browse=findViewById(R.id.browse);
        text=findViewById(R.id.text);
        next=findViewById(R.id.next);
        type=findViewById(R.id.type);


        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(UploadImage.this)
                        .galleryOnly()
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                       .compress(1024)			//Final image size will be less than 1 MB(Optional)
                       .maxResultSize(100, 100)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

 next.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent= new Intent(UploadImage.this,MainActivity.class);
         intent.putExtra("name",type.getText());
        // intent.putExtra("image",uri);
        // intent.putExtra("article",text.getText());
         startActivity(intent);
     }
 });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { super.onActivityResult(requestCode, resultCode, data);

        uri=data.getData();
        imageView.setBackground(null);
        imageView.setImageURI(uri);

        next.setEnabled(true);
    }


}