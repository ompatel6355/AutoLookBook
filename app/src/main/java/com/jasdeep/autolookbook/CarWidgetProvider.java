package com.jasdeep.autolookbook;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class CarWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            // Create an Intent to launch MainActivity when the widget is clicked
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            // Update the widget layout
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_car_list);

            // Example: Update widget content
            views.setTextViewText(R.id.widget_title, "Car Listings");

            // Handle the widget click event
            views.setOnClickPendingIntent(R.id.widget_title, pendingIntent);

            // Update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
