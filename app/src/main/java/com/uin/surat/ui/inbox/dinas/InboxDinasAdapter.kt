package com.uin.surat.ui.inbox.dinas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.uin.surat.R
import com.uin.surat.databinding.MailItemBinding
import com.uin.surat.models.Surat
import com.uin.surat.ui.inbox.mail.MailViewModel

class InboxDinasAdapter  : RecyclerView.Adapter<InboxDinasAdapter.ViewHolder>(){

    private lateinit var mailList: List<Surat>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val binding: MailItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.mail_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(::mailList.isInitialized) mailList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mailList[position])
    }

    fun updateMailList(mailList: List<Surat>){
        this.mailList = mailList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: MailItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val viewModel = MailViewModel()

        fun bind(mail: Surat){
            viewModel.bind(mail)
            binding.viewModel = viewModel
        }
    }

}
