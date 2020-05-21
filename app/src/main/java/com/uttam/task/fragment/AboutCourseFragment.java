package com.uttam.task.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uttam.task.R;

import static com.uttam.task.utils.MyAppPreferences.getCourseDetails;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutCourseFragment extends Fragment {

    private TextView aboutCoursesTv;

    public AboutCourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_course, container, false);

        aboutCoursesTv = view.findViewById(R.id.about_courses);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        aboutCoursesTv.setText(HtmlCompat.fromHtml(getCourseDetails().getDescription(), 0));
    }
}
