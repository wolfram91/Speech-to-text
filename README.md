# Speech to Text Documentation

## Setup
1. **Clone the repository**
   ```bash
   git clone https://github.com/wolfram91/Speech-to-text.git
   cd Speech-to-text
   ```

2. **Install dependencies**
   Make sure you have Python 3.x installed. Then install required libraries:
   ```bash
   pip install -r requirements.txt
   ```

## Build
To build the project, run the following command:
```bash
python setup.py build
```

## Usage
To use the Speech to Text functionality, follow these steps:
1. **Import the package**:
   ```python
   from speech_to_text import SpeechToText
   ```

2. **Initialize the SpeechToText object**:
   ```python
   stt = SpeechToText()
   ```

3. **Transcribe audio**:
   ```python
   text = stt.transcribe("path/to/audio/file")
   print(text)
   ```

## Contributing
If you want to contribute, feel free to fork the repository and make a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.