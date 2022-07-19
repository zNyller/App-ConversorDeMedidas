package com.nyller.android.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nyller.android.conversordemedidas.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getDoubleExtra("RESULT", 0.0)
        val label = intent.getStringExtra("LABEL")

        binding.tvValue.text = result.toString()
        binding.tvValueLabel.text = label

        binding.btnClose.setOnClickListener {
            finish()
        }

    }
}