# Kotlin Android App Showcase

The OnGuard Surveillance App is currently in development and aims to provide enhanced security for parents, pet owners, and homeowners. The app integrates advanced features such as real-time camera and microphone streaming, call log fetching, and location tracking. Utilizing Kotlin, XML and Firebase, OnGuard offers a robust and reliable solution for real-time surveillance and monitoring.

This repository demonstrates various Kotlin programming techniques and Android development concepts used in a video streaming application. The code snippets and explanations provided here showcase my Kotlin skills and understanding of Android development best practices.

## Key Features

1. Permission Handling
2. UI Initialization and Management
3. Background Tasks and Coroutines
4. Custom UI Elements and Animations
5. Audio/Video Stream Management
6. User Preferences and Settings

## Code Highlights

### 1. Permission Handling

```kotlin
if (!checkSelfPermission()) {
    Log.d(TAG, "Requesting necessary permissions")
    ActivityCompat.requestPermissions(this, REQUESTED_PERMISSIONS, PERMISSION_REQ_ID)
} else {
    Log.d(TAG, "Permissions already granted")
}
```

This snippet demonstrates how to check and request necessary permissions for the application. It's crucial for ensuring the app has the required access to device features.

### 2. UI Initialization and Management

```kotlin
private fun initializeUI() {
    // Initialize UI elements
    surfaceViewMain = findViewById(R.id.surface_view_main)
    btnStartStream = findViewById(R.id.btn_start_stream)
    btnAgoraChannel = findViewById(R.id.btn_agora_channel)
    // ... (other UI element initializations)

    // Set up click listeners
    btnStartStream.setOnClickListener { handleStartStreamClick() }
    btnAgoraChannel.setOnClickListener { handleAgoraChannelClick() }
    // ... (other click listeners)
}
```

This function showcases the initialization of UI elements and setting up click listeners. It demonstrates good practice in organizing UI-related code.

### 3. Background Tasks and Coroutines

```kotlin
private fun scheduleRemoteBatteryCheck() {
    lifecycleScope.launch {
        while (isActive) {
            delay(60000) // Check every minute
            commandBManager.sendCloudFunctionRequest("READ_BATTERY")
        }
    }
}
```

This function uses Kotlin coroutines to schedule a periodic task. It demonstrates how to perform background operations efficiently without blocking the main thread.

### 4. Custom UI Elements and Animations

```kotlin
private fun showMessage(message: String, position: String) {
    val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    when (position.toLowerCase()) {
        "top" -> toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 150)
        "center" -> toast.setGravity(Gravity.CENTER, 0, 0)
        else -> toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 150)
    }
    toast.show()
}
```

This custom function creates a Toast message with different positioning options. It showcases how to create reusable UI components with customizable behavior.

## Summary

These code snippets demonstrate proficiency in Kotlin programming and Android development. They showcase skills in handling permissions, managing UI elements, working with coroutines for background tasks, and creating custom UI components.

For more detailed code examples and implementations, please refer to the KotlinShowcaseExamples.kt file in this repository.
