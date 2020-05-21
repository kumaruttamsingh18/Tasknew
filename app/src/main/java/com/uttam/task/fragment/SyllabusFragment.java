package com.uttam.task.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.uttam.task.R;

import static com.uttam.task.utils.MyAppPreferences.getCourseDetails;

/**
 * A simple {@link Fragment} subclass.
 */
public class SyllabusFragment extends Fragment {

    private WebView webViewSyllabus;

    public SyllabusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);

        webViewSyllabus = view.findViewById(R.id.webView_syllabus);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webViewSyllabus.loadData(getCourseDetails().getSyllabus(), "text/html", "UTF-8");
    }
}
