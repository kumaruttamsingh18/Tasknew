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
import com.uttam.task.activity.MainActivity;
import com.uttam.task.adapter.SubjectAdapter;
import com.uttam.task.model.SubjectCourse.Subject;
import com.uttam.task.model.SubjectCourse.SubjectModel;
import com.uttam.task.rest.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<SubjectModel> subjectModelList;
    private SubjectAdapter subjectAdapter;
    private SwipeRefreshLayout refreshLayout;

    public SubjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject, container, false);

        refreshLayout = view.findViewById(R.id.swipe_refresh);
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        subjectModelList = new ArrayList<>();
        showAllSubject();

        refreshLayout.setOnRefreshListener(() -> showAllSubject());

    }

    private void showAllSubject() {
        refreshLayout.setRefreshing(true);
        Call<Subject> call = ApiClient.getInstance().getApi().ShowAllSubject("1");
        call.enqueue(new Callback<Subject>() {
            @Override
            public void onResponse(Call<Subject> call, Response<Subject> response) {
                refreshLayout.setRefreshing(false);
                if(response.body().getStatus()== 1) {
                    subjectModelList = response.body().getSubjects();
                    subjectAdapter = new SubjectAdapter(getActivity(),subjectModelList);
                    recyclerView.setAdapter(subjectAdapter);
                    subjectAdapter.notifyDataSetChanged();

                }else {
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Subject> call, Throwable t) {
                refreshLayout.setRefreshing(false);
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
