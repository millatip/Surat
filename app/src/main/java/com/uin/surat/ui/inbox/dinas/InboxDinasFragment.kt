package com.uin.surat.ui.inbox.dinas


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.uin.surat.R
import com.uin.surat.databinding.FragmentInboxDinasBinding


class InboxDinasFragment : Fragment() {

    private lateinit var binding: FragmentInboxDinasBinding
    private lateinit var viewModel: InboxDinasViewModel
    private var errorSnackbar:Snackbar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_inbox_dinas, container, false)

        viewModel = ViewModelProviders.of(this).get(InboxDinasViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if (errorMessage != null) showError(errorMessage) else hideError()
        })

        binding.rvDinasInbox.layoutManager = LinearLayoutManager(context)
        binding.viewModel = viewModel


        return binding.root
    }

     private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }

    /*private fun displayEmails(emails: List<Surat>){
        swipeRefreshLayout.isRefreshing = false
        val adapter = InboxDinasAdapter(emails)
        rvDinasInbox.adapter = adapter
        rvDinasInbox.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
    }*/


}
