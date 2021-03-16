package br.com.digitalhouse.desafioandroid.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafioandroid.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btnCadastrar.setOnClickListener {
            startActivity(Intent(this,CadastroActvity::class.java))
        }


    }
}