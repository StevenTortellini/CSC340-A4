The Rest API perfroms CRUD operations on animal objects
Read functions:
/animals/all returns a list of all objects
/animals/1 returns single object with an specified animalId

Create function 
/animals/new insert object into DB

Update function 
/animals/update/{animalId} update existing object

Delete function
/animals/delete/{animalId} deletes existing object (leaves Id's as is)
