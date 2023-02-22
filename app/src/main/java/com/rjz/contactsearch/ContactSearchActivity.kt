package com.rjz.contactsearch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.rjz.contactsearch.databinding.ActivityContactSearchBinding
import java.util.stream.Collectors

class ContactSearchActivity : AppCompatActivity() {

    private var binding: ActivityContactSearchBinding? = null
    private var list = ArrayList<Contact>()
    private var adapter: ContactAdapter? = null
    private var hashmapSort = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactSearchBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViews()
        initListeners()
        hashmapSort = Util.getRegData()
    }

    private fun initViews() {
        list = DummyData.getDummyData()
        adapter = ContactAdapter(list)
        binding?.rvList?.adapter = adapter
    }

    private fun initListeners() {
        binding?.etEnterName?.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // no-op
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // no-op
            }

            override fun afterTextChanged(s: Editable) {
                var regEx = ""
                s.toString().forEach {
                    regEx += hashmapSort[it.toString() + ""]
                }
                filterData(".*$regEx.*$",s.toString())
            }
        })
    }

    private fun filterData(finalRegEx: String , onlyDigit : String) {
        (list.stream().filter { contact ->
            Util.isContactMatched(contact, finalRegEx,onlyDigit)
        }.collect(Collectors.toList()) as ArrayList<Contact>).let {
            adapter?.updateList(it,onlyDigit)
        }
    }
}