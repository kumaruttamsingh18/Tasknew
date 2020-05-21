package com.uttam.task.utils;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.uttam.task.MyAppMaster;
import com.uttam.task.helper.Constants;
import com.uttam.task.model.AllCourses.CourseModel;

public class MyAppPreferences implements Constants {

    public static SharedPreferences getPreferences() {
        return MyAppMaster.appContext.getSharedPreferences(APP_NAME, Activity.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor preferenceEditor() {
        return MyAppMaster.appContext.getSharedPreferences(APP_NAME, Activity.MODE_PRIVATE).edit();
    }

    public static void saveCourseDetails(CourseModel value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        editor.putString("SAVE_COURSE_DETAILS", json);
        editor.commit();
    }

    public static CourseModel getCourseDetails() {
        SharedPreferences mSharedPreferences = getPreferences();
        Gson gson = new Gson();
        String json = mSharedPreferences.getString("SAVE_COURSE_DETAILS", "");
        CourseModel value = gson.fromJson(json, CourseModel.class);
        return value;
    }
}
