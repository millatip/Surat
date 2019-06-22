package com.uin.surat.ui.inbox.dinas

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uin.surat.R
import com.uin.surat.base.BaseViewModel
import com.uin.surat.models.Surat
import com.uin.surat.network.MailApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.math.log

class InboxDinasViewModel: BaseViewModel(){

    @Inject
    lateinit var mailApi: MailApi

    val inboxMailListAdapter: InboxDinasAdapter = InboxDinasAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadMails() }

    private lateinit var subscription: Disposable

    init {
        loadMails()
    }

    private fun loadMails(){
        subscription = mailApi.getMails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{onRetrieveMailListStart()}
            .doOnTerminate{onRetrieveMailListFinish()}
            .subscribe(
                {result -> onRetrieveMailListSuccess(result)},
                {onRetrieveMailListError()}
            )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrieveMailListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveMailListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveMailListSuccess(mailList: List<Surat>){
        inboxMailListAdapter.updateMailList(mailList)
        Log.i("InboxDinasViewModel", mailList.toString())
    }

    private fun onRetrieveMailListError(){
        errorMessage.value = R.string.post_error
//        Log.i("InboxDinasViewModel", mailList.toString())
        Log.INFO
    }

}
