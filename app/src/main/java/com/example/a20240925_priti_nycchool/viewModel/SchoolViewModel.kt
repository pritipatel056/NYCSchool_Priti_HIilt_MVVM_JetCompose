package com.example.a20240925_priti_nycchool.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20240924_pritipatel_nycschools.model.SchoolModel
import com.example.a20240925_priti_nycchool.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(private val repository: SchoolRepository = SchoolRepository()):ViewModel() {

    private  val _schoolList = MutableLiveData<List<SchoolModel>>()
    val schoolList :LiveData<List<SchoolModel>> = _schoolList

    fun fetchSchoolDetails(){
        viewModelScope.launch {
            try {
                val school =repository.getSchoolDetails()
                Log.e("FetchSchoolDetails", _schoolList.value.toString())

            }catch (e:Exception){
                Log.e("FetchSchoolDetailsError",e.message.toString())

            }
        }
    }
}