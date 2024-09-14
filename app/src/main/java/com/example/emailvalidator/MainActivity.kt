package com.example.emailvalidator

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.emailvalidator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var button: Button
    lateinit var emailField: EditText
    lateinit var passwordField: EditText
    var emailToggle = false
    var passwordToggle = false
    var buttonToggle = false
    lateinit var emailText: String
    lateinit var passwordText: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        button = binding.validateButton
        emailField = binding.textViewMail
        passwordField = binding.textViewPassword
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        onEmailTextFieldChanged()
        onPasswordTextFieldChanged()
        if (emailToggle && passwordToggle) {
            button.setBackgroundColor(Color.CYAN)
        }
        else {
            button.setBackgroundColor(Color.RED)
        }

        // Куда его такого совать?...
        val watcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if ((emailField.text.toString() == emailText) && (passwordField.toString() == passwordText)) {
                    button.setBackgroundColor(Color.CYAN)
                }
            }
        }
    }

    fun onEmailTextFieldChanged() {
        emailField.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
                // Здесь вы получаете текущий текст, введённый пользователем
                val enteredText = charSequence.toString()
                val isValid = Patterns.EMAIL_ADDRESS.matcher(enteredText).matches()
                if (isValid)
                    {
                        emailToggle = true
                    }
                else
                    {
                        emailToggle = false
                    }
                emailText = charSequence.toString()
            }

            override fun afterTextChanged(editable: Editable) {
                // Здесь вы можете выполнить дополнительные действия после изменения текста
            }
        }
        )
    }

    fun onPasswordTextFieldChanged() {
        passwordField.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
                // Здесь вы получаете текущий текст, введённый пользователем
                if (charSequence.length >= 8)
                {
                    passwordToggle = true
                }
                else
                {
                    passwordToggle = false
                }
                passwordText = charSequence.toString()
            }

            override fun afterTextChanged(editable: Editable) {
                // Здесь вы можете выполнить дополнительные действия после изменения текста
            }
        }
        )
    }
}