package com.example.kotlinbottomnavsample.data.remote.interfaces

import com.example.kotlinbottomnavsample.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface UserEndpoints {

    @GET("users")
    fun getUsers(): Observable<User>

}