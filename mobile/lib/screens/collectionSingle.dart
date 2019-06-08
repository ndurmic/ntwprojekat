import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/animation.dart';
import 'package:async/async.dart';
import 'package:mobile/screens/authorSingle.dart';
import 'package:mobile/screens/profileScreen.dart';


//--------------------------------MAIN CLASS--------------------------------------//

class CollectionSingle extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new  Scaffold(
        appBar: AppBar(
          title: const Text('Naziv kolekcije'),
        ),
        body: CollectionSingleState(),
      );
  }
}

class CollectionSingleState extends StatefulWidget {
  @override
  CollectionSingleStateCreate createState() => new CollectionSingleStateCreate();
}

class CollectionSingleStateCreate extends State<CollectionSingleState> {
  @override
  void initState() {
    super.initState();
  }

  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: 2,
        itemBuilder: (context, index) {
            return book(context);
        });
  }
}


//--------------------------------MAIN CLASS--------------------------------------//

//--------------------------------SINGLE BOOK--------------------------------------//

Widget book(BuildContext context) {
  return Container(
    padding: EdgeInsets.all(4.0),
    child: DecoratedBox(
      decoration: BoxDecoration(
        color: Color.fromRGBO(31, 32, 35, .9),
        borderRadius: BorderRadius.all(Radius.circular(8.0)),
      ),
      child: ExpansionTile(
        initiallyExpanded: true,
        title: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Container(
              margin: EdgeInsets.only(top: 10.0, bottom: 10.0),
              height: MediaQuery.of(context).size.height * 0.15,
              width: MediaQuery.of(context).size.width * 0.3,
              child: DecoratedBox(
                decoration: BoxDecoration(
                  image: DecorationImage(
                    image: AssetImage('assets/booktwo.jpg'),
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
                      padding: EdgeInsets.only(left: 15.0),
                      child: Text(
                        "Naslov knjige",
                        style: TextStyle(
                          fontSize: 18.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    FlatButton(
                      child: Text(
                        "Ime autora",
                        style: TextStyle(
                          color: Colors.white70,
                        ),
                      ),
                      onPressed: () {
                        Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => AuthorSingle()));
                      },
                    ),
                  ],
                ),
              ],
            ),
          ],
        ),
        children: <Widget>[
          Container(
            height: 100.0,
            padding: EdgeInsets.only(left:25.0,right:10.0),
            child: SingleChildScrollView(
              scrollDirection: Axis.vertical,
              child: Container(
                padding: EdgeInsets.all(5.0),
                width:MediaQuery.of(context).size.width*0.9,
                child: RichText(
                  textAlign:TextAlign.justify,
                  text: TextSpan(
                      children:[
                        TextSpan(
                          text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur: ",
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 13.0,
                          ),
                        ),
                      ]
                  ),
                ),
              ),

            ),
          ),
          Container(
            padding: EdgeInsets.all(10.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Row(
                  children: <Widget>[
                    IconButton(
                        icon: Icon(Icons.comment),
                        onPressed: () {
                          /*Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => CommentsScreen()));*/
                        }),
                    Container(
                      padding: EdgeInsets.only(left: 5.0),
                      child: Text("20"),
                    )
                  ],
                ),
                Text("Datum objavljivanja"),
              ],
            ),
          ),
        ],
      ),
    ),
  );
}

//--------------------------------SINGLE BOOK--------------------------------------//
