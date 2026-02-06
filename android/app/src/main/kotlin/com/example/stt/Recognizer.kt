// Recognizer.kt

package com.example.stt

import org.vosk.Recognizer
import org.vosk.Model
import org.vosk.android.RecognizerListener

class Recognizer(private val modelPath: String) : RecognizerListener {
    private lateinit var recognizer: Recognizer

    init {
        initRecognizer() 
    }

    private fun initRecognizer() {
        val model = Model(modelPath)
        recognizer = Recognizer(model, 16000.0f)
        recognizer.setListener(this)
    }

    fun startRecognition() {
        recognizer.start()  
    }

    fun stopRecognition() {
        recognizer.stop()
    }

    override fun onResult(result: String) {
        // handle the recognition result
    }

    override fun onError(e: Exception) {
        // handle errors
    }

    // Other necessary methods from RecognizerListener...
}