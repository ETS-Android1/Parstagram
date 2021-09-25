package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;


public class ParseApplication extends Application {

    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("WdmbNUfd9jbaKYBzHv9aLsnmjR69QgMpGa4FYwNV")
                .clientKey("tkRksjKgVNFvClfxefSlb5d9FU42MHuNlaA9fu4O")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
