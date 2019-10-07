package br.com.washi.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    @SerializedName("codigo")
    val code: Int = 0,
    @SerializedName("nome")
    val name: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("senha")
    val password: String = "",
    @SerializedName("documento")
    val document: String = "",
    @SerializedName("telefone")
    val telephone: String = "",
    @SerializedName("endCep")
    val zone: String? = "",
    @SerializedName("endDescricao")
    val address: String? = "",
    @SerializedName("endNumero")
    val addressNumber: String? = "",
    @SerializedName("endBairro")
    val addressNeighborhood: String? = "",
    @SerializedName("endCidade")
    val addressCity: String? = "",
    @SerializedName("endEstado")
    val addressState: String? = ""
) : Parcelable