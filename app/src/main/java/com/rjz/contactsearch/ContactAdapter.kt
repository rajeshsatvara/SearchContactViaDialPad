package com.rjz.contactsearch

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rjz.contactsearch.ContactAdapter.MyViewHolder
import com.rjz.contactsearch.databinding.ItemContactBinding


class ContactAdapter(private var nameList: ArrayList<Contact>) :
    RecyclerView.Adapter<MyViewHolder>() {

    private var searchedText: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemTodayCheckpointListBinding = DataBindingUtil.inflate<ItemContactBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_contact,
            parent,
            false
        )
        return MyViewHolder(itemTodayCheckpointListBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contact = nameList[position]
        holder.itemContactBinding.txtName.text = contact.name
        holder.itemContactBinding.txtPhn.text = contact.phoneNumber
        try {
            holder.itemContactBinding.tvContact.text = contact.name[0].toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            // check phone number
            val index = Util.digitsOnly(contact.phoneNumber).indexOf(searchedText)
            if (index >= 0) {
                try {
                    val span = SpannableString(contact.phoneNumber)
                    span.setSpan(
                        ForegroundColorSpan(Color.RED),
                        index,
                        index + searchedText.length,
                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                    )
                    holder.itemContactBinding.txtPhn.text = span
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    fun updateList(list: ArrayList<Contact>, onlyDigit: String) {
        nameList = ArrayList()
        nameList.addAll(list)
        searchedText = onlyDigit
        notifyDataSetChanged()
    }

    inner class MyViewHolder(var itemContactBinding: ItemContactBinding) : RecyclerView.ViewHolder(
        itemContactBinding.root
    )
}