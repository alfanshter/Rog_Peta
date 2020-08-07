package com.alfanshter.udinlelangfix.Session

import android.content.Context
import android.content.SharedPreferences

class SessionManager(private val context: Context?) {
    val privateMode = 0
    val privateName ="login"
    var Pref : SharedPreferences?=context?.getSharedPreferences(privateName,privateMode)
    var editor : SharedPreferences.Editor?=Pref?.edit()

    private val nama = "nama"
    fun setnama(check:String?)
    {
        editor?.putString(nama,check)
        editor?.commit()
    }

    fun getnama():String?
    {
        return Pref?.getString(nama,"")
    }



    private val lokasi = "lokasi"
    fun setlokasi(check:String?)
    {
        editor?.putString(lokasi,check)
        editor?.commit()
    }

    fun getlokasi():String?
    {
        return Pref?.getString(lokasi,"")
    }

    private val latitude = "latitude"
    fun setlatitude(check:String?)
    {
        editor?.putString(latitude,check)
        editor?.commit()
    }

    fun getlatitude():String?
    {
        return Pref?.getString(latitude,"")
    }

    private val longitude = "longitude"
    fun setlongitude(check:String?)
    {
        editor?.putString(longitude,check)
        editor?.commit()
    }

    fun getlongitude():String?
    {
        return Pref?.getString(longitude,"")
    }



}