package com.danny.gamingcovefyp.Review;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.danny.gamingcovefyp.DashboardActivity;
import com.danny.gamingcovefyp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;



public class ReviewActivity extends AppCompatActivity implements View.OnClickListener {
    private Button writeReview;
    private Button buttonBack;
    private RecyclerView reviewList;
    private LinearLayoutManager layoutManager;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        database = FirebaseDatabase.getInstance().getReference().child("Reviews");
        reviewList = (RecyclerView) findViewById(R.id.review_list);
        reviewList.setHasFixedSize(true);
        reviewList.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(ReviewActivity.this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        writeReview = (Button)findViewById(R.id.reviewButton);
        writeReview.setOnClickListener(this);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Review, ReviewViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Review, ReviewViewHolder>(
                Review.class,
                R.layout.review_row,
                ReviewViewHolder.class,
                database
            ) {

            @Override
            protected void populateViewHolder(ReviewViewHolder viewHolder, Review model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(),model.getImage());

            }
        };
        reviewList.setLayoutManager(layoutManager);
        reviewList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder{
        View view;

        public ReviewViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }
        public void setTitle(String title){
            TextView post_review = (TextView)view.findViewById(R.id.post_title);
            post_review.setText(title);
        }

        public void setDesc(String desc){
            TextView post_desc = (TextView)view.findViewById(R.id.post_desc);
            post_desc.setText(desc);
        }

        public void setImage (Context ctx, String image){
            ImageView post_image = (ImageView) view.findViewById(R.id.post_image);
            Picasso.with(ctx).load(image).into(post_image);
        }

    }

    @Override
    public void onClick(View view){
        if (view ==  writeReview){
            startActivity(new Intent(this, PostReviewActivity.class));
        }
        if (view == buttonBack){
            startActivity(new Intent(this, DashboardActivity.class));
        }

    }
}
