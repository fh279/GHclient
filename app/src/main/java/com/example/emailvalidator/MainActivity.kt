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
        binding.passwordTExtInputEditText.doAfterTextChanged { validateEditTexts() }
        binding.emailEditText.doAfterTextChanged { validateEditTexts() }

        /*val weatherStation = WeatherStation()
        weatherStation.addMan(Man(name = "Алексей", surname = "Гладков"))
        weatherStation.addMan(Man(name = "Иван", surname = "Иванов"))
        weatherStation.addMan(Man(name = "Тоня", surname = "Старк"))
        weatherStation.addMan(Man(name = "Сара", surname = "Керриган"))

        weatherStation.updateWeather()*/
    }

    private fun validateEditTexts() {
        val isEmailValidated =
            // binding.textViewMail.editText?.text?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() }
            /*binding.emailEditText.text.matchesPatterns.*/
            Patterns.EMAIL_ADDRESS.matcher(binding.emailEditText.text).matches()

        val pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}\$"

        val isPasswordValidated = Regex(pattern).matches(binding.passwordTExtInputEditText.text.toString())

        if (isEmailValidated && isPasswordValidated) {
            binding.validateButton.setBackgroundColor(Color.CYAN)
        }
        else {
            binding.validateButton.setBackgroundColor(Color.GRAY)
        }
    }




}
