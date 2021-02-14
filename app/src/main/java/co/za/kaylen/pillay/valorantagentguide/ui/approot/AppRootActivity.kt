package co.za.kaylen.pillay.valorantagentguide.ui.approot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.za.kaylen.pillay.valorantagentguide.databinding.AppRootLayoutBinding

class AppRootActivity : AppCompatActivity() {
    private lateinit var binding: AppRootLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AppRootLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}