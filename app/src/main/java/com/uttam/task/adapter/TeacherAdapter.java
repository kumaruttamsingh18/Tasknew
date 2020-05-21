package com.uttam.task.adapter;

import android.content.Context;
import android.content.Intent;
import android.transition.CircularPropagation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uttam.task.R;
import com.uttam.task.activity.CourseDetailsActivity;
import com.uttam.task.model.AllCourses.CourseModel;
import com.uttam.task.model.AllTeacher.TeacherModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.uttam.task.helper.Constants.SERIES_IMAGE_BASE_URL;
import static com.uttam.task.helper.Constants.TEACHER_IMAGE_BASE_URL;
import static com.uttam.task.utils.MyAppPreferences.saveCourseDetails;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private Context context;
    private List<TeacherModel> teacherModelList;

    public TeacherAdapter(Context context, List<TeacherModel> teacherModelList) {
        this.context = context;
        this.teacherModelList = teacherModelList;
    }
    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher, parent, false);
        return new TeacherViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return teacherModelList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        String filePath = TEACHER_IMAGE_BASE_URL + teacherModelList.get(position).getImage();
        Glide.with(context).load(filePath).placeholder(R.drawable.placeholder_small).into(holder.image);
        holder.name.setText(teacherModelList.get(position).getName());
        holder.subExp.setText(teacherModelList.get(position).getExpertiseIn()+" Expert("+teacherModelList.get(position).getExperience()+")");
        holder.qualification.setText(teacherModelList.get(position).getQualifiedExams());
        holder.about.setText(HtmlCompat.fromHtml(teacherModelList.get(position).getAbout(),HtmlCompat.FROM_HTML_MODE_COMPACT));
    }

    public class TeacherViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView image;
        private TextView name,subExp,qualification,about;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name_tv);
            subExp = itemView.findViewById(R.id.sub_exp_tv);
            qualification = itemView.findViewById(R.id.qualification_tv);
            about = itemView.findViewById(R.id.about_tv);
        }
    }
}

