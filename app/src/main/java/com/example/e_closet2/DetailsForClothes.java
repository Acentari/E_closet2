package com.example.e_closet2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class DetailsForClothes extends AppCompatActivity {

    private static final int GALLERY_REQ_CODE = 1000 ;
//    ImageSwitcher imageSwitcherClothes;//there was an imageView
    ImageView imageViewClothes;
//    Button btnNExt, btnPrevious;
    public static Uri uri;
    public Spinner SpinnerSeason;
    public Spinner SpinnerSport;

//    public static ArrayList<Uri> imagesURI;
    //position of selected images
//    int pos=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_for_clothes);

        Button buttonAdd = findViewById(R.id.addClthes);
        Button save = findViewById(R.id.save);
//        btnNExt=findViewById(R.id.btnNext);
//        btnPrevious=findViewById(R.id.btnPrevious);

//        imageSwitcherClothes=findViewById(R.id.imageClothes);
        imageViewClothes=findViewById(R.id.imageClothes);

        SpinnerSeason=findViewById(R.id.spinnerSeason);
        SpinnerSport=findViewById(R.id.spinnerSport);

        ArrayAdapter <CharSequence> adapterSeason =ArrayAdapter.createFromResource(this, R.array.spinnerSeason, android.R.layout.simple_spinner_item);
        ArrayAdapter <CharSequence> adapterSport =ArrayAdapter.createFromResource(this, R.array.spinnerSport, android.R.layout.simple_spinner_item);
        SpinnerSeason.setAdapter(adapterSeason);
        SpinnerSport.setAdapter(adapterSport);


//        imagesURI=new ArrayList<>();

        imageViewClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               return view;

            }
        });

        //add clothes from gallery button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               pickImagesWithIntent();
                Intent imageGalery = new Intent(Intent.ACTION_PICK);
                imageGalery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(imageGalery,GALLERY_REQ_CODE);
            }
        });

        //previous photo button
//        btnPrevious.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(pos>0){
//                    pos--;
//                    imageSwitcherClothes.setImageURI(imagesURI.get(pos));
//                }
//                else{
//                    Snackbar.make(view, "previoius", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                }
//            }
//        });
//
//        //next photo button
//        btnNExt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(pos<imagesURI.size()-1){
//                    pos++;
//                    imageSwitcherClothes.setImageURI(imagesURI.get(pos));
//                }
//                else{
//                    Snackbar.make(view, "next", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                }
//            }
//        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsForClothes.this, MainActivity.class);
////                intent.putExtra("multiple",imagesURI);
                startActivity(intent);
            }
        });
    }
//
//    private void pickImagesWithIntent(){
//        Intent intent =new Intent();
//        //how to style gallery
//        intent.setType("image/*");
//        intent.putExtra(Intent.ACTION_PICK,true);
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent,"Select image"),GALLERY_REQ_CODE );
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                uri = data.getData();

                finish();
//                Intent intent = new Intent(DetailsForClothes.this, MainActivity.class);
//                intent.putExtra("data", data.getData());
//                startActivity(intent);
                imageViewClothes.setImageURI(data.getData());


            }
        }
    }

//        if(resultCode==RESULT_OK){
//            if(requestCode==GALLERY_REQ_CODE){
//        if(requestCode == GALLERY_REQ_CODE){
//            if(resultCode == Activity.RESULT_OK){
////                if (data.getClipData() != null){
//                    //pick images
//                    int counter = data.getClipData().getItemCount();
//                    for(int i=0;i<counter;i++){
//                        //spesific possition
//                        Uri imgUri=data.getClipData().getItemAt(i).getUri();
//                        imagesURI.add(imgUri);
//                    }
//                    System.out.println("------1-------->"+imagesURI);
//                    imageSwitcherClothes.setImageURI(imagesURI.get(0));
//                    pos=0;
//                }
//                else{
//                    Uri uri=data.getData();
//                    imagesURI.add(uri);
//                    imageSwitcherClothes.setImageURI(imagesURI.get(0));
//                    pos=0;
//                    System.out.println("------2-------->"+imagesURI);

//                }
//                uri = data.getData();
//
//                finish();
//                Intent intent = new Intent(DetailsForClothes.this, MainActivity.class);
//                intent.putExtra("data", data.getData());
//                startActivity(intent);
//                imageViewClothes.setImageURI(data.getData());
//            }
//        }
//    }
}

