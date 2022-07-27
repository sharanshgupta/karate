Feature: Get tests

  Background:
    * url 'http://localhost:8080/employee/'

    Scenario: Get invalid employee
      Given path '1'
      And header username = "user"
      And header password = "password"
      When method GET
      Then status 404

    Scenario: Create employee
      Given path ''
      And request { "name": "Sheldon", "age": 30 }
      And header username = "user"
      And header password = "password"
      And header Content-Type = "application/json"
      When method POST
      Then status 200
      Then match response == { "id": 1, "name": "Sheldon", "age": 30 }

    Scenario: Get valid employee
      Given path '1'
      And header username = "user"
      And header password = "password"
      When method GET
      Then status 200
      Then match response == { "id": 1, "name": "Sheldon", "age": 30 }