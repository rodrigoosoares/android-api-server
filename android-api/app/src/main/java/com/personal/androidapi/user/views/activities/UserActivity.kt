package com.personal.androidapi.user.views.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.personal.androidapi.R
import com.personal.androidapi.gateways.commons.HttpRequestQueue

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        getUsers()
    }

    private fun getUsers() {
        val txUsers: TextView = findViewById(R.id.tvUsers)

        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, "http://172.18.0.1:8080/user/all", null,
                { response ->
                    txUsers.text = response.toString()
                },
                { error ->
                    txUsers.text = "That didn't work! $error"
                })

        HttpRequestQueue.getInstance(this).add(jsonObjectRequest)
    }


}