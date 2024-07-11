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

/**
 * This class demonstrates various Kotlin and Android development concepts.
 * It showcases best practices in Android app architecture, coroutines usage,
 * and Kotlin language features.
 */
class KotlinShowcaseExamples : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_showcase)

        // Initialize UI components and set up the user interface
        initializeUI()

        // Start a background task to periodically check the battery
        scheduleRemoteBatteryCheck()
    }

    /**
     * Initializes UI components and sets up click listeners.
     * This function demonstrates how to interact with UI elements in Kotlin.
     */
    private fun initializeUI() {
        // Find the button in the layout using its ID
        val btnExample = findViewById<Button>(R.id.btn_example)

        // Set up a click listener using a lambda expression
        btnExample.setOnClickListener {
            handleExampleButtonClick()
        }

        // More UI initializations can be added here...
    }

    /**
     * Handles the click event of the example button.
     * This function showcases how to respond to user interactions.
     */
    private fun handleExampleButtonClick() {
        // Display a message using our custom showMessage function
        showMessage("Example button clicked!", "center")
    }

    /**
     * Schedules a periodic battery check using Kotlin coroutines.
     * This demonstrates how to perform background tasks efficiently in Android.
     */
    private fun scheduleRemoteBatteryCheck() {
        // Launch a coroutine in the lifecycle scope of the activity
        lifecycleScope.launch {
            // Keep running as long as the coroutine is active
            while (isActive) {
                // Wait for 60 seconds (1 minute)
                delay(BATTERY_CHECK_INTERVAL)
                // Perform the battery check
                performBatteryCheck()
            }
        }
    }

    /**
     * Simulates a battery check operation.
     * In a real app, this would interact with the device's battery info.
     */
    private fun performBatteryCheck() {
        // Simulate getting a random battery level (0-100)
        val batteryLevel = (0..100).random()
        // Display the battery level using our custom showMessage function
        showMessage("Battery level: $batteryLevel%", "top")
    }

    /**
     * Displays a custom toast message with specified position.
     * This function demonstrates how to create reusable UI components.
     * 
     * @param message The message to display
     * @param position The position of the toast: "top", "center", or "bottom"
     */
    private fun showMessage(message: String, position: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        // Set the position of the toast based on the input
        when (position.toLowerCase()) {
            "top" -> toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 150)
            "center" -> toast.setGravity(Gravity.CENTER, 0, 0)
            else -> toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 150)
        }
        toast.show()
    }

    /**
     * Extension function for Context to show a toast message.
     * This demonstrates how to create and use Kotlin extension functions.
     * 
     * @param message The message to display
     * @param duration The duration of the toast (default is short)
     */
    fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    /**
     * Data class example.
     * This demonstrates how to create simple, immutable data holding classes in Kotlin.
     */
    data class User(val name: String, val age: Int)

    /**
     * Companion object for holding constant values and utility functions.
     * This demonstrates how to use companion objects in Kotlin, which are similar to static members in Java.
     */
    companion object {
        private const val TAG = "KotlinShowcaseExamples"
        private const val BATTERY_CHECK_INTERVAL = 60000L // 60 seconds in milliseconds
    }
}
