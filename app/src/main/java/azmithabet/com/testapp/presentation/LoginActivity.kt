package azmithabet.com.testapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import azmithabet.com.testapp.R
import azmithabet.com.testapp.data.model.AssociatedDrug
import azmithabet.com.testapp.data.model.Medications
import azmithabet.com.testapp.databinding.ActivityLoginBinding
import azmithabet.com.testapp.presentation.associateddrug.AssociatedDrugActivity
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login)

          binding.login.setOnClickListener {
            if (binding.userName.text.toString().isNotEmpty()) {
                val intent = Intent(this, AssociatedDrugActivity::class.java)
                intent.putExtra("user_name", binding.userName.text.toString())
                startActivity(intent)
                finish()
            }
            else{
                binding.userName.error=getString(R.string.requred)
            }
        }
    }
}