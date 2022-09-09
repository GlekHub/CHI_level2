package com.example.chi_level2.model

import android.annotation.SuppressLint
import androidx.annotation.BoolRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

@SuppressLint("SupportAnnotationUsage")
data class Students(
    @StringRes val nameResourceId: Int,
    @IntegerRes val ageResourceId: Int,
    @BoolRes val booleanResourceId: Boolean
)
