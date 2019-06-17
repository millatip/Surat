package com.uin.surat.ui.inbox.dinas


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.uin.surat.R
import com.uin.surat.models.Surat
import kotlinx.android.synthetic.main.fragment_inbox_dinas.*
import kotlinx.android.synthetic.main.fragment_inbox_dinas.swipeRefreshLayout


class InboxDinasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inbox_dinas, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        displayEmails(emails = )
    }

    private fun displayEmails(emails: List<Surat>){
        swipeRefreshLayout.isRefreshing = false
        val adapter = InboxDinasAdapter(emails)
        rvDinasInbox.adapter = adapter
        rvDinasInbox.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
    }


}
