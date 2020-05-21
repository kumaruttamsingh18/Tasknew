package com.uttam.task.model.AllCourses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseModel {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("is_paid")
    @Expose
    private int isPaid;
    @SerializedName("cost")
    @Expose
    private String cost;
    @SerializedName("validity")
    @Expose
    private int validity;
    @SerializedName("total_items")
    @Expose
    private int totalItems;
    @SerializedName("lms_category_id")
    @Expose
    private int lmsCategoryId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("record_updated_by")
    @Expose
    private int recordUpdatedBy;
    @SerializedName("show_in_front")
    @Expose
    private int showInFront;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_popular")
    @Expose
    private Object isPopular;
    @SerializedName("course_duration")
    @Expose
    private Object courseDuration;
    @SerializedName("job_post_cover")
    @Expose
    private String jobPostCover;
    @SerializedName("syllabus")
    @Expose
    private String syllabus;
    @SerializedName("backgroundimage")
    @Expose
    private String backgroundimage;
    @SerializedName("mobile_app_background")
    @Expose
    private String mobileAppBackground;
    @SerializedName("mobile_faculty")
    @Expose
    private String mobileFaculty;
    @SerializedName("teachers")
    @Expose
    private Object teachers;
    @SerializedName("availability_on")
    @Expose
    private String availabilityOn;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sale_end_date")
    @Expose
    private String saleEndDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getLmsCategoryId() {
        return lmsCategoryId;
    }

    public void setLmsCategoryId(int lmsCategoryId) {
        this.lmsCategoryId = lmsCategoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getRecordUpdatedBy() {
        return recordUpdatedBy;
    }

    public void setRecordUpdatedBy(int recordUpdatedBy) {
        this.recordUpdatedBy = recordUpdatedBy;
    }

    public int getShowInFront() {
        return showInFront;
    }

    public void setShowInFront(int showInFront) {
        this.showInFront = showInFront;
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

    public Object getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(Object isPopular) {
        this.isPopular = isPopular;
    }

    public Object getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Object courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getJobPostCover() {
        return jobPostCover;
    }

    public void setJobPostCover(String jobPostCover) {
        this.jobPostCover = jobPostCover;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getBackgroundimage() {
        return backgroundimage;
    }

    public void setBackgroundimage(String backgroundimage) {
        this.backgroundimage = backgroundimage;
    }

    public String getMobileAppBackground() {
        return mobileAppBackground;
    }

    public void setMobileAppBackground(String mobileAppBackground) {
        this.mobileAppBackground = mobileAppBackground;
    }

    public String getMobileFaculty() {
        return mobileFaculty;
    }

    public void setMobileFaculty(String mobileFaculty) {
        this.mobileFaculty = mobileFaculty;
    }

    public Object getTeachers() {
        return teachers;
    }

    public void setTeachers(Object teachers) {
        this.teachers = teachers;
    }

    public String getAvailabilityOn() {
        return availabilityOn;
    }

    public void setAvailabilityOn(String availabilityOn) {
        this.availabilityOn = availabilityOn;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(String saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

}