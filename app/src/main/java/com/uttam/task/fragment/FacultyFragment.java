package com.uttam.task.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.uttam.task.R;
import com.uttam.task.adapter.TeacherAdapter;
import com.uttam.task.model.AllTeacher.AllTeacherModel;
import com.uttam.task.model.AllTeacher.TeacherModel;
import com.uttam.task.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.uttam.task.utils.MyAppPreferences.getCourseDetails;

/**
 * A simple {@link Fragment} subclass.
 */
public class FacultyFragment extends Fragment {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private TeacherAdapter teacherAdapter;
    private List<TeacherModel> teacherModelList;

    public FacultyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        refreshLayout = view.findViewById(R.id.swipe_refresh);
        recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showAllTeacher();
        refreshLayout.setOnRefreshListener(() -> showAllTeacher());
    }

    private void showAllTeacher() {
        refreshLayout.setRefreshing(true);

        Call<AllTeacherModel> call = ApiClient.getInstance().getApi().ShowAllTeacher("" + getCourseDetails().getId());
        call.enqueue(new Callback<AllTeacherModel>() {
            @Override
            public void onResponse(Call<AllTeacherModel> call, Response<AllTeacherModel> response) {
                refreshLayout.setRefreshing(false);
                if (response.body().getStatus() == 1) {
                    teacherModelList = response.body().getTeachers();
                    teacherAdapter = new TeacherAdapter(getContext(), teacherModelList);
                    recyclerView.setAdapter(teacherAdapter);
                    teacherAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllTeacherModel> call, Throwable t) {
                refreshLayout.setRefreshing(false);
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
