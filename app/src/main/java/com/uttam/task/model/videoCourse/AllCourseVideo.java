package com.uttam.task.model.videoCourse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCourseVideo {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("poster_image")
    @Expose
    private String posterImage;
    @SerializedName("ppt")
    @Expose
    private Object ppt;
    @SerializedName("subject_id")
    @Expose
    private int subjectId;
    @SerializedName("subject_name")
    @Expose
    private String subjectName;
    @SerializedName("topic_name")
    @Expose
    private String topicName;
    @SerializedName("teacher")
    @Expose
    private String teacher;
    @SerializedName("scheduled_for")
    @Expose
    private String scheduledFor;
    @SerializedName("expiration")
    @Expose
    private String expiration;
    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("is_live")
    @Expose
    private String isLive;
    @SerializedName("is_demo")
    @Expose
    private String isDemo;
    @SerializedName("is_url")
    @Expose
    private int isUrl;
    @SerializedName("file_path")
    @Expose
    private String filePath;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("enable_chat")
    @Expose
    private int enableChat;
    @SerializedName("chat_for")
    @Expose
    private int chatFor;
    @SerializedName("record_updated_by")
    @Expose
    private int recordUpdatedBy;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("topic_id")
    @Expose
    private int topicId;
    @SerializedName("document")
    @Expose
    private String document;
    @SerializedName("document_thumbnail")
    @Expose
    private String documentThumbnail;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public Object getPpt() {
        return ppt;
    }

    public void setPpt(Object ppt) {
        this.ppt = ppt;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getScheduledFor() {
        return scheduledFor;
    }

    public void setScheduledFor(String scheduledFor) {
        this.scheduledFor = scheduledFor;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getIsLive() {
        return isLive;
    }

    public void setIsLive(String isLive) {
        this.isLive = isLive;
    }

    public String getIsDemo() {
        return isDemo;
    }

    public void setIsDemo(String isDemo) {
        this.isDemo = isDemo;
    }

    public int getIsUrl() {
        return isUrl;
    }

    public void setIsUrl(int isUrl) {
        this.isUrl = isUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnableChat() {
        return enableChat;
    }

    public void setEnableChat(int enableChat) {
        this.enableChat = enableChat;
    }

    public int getChatFor() {
        return chatFor;
    }

    public void setChatFor(int chatFor) {
        this.chatFor = chatFor;
    }

    public int getRecordUpdatedBy() {
        return recordUpdatedBy;
    }

    public void setRecordUpdatedBy(int recordUpdatedBy) {
        this.recordUpdatedBy = recordUpdatedBy;
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

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentThumbnail() {
        return documentThumbnail;
    }

    public void setDocumentThumbnail(String documentThumbnail) {
        this.documentThumbnail = documentThumbnail;
    }

}
