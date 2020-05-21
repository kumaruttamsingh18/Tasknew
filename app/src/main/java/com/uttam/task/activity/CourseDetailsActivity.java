package com.uttam.task.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.uttam.task.R;
import com.uttam.task.adapter.MainPagerAdapter;
import com.uttam.task.fragment.AboutCourseFragment;
import com.uttam.task.fragment.DemoFragment;
import com.uttam.task.fragment.FacultyFragment;
import com.uttam.task.fragment.LiveFragment;
import com.uttam.task.fragment.SubjectFragment;
import com.uttam.task.fragment.SyllabusFragment;
import com.uttam.task.model.AllCourses.CourseModel;

import static com.uttam.task.helper.Constants.SERIES_IMAGE_BASE_URL;
import static com.uttam.task.utils.MyAppPreferences.getCourseDetails;

public class CourseDetailsActivity extends AppCompatActivity {

    private ImageView courseImage;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainPagerAdapter mainPagerAdapter;
    private Toolbar toolbar;
    private TextView coursePrice,cuttedPrice,watchDemoBtn;
    private View cuttedView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        courseImage = findViewById(R.id.course_image);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        toolbar = findViewById(R.id.toolbar);
        coursePrice = findViewById(R.id.course_price);
        cuttedPrice = findViewById(R.id.cutted_price);
        cuttedView = findViewById(R.id.view_cutted);
        watchDemoBtn = findViewById(R.id.watch_demo_btn);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getCourseDetails().getTitle());

        String filePath = SERIES_IMAGE_BASE_URL + getCourseDetails().getImage();
        Glide.with(this).load(filePath).placeholder(R.drawable.placeholder_small).into(courseImage);
        if(getCourseDetails().getSalePrice().equals("0.00")){
            coursePrice.setText("₹"+getCourseDetails().getCost()+"/-");
            cuttedPrice.setVisibility(View.INVISIBLE);
            cuttedView.setVisibility(View.INVISIBLE);
        }else {
            coursePrice.setText("₹"+getCourseDetails().getSalePrice()+"/-");
            cuttedPrice.setText("₹"+getCourseDetails().getCost()+"/-");
        }

        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

        watchDemoBtn.setOnClickListener(v ->
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainPagerAdapter.addFragment(new AboutCourseFragment(), "ABOUT COURSES");
        mainPagerAdapter.addFragment(new SyllabusFragment(), "SYLLABUS");
        mainPagerAdapter.addFragment(new FacultyFragment(), "FACULTY");
        viewPager.setAdapter(mainPagerAdapter);

        setPager();
    }

    private void setPager(){

        viewPager.setCurrentItem(0);
    }
}
