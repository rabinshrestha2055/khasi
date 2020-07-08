import 'package:flutter/material.dart';
import 'package:masu_bazar/pages/home_page.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
  
    return MaterialApp(
      title: 'Flutter Demo projet',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primaryColor: Color(0xFF3EBACE),
        accentColor: Color(0xFFD8ECF1),
        scaffoldBackgroundColor: Color(0xFFF3F5F7),
       // primarySwatch: Colors.blue
      ),
      home: HomePage(),
    );
  }
}

