package com.example.e_closet2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Dreses extends AppCompatActivity {

    private final int GALLERY_REQ_CODE = 1000;
    ImageView imageViewClothes2;
    ListView testList;
    public static Uri uri2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreses);

        Button buttonAdd = findViewById(R.id.adddreses);
        imageViewClothes2=findViewById(R.id.addClothes);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent imageGalery = new Intent(Intent.ACTION_PICK);
                imageGalery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(imageGalery,GALLERY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data2) {
        super.onActivityResult(requestCode, resultCode, data2);

        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                uri2 = data2.getData();
                finish();
//                Intent intent = new Intent(DetailsForClothes.this, MainActivity.class);
//                intent.putExtra("data", data.getData());
//                startActivity(intent);
                imageViewClothes2.setImageURI(data2.getData());


            }
        }
    }
}

