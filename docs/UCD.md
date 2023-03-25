@startuml
!theme lightgray
left to right direction
actor "Project Manager" as pm
actor "Sales Clerk" as sc
actor "Warehouse Employee" as we
actor "Software Product Client" as spc
actor "Sales Manager" as sm
actor "Customer" as c

  usecase "G002: Elaborate a Domain Model using DDD." as G002
  usecase "G003: Configure the project repository." as G003
  usecase "G004: Configure the project structure to facilitate/accelerate the development of upcoming user stories." as G004
  usecase "US1001: Specify a new product for sale." as US1001
  usecase "US1002: View/search the products catalog." as US1002
  usecase "US1003: Register a new customer." as US1003
  usecase "US1004: Create a new products order on behalf of a given customer." as US1004
  usecase "US2001: Set up the warehouse plant by uploading a JSON file." as US2001
  usecase "US9001: Prepare a presentation." as US9001
  usecase "US1900: The system has the possibility of being initialized (bootstrap) with some information related to the product catalog and auxiliary information." as US1900
  usecase "US2002: Configure the AGVs available on the warehouse." as US2002
  usecase "US1005: Define a new category of products." as US1005
  
  usecase "US2003: Access the list of orders that need to be prepared by an AGV and be able to ask/force any of those orders to be immediately prepared by an AGV available." as US2003
  usecase "US3000: Specify a grammar allowing to express several kinds of questionnaires." as US3000
  usecase "US3001: Create a new questionnaire to be further answered by customers meeting the specified criteria." as US3001
  usecase "US4001: The "AGVManager" component supports properly, at request, the needs of the "BackOfficeApp" application as well as the needs the AGV digital twin." as US4001
  usecase "US4002: The "AGVManager" component is enhanced with a basic FIFO algorithm to automatically assign tasks to AGVs." as US4002
  usecase "US5001: Start developing the input communication module of the AGV digital twin to accept requests from the "AGVManager"." as US5001
  usecase "US5002: Start developing the output communication module of the AGV digital twin to update its status on the "AGVManager"." as US5002
  usecase "US2004: Access the list of orders that have already been prepared by the AGVs and be able to update any of those orders as having been dispatched for customer delivery. " as US2004
  usecase "US2005: Open a web dashboard presenting the current status of the AGVs as well as their position in the warehouse layout and keeps updated automatically." as US2005
  usecase "US1501: View/search the product catalog and be able to add a product to the shopping cart." as US1501
  usecase "US1901: The "OrdersServer" component supports properly, at request, the needs of the "CustomerAppMain" application." as US1901
  usecase "US3002: Get a statistical report regarding a previously set up questionnaire." as US3002
  usecase "US3501: List of questionnaires that the system is asking me to answer and be able to answer any of those questionnaires." as US3501
  usecase "US4003: Communications (of the AGVManager) made through the SPOMS2022 protocol to be secured/protected." as US4003
  usecase "US5003: Input communications (of the AGV Digital Twin) made through the SPOMS2022 protocol to be secured/protected." as US5003
  usecase "US5004: Output communications  (of the AGV Digital Twin) made through the SPOMS2022 protocol to be secured/protected." as US5004
  usecase "US5100: Develop and integrate the others components/parts of the AGV digital twin (e.g.: movement, obstacle sensors, control unit)." as US5100
  usecase "US9002: Prepare a presentation" as US9002  
  usecase "US1006: Access a list of orders that had been dispatched for customer delivery and be able to update some of those orders to as being delivered. " as US1006  
  usecase "US2006: Communications made through the SPOMS2022 protocol to be secured/protected." as US2006  
  usecase "US1502: View/check the status of my open orders." as US1502
  usecase "US1902: I want the communications made through the SPOMS2022 protocol to be secured/protected." as US1902
  
  

pm --> G002
pm --> G003
pm --> G004
pm --> US1900
pm --> US3000
pm --> US4001
pm --> US4002
pm --> US5001
pm --> US5002
pm --> US1901
pm --> US4003
pm --> US5003
pm --> US5004
pm --> US5100
pm --> US2006
pm --> US1902

sc --> US1001
sc --> US1002
sc --> US1003
sc --> US1004
sc --> US1005
sc --> US1006

we --> US2001
we --> US2002
we --> US2003
we --> US2004
we --> US2005

spc --> US9001
spc --> US9002

sm --> US3001
sm --> US3002

c --> US1501
c --> US3501
c --> US1502

@enduml