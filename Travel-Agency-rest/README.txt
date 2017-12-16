Create new (using GitBash ,Windows command line have problem with symbol ')
curl -X POST -i -H "Content-Type: application/json" --data '{"name":"New Trip","dateFrom":"2015-01-01","dateTo":"2015-01-10","destination":"Kosice","price":1000.00,"availableSpots":10}' http://localhost:8080/pa165/rest/trips/create

Update
curl -X PUT -i -H "Content-Type: application/json" --data '{"id":1,"name":"Updated Trip","dateFrom":"2015-01-01","dateTo":"2015-01-10","destination":"KosiceUpdated","price":500.00,"availableSpots":200}' http://localhost:8080/pa165/rest/trips/1

List all
curl -i -X GET http://localhost:8080/pa165/rest/trips

List with id 1
curl -i -X GET http://localhost:8080/pa165/rest/trips/1

Delete with id 1
curl -i -X DELETE http://localhost:8080/pa165/rest/trips/1
