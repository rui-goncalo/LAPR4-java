@startuml
package Product <<aggregate>> {
	entity Product <<Entity>> <<root>>
	object product_id <<Value Object>>
	object internal_code <<Value Object>>
	object price <<Value Object>>
	object reference <<Value Object>>
	object brand <<Value Object>>
	object photo <<Value Object>>
	object barcode <<Value Object>>
	object description_product <<Value Object>>
	object weight <<Value Object>>
	object production_code <<Value Object>>
}

package Item_Ordered <<aggregate>> {
	entity Item_Ordered <<Entity>> <<root>>
	object price_ordered <<Value Object>>
	object id_product <<Value Object>>
}

package Shop_Cart <<aggregate>> {
	entity Shop_cart <<Entity>> <<root>>
	object Item <<Value Object>>
	object quantity <<Value Object>>
}

package User <<aggregate>> {
	entity User <<Entity>> <<root>>
	object username <<Value Object>>
	object password <<Value Object>>
	object name <<Value Object>>
	object email <<Value Object>>
}

package Customer <<aggregate>> {
	entity Customer <<Entity>> <<root>>
	object ID <<Value Object>>
	object name_c <<Value Object>>
	object email_c <<Value Object>>
	object gender <<Value Object>>
	object birthdate <<Value Object>>
	object phone <<Value Object>>
	object vat <<Value Object>>
	object postalAddress <<Value Object>>
}

package Category <<aggregate>> {
	entity Category <<Entity>> <<root>>
	object description_category <<Value Object>>
	object code_category <<Value Object>>
}

package Warehouse <<aggregate>> {
	entity Warehouse <<Entity>> <<root>>
	object Plant <<Value Object>>
}

package Aisle <<aggregate>> {
	entity Aisle <<Entity>> <<root>>
	object ID_Aisle <<Value Object>>
	object accessibility <<Value Object>>
	object depth <<Value Object>>
	object begin <<Value Object>>
	object end <<Value Object>>
}

package Row <<aggregate>> {
	entity Row <<Entity>> <<root>>
	object rowID <<Value Object>>
	object begin_r <<Value Object>>
	object end_r <<Value Object>>
	object shelf <<Value Object>>
}

package AGV <<aggregate>> {
	entity AGV <<Entity>> <<root>>
	object AGV_Description <<Value Object>>
	object maxWeight <<Value Object>>
	object dock <<Value Object>>
	object model <<Value Object>>
	object identifier <<Value Object>>
	object task <<Value Object>>
}

package Route <<aggregate>> {
	entity Route <<Entity>> <<root>>
	object position <<Value Object>>
}

package Order <<aggregate>> {
	entity Order <<Entity>> <<root>>
	object date <<Value Object>>
	object payment_method <<Value Object>>
	object clerk <<Value Object>>
	object id_order <<Value Object>>
	object status <<Value Object>>
	object tax <<Value Object>>
}

package Shipment <<aggregate>> {
	entity Shipment <<Entity>> <<root>>
	object shipment_type <<Value Object>>
	object cost <<Value Object>>
}

package Questionnaire <<aggregate>> {
	entity Questionnaire <<Entity>> <<root>>
	object ID_questionnaire <<Value Object>>
	object code <<Value Object>>
	object description <<Value Object>>
	object final_message <<Value Object>>
	object title <<Value Object>>
	object welcome_message <<Value Object>>
}

package Section <<aggregate>> {
	entity Section <<Entity>> <<root>>
	object ID_section <<Value Object>>
	object title_section <<Value Object>>
	object description_section <<Value Object>>
	object repeatability <<Value Object>>
	object obligatoriness <<Value Object>>
}

package Question <<aggregate>> {
	entity Question <<Entity>> <<root>>
	object ID_question <<Value Object>>
	object instruction <<Value Object>>
	object type_question <<Value Object>>
	object extra_info <<Value Object>>
	object obligatoriness_question <<Value Object>>
	object answer <<Value Object>>
}

Product -- "1" product_id : has
Product -- "1" internal_code : has
Product -- "1" price : has
Product -- "1" reference : has
Product -- "1" brand : has
Product -- "1" photo : has
Product -- "1" barcode : has
Product -- "1" description_product : has
Product -- "1" weight : has
Product -- "1" production_code : has
Product "*" -- "1" Category : belongs to >
Product "1..*" -- "1" id_product : has >
Product "1..*" -- "1" Warehouse : stores <

Item_Ordered -- "1" price_ordered : has
Item_Ordered -- "1" id_product : has
Item_Ordered "1..*" -- "1" Order : has <

Shop_cart -- "1" Item : has
Shop_cart -- "1" quantity : has
Shop_cart "1" -- "1" Customer : belongs to >
Item "1" -- "1" id_product : has >

User -- "1" username : has
User -- "1" password : has
User -- "1" name : has
User -- "1" email : has

Customer -- "1" ID : has
Customer -- "1" name_c : has
Customer -- "1" email_c : has
Customer -- "1" gender : has
Customer -- "1" birthdate : has
Customer -- "1" phone : has
Customer -- "1" vat : has
Customer -- "1" postalAddress : has
Customer "1" -- "1" User : associated to >
Customer "1" -- "1" Order : belongs to <
Customer "1" -- "*" answer : has >

Category -- "1" description_category : has
Category -- "1" code_category : has
Category "1" -- "1..*" Category : has >

Warehouse -- "1" Plant : has
Warehouse "1" -- "1..*" AGV : has >
Warehouse "1" -- "1..*" Aisle : has a set of >

Aisle -- "1" ID_Aisle : has
Aisle -- "1" accessibility : has
Aisle -- "1" depth : has
Aisle -- "1" begin : has
Aisle -- "1" end : has
Aisle "1" -- "1..*" Row : has >

Row -- "1" rowID : has
Row -- "1" begin_r : has
Row -- "1" end_r : has
Row -- "1" shelf : has

AGV -- "1" AGV_Description : has
AGV -- "1" maxWeight : has
AGV -- "1" dock : has
AGV -- "1" model : has
AGV -- "1" identifier : has
AGV -- "1" task : has
AGV "1" -- "1" Route : has >

Route -- "1" position : has

Order -- "1" date : has
Order -- "1" payment_method : has
Order -- "1" clerk : has
Order -- "1" id_order : has
Order -- "1" status : has
Order -- "1" tax : has
Order "1" -- "1" Shipment : has >

Shipment "1..*" -- "1" shipment_type : has
Shipment -- "1" cost : has

Questionnaire -- "1" ID_questionnaire : has
Questionnaire -- "1" code : has
Questionnaire -- "1" description : has
Questionnaire -- "1" final_message : has
Questionnaire -- "1" title : has
Questionnaire -- "1" welcome_message : has
Questionnaire "1..*" -- "1" Customer : has <
Questionnaire "1" -- "1..*" Section : has >

Section -- "1" ID_section : has
Section -- "1" title_section : has
Section -- "1" description_section : has
Section -- "1" repeatability : has
Section -- "1" obligatoriness : has
Section "1" -- "1..*" Question : has >

Question -- "1" ID_question : has
Question -- "1" instruction : has
Question -- "1" type_question : has
Question -- "1" extra_info : has
Question -- "1" obligatoriness_question : has
Question "1" -- "1..*" answer : has >
@enduml