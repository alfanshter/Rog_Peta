package com.alfanshter.aplikasiiska.Model

class AmbilData {

    /// MOdel class
    var tinggi: String? = null
    var latitude: String? = null
    var longitude: String? = null
    var status : String? = null
    var warna : String? = null
    constructor() {

    }

    constructor(

        tinggi: String?,
        status : String?,

        latitude: String?,
        longitude: String?,
        warna : String?

    ) {
        this.tinggi = tinggi
        this.latitude = latitude
        this.longitude = longitude
        this.status = status
        this.warna = warna
    }
}