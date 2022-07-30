package com.example.grocery.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(val name: String, val image: Int, val weight: String, val price: Int):Parcelable
