// File: KotlinShowcaseExamples.kt

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class KotlinShowcaseExamples : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_showcase)

        initializeUI()
        scheduleRemoteBatteryCheck()
    }

    private fun initializeUI() {
        // Initialize UI elements
        val btnExample = findViewById<Button>(R.id.btn_example)

        btnExample.setOnClickListener {
            handleExampleButtonClick()
        }

        // More UI initializations...
    }

    private fun handleExampleButtonClick() {
        showMessage("Example button clicked!", "center")
    }

    private fun scheduleRemoteBatteryCheck() {
        lifecycleScope.launch {
            while (isActive) {
                delay(60000) // Check every minute
                performBatteryCheck()
            }
        }
    }

    private fun performBatteryCheck() {
        // Simulated battery check function
        val batteryLevel = (0..100).random()
        showMessage("Battery level: $batteryLevel%", "top")
    }

    private fun showMessage(message: String, position: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        when (position.toLowerCase()) {
            "top" -> toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 150)
            "center" -> toast.setGravity(Gravity.CENTER, 0, 0)
            else -> toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 150)
        }
        toast.show()
    }

    // Extension function example
    fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    // Data class example
    data class User(val name: String, val age: Int)

    // Companion object example
    companion object {
        private const val TAG = "KotlinShowcaseExamples"
        private const val BATTERY_CHECK_INTERVAL = 60000L
    }
}
