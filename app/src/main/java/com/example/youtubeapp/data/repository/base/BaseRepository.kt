package com.example.youtubeapp.data.repository.base

import androidx.lifecycle.liveData
import com.example.youtubeapp.utils.Either
import kotlinx.coroutines.Dispatchers
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(request()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}