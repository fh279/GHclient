package com.example.emailvalidator

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.example.emailvalidator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textViewPassword.doAfterTextChanged { validateEditTexts() }
        binding.textViewMail.doAfterTextChanged { validateEditTexts() }
    }

    private fun validateEditTexts() {
        val isEmailValidated = Patterns.EMAIL_ADDRESS.matcher(binding.textViewMail.text).matches()
        val pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"
        val isPasswordValidated = binding.textViewPassword.text.toString().matches(Regex(pattern))
        if (isEmailValidated && isPasswordValidated) {
            binding.validateButton.setBackgroundColor(Color.CYAN)
        }
        else {
            binding.validateButton.setBackgroundColor(Color.GRAY)
        }
    }
}