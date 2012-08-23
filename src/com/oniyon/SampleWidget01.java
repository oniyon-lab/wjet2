package com.oniyon;

import java.util.Calendar;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;
import android.widget.TextView;

public class SampleWidget01 extends AppWidgetProvider {
	@Override
	public void onUpdate(Context c, AppWidgetManager awm, int[] awi) {
		// ～　リモートビューにmain.xmlをセット　～//
		RemoteViews rv = new RemoteViews(c.getPackageName(), R.layout.main);
		final Calendar calendar = Calendar.getInstance();

		final int year = calendar.get(Calendar.YEAR);
		final int month = calendar.get(Calendar.MONTH);
		final int day = calendar.get(Calendar.DAY_OF_MONTH);
		final int hour = calendar.get(Calendar.HOUR_OF_DAY);
		final int minute = calendar.get(Calendar.MINUTE);
		final int second = calendar.get(Calendar.SECOND);
		final int ms = calendar.get(Calendar.MILLISECOND);

		String text = year
				+ "/" + (month + 1)
				+ "/" + day
				+ "/" + " "
				+ hour
				+ ":"+ minute
				+ ":" + second
				+ "." + ms;

		rv.setTextViewText(R.id.TextView01, text);

		// ～　ウィジェットにremoteViewsをセット　～//
		ComponentName cn = new ComponentName(c, SampleWidget01.class);
		awm.updateAppWidget(cn, rv);
	}

}