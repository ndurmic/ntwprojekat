import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/animation.dart';
import 'package:async/async.dart';
import 'package:mobile/screens/profileScreen.dart';

//--------------------------------MAIN CLASS--------------------------------------//

class AuthorSingle extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: AppBar(
        title: const Text('Ime autora'),
      ),
      body: AuthorSingleState(),
    );
  }
}

class AuthorSingleState extends StatefulWidget {
  @override
  AuthorSingleStateCreate createState() => new AuthorSingleStateCreate();
}

class AuthorSingleStateCreate extends State<AuthorSingleState> {
  @override
  void initState() {
    super.initState();
  }

  Widget build(BuildContext context) {
    return ListView(
      children: <Widget>[
        Container(
          margin: EdgeInsets.only(top: 20.0, bottom: 20.0),
          height: MediaQuery.of(context).size.height * 0.3,
          width: MediaQuery.of(context).size.width * 0.3,
          child: DecoratedBox(
            decoration: BoxDecoration(
              image: DecorationImage(
                image: AssetImage('assets/author.jpg'),
                fit: BoxFit.contain,
              ),
              shape: BoxShape.rectangle,
            ),
          ),
        ),
        Row(
          children: <Widget>[
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Container(
                  padding: EdgeInsets.all(15.0),
                  child: Text(
                    "Ime autora",
                    style: TextStyle(
                      fontSize: 18.0,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
                Container(
                  padding: EdgeInsets.all(15.0),
                  child: Text(
                    "Datum rođenja",
                    style: TextStyle(
                      color: Colors.white70,
                    ),
                  ),
                ),
                Container(
                  height: 200.0,
                  padding: EdgeInsets.only(left: 10.0, right: 10.0),
                  child: SingleChildScrollView(
                    scrollDirection: Axis.vertical,
                    child: Container(
                      padding: EdgeInsets.all(5.0),
                      width: MediaQuery.of(context).size.width * 0.9,
                      child: RichText(
                        textAlign: TextAlign.justify,
                        text: TextSpan(children: [
                          TextSpan(
                            text:
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur: ",
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 13.0,
                            ),
                          ),
                          TextSpan(
                            text:
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur: ",
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 13.0,
                            ),
                          ),
                        ]),
                      ),
                    ),
                  ),
                ),

                Container(
                  padding: EdgeInsets.all(15.0),
                  child: Text(
                    "Djela:",
                    style: TextStyle(
                      color: Colors.white70,
                    ),
                  ),
                ),

                Container(
                  padding: EdgeInsets.only(left: 15.0, right: 10.0),
                  width: MediaQuery.of(context).size.width*0.9,
                  child: SingleChildScrollView(
                    scrollDirection: Axis.horizontal,
                    child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                        children: <Widget>[
                          Text(
                            "Naslov knjige 1 "
                          ),
                          Text(
                              "Naslov knjige 2 "
                          ),
                          Text(
                              "Naslov knjige 3 "
                          ),
                          Text(
                              "Naslov knjige 4 "
                          ),
                        ],
                      )
                    ),
                  ),
              ],
            ),
          ],
        ),
      ],
    );
  }
}

//--------------------------------MAIN CLASS--------------------------------------//
