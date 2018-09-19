package com.example.myfirstapp_retrofit;

import android.app.Application;

import com.example.myfirstapp_retrofit.components.ApplicationComponent;
import com.example.myfirstapp_retrofit.components.DaggerApplicationComponent;
import com.example.myfirstapp_retrofit.modules.RetrofitModule;

public class App extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
