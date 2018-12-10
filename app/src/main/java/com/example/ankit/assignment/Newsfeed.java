package com.example.ankit.assignment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

public class Newsfeed extends AppCompatActivity {
    EditText editText;
    private static final int PICK_FROM_GALLERY = 101;
    ImageButton post, attatch;
    String tx;
    ImageView img1;
    MainActivity mainActivity = new MainActivity();
    Bitmap b;
    Feeds fd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_feed);
        editText=findViewById(R.id.text1);
        img1 = findViewById(R.id.image2);
        post = findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx = editText.getText().toString();
                fd = new Feeds("Ankit Kumar", "Just now", tx + "", 4, 5, R.drawable.circle, b);

            }
        });

        attatch = findViewById(R.id.attach);
        attatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra("return-data", true);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"),
                        PICK_FROM_GALLERY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            try {
                b = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                img1.setImageBitmap(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
