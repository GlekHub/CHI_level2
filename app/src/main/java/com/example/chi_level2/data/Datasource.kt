package com.example.chi_level2.data

import android.annotation.SuppressLint
import com.example.chi_level2.R
import com.example.chi_level2.model.Students

class Datasource {
    @SuppressLint("ResourceType")
    fun loadItemView(): List<Students> {
        return listOf(
            Students(R.string.name1, R.string.age1, false),
            Students(R.string.name2, R.string.age2,false),
            Students(R.string.name3, R.string.age3,false),
            Students(R.string.name4, R.string.age4, false),
            Students(R.string.name5, R.string.age5, false),
            Students(R.string.name6, R.string.age6, false),
            Students(R.string.name7, R.string.age7, false)
        )
    }
}