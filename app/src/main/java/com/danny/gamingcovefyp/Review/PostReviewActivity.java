package com.danny.gamingcovefyp.Review;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import com.danny.gamingcovefyp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;



public class PostReviewActivity extends AppCompatActivity {
    private ImageButton selectImage;
    private EditText reviewTitle;
    private EditText reviewDescription;

    private Button submitReview;
    private Uri imageUri = null;
    private StorageReference storage;
    private ProgressDialog progress;
    private DatabaseReference database;
    private static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_review);
        storage = FirebaseStorage.getInstance().getReference();
        database = FirebaseDatabase.getInstance().getReference().child("Reviews");//Reviews database reference


        selectImage = (ImageButton) findViewById(R.id.imageSelect);
        reviewTitle = (EditText)findViewById(R.id.titleText);
        reviewDescription = (EditText)findViewById(R.id.descriptionText);
        submitReview = (Button)findViewById(R.id.submitReview1);
        progress = new ProgressDialog(this);


        selectImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);

            }
        });
        submitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostReview();

            }


        });
    }
        private void PostReview(){
            progress.setMessage("Posting review!");
            final String title_val = reviewTitle.getText().toString().trim();
            final String desc_val = reviewDescription.getText().toString().trim();

            if(!TextUtils.isEmpty(title_val)&& !TextUtils.isEmpty(desc_val)&& imageUri != null)
                progress.show();{
                StorageReference filepath = storage.child("Review_Images").child(imageUri.getLastPathSegment());
                filepath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        DatabaseReference newPost = database.push();
                        newPost.child("title").setValue(title_val);
                        newPost.child("desc").setValue(desc_val);
                        newPost.child("image").setValue(downloadUrl.toString());

                        progress.dismiss();

                        startActivity(new Intent(PostReviewActivity.this, ReviewActivity.class));
                    }
                });

            }
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){
             imageUri = data.getData();
            selectImage.setImageURI(imageUri);
        }
    }

}
