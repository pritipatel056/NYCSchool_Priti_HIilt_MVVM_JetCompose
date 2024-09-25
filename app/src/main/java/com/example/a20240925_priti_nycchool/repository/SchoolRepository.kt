package com.example.a20240925_priti_nycchool.repository

import com.example.a20240924_pritipatel_nycschools.model.SchoolModel
import javax.inject.Inject

class SchoolRepository @Inject  constructor(  private val schoolService: SchoolService = RetrofitInstanceService.schoolService
) {

    suspend fun getSchoolDetails():List<SchoolModel>{
        return schoolService.getSchoolDetails()
    }
}