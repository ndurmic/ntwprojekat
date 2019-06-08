import 'package:flutter/material.dart';
import 'dart:async';

import 'package:mobile/screens/homeScreen.dart';

class LoginScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomPadding: true,
      body: LoginScreenState(),
    );
  }
}

class LoginScreenState extends StatefulWidget {
  @override
  LoginScreenStateCreate createState() => LoginScreenStateCreate();
}

class LoginScreenStateCreate extends State<LoginScreenState> {
  bool isButtonDisabled = false;
  String name = "";

  TextEditingController logEmailController = TextEditingController();
  TextEditingController logPasswordController = TextEditingController();

  Future<bool> onBackPressed() {
    Navigator.of(context)
        .popUntil(ModalRoute.withName(Navigator.defaultRouteName));
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
        onWillPop: onBackPressed,
        child: Container(
            height: MediaQuery.of(context).size.height,
            decoration: BoxDecoration(
              color: Colors.black38,
              image: DecorationImage(
                colorFilter: ColorFilter.mode(
                    Colors.black.withOpacity(0.1), BlendMode.dstATop),
                image: AssetImage('assets/homeWallpaper.jpg'),
                fit: BoxFit.cover,
              ),
            ),
            child: SingleChildScrollView(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: <Widget>[
                      Container(
                        margin: EdgeInsets.only(top: 60.0),
                        height: 80.0,
                        decoration: BoxDecoration(
                          image: DecorationImage(
                            image: AssetImage('assets/librarythree.png'),
                          ),
                        ),
                      ),
                      Container(
                        child: Text(
                          "eBiblioteka",
                          style: TextStyle(
                              color: Colors.white,
                              fontSize: 20.0,
                              fontWeight: FontWeight.bold),
                        ),
                      ),
                    ],
                  ),
                  Form(
                    child: Column(children: <Widget>[
                      Container(
                        padding: EdgeInsets.only(
                            right: 40.0, left: 40.0, bottom: 20.0),
                        child: TextFormField(
                          controller: logEmailController,
                          validator: (value) {
                            if (value.isEmpty) {
                              return 'Please enter your email';
                            }
                          },
                          decoration: InputDecoration(
                            contentPadding: EdgeInsets.all(15.0),
                            hintText: 'Email',
                            hintStyle: TextStyle(color: Colors.white),
                          ),
                          keyboardType: TextInputType.emailAddress,
                        ),
                      ),
                      Container(
                        padding: EdgeInsets.only(
                            right: 40.0, left: 40.0, bottom: 20.0),
                        child: TextFormField(
                          obscureText: true,
                          controller: logPasswordController,
                          validator: (value) {
                            if (value.isEmpty) {
                              return "Please enter your password";
                            }
                          },
                          decoration: InputDecoration(
                            contentPadding: EdgeInsets.all(15.0),
                            hintText: 'Password',
                            hintStyle: TextStyle(color: Colors.white),
                          ),
                        ),
                      ),
                      Container(
                        height: 50.0,
                        width: MediaQuery.of(context).size.width,
                        padding: EdgeInsets.only(
                            left: 40.0, right: 40.0, bottom: 5.0, top: 0.0),
                        child: RaisedButton(
                          shape: RoundedRectangleBorder(
                              side: BorderSide(color: Colors.black54),
                              borderRadius: BorderRadius.circular(25.0)),
                          color: Colors.white70,
                          textColor: Colors.black,
                          onPressed: isButtonDisabled ? null : () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                        builder: (context) => HomeScreen()),
                                  );

                                  setState(() {
                                    isButtonDisabled = true;
                                  });

                                  //VALIDATION FOR EMPTY FIELDS
                                  if (logEmailController.text.isEmpty ||
                                      logPasswordController.text.isEmpty) {
                                    final snackBar = SnackBar(
                                      content: Text(
                                          "Please insert email and password!"),
                                    );
                                    Scaffold.of(context).showSnackBar(snackBar);

                                    setState(() {
                                      isButtonDisabled = false;
                                    });
                                  } else {
                                    //metoda za provjeru logina i dobijanje tokena
                                    /*
                                  final Future<String> getToken = token(logEmailController.text,logPasswordController.text);

                                  getToken.then((response){

                                  }).catchError((e){
                                    return Text("No valid token ILI STAVI SNACKBAR DA USER NIJE VALIDAN");
                                  });
                                  */
                                  }
                                },
                          child: Text(
                            "LOGIN",
                            style: TextStyle(color: Colors.black),
                          ),
                        ),
                      ),
                      Container(
                        padding: EdgeInsets.only(left: 35.0),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.start,
                          children: <Widget>[
                            FlatButton(
                              child: Text("Forgot Password?",
                                  style:
                                      TextStyle(fontWeight: FontWeight.bold)),
                              onPressed: () {
                                /*  Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                      builder: (context) => RecoverPass()),
                                );*/
                              },
                            ),
                          ],
                        ),
                      ),
                    ]),
                  ),
                ],
              ),
            )));
  }
}
