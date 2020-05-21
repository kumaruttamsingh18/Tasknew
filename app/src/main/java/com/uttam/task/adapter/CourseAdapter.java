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
import com.uttam.task.activity.CourseDetailsActivity;
import com.uttam.task.model.AllCourses.CourseModel;

import java.util.List;

import static com.uttam.task.helper.Constants.IMAGE_BASE_URL;
import static com.uttam.task.helper.Constants.SERIES_IMAGE_BASE_URL;
import static com.uttam.task.utils.MyAppPreferences.saveCourseDetails;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;
    private List<CourseModel> courseModelList;

    public CourseAdapter(Context context, List<CourseModel> courseModelList) {
        this.context = context;
        this.courseModelList = courseModelList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return courseModelList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        String filePath = SERIES_IMAGE_BASE_URL + courseModelList.get(position).getImage();
        Glide.with(context).load(filePath).placeholder(R.drawable.placeholder_small).into(holder.image);
        holder.title.setText(courseModelList.get(position).getTitle());
        holder.startedDate.setText("Start From :\n"+courseModelList.get(position).getStartDate());

        /*long salePrice = Long.parseLong("999"*//*courseModelList.get(position).getSalePrice()*//*);
        long costPrice = Long.parseLong("1299"*//*courseModelList.get(position).getCost()*//*);*/
        if(courseModelList.get(position).getSalePrice().equals("0.00")){
            holder.price.setText("₹"+courseModelList.get(position).getCost()+"/-");
            holder.cutedPrice.setVisibility(View.INVISIBLE);
            holder.cuttedView.setVisibility(View.INVISIBLE);
        }else {
            holder.price.setText("₹"+courseModelList.get(position).getSalePrice()+"/-");
            holder.cutedPrice.setText("₹"+courseModelList.get(position).getCost()+"/-");
        }

        holder.itemView.setOnClickListener(v -> {
            saveCourseDetails(courseModelList.get(position));
            Intent courseDetailsIntent = new Intent(context, CourseDetailsActivity.class);
            context.startActivity(courseDetailsIntent);
        });

    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title,price,cutedPrice,startedDate;
        private View cuttedView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.course_image);
            title = itemView.findViewById(R.id.course_title);
            price = itemView.findViewById(R.id.course_price);
            cutedPrice = itemView.findViewById(R.id.cutted_price);
            startedDate = itemView.findViewById(R.id.started_date);
            cuttedView = itemView.findViewById(R.id.view_cutted);
        }
    }
}

