package com.ecommerce.sharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.resocoder.mvvmbasicstut.ui.quotes.PhoneBookViewModel
import com.resocoder.mvvmbasicstut.utilities.InjectorUtils

class FormFragment : Fragment() {

    // to send message
    lateinit var btn: Button

    // to write message
    lateinit var first_name: EditText
    lateinit var last_name: EditText
    lateinit var email: EditText
    lateinit var phone: EditText
    var updateFlag: Boolean = false
    var position: Int = -1


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn = view.findViewById(R.id.button)
        first_name = view.findViewById(R.id.first_name)
        phone = view.findViewById(R.id.phone)
        email = view.findViewById(R.id.email)
        last_name = view.findViewById(R.id.last_name)

        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(PhoneBookViewModel::class.java)

        viewModel.getPosition().observe(viewLifecycleOwner, Observer {
            position = it
        })

        viewModel.getFlag().observe(viewLifecycleOwner, Observer {
            updateFlag = it
        })

        viewModel.getQuotes().observe(viewLifecycleOwner, Observer {
            if (position != -1) {
                refreshScreen(it.get(position))
            }
        })

        btn.setOnClickListener {
            val phoneModel = PhoneModel(
                first_name.text.toString(),
                email.text.toString(),
                last_name.text.toString(),
                phone.text.toString()
            )
            if (updateFlag) {
                viewModel.update(position, phoneModel)
            } else {
                viewModel.addQuote(phoneModel)
            }
            first_name.setText("")
            email.setText("")
            last_name.setText("")
            phone.setText("")


//            model.list.value?.add(phoneModel)
            val communicator = activity as Communicator
            communicator.switchBetweenFragment(ListFragment())
        }
    }

    private fun refreshScreen(phoneModel: PhoneModel) {
        first_name.setText(phoneModel.firstname)
        email.setText(phoneModel.email)
        last_name.setText(phoneModel.lastname)
        phone.setText(phoneModel.phone)
    }


}