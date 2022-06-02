Feature: Get Request

  //@APITest
  Scenario Outline: Perform Get request and verify that the response has the expected fields and values
    Given Get request to API "<baseURI>"
    Then Response is satus code "<statusCode>"
    And  Response has the expected fields and values id:"<idV>", name:"<nameV>", username:"<usernameV>", email:"<emailV>", street:"<streetV>", suite:"<suiteV>", city:"<cityV>", zipcode:"<zipcodeV>", lat:"<latV>", lng:"<lngV>", phone:"<phoneV>", website:"<websiteV>", name:"<nameCV>", catchPhrase:"<catchPhraseV>", bs:"<bsV>"

    Examples:
    | baseURI                                      | statusCode | idV | nameV         | usernameV | emailV            | streetV     | suiteV   | cityV       | zipcodeV   | latV     | lngV    | phoneV                | websiteV      | nameCV          | catchPhraseV                           | bsV                         |
    | https://jsonplaceholder.typicode.com/users/1 | 200        | 1   | Leanne Graham | Bret      | Sincere@april.biz | Kulas Light | Apt. 556 | Gwenborough | 92998-3874 | -37.3159 | 81.1496 | 1-770-736-8031 x56442 | hildegard.org | Romaguera-Crona | Multi-layered client-server neural-net | harness real-time e-markets |