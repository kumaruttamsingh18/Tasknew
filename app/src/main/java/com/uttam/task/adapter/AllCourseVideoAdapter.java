package com.uttam.task.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uttam.task.R;
import com.uttam.task.activity.PlayVideoActivity;
import com.uttam.task.model.videoCourse.AllCourseVideo;

import java.util.List;

import static com.uttam.task.helper.Constants.IMAGE_BASE_URL;

public class AllCourseVideoAdapter extends RecyclerView.Adapter<AllCourseVideoAdapter.VideoListViewHolder> {

    private Context context;
    private List<AllCourseVideo> selectedCourseVideoList;

    public AllCourseVideoAdapter(Context context, List<AllCourseVideo> selectedCourseVideoList) {
        this.context = context;
        this.selectedCourseVideoList = selectedCourseVideoList;
    }

    @NonNull
    @Override
    public VideoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_list, parent,false);
        return new VideoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoListViewHolder holder, int position) {

        String filePath = IMAGE_BASE_URL + selectedCourseVideoList.get(position).getImage();
        Glide.with(context).load(filePath).placeholder(R.drawable.placeholder_small).into(holder.videoImage);
        holder.videoTitle.setText(selectedCourseVideoList.get(position).getTitle());
        holder.videoScheduled.setText(selectedCourseVideoList.get(position).getScheduledFor());
        holder.itemView.setOnClickListener(v->{
            Intent playVideoIntent = new Intent(context, PlayVideoActivity.class);
            playVideoIntent.putExtra("Title", selectedCourseVideoList.get(position).getTitle());
            playVideoIntent.putExtra("Url", selectedCourseVideoList.get(position).getFilePath());
            context.startActivity(playVideoIntent);
        });
    }

    @Override
    public int getItemCount() {
        return selectedCourseVideoList.size();
    }

    public class VideoListViewHolder extends RecyclerView.ViewHolder {
        private ImageView videoImage;
        private TextView videoTitle,videoScheduled;
        public VideoListViewHolder(@NonNull View itemView) {
            super(itemView);
            videoImage = itemView.findViewById(R.id.video_image);
            videoTitle = itemView.findViewById(R.id.video_title);
            videoScheduled = itemView.findViewById(R.id.video_schedule);
        }
    }
}
