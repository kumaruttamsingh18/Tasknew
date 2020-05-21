package com.uttam.task.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uttam.task.R;
import com.uttam.task.activity.VideoListActivity;
import com.uttam.task.model.SubjectCourse.SubjectModel;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.viewholder> {
    private Context context;
    private List<SubjectModel> subjectModelList;

    public SubjectAdapter(Context context, List<SubjectModel> subjectModelList) {
        this.context = context;
        this.subjectModelList = subjectModelList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {
        holder.subjectName.setText(subjectModelList.get(position).getSubjectName());
        holder.itemView.setOnClickListener(v -> {
            Intent videoIntent = new Intent(context, VideoListActivity.class);
            videoIntent.putExtra("SubjectId", subjectModelList.get(position).getSubjectId());
            videoIntent.putExtra("SubjectName", subjectModelList.get(position).getSubjectName());
            context.startActivity(videoIntent);
        });
    }


    @Override
    public int getItemCount() {
        return subjectModelList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView subjectName;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subject_name);
        }
    }
}
