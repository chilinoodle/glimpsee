package com.mjdroid.glimpsee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.mjdroid.glimpsee.ActivityAdapter;
import com.mjdroid.glimpsee.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String city = bundle.getString("selectedCity");

        TextView cityView = (TextView) findViewById(R.id.city_view);

        cityView.setText(city);

        TextView addButtonView = (TextView) findViewById(R.id.add_button);

        addButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPlanner = new Intent(MainActivity.this, PlannerActivity.class);
                startActivity(goToPlanner);
            }
        });

        Intent sentActivity = getIntent();

        if (sentActivity.getSerializableExtra("selectedActivityObj") != null) {

            ArrayList activities = new ArrayList<>();
            PlanActivity selectedActivityObj = (PlanActivity) sentActivity.getSerializableExtra("selectedActivityObj");
            activities.add(selectedActivityObj);
            ActivityAdapter adapter = new ActivityAdapter(this, activities);
            ListView listView = (ListView) findViewById(R.id.list_container);
            listView.setAdapter(adapter);

        }



    }
}
