

package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Implement click event.
 * - Alt + Enter na SplashActivity for implement all menbers
 */
class SplashActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * Create a new package and a new Kotlin File
     *
     */

    private lateinit var mSecurityPreferences: SecurityPreferences //lateinit because because don't have context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /**
         * The context only starts after the two lines above.
         */
        mSecurityPreferences = SecurityPreferences(this) //start the context

        /**
         * Code to remove supportActionBar
         */
        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener(this)
        verifyName()
    }


    /**
     * Dealing with which button to press
     */

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave){
            handleSave()
        }

    }


    /**
     * Checks if a saved name already exists.
     * If it exists, it navigates straight to MainActivity
     */
    private fun verifyName(){
        val name= mSecurityPreferences.getString(MotivationConstants.Key.PERSON_NAME)
        if (name != ""){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }


    /**
     * Checks if the name has been filled
     */
    private fun handleSave(){

        val name = editName.text.toString()

        if(name != ""){
            mSecurityPreferences.storeString(MotivationConstants.Key.PERSON_NAME, name) //reference the MotivationConstats class and the "name" key
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else{
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
        }

    }
}
