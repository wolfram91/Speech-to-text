import 'package:flutter/material.dart';

class ModeSelector extends StatelessWidget {
  final List<String> modes;
  final ValueChanged<String> onModeSelected;

  ModeSelector({required this.modes, required this.onModeSelected});

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: modes.map((mode) {
        return GestureDetector(
          onTap: () => onModeSelected(mode),
          child: Container(
            padding: EdgeInsets.all(10.0),
            margin: EdgeInsets.symmetric(horizontal: 5.0),
            decoration: BoxDecoration(
              color: Colors.blue,
              borderRadius: BorderRadius.circular(5.0),
            ),
            child: Text(
              mode,
              style: TextStyle(color: Colors.white, fontSize: 16),
            ),
          ),
        );
      }).toList(),
    );
  }
}