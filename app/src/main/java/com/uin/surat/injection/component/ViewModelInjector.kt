package com.uin.surat.injection.component

import com.uin.surat.injection.module.NetworkModule
import com.uin.surat.ui.inbox.dinas.InboxDinasViewModel
import com.uin.surat.ui.inbox.mail.MailViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified InboxDinasViewModel.
     * @param InboxDinasViewModel InboxDinasViewModel in which to inject the dependencies
     */

    fun inject(inboxDinasViewModel: InboxDinasViewModel)

    fun inject(mailViewModel: MailViewModel)

    @Component.Builder
    interface Builder{
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
