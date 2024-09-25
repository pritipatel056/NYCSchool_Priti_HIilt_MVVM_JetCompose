package com.example.a20240925_priti_nycchool.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.example.a20240924_pritipatel_nycschools.model.SchoolModel
import com.example.a20240925_priti_nycchool.viewModel.SchoolViewModel
import java.lang.reflect.Modifier


@Composable
fun schoolDetailsScreen (viewModel: SchoolViewModel){
    val  schoolDetails by viewModel.schoolList.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchSchoolDetails()
    }

    Column {
        if(schoolDetails == null ){
            Text(text = "Loading")
        }
        else{
            schoolItem(schoolDetails!!)
        }
    }
}

@Composable
fun schoolItem(schoolItem:List<SchoolModel>){
    Card(
        modifier= androidx.compose.ui.Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        Column( modifier = androidx.compose.ui.Modifier
            .padding(16.dp)
            .fillMaxWidth()) {

Text(text = schoolItem[1].school_name)
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
            Text(text = schoolItem[1].ell_programs)
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
            Text(text = schoolItem[1].program1)


        }

    }
}