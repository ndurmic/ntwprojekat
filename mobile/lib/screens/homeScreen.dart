import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/animation.dart';
import 'package:async/async.dart';
import 'package:mobile/screens/authorSingle.dart';
import 'package:mobile/screens/collectionSingle.dart';
import 'package:mobile/screens/profileScreen.dart';

//--------------------------------SIGN OUT--------------------------------------//
void signOut() {
  print("User signed out");
}

//SHOW DIALOG
// user defined function
void logOutDialog(BuildContext context) {
  // flutter defined function
  showDialog(
    context: context,
    builder: (BuildContext context) {
      // return object of type Dialog
      return AlertDialog(
        title: Text("LOGOUT SCREEN "),
        content: Text("Are you sure you want to logout?"),
        actions: <Widget>[
          // usually buttons at the bottom of the dialog
          FlatButton(
            child: Text("Yes"),
            onPressed: () {
              //clicked();
              signOut();
              Navigator.of(context).pop();
              Navigator.of(context).pop();
            },
          ),
          FlatButton(
            child: Text("No"),
            onPressed: () {
              //clicked();
              Navigator.of(context).pop();
            },
          ),
        ],
      );
    },
  );
}

//--------------------------------SIGN OUT--------------------------------------//

//--------------------------------MAIN CLASS--------------------------------------//

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new DefaultTabController(
      length: 3,
      child: Scaffold(
        appBar: new AppBar(
          leading: IconButton(
            icon: Container(
              height: 20.0,
              width: 20.0,
              child: Image.asset('assets/signOut.png'),
            ),
            onPressed: () {
              logOutDialog(context);
            },
          ),
          title: Text(''),
          bottom: TabBar(
            isScrollable: true,
            indicatorSize: TabBarIndicatorSize.tab,
            tabs: <Widget>[
              Container(
                width:MediaQuery.of(context).size.width*0.2,
                child:Tab(text: "Naslovna"),
              ),
              Container(
                width:MediaQuery.of(context).size.width*0.2,
                child:Tab(text: "Knjige"),
              ),
              Container(
                width:MediaQuery.of(context).size.width*0.2,
                child:Tab(text: "Kolekcije"),
              ),
            ],
          ),
          actions: <Widget>[
            new IconButton(
                icon: const Icon(Icons.person),
                onPressed: () {
                  Navigator.push(context,
                      MaterialPageRoute(builder: (context) => ProfileScreen()));
                }),
          ],
        ),
        body: HomeScreenState(),
      ),
    );
  }
}

class HomeScreenState extends StatefulWidget {
  @override
  HomeScreenStateCreate createState() => new HomeScreenStateCreate();
}

class HomeScreenStateCreate extends State<HomeScreenState> {
  @override
  void initState() {
    super.initState();
  }

  Widget build(BuildContext context) {
    return TabBarView(
      children: <Widget>[
        Container(
          child: buildHome(context),
        ),
        ListView.builder(
            itemCount: 15,
            itemBuilder: (context, index) {
              return book(context);
            }),
        ListView.builder(
            itemCount: 15,
            itemBuilder: (context, index) {
              return collection(context);
            }),
      ],
    );
  }
}

Widget buildHome(BuildContext context) {
  return ListView.builder(
      itemCount: 15,
      itemBuilder: (context, index) {
        if (index % 7 == 0 && index > 0) {
          return Container(
              height: MediaQuery.of(context).size.height * 0.32,
              width: MediaQuery.of(context).size.width * 0.25,
              child: ListView.builder(
                scrollDirection: Axis.horizontal,
                itemCount: 6,
                itemBuilder: (context, index) {
                  return collection(context);
                },
              ));
        } else
          return book(context);
      });
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
                    image: AssetImage('assets/book.jpg'),
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

//--------------------------------SINGLE COLLECTION--------------------------------------//

Widget collection(BuildContext context) {
  return Container(
    margin: EdgeInsets.all(5.0),
    color: Colors.grey,
    child: Row(
      mainAxisAlignment: MainAxisAlignment.start,
      children: <Widget>[
        Container(
          padding: EdgeInsets.all(10.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              FlatButton(
                padding: EdgeInsets.all(0.0),
                child: Text(
                  "Naziv kolekcije",
                  style:
                  TextStyle(fontStyle: FontStyle.italic, fontSize: 18.0),
                ),
                onPressed: () {
                  Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => CollectionSingle()));
                },
              ),
              Row(
                children: <Widget>[
                  Container(
                    height: 100.0,
                    width: 100.0,
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
                  Container(
                    height: 100.0,
                    width: 100.0,
                    child: DecoratedBox(
                      decoration: BoxDecoration(
                        image: DecorationImage(
                          image: AssetImage('assets/bookthree.jpg'),
                          fit: BoxFit.contain,
                        ),
                        shape: BoxShape.rectangle,
                      ),
                    ),
                  ),

                ],
              ),
              Container(
                child: FlatButton(
                  padding: EdgeInsets.all(0.0),
                  child: Text("Kreirao:" + "Username",
                      style: TextStyle(
                          fontStyle: FontStyle.italic, color: Colors.white70)),
                ),
              ),
            ],
          ),
        ),
      ],
    ),
  );
}

//--------------------------------SINGLE COLLECTION--------------------------------------//
