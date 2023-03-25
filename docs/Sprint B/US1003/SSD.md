@startuml
autonumber
actor "Sales Clerk" as SC

activate SC
SC -> ":System" : Starts registering new Customer
activate ":System"
":System" --> SC : requests data
deactivate ":System"

SC -> ":System" : types requested data
activate ":System"
":System" --> SC : shows the customer
deactivate ":System"

deactivate SC

@enduml