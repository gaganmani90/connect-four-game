## Compile ##
`mvn clean verify`
## Run Service ##
`java -jar target/9dt-backend-1.0-SNAPSHOT.jar server src/main/resources/local.yml`
## Test service manually ##
```
 curl --header "Content-type: Application/json" -X POST http://localhost:8080/drop_token -d'{ "players":["p1", "p2"], "rows":4, "columns":4}'
```


## APIs 
https://www.getpostman.com/collections/7e539a66ff079f500b60
```json
{
	"info": {
		"_postman_id": "18d133e0-f65b-4689-85d1-b1be2c940ed5",
		"name": "drop-token",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "createGame",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"players\" : [\"Gagan\", \"Shivani\"],\n    \"columns\": 4,\n    \"rows\": 4\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/drop_token/",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"drop_token",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "getGames",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/drop_token/123",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"drop_token",
						"123"
					]
				}
			},
			"response": []
		},
		{
			"name": "getMoves",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/drop_token/123/moves/123",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"drop_token",
						"123",
						"moves",
						"123"
					]
				}
			},
			"response": []
		},
		{
			"name": "getMove",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/drop_token/123/moves/123",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"drop_token",
						"123",
						"moves",
						"123"
					]
				}
			},
			"response": []
		},
		{
			"name": "getGameStatus",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/drop_token/123",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"drop_token",
						"123"
					]
				}
			},
			"response": []
		},
		{
			"name": "playerQuit",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/drop_token/123/1233",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"drop_token",
						"123",
						"1233"
					]
				}
			},
			"response": []
		},
		{
			"name": "postMove",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"column\": 4\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/drop_token/123/1234",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"drop_token",
						"123",
						"1234"
					]
				}
			},
			"response": []
		}
	],
	"protocolProfileBehavior": {}
}
```