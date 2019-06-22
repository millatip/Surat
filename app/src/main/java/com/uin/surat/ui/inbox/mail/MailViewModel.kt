package com.uin.surat.ui.inbox.mail

import androidx.lifecycle.MutableLiveData
import com.uin.surat.base.BaseViewModel
import com.uin.surat.models.Surat

class MailViewModel:BaseViewModel() {

    private val noSurat = MutableLiveData<String>()
    private val asalSurat = MutableLiveData<String>()
    private val perihal = MutableLiveData<String>()
    private val lampiran = MutableLiveData<String>()
    private val timeEmail = MutableLiveData<String>()
    private val dateEmail = MutableLiveData<String>()

    fun bind(mail: Surat){
        asalSurat.value = mail.asalSurat
        perihal.value = mail.perihal
        noSurat.value = mail.noSurat
        lampiran.value = mail.lampiran
        timeEmail.value = mail.tanggalMasuk
        dateEmail.value = mail.tanggalMasuk
    }

    fun getSender(): MutableLiveData<String>{
        return asalSurat
    }

    fun getPerihal(): MutableLiveData<String>{
        return  perihal
    }

    fun getLampiran(): MutableLiveData<String>{
        return lampiran
    }

    fun getMailTime(): MutableLiveData<String>{
        return  timeEmail
    }

    fun getMailDate(): MutableLiveData<String>{
        return  dateEmail
    }
}
