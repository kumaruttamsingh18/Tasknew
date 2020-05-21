package com.uttam.task.rest;


import com.uttam.task.model.AllCourses.AllCourseModel;
import com.uttam.task.model.AllTeacher.AllTeacherModel;
import com.uttam.task.model.SubjectCourse.Subject;
import com.uttam.task.model.videoCourse.VideoCourse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("course-all-subject")
    Call<Subject> ShowAllSubject(
            @Field("course_id") String id);

    @FormUrlEncoded
    @POST("all-course-video")
    Call<VideoCourse> ShowAllVideo(
            @Field("course_id") String id);

    @GET("allcourses")
    Call<AllCourseModel> ShowAllCourse();

    @FormUrlEncoded
    @POST("course-all-teacher")
    Call<AllTeacherModel> ShowAllTeacher(
            @Field("course_id") String id);
}

