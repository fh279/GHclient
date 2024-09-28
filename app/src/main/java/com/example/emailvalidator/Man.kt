package com.example.emailvalidator

import android.util.Log

class Man(val name: String, val surname: String): ManBehavoiur {
    private val TAG = Man::class.java.simpleName
    override fun getCloth(degrees: Int) {
        if (degrees > 200) {
            Log.e(TAG, "It's warm outside")
        } else {
            Log.e(TAG, "It's cold outside")
        }
    }

}