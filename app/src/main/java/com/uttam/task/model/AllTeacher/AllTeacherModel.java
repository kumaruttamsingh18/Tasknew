package com.uttam.task.model.AllTeacher;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllTeacherModel {

    @SerializedName("subjects")
    @Expose
    private List<TeacherModel> teachers = null;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("baseImagepath")
    @Expose
    private String baseImagepath;
    @SerializedName("message")
    @Expose
    private String message;

    public List<TeacherModel> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherModel> teachers) {
        this.teachers = teachers;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBaseImagepath() {
        return baseImagepath;
    }

    public void setBaseImagepath(String baseImagepath) {
        this.baseImagepath = baseImagepath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

