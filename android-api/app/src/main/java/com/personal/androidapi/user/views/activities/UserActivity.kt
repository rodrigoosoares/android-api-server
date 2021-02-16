package com.personal.androidapi.user.views.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.personal.androidapi.R
import com.personal.androidapi.gateways.commons.HttpRequestQueue
import com.personal.androidapi.user.viewmodels.UsersViewModel
import com.personal.androidapi.user.views.activities.extensions.addFragmentTo
import com.personal.androidapi.user.views.fragments.UsersFragment

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        addFragmentTo(R.id.fragment_container_view_user_fragment, createFragment())
    }

    private fun createFragment(): UsersFragment {
        return UsersFragment(createViewModel())
    }

    private fun createViewModel(): UsersViewModel {
        return UsersViewModel()
    }

}