# Build Instructions for Speech-to-Text

This document outlines the steps needed to build the Speech-to-Text application. Follow the instructions carefully to set up your environment and build the APK.

## Prerequisites
- **Java JDK**: Ensure you have JDK 8 or higher installed.
- **Android Studio**: Install the latest version of Android Studio from [here](https://developer.android.com/studio).
- **Android SDK**: Make sure you have the Android SDK and related build tools.

## Setup Steps
1. **Clone the Repository**: 
   ```bash
   git clone https://github.com/wolfram91/Speech-to-text.git
   cd Speech-to-text
   ```  

2. **Open the Project in Android Studio**: 
   - Launch Android Studio and open the cloned project.

3. **Install Dependencies**: 
   - Go to `File > Project Structure > Dependencies` and ensure all required libraries are included.

## APK Build Commands
To build the APK, you can use the following commands:
1. Open the terminal in Android Studio or use your command line with the project directory.
2. Run the following command:
   ```bash
   ./gradlew assembleDebug
   ```
   - For a release build, run:
   ```bash
   ./gradlew assembleRelease
   ```

## Installation Steps
1. **Connect Your Android Device**: Ensure your device is connected via USB and USB debugging is enabled.
2. **Install the APK**:
   - You can install the APK directly from Android Studio by selecting `Run > Run 'app'`. 
   - Alternatively, use ADB to install the APK:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

## Troubleshooting Guide
- **Build Fails**: Check the error log for any missing dependencies or compilation errors in the code.
- **Device Not Detected**: Ensure developer options and USB debugging are enabled on your device.
- **APK Not Installing**: Make sure that your device allows installations from unknown sources. Go to settings and enable this option.

For further assistance, refer to the project's issue tracker or contact the maintainers.