package com.uttam.task.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.uttam.task.R;
import com.uttam.task.adapter.CourseAdapter;
import com.uttam.task.model.AllCourses.AllCourseModel;
import com.uttam.task.model.AllCourses.CourseModel;
import com.uttam.task.rest.ApiClient;
import com.uttam.task.utils.MyAppPreferences;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.uttam.task.utils.MyAppPreferences.saveCourseDetails;

public class DashboardActivity extends AppCompatActivity {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private List<CourseModel> courseModelList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        refreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dashboard");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        showAllCourse();
        refreshLayout.setOnRefreshListener(() -> showAllCourse());

    }

    private void showAllCourse() {
        refreshLayout.setRefreshing(true);

        Call<AllCourseModel> call = ApiClient.getInstance().getApi().ShowAllCourse();
        call.enqueue(new Callback<AllCourseModel>() {
            @Override
            public void onResponse(Call<AllCourseModel> call, Response<AllCourseModel> response) {
                refreshLayout.setRefreshing(false);
                if(response.body().getStatus() == 1) {
                    courseModelList = response.body().getAllcourses();
                    courseAdapter = new CourseAdapter(DashboardActivity.this, courseModelList);
                    recyclerView.setAdapter(courseAdapter);
                    courseAdapter.notifyDataSetChanged();

                }else {
                    Toast.makeText(getApplicationContext(), response.body().getStatus(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllCourseModel> call, Throwable t) {
                refreshLayout.setRefreshing(false);
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}