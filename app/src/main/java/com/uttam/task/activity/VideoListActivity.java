package com.uttam.task.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.uttam.task.R;
import com.uttam.task.adapter.AllCourseVideoAdapter;
import com.uttam.task.model.videoCourse.AllCourseVideo;
import com.uttam.task.model.videoCourse.VideoCourse;
import com.uttam.task.rest.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private AllCourseVideoAdapter allCourseVideoAdapter;
    private int subjectId;
    private String subjectName;
    private List<AllCourseVideo> allCourseVideoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        toolbar = findViewById(R.id.toolbar);
        refreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.recyclerView);

        subjectId = getIntent().getIntExtra("SubjectId", -1);
        subjectName = getIntent().getStringExtra("SubjectName");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(subjectName);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        showVideoList();

        refreshLayout.setOnRefreshListener(() -> showVideoList());
    }

    private void showVideoList() {
        refreshLayout.setRefreshing(true);
        Call<VideoCourse> call = ApiClient.getInstance().getApi().ShowAllVideo("1");
        call.enqueue(new Callback<VideoCourse>() {
            @Override
            public void onResponse(Call<VideoCourse> call, Response<VideoCourse> response) {
                refreshLayout.setRefreshing(false);
                if (response.body().getStatus() == 1) {
                    allCourseVideoList = response.body().getAllCourseVideo();
                    List<AllCourseVideo> selectedCourseVideoList = new ArrayList<>();
                    for (int i = 0; i < allCourseVideoList.size(); i++) {
                        if (subjectId == allCourseVideoList.get(i).getSubjectId()) {
                            selectedCourseVideoList.add(allCourseVideoList.get(i));
                        }
                    }
                    allCourseVideoAdapter = new AllCourseVideoAdapter(VideoListActivity.this, selectedCourseVideoList);
                    recyclerView.setAdapter(allCourseVideoAdapter);
                    allCourseVideoAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(getApplicationContext(), response.body().getAllCourseVideo().toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<VideoCourse> call, Throwable t) {
                refreshLayout.setRefreshing(false);
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
