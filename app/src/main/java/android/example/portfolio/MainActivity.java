package android.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button movies_1 = findViewById(R.id.movies_1_button);
        movies_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = "movies.popular.nanodegree.android.popularmovies";
                launchApp(packageName);
            }
        });

        Button baking = findViewById(R.id.baking_button);
        baking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = "baking.nanodegree.android.baking";
                launchApp(packageName);
            }
        });

        Button material_design = findViewById(R.id.material_design_button);
        material_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = "com.example.xyzreader";
                launchApp(packageName);
            }
        });

        Button capstone = findViewById(R.id.capstone_button);
        capstone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = "nanodegree.android.nba";
                launchApp(packageName);
            }
        });

        Button movies_2 = findViewById(R.id.movies_2_button);
        movies_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = "com.tparrish.android.popularmovies";
                launchApp(packageName);
            }
        });
    }

    protected void launchApp(String packageName){
        Context mContext = this;
        PackageManager pm = mContext.getPackageManager();
        try{
            Intent intent = pm.getLaunchIntentForPackage(packageName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);

            if(intent == null){
                throw new PackageManager.NameNotFoundException();
            }else{
                mContext.startActivity(intent);
            }
        }catch(PackageManager.NameNotFoundException e){
            Log.e("Launch",e.getMessage());
        }
    }
}
