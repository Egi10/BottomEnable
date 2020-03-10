package com.egi10.bottomenable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail.addTextChangedListener(textWatcher)
        etPassword.addTextChangedListener(textWatcher)
    }

    fun updateBottom() {
        btnPassword.isEnabled = etEmail.text.isNotEmpty() &&
                etPassword.text.length >= 6
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            updateBottom()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (etEmail.text.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {
                etEmail.error = "Email Anda Belum Benar"
            }

            if (etPassword.text.length < 6) {
                etPassword.error = "Password Tidak Boleh Kurang Dari 6"
            }
        }

    }
}
