package com.example.myfirstapp_retrofit.components;

import com.example.myfirstapp_retrofit.activities.DisplayListActivity;
import com.example.myfirstapp_retrofit.activities.MyActivity;
import com.example.myfirstapp_retrofit.api.API;
import com.example.myfirstapp_retrofit.modules.RetrofitModule;

import dagger.Component;

@Component(modules = {RetrofitModule.class})
public interface ApplicationComponent {

    public API getApiInterface();

    public void inject(MyActivity myActivity);

    public void inject(DisplayListActivity displayListActivity);
}
