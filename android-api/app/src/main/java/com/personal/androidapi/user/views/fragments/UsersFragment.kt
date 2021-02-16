package com.personal.androidapi.user.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.personal.androidapi.R
import com.personal.androidapi.databinding.UsersFragmentBinding
import com.personal.androidapi.gateways.commons.HttpRequestQueue
import com.personal.androidapi.user.viewmodels.UsersViewModel

class UsersFragment(private val viewModel: UsersViewModel) : Fragment(R.layout.users_fragment) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: UsersFragmentBinding = UsersFragmentBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.recyclerViewUsersList.adapter = 

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUsers(view)
    }

    private fun getUsers(view: View) {
        val txUsers: TextView = view.findViewById(R.id.cast_notification_id)
        val url = "http://172.18.26.1:8080/user/all"
//        val url = "http://172.18.0.1:8080/user/all"

        val jsonObjectRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                txUsers.text = response.toString()
            },
            { error ->
                txUsers.text = "That didn't work! $error"
            })

        HttpRequestQueue.getInstance(view.context).add(jsonObjectRequest)
    }
}