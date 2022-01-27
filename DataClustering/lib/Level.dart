import 'dart:collection';
import 'dart:convert';


import 'package:flutter/material.dart';
import 'package:http/http.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'package:syncfusion_flutter_charts/charts.dart';

void main() {
  runApp(Level());
}
class Level extends StatefulWidget {
  @override
  LevelState createState() => LevelState();
  }

class LevelState extends State<Level> {
  final url = "http://192.168.1.109:8080/job/LevelDemanding";
  late TooltipBehavior _tooltipBehavior;
  late List<GDPData> _chartData;

  var levelJson = [];

  void fetchLevels() async{
    try {
      final response = await get(Uri.parse(url));
      var jsonData = json.decode(response.body) as List;
      setState(() {
        levelJson = jsonData;
      });
    }catch (err) {}
  }

  @override
  void initState() {
    // TODO: implement initState
    _chartData = getChartData();
    _tooltipBehavior = TooltipBehavior(enable: true);
    super.initState();
    fetchLevels();
  }


  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: Scaffold(
            body: SfCircularChart(
              title:
              ChartTitle(text: 'le niveau d\'expérience \n le plus demandé '),
              legend:
              Legend(isVisible: true, overflowMode: LegendItemOverflowMode.wrap),
              tooltipBehavior: _tooltipBehavior,
              series: <CircularSeries>[
                PieSeries<GDPData, String>(
                    dataSource: _chartData,
                    xValueMapper: (GDPData data, _) => data.level,
                    yValueMapper: (GDPData data, _) => data.gdp,
                    dataLabelSettings: DataLabelSettings(isVisible: true),
                    enableTooltip: true,)
              ],
            )));
    /*return MaterialApp(
      home: Scaffold(
        body: ListView.builder(
            itemCount: levelJson.length,
            itemBuilder: (context, i) {
           final level = levelJson[i];
         //  hashMap.addAll({"entry": level["entry"],"manager":level["manager"]
         //  ,"student":level["student"],"freelance":level["freelance"],"experienced":level["experienced"]});
           /*hashMap.putIfAbsent("entry", () => level["entry"]);
           hashMap.putIfAbsent("manager", () => level["manager"]);
           hashMap.putIfAbsent("student", () => level["student"]);
           hashMap.putIfAbsent("freelance", () => level["freelance"]);
           hashMap.putIfAbsent("experienced", () => level["experienced"]);*/
            return Text(
                "level : ${level["level"]}"
               /* "Entry : ${level["entry"]} \n Manager : ${level["manager"]} "
                "\n Student : ${level["student"]}"
                "\n Freelance : ${level["freelance"]}"
                "\n Experienced : ${level["experienced"]}"*/
               );
            },
        ),

      ),
    );*/

   /* return Scaffold(
      appBar: new AppBar(
        title: new Text("All Levels Details"),
      ),
      body: Container(
        child: FutureBuilder(
          future: getLevel(),
          builder: (BuildContext context, AsyncSnapshot snapshot) {
            if (snapshot.data == null) {
              return Container(child: Center(child: Icon(Icons.error)));
            }
            return ListView.builder(
                itemCount: snapshot.data.length,
                itemBuilder: (BuildContext context, int index) {
                  return ListTile(
                    title: Text('ID' + ' ' + 'First Name' + ' ' + 'Last Name'),
                    subtitle: Text('${snapshot.data[index].entry}' +
                        '${snapshot.data[index].manager}' +
                        '${snapshot.data[index].student}'
                    ),
                  );
                });
          },
        ),
      ),
    );*/
  }
  List<GDPData> getChartData() {
    final List<GDPData> chartData = [
      GDPData('Entry', 1136 ),
      GDPData('Student', 14),
      GDPData('Freelance', 32),
      GDPData('Experienced', 2194),
      GDPData('Manager',736),
    ];
    return chartData;
  }
}

class GDPData {
  GDPData(this.level, this.gdp);
  final String level;
  final int gdp;
}