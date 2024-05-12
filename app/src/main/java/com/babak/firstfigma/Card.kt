package com.babak.firstfigma
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(val name:String,@DrawableRes val rate:Int,val newPrice:Double,val oldPrice:Double,val sale:Boolean,@DrawableRes val image:Int):Parcelable
