package com.uin.surat.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.uin.surat.R
import com.uin.surat.ui.inbox.InboxFragment
import com.uin.surat.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavListener()
        setupViewPager(viewPager)
    }

    private fun bottomNavListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_inbox -> viewPager.currentItem = 0
                R.id.action_outbox -> viewPager.currentItem = 1
                R.id.action_profile -> viewPager.currentItem = 2
            }
            true
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(InboxFragment(), "Inbox")
        viewPager.adapter = adapter
    }
}
