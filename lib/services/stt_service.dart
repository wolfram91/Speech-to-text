import 'package:flutter/services.dart';

class SttService {
  static const MethodChannel _channel = MethodChannel('stt_service');

  Future<String> transcribeSpeech(String audioFilePath) async {
    final String transcription = await _channel.invokeMethod('transcribeSpeech', {'audioFilePath': audioFilePath});
    return transcription;
  }
}