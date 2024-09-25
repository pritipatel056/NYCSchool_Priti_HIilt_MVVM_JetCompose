package com.example.a20240925_priti_nycchool.repository

import com.example.a20240924_pritipatel_nycschools.model.SchoolModel
import retrofit2.http.GET

interface SchoolService {
    @GET("/resource/s3k6-pzi2.json")
    suspend fun getSchoolDetails():List<SchoolModel>
}