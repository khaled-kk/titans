package com.example.titans

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private var mAuth: FirebaseAuth? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)
        val btn5 = findViewById<Button>(R.id.button5)
        mAuth = FirebaseAuth.getInstance();

        btn1.setOnClickListener {
            // Handler code here.
            val intent = Intent(this , VIDEO1::class.java)
            startActivity(intent);
        }


        btn2.setOnClickListener {
            // Handler code here.
            val intent = Intent(this , VIDEO2::class.java)
            startActivity(intent);
        }

        btn3.setOnClickListener {
            // Handler code here.
            val intent = Intent(this , VIDEO3::class.java)
            startActivity(intent);
        }

        btn4.setOnClickListener(){
            mAuth!!.signOut()
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this@MainActivity, "Logout Successful !", Toast.LENGTH_SHORT).show()

        }
        btn5.setOnClickListener {
            // Handler code here.
            val intent = Intent(this , VIDEO4::class.java)
            startActivity(intent);
        }











    }
}