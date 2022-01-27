import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'Level.dart';


void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    home: Home(),
  ));
}

class Home extends StatelessWidget {
  const Home({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: <Widget>[
          Padding(
            padding: const EdgeInsets.only(top: 100.0),
            child: Text(
                'La partie mobile',
                style: TextStyle(fontSize: 32,fontWeight: FontWeight.bold,color: Colors.blue),
            ),
          ),
          SizedBox(height: 50,),
          CircleAvatar(
            radius: 100,
            backgroundImage: AssetImage('images/hamza.jpg'),
          ),
          SizedBox(height: 30,),
          Text(
              'Hamza Dbani',
              style: TextStyle(fontSize: 25,color: Colors.blue),
          ),
          SizedBox(height: 30,),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Column(
              children: <Widget>[
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Icon(Icons.mail),
                    SizedBox(width:10,),
                    Text(
                          'Email :  hamzadbani1@gmail.com   ',
                          style: TextStyle(fontSize: 18,),
                    )
                  ],
                ),
                SizedBox(height: 20,),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Icon(Icons.location_on),
                    SizedBox(width:10,),
                    Text(
                        'Faculté des sciences et Techniques  ',
                         style: TextStyle(fontSize: 18,),
                    )
                  ],
                ),
                SizedBox(height: 20,),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Icon(Icons.info),
                    SizedBox(width:10,),
                    Text(
                        'Étudiant en 2éme année Master SIM',
                         style: TextStyle(fontSize: 18,),
                    )
                  ],
                ),
                SizedBox(height: 20,),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Icon(Icons.book_online),
                    SizedBox(width:10,),
                    Text(
                        'Module :    Architectures distribuées',
                        style: TextStyle(fontSize: 18,),
                    )
                  ],
                ),
                SizedBox(height: 20,),

              ],
            ),
          ),
        /*  Container(
            width: double.infinity,
            child: TextButton(
              style: TextButton.styleFrom(
                padding: const EdgeInsets.all(8.0),
                primary: Colors.black,
                textStyle: const TextStyle(fontSize: 20),
              ),
              //onPressed: () {_Detection(context);},
              onPressed: () {  },
              child: const Text('Continuer'),
            ),
          ),*/
          ClipRRect(
            borderRadius: BorderRadius.circular(10),
            child: Container(
                width: double.infinity,
                //color: Colors.tealAccent,
                child: Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(30),
                    child: Stack(
                      children: <Widget>[
                        Positioned.fill(
                          child: Container(
                            decoration: const BoxDecoration(
                              gradient: LinearGradient(
                                colors: <Color>[
                                  Color(0xFF0D47A1),
                                  Color(0xFF1976D2),
                                  Color(0xFF42A5F5),
                                  Color(0xFF42A5F5),
                                  Color(0xFF42A5F5),
                                  Color(0xFF1976D2),
                                  Color(0xFF0D47A1),

                                ],
                              ),
                            ),
                          ),
                        ),
                        Container(
                          width: double.infinity,
                          child: TextButton(
                            style: TextButton.styleFrom(
                              padding: const EdgeInsets.all(8.0),
                              primary: Colors.white,
                              textStyle: const TextStyle(fontSize: 20),
                            ),
                            onPressed: () { _Data(context);},
                            child: const Text('Continuer'),
                          ),
                        ),
                      ],
                    ),
                  ),
                )),
          ),

        ],
      ),
    );
  }
  void _Data(BuildContext context) {
    final route=MaterialPageRoute(builder: (BuildContext context){
      return Level();

    });
    Navigator.of(context).push(route);
  }
}
