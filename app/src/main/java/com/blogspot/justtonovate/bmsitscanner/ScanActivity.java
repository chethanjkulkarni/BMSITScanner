package com.blogspot.justtonovate.bmsitscanner;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ScanActivity extends AppCompatActivity {
    private static final String TAG = "ScanActivity";
    private static final Class HomeClass = ScanActivity.class;
    private static final Class targetClass = ComplainActivity.class;
    private static final int item_number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        setupNavigation(item_number, bottomNavigationView);
        enableNavigation(HomeClass, targetClass, ScanActivity.this, bottomNavigationView);
        Log.d(TAG, "Scan Activity has Started");
    }

    public void setupNavigation(int item_number, BottomNavigationView bottomNavigationView){
        Menu menu= bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(item_number);
        menuItem.setChecked(true);
    }
    public void enableNavigation(final Class HomeClass, final Class targetClass, final Context context, BottomNavigationView bottomNavigationView){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.scan:
                        Intent scan = new Intent(context, HomeClass);
                        context.startActivity(scan);
                        break;
                    case R.id.complain:
                        Intent complain = new Intent(context, targetClass);
                        context.startActivity(complain);
                        break;
                }
                return false;
            }
        });
    }
}
