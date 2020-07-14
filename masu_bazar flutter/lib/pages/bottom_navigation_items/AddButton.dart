
import 'dart:io';
import 'package:http/http.dart' as http;
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:masu_bazar/json_model/khasi_model.dart';
class AddButton extends StatefulWidget {
  AddButton({Key key}) : super(key: key);

  @override
  _AddButtonState createState() => _AddButtonState();
}
Future<KhasiModel> createKhasiList(String title,String category,String desc,String weight,String color,String daat,String name,String address,String phnNo,String contactNo,String age,String khasiImage) async{
    try{
  final String apiUrl="http://192.168.10.104:3000/khasiLists/post";
  
 final response= await http.post(apiUrl,body: {

            "title": title,
            "category": category,
            "short_description": desc,
            "estimated_weight": weight,
            "color": color,
            "daat": daat,
            "owner_name": name,
            "address": address,
            "primary_contact_no": phnNo,
            "secondary_contact_no": contactNo,
            "age": age,
            "khasiImage":khasiImage,
 });
 
 if(response.statusCode==201){
 final String responseString=response.body;
 return khasiModelFromJson(responseString);

 }else{
   return null;
 }
  }catch(e)
  {
    print(e);
    return null;
  }
}
class _AddButtonState extends State<AddButton> {
    KhasiModel _khasi;
 final TextEditingController titleController=TextEditingController();
 final TextEditingController descriptionController=TextEditingController();
 final TextEditingController weightController=TextEditingController();
 final TextEditingController colorController=TextEditingController();
 final TextEditingController daatController=TextEditingController();
 final TextEditingController nameController=TextEditingController();
 final TextEditingController addressController=TextEditingController();
 final TextEditingController primaryContactController=TextEditingController();
 final TextEditingController secondaryContactController=TextEditingController();
 final TextEditingController ageController=TextEditingController();
  File _image;
  var _catrgory=['Select Category','Khasi','Boka','Raga','Kukhura','Birds','Vakal','Anya'];
  var _currentCategorySelected="Select Category";
 
  final GlobalKey<FormState> _formKey=GlobalKey<FormState>();

 
  Widget _buildTitle(){
    return TextFormField(
      controller: titleController,
      decoration: InputDecoration(labelText: 'Title'),
      validator: (String value){
        if(value.isEmpty){
          return 'Title is Required';
        }
      },
    );
  }
    Widget _buildCategory(){
    return Container(
      width: MediaQuery.of(context).size.width,
       decoration: BoxDecoration(
          color: Colors.white,
          border:Border.all(color: Colors.black26,style: BorderStyle.solid),
          borderRadius: BorderRadius.circular(10),
          boxShadow: [
            BoxShadow(
               color: Colors.black26,
               offset: Offset(0.0,0.5)
            ),
          ]
        ),
      child: DropdownButton<String>(
        
          items: _catrgory.map((String dropDownStringItem){
                return DropdownMenuItem<String>(
                  value: dropDownStringItem,
                  child: Text(dropDownStringItem),
                );
          }).toList(),
          onChanged: (String newValueSelected){
            setState(() {
              this._currentCategorySelected=newValueSelected;
            });
          },
          
          value: _currentCategorySelected,
      ),
    );
  }
    Widget _buildDesc(){
     return TextFormField(
       controller: descriptionController,
        decoration: InputDecoration(labelText: 'Short_description',),
        validator: (String value){
          if(value.isEmpty){
     return 'Short_description is Required';
          }
        },
    );
  }
    Widget _buildWeight(){
       return TextFormField(
         controller: weightController,
      decoration: InputDecoration(labelText: 'Weight'),
      validator: (String value){
        if(value.isEmpty){
          return 'Weight is Required';
        }
      },
    );
  }
    Widget _buildColor(){
       return TextFormField(
         controller: colorController,
      decoration: InputDecoration(labelText: 'Color'),
      validator: (String value){
        if(value.isEmpty){
          return 'Color is Required';
        }
      },
    );
  }
    Widget _buildDaat(){
       return TextFormField(
         controller: daatController,
      decoration: InputDecoration(labelText: 'Satiyako Daat'),
      validator: (String value){
        if(value.isEmpty){
          return 'Satiyako Daat is Required';
        }
      },
    );
  }
    Widget _buildName(){
       return TextFormField(
         controller: nameController,
      decoration: InputDecoration(labelText: 'Owner_name'),
      validator: (String value){
        if(value.isEmpty){
          return 'Owner_name is Required';
        }
      },
    );
  }
    Widget _buildAddress(){
        return TextFormField(
          controller: addressController,
      decoration: InputDecoration(labelText: 'Address'),
      validator: (String value){
        if(value.isEmpty){
          return 'Address is Required';
        }
      },
    );
  }
    Widget _buildPNumber(){
        return TextFormField(
          controller: primaryContactController,
      decoration: InputDecoration(labelText: 'Primary_contact_no '),
      validator: (String value){
        if(value.isEmpty){
          return 'Primary_contact_no is Required';
        }
      },
    );
  }
    Widget _buildSNumber(){
       return TextFormField(
         controller: secondaryContactController,
      decoration: InputDecoration(labelText: 'Secondary_contact_no '),
    
    );
  }
    Widget _buildage(){
       return TextFormField(
         controller: ageController,
         textAlign: TextAlign.start,
      decoration: InputDecoration(labelText: 'Age '),
      validator: (String value){
        if(value.isEmpty){
          return 'Age is Required';
        }
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
              appBar:AppBar(
            backgroundColor: Colors.orange,
            elevation: 0.0,
            title: Text('POST New Item',style: TextStyle(color: Colors.black87),),
             actions: [
            IconButton(
              onPressed: (){},
              icon: Icon(Icons.search,color: Colors.black54,),),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: CircleAvatar(
              radius: 20.0,
              backgroundColor: Colors.orange,
              child: Image(image: AssetImage('assets/images/logo1.png'),)),
          ),
          
        ],
          ),
       body: SingleChildScrollView(
                child: Container(
                  color: Colors.black12,
              child: Container(
                
                        decoration: BoxDecoration(
                          border:Border.all(color: Colors.black26,style: BorderStyle.solid),
                   boxShadow: [
                  BoxShadow(
                    color:Colors.white,
                              offset: Offset(1.0,1.0)
            ),
           ]
                    ),
            margin: EdgeInsets.all(5),
            child: Form(
              
              key: _formKey,
              child:Column(
                  
                    children: [
                      _buildTitle(),
                      SizedBox(height: 10,),
                      _buildCategory(),
                       SizedBox(height: 10,),
                      _buildDesc(),
                       SizedBox(height: 5,),
                       Image(image:_image!=null?FileImage(_image): AssetImage('assets/images/noimage.png',),width: 300,height: 200,),
                       SizedBox(height: 5,),
                       RaisedButton(onPressed: (){
                         PickImage();
                                                  },
                                                  child: Text('CHOOSE IMAGE'),
                                                  ),
                                                  SizedBox(height: 10,),
                                                _buildWeight(),
                                                  SizedBox(height: 10,),
                                                _buildColor(),
                                                  SizedBox(height: 10,),
                                                _buildDaat(),
                                                  SizedBox(height: 10,),
                                                _buildName(),
                                                  SizedBox(height: 10,),
                                                _buildAddress(),
                                                  SizedBox(height: 10,),
                                                _buildPNumber(),
                                                  SizedBox(height: 10,),
                                                _buildSNumber(),
                                                  SizedBox(height: 10,),
                                                _buildage(),
                                                SizedBox(height: 10,),
                                                RaisedButton(
                                                  child:Text('Submit') ,
                                                  onPressed: ()async{
                                                     final String title=titleController.text;
                                                     final String category=_currentCategorySelected.toString();
                                                     final String desc=descriptionController.text;
                                                     final String weight=weightController.text;
                                                     final String color=colorController.text;
                                                      final String daat=daatController.text;
                                                      final String name=nameController.text;
                                                      final String address=addressController.text;
                                                      final String phnNo=primaryContactController.text;
                                                      final String contactNo=secondaryContactController.text;
                                                      final String age=ageController.text;
                                                      final String khasiImage=_image.path;
                                                    final KhasiModel khasi=await  createKhasiList(title, category, desc, weight, color, daat, name, address, phnNo, contactNo, age, khasiImage);
                                                    setState(() {
                                                      _khasi=khasi;
                                                    });
                                                    if(!_formKey.currentState.validate()){
                                                      return;
                                                    }
                                                    _formKey.currentState.save();
                                                  },
                                                  )
                                              ],
                                              ) ,
                                        ),
                                    ),
                                          ),
                                  ),
                              );
                            }
                         
                           void PickImage() async {
                             // ignore: deprecated_member_use
                             var image=await ImagePicker.pickImage(source: ImageSource.gallery);
                             setState(() {
                               _image=image ;
                               print(_image);
                             });

                           }
}