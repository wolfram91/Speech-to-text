enum UserMode {
  NORMAL,
  SILENT,
  LOUD,
  CUSTOM
}

class UserModeData {
  UserMode mode;
  String customModeName;

  UserModeData({required this.mode, this.customModeName = ''});

  void setCustomMode(String name) {
    if (mode == UserMode.CUSTOM) {
      customModeName = name;
    }
  }
}