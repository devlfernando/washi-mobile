package br.com.washi.util

fun removeReaisFromString(cash: String): Double = cash.removePrefix("R$ ").toDouble()