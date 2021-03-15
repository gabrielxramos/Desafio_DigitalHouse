package br.com.digitalhouse.desafioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.digitalhouse.desafioandroid.ui.MainActivity
import br.com.digitalhouse.desafioandroid.ui.Restaurante

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


//        Handler().postDelayed({
//            val mIntent = Intent(this, Restaurante::class.java)
//            startActivity(mIntent)
//            finish()
//        }, 3000)
    }
}