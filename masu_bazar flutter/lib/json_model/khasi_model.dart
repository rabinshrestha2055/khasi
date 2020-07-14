import 'dart:convert';

KhasiModel khasiModelFromJson(String str) => KhasiModel.fromJson(json.decode(str));

String khasiModelToJson(KhasiModel data) => json.encode(data.toJson());

class KhasiModel {
    KhasiModel({
        this.id,
        this.title,
        this.category,
        this.shortDescription,
        this.estimatedWeight,
        this.color,
        this.daat,
        this.ownerName,
        this.address,
        this.primaryContactNo,
        this.secondaryContactNo,
        this.age,
        this.khasiImage,
    });

    String id;
    String title;
    String category;
    String shortDescription;
    int estimatedWeight;
    String color;
    int daat;
    String ownerName;
    String address;
    int primaryContactNo;
    int secondaryContactNo;
    int age;
    String khasiImage;

    factory KhasiModel.fromJson(Map<String, dynamic> json) => KhasiModel(
        id: json["_id"],
        title: json["title"],
        category: json["category"],
        shortDescription: json["short_description"],
        estimatedWeight: json["estimated_weight"],
        color: json["color"],
        daat: json["daat"],
        ownerName: json["owner_name"],
        address: json["address"],
        primaryContactNo: json["primary_contact_no"],
        secondaryContactNo: json["secondary_contact_no"],
        age: json["age"],
        khasiImage:json["khasiImage"],
    );

    Map<String, dynamic> toJson() => {
        "_id": id,
        "title": title,
        "category": category,
        "short_description": shortDescription,
        "estimated_weight": estimatedWeight,
        "color": color,
        "daat": daat,
        "owner_name": ownerName,
        "address": address,
        "primary_contact_no": primaryContactNo,
        "secondary_contact_no": secondaryContactNo,
        "age": age,
        "khasiImage":khasiImage,
    };
}