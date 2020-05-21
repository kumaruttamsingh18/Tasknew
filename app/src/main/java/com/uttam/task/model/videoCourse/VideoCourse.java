package com.uttam.task.model.videoCourse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoCourse {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("base_image_path")
    @Expose
    private String baseImagePath;
    @SerializedName("all-course-video")
    @Expose
    private List<AllCourseVideo> allCourseVideo = null;

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

    public List<AllCourseVideo> getAllCourseVideo() {
        return allCourseVideo;
    }

    public void setAllCourseVideo(List<AllCourseVideo> allCourseVideo) {
        this.allCourseVideo = allCourseVideo;
    }

}

