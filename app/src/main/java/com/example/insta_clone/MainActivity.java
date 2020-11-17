package com.example.insta_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText description;
    Button takePic;
    ImageView pic;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description=findViewById(R.id.edtDescription);
        takePic=findViewById(R.id.btnTakePic);
        pic=findViewById(R.id.ivPic);
        submit= findViewById(R.id.btnSubmit);

        queryPosts();
    }

    private void queryPosts() {
        ParseQuery<Post> query= ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e!=null)
                {

                }
                for(Post post: posts)
                {

                }
            }
        });
    }
}