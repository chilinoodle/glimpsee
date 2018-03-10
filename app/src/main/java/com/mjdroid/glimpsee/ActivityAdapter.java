package com.mjdroid.glimpsee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ActivityAdapter extends ArrayAdapter <PlanActivity> {

    public ActivityAdapter(Context context, ArrayList<PlanActivity> activities) {
        super(context,0,activities);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item, parent, false);
        }

        PlanActivity selectedActivity = getItem(position);


        ImageView activityIcon = (ImageView) listItemView.findViewById(R.id.activity_icon);
        //findImageResource defined in PlanActivity class (switch case)
        activityIcon.setImageResource(selectedActivity.findImageResource());

        TextView activityName = (TextView) listItemView.findViewById(R.id.activity_name);
        activityName.setText(selectedActivity.getLongText());

        TextView activityCompany = (TextView) listItemView.findViewById(R.id.with_name);
        activityCompany.setText("with: " + selectedActivity.getContact());

        TextView activityDate = (TextView) listItemView.findViewById(R.id.date);
        activityDate.setText(selectedActivity.getDate());

        TextView activityFrom = (TextView) listItemView.findViewById(R.id.time);
        activityFrom.setText(selectedActivity.getFromTime());

        return listItemView;
    }

}
