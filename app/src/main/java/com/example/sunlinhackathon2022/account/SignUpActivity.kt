package com.example.sunlinhackathon2022.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import com.example.sunlinhackathon2022.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    var email = false
    var passwordLength = false
    var passwordCoincide = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        edTextCheck(binding.emailEdittext, "emil")
        edTextCheck(binding.passwordEdittext, "passwordLength")
        edTextCheck(binding.passwordEdittext, "passwordCoincide")

        binding.signButton.setOnClickListener {
            if(informationCheck()){
                binding.emailEdittext.text
                binding.passwordEdittext.text
                binding.nameEdittext.text
            }else{
                Toast.makeText(this,"형식을 확인해주세요",Toast.LENGTH_LONG).show()
            }


        }
    }


    private fun emailCheck(email: String) = email.contains("@")

    private fun passwordLengthCheck(password: String) = password.length >= 7

    private fun passwordCheck(password: String, passwordCheck: String) = passwordCheck == password

    private fun edTextCheck(editText: EditText, type: String) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                when (type) {
                    "emil" -> {
                        email = emailCheck(binding.emailEdittext.text.toString())
                        if(!email) binding.emailTextLayout.error="이메일 형식을 확인해주세요"
                        else binding.emailTextLayout.isErrorEnabled=false
                    }

                    "passwordLength" -> {
                        passwordLength = passwordLengthCheck(binding.passwordEdittext.text.toString())
                        if(!passwordLength) binding.passwordEdittext.error="비밀번호의 길이를 7자 이상으로 설정해주세요"
                        else binding.passwordTextLayout.isErrorEnabled=false
                    }
                    "passwordCoincide" -> {
                        passwordCoincide = passwordCheck(binding.passwordEdittext.text.toString(), binding.passwordCheckEdittext.text.toString())
                        if(!passwordCoincide) binding.passwordCheckTextLayout.error="비밀번호가 일치하지않습니다"
                        else binding.passwordCheckTextLayout.isErrorEnabled=false
                    }
                }

            }

        })

    }
    private fun informationCheck()=email&&passwordLength&&passwordCoincide&&binding.nameEdittext.text.toString().length>1

}