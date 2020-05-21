package com.uttam.task.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.uttam.task.R;
import com.uttam.task.adapter.MainPagerAdapter;
import com.uttam.task.fragment.DemoFragment;
import com.uttam.task.fragment.LiveFragment;
import com.uttam.task.fragment.SubjectFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainPagerAdapter mainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainPagerAdapter.addFragment(new SubjectFragment(), "Conducted");
        mainPagerAdapter.addFragment(new LiveFragment(), "Live");
        mainPagerAdapter.addFragment(new DemoFragment(), "Demo");
        viewPager.setAdapter(mainPagerAdapter);

        setPager();
    }

    private void setPager(){

        viewPager.setCurrentItem(0);
    }
}
