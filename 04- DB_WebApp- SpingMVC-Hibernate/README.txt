- This section contains CRM applications one with XML configuration and the other is a Maven app with a Java class configuration.
  It also contains the scripts to create the database on Mysql.

- CRM application is a Customer RelatioRelationship Management provides listing, adding, updating and deleting cunstmers from a database
- The application is structured as follows:

Web browser ---Request 1--> Controller ----2----> Service---3--> Data Access Object ---4---> Database
				| Model<----7---- 	<---6----	DAO	  <---5----	
				|
				|
				8
				|
				|
				V
Web browser  <-----9------  Jsp Page

The Data Access Object flow:
DAO <----> Session Factory <----> Data Source <----> Database
