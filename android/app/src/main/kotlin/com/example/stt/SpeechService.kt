import android.app.Service
import android.content.Intent
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.os.IBinder
import org.vosk.Model
import org.vosk.RecognitionListener
import org.vosk.Recognizer
import java.io.File
import java.io.FileOutputStream

class SpeechService : Service() {
    private var recorder: AudioRecord? = null
    private var isRecording = false
    private lateinit var recognizer: Recognizer

    override fun onCreate() {
        super.onCreate()
        val model = Model("/path/to/vosk/model") // Set your model path
        recognizer = Recognizer(model, 16000.0f)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startRecording()
        return START_STICKY
    }

    private fun startRecording() {
        val bufferSize = AudioRecord.getMinBufferSize(
            16000, 
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )

        recorder = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            16000,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )

        recorder?.startRecording()
        isRecording = true
        Thread(Runnable { writeAudioDataToFile() }).start()
    }

    private fun writeAudioDataToFile() {
        val audioData = ByteArray(4096)

        while (isRecording) {
            val readSize = recorder?.read(audioData, 0, audioData.size) ?: 0
            if (readSize > 0) {
                // Here you would normally process audio data with Vosk recognizer
                recognizer.acceptWaveForm(audioData, readSize)
                // Example: Log the result
                val result = recognizer.result
            }
        }

        stopRecording()
    }

    private fun stopRecording() {
        if (isRecording) {
            isRecording = false
            recorder?.stop()
            recorder?.release()
            recognizer.stop()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopRecording()
    }
}