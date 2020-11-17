package com.example.insta_clone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("vtUMFEoS1Rry8BpmR7OUR0f2q1yQ1pze1cE7DUHQ")
                .clientKey("IkWhwhUucB0wf7eCEymALHkEYYyqu4YM6pNgvGb1")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
