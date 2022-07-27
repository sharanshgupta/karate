# Karate Framework

* Execute **mvn test** to run testcases

### Sample GET request
curl --location --request GET 'http://localhost:8080/employee/1' \
--header 'username: user' \
--header 'password: password'

### Sample POST request
curl --location --request POST 'http://localhost:8080/employee' \
--header 'username: user' \
--header 'password: password' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Sheldon",
"age": 30
}'