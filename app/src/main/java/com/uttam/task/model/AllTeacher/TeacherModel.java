package com.uttam.task.model.AllTeacher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeacherModel {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("experience")
    @Expose
    private String experience;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("expertise_in")
    @Expose
    private String expertiseIn;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("qualified_exams")
    @Expose
    private String qualifiedExams;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_by")
    @Expose
    private int createdBy;
    @SerializedName("updated_by")
    @Expose
    private int updatedBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExpertiseIn() {
        return expertiseIn;
    }

    public void setExpertiseIn(String expertiseIn) {
        this.expertiseIn = expertiseIn;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getQualifiedExams() {
        return qualifiedExams;
    }

    public void setQualifiedExams(String qualifiedExams) {
        this.qualifiedExams = qualifiedExams;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
