package com.aryanakul31.black.views

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aryanakul31.black.R
import com.aryanakul31.black.databinding.ActivityMainBinding
import com.aryanakul31.black.viewmodels.MainActivityVM
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityVM

    companion object {
        lateinit var context: WeakReference<Context>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityVM::class.java)
        binding.viewModel = viewModel

        context = WeakReference(this)
    }
}