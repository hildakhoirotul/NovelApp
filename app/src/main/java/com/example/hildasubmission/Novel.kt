package com.example.hildasubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Novel(
    val name: String,
    val description: String,
    val photo: Int,
    val isbn: String? = "",
    val publisher: String? = "",
    val page: String? = "",
    val size: String? = ""
) : Parcelable
