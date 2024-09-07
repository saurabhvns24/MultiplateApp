package com.ecommerce.sharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.resocoder.mvvmbasicstut.ui.quotes.PhoneBookViewModel
import com.resocoder.mvvmbasicstut.utilities.InjectorUtils

class ListFragment : Fragment(), ClickListener {
    lateinit var recyclerview: RecyclerView
    lateinit var adapter: CustomAdapter
    lateinit var add: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview = view.findViewById(R.id.recyclerview)
        add = view.findViewById(R.id.add)
        recyclerview.layoutManager = LinearLayoutManager(context)
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(PhoneBookViewModel::class.java)
        viewModel.getQuotes().observe(viewLifecycleOwner, Observer {
            adapter = CustomAdapter(it,this)
            recyclerview.adapter = adapter
        })
        add.setOnClickListener {
            val communicator = activity as Communicator
            communicator.switchBetweenFragment(FormFragment())
        }
    }

    override fun onClickItem(position: Int, updateFlag: Boolean) {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(PhoneBookViewModel::class.java)
        viewModel.updateFlagWithPosition(position, updateFlag)
       /*  viewModel.getQuotes().observe(viewLifecycleOwner, Observer {
             first_name.setText(it.get(position).firstname)
             email.setText(it.get(position).email)
             last_name.setText(it.get(position).lastname)
             phone.setText(it.get(position).phone)
         })
        */
        val communicator = activity as Communicator
        communicator.switchBetweenFragment(FormFragment())
    }
}