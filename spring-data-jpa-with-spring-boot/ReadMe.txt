Create single person
POST
http://localhost:8080/person
{
    "id": 1,
    "age": 32,
    "firstName": "John",
    "lastName": "Doe"
}

Create multiple Person
POST
http://localhost:8080/persons
[
	{
    "id": 2,
    "age": 21,
    "firstName": "Sara",
    "lastName": "Nichol"
	},
	{
    "id": 3,
    "age": 28,
    "firstName": "Matt",
    "lastName": "Daemon"
	},
	{
    "id": 4,
    "age": 45,
    "firstName": "Richard",
    "lastName": "Brown"
	},
	{
    "id": 5,
    "age": 52,
    "firstName": "Claire",
    "lastName": "Kendall"
	},
	{
    "id": 6,
    "age": 35,
    "firstName": "David",
    "lastName": "Dough"
	}
]

Retrieve a person by id
GET
http://localhost:8080/person/2

Retrieve All Person
GET
http://localhost:8080/person

Retrieve Person by name
http://localhost:8080/personByName/David

Update Person
http://localhost:8080/person
{
    "id": 2,
    "age": 21,
    "firstName": "Sara",
    "lastName": "Nichol1123"
}

Delete
http://localhost:8080/person/1

Delete All
http://localhost:8080/persons