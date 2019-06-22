package com.uin.surat.base

import androidx.lifecycle.ViewModel
import com.uin.surat.injection.component.DaggerViewModelInjector
import com.uin.surat.injection.component.ViewModelInjector
import com.uin.surat.injection.module.NetworkModule
import com.uin.surat.ui.inbox.dinas.InboxDinasViewModel
import com.uin.surat.ui.inbox.mail.MailViewModel

abstract class BaseViewModel: ViewModel()  {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */

    private fun inject(){
        when(this){
            is InboxDinasViewModel -> injector.inject(this)
            is MailViewModel -> injector.inject(this)
        }
    }
}
