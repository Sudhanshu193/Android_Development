package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            nickName(it)// it is used for view address
//        }
        binding.doneButton.setOnClickListener {
            nickName(it)
        }
    }


    private fun nickName(view: View) {
//        val editText = findViewById<EditText>(R.id.nickName)
//        val nicknameTextView =findViewById<TextView>(R.id.nickname_text)

//        nicknameTextView.text =editText.text //referencing
//        editText.visibility = View.GONE
//        view.visibility=View.GONE
//        nicknameTextView.visibility=View.VISIBLE

        //after data binding
        binding.apply {
            nicknameText.text = binding.nickName.text
            invalidateAll()
            nickName.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}