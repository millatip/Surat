package com.uin.surat.network

import com.uin.surat.models.Surat
import io.reactivex.Observable
import retrofit2.http.GET

interface MailApi {

    @GET("/millatip/surat/mails")
    fun getMails(): Observable<List<Surat>>
}
