package br.com.washi.login.ktx

import br.com.washi.util.Result
import java.io.IOException

suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>, errorMessage: String): Result<T> =
    try {
        call.invoke()
    } catch (e: Exception) {
        Result.Error(IOException(errorMessage, e))
    }