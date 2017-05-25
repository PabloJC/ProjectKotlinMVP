package com.mibaldi.proyectkotlin.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by mikelbalducieldiaz on 24/5/17.
 */
data class Prefix(@SerializedName("prefijo")val prefix : String, @SerializedName("codigoPais") val countryCode: String,
                  @SerializedName("idioma") val language: String, @SerializedName("orden")val order: String,
                  @SerializedName("formatoCorto") val shortFormat: String, @SerializedName("displayName") val displayName: String) {
}
data class PrefixList(@SerializedName("prefixs") val prefixs: List<Prefix>)