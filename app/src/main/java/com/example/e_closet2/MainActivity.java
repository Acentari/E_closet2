package com.example.e_closet2;

import static com.example.e_closet2.GalleryImageAdapter.mContext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addFab;
    FloatingActionButton addBlouses;
    FloatingActionButton addTrouses;
    List<Bitmap> bitmaps;
    List<Bitmap> bitmaps2;
    ListView listView;
    ListView listView2;
    Boolean isAllFabsVisible;
    Boolean clickfabBlouses;
    Boolean clickfabTrouses;
    Button hoodies,Dresses;
    TextView textView1,textView2;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bitmaps = new ArrayList<>();
        bitmaps2 = new ArrayList<>();

        listView = findViewById(R.id.listDress);

        listView2 = findViewById(R.id.ListBlouses);

        listView.setOnTouchListener((v, event) -> (event.getAction() == MotionEvent.ACTION_MOVE));
        listView2.setOnTouchListener((v, event) -> (event.getAction() == MotionEvent.ACTION_MOVE));

        List<String> stringList = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();

        //we know that both of lists are diferent
//        for (int i = 0; i <10; i++) {
//            stringList.add(String.valueOf(i));
//        }
//
//        for (int i = 10; i <50; i++) {
//            stringList2.add(String.valueOf(i));
//        }

        ListAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringList);
        ListAdapter adapter2= new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringList2);

        listView.setAdapter(adapter);
        listView2.setAdapter(adapter2);

        addFab=findViewById(R.id.addFab);
        addBlouses=findViewById(R.id.add_blouses);
        addTrouses=findViewById(R.id.addtrousses);

        hoodies=findViewById(R.id.hoodies);
        Dresses=findViewById(R.id.Dresses);

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);


        addBlouses.setVisibility(View.GONE);
        addTrouses.setVisibility(View.GONE);

        isAllFabsVisible = false;

        addFab.setOnClickListener(view -> {
            if (!isAllFabsVisible) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                addBlouses.show();
                addTrouses.show();
                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = true;
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                addBlouses.hide();
                addTrouses.hide();
                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = false;
            }
        });

        addBlouses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickfabBlouses=true;
                clickfabTrouses=false;
                startActivity( new Intent(MainActivity.this,DetailsForClothes.class));
//                Snackbar.make(view, "blouzes", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });

        addTrouses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickfabTrouses=true;
                clickfabBlouses=false;
                startActivity( new Intent(MainActivity.this,DetailsForClothes.class));
//                Snackbar.make(view, "pantelonia", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });

        hoodies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setBackgroundColor(Color.parseColor("red"));
            }
        });

        Dresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setBackgroundColor(Color.parseColor("green"));
            }
        });




//        float rotation=listView.getRotation();
//        listView.setRotation(90);
//
//        float rotation2=listView2.getRotation();
//        listView2.setRotation(90);
//
//        Log.d("rotation", String.valueOf(rotation));
//        Log.d("rotation2", String.valueOf(rotation2));

//        ActionBar actionBar;actionBar=getSupportActionBar();

    }

//    ArrayList<Uri> listOfUris = (ArrayList<Uri>) getIntent().getSerializableExtra("multiple");

    @Override
    protected void onRestart() {
        Log.d("transfer","hello");
        Bitmap bitmap = null;
        Bitmap bitmap2 = null;
//        ArrayList<Uri> data=DetailsForClothes.imagesURI;
//        System.out.println(data);
//        Uri data2 = DetailsForClothes.uri;
//        System.out.println(data2);

        if (clickfabBlouses==true){
            Uri data = DetailsForClothes.uri;
            System.out.println(data);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver() ,data);

//                     bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver() , Uri.parse(String.valueOf(data)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bitmaps.add(bitmap);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    GalleryImageAdapter myAdapter;
                    myAdapter = new GalleryImageAdapter(getApplicationContext(), bitmaps);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listView.setAdapter(myAdapter);
                            System.out.println("listView---->"+listView);
                        }
                    });
                }
            }).start();
            System.out.println(data);
        }
        else if (clickfabTrouses==true){
            Uri data2 = DetailsForClothes.uri;
            System.out.println(data2);
            try {
                bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver() , data2);
//                bitmap2 = MediaStore.Images.Media.getBitmap(mContext.getContentResolver() , Uri.parse(String.valueOf(data2)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bitmaps2.add(bitmap2);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    GalleryImageAdapter myAdapter2;
                    myAdapter2 = new GalleryImageAdapter(getApplicationContext(), bitmaps2);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listView2.setAdapter(myAdapter2);
//                            System.out.println(listView2);
                        }
                    });
                }
            }).start();
        }
        super.onRestart();
    }
}
