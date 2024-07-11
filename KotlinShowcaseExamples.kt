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
 * This class demonstrates a simple Android app structure using Kotlin.
 * It shows how different parts of an app work together:
 * 1. The main activity (this class) controls the app's overall behavior.
 * 2. UI elements (like buttons) that the user can interact with.
 * 3. Background tasks (like checking battery) that run independently.
 * 4. Helper functions that can be used throughout the app.
 */
class KotlinShowcaseExamples : AppCompatActivity() {

    // This function is called when the app starts.
    // It sets up the initial state of the app.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This line sets what the app looks like, linking to a layout file.
        setContentView(R.layout.activity_kotlin_showcase)

        // Call other functions to set up different parts of the app.
        initializeUI()
        scheduleRemoteBatteryCheck()
    }

    /**
     * This function sets up the user interface.
     * It connects code to the visual elements that the user sees and interacts with.
     */
    private fun initializeUI() {
        // Find a button in the layout and remember it for later use.
        val btnExample = findViewById<Button>(R.id.btn_example)

        // Tell the button what to do when it's clicked.
        // It will call another function (handleExampleButtonClick) when pressed.
        btnExample.setOnClickListener {
            handleExampleButtonClick()
        }

        // More UI setup can be added here...
    }

    /**
     * This function is called when the example button is clicked.
     * It shows how the app responds to user actions.
     */
    private fun handleExampleButtonClick() {
        // When the button is clicked, show a message to the user.
        // This uses our custom showMessage function defined below.
        showMessage("Example button clicked!", "center")
    }

    /**
     * This function sets up a repeating task to check the battery level.
     * It shows how to do things in the background without interrupting the user.
     */
    private fun scheduleRemoteBatteryCheck() {
        // Start a background task that keeps running
        lifecycleScope.launch {
            while (isActive) {
                // Wait for a minute
                delay(BATTERY_CHECK_INTERVAL)
                // Then check the battery
                performBatteryCheck()
                // This will repeat until the app is closed
            }
        }
    }

    /**
     * This function pretends to check the battery level.
     * In a real app, it would actually check the device's battery.
     * It's called repeatedly by the scheduleRemoteBatteryCheck function.
     */
    private fun performBatteryCheck() {
        // Pretend to check the battery by picking a random number
        val batteryLevel = (0..100).random()
        // Show the "battery level" to the user
        showMessage("Battery level: $batteryLevel%", "top")
    }

    /**
     * This function shows a message to the user.
     * It's a helper function used by other parts of the app to communicate with the user.
     * Both handleExampleButtonClick and performBatteryCheck use this to show messages.
     */
    private fun showMessage(message: String, position: String) {
        // Create a Toast (a small pop-up message)
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        
        // Decide where to show the message based on the 'position' parameter
        when (position.toLowerCase()) {
            "top" -> toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 150)
            "center" -> toast.setGravity(Gravity.CENTER, 0, 0)
            else -> toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 150)
        }
        
        // Show the message
        toast.show()
    }

    /**
     * This is an extension function. It adds a new function to the Context class.
     * It's another way to show messages, similar to showMessage above.
     * It could be used instead of showMessage if we prefer.
     */
    fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    /**
     * This companion object holds constants used elsewhere in the class.
     * It's a way to keep important values in one place.
     */
    companion object {
        // A tag for log messages (used for targeted debugging)
        private const val TAG = "KotlinShowcaseExamples"
        // How often to check the battery (every 60 seconds)
        private const val BATTERY_CHECK_INTERVAL = 60000L // 60 seconds in milliseconds
    }
}
