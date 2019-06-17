package com.uin.surat.ui.inbox


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.uin.surat.R
import com.uin.surat.ui.inbox.dinas.InboxDinasFragment
import com.uin.surat.ui.inbox.personal.InboxPersonalFragment
import com.uin.surat.ui.inbox.tembusan.InboxTembusanFragment
import com.uin.surat.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_inbox.*

class InboxFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inbox, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupWithViewPager(viewPagerInbox)
        tabLayoutInbox.setupWithViewPager(viewPagerInbox)
//        setHasOptionsMenu(true)
    }

    private fun setupWithViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(InboxTembusanFragment(), "Tembusan")
        adapter.addFragment(InboxDinasFragment(), "Dinas")
        adapter.addFragment(InboxPersonalFragment(), "Personal")
        viewPager.adapter = adapter
    }


}
