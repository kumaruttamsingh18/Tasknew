package com.uttam.task.model.AllCourses;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCourseModel {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("base_image_path")
    @Expose
    private String baseImagePath;
    @SerializedName("allcourses")
    @Expose
    private List<CourseModel> allcourses = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBaseImagePath() {
        return baseImagePath;
    }

    public void setBaseImagePath(String baseImagePath) {
        this.baseImagePath = baseImagePath;
    }

    public List<CourseModel> getAllcourses() {
        return allcourses;
    }

    public void setAllcourses(List<CourseModel> allcourses) {
        this.allcourses = allcourses;
    }

}
