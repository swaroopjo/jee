# Simple Services with Jersey-Jaxb-Derby-maven

Shopping cart application that provides resources as a Restful service

Application is built using Jersey 1.8, JaxB, Derby, Maven. 
Services: 
http://localhost:8080/sc-jersey-derby/rest/products
Returns list of products from Database. 

The app checks if the Products table already exists in the derby DB. if not, The Data loader loads the data from a flat file into the database.
Pojos are annotated using Jaxb to Marshall the Java Objects to XML and send it as a response. 
