package com.example.universityofyogyakarta

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class University(
    val name:String,
    val description: String,
    val photo: String
) : Parcelable
