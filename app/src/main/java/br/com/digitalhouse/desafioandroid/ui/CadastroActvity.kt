package br.com.digitalhouse.desafioandroid.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.digitalhouse.desafioandroid.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        btnCadastro.setOnClickListener {
            when{
                edtNome.text!!.isEmpty() || edtvEmail.text!!.isEmpty() || edtCadastroSenha.text!!.isEmpty() || edtConfirmSenha.text!!.isEmpty() -> {
                    Toast.makeText(this,"Alguns campos estão vazios", Toast.LENGTH_LONG).show()
                }
                edtCadastroSenha.text.toString() != edtConfirmSenha.text.toString() -> {
                    Toast.makeText(this, "A senha não confere", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this, "Usuário criado com sucesso", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }

        ivBackCadastro.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}