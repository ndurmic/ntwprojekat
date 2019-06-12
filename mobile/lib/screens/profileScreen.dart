import 'package:flutter/material.dart';

//--------------------------------Info Screen--------------------------------------//
class ProfileScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: AppBar(
        title: const Text('Your Profile'),
      ),
      body: ProfileForm(),
    );
  }
}

class ProfileForm extends StatefulWidget {
  @override
  ProfileFormState createState() {
    return ProfileFormState();
  }
}

class ProfileFormState extends State<ProfileForm> {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    // Build a Form widget using the _formKey we created above
    return Form(
      key: _formKey,
      child: ListView(
        children: <Widget>[
          Container(
            height: 200,
            child: Image.asset("assets/user.png"),
          ),
          ListTile(
            leading: Icon(Icons.person),
            title: Text("Username"),
          ),
          ListTile(
            leading: Icon(Icons.email),
            title: Text("Email"),
          ),
          ListTile(
            leading: Icon(Icons.format_list_numbered),
            title: Text("Broj kolekcija"),
          ),
        ],
      ),
    );
  }
}
