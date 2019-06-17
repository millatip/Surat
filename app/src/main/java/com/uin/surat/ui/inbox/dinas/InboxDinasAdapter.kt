package com.uin.surat.ui.inbox.dinas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uin.surat.R
import com.uin.surat.models.Surat
import kotlinx.android.synthetic.main.mail_item.view.*

class InboxDinasAdapter (private  val emails: List<Surat>) : RecyclerView.Adapter<InboxDinasAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder (
        LayoutInflater.from(parent.context).inflate(
            R.layout.mail_item, parent, false
        )
    )

    override fun getItemCount(): Int = emails.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(emails[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(email : Surat){
            itemView.tvEmailSender.text = email.senderEmail
            itemView.tvEmailTitle.text = email.titleEmail
            itemView.tvEmailDetails.text = email.descriptionEmail
            itemView.tvEmailTime.text = email.dateEmail
        }
    }

}
