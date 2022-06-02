Environment assumptions:
1. JDK installed
2. Maven installed

The Framework has been developed as follows:
1. Page Object Model design pattern + Page Factory
2. BDD (Cucumber tool and the gherkin syntax to write the test cases)
3. Maven
4. Junit
5. Selenium Web Drive (Browser supported Chrome)
6. RestAssured library to test Rest API task

Instruction to run the project:

1. Open a terminal window

1.1 Clone on your local machine the public git repository where is located the project:
git clone https://github.com/fabioridango/rivertech.git

1.2 Move to “rivertech” directory

1.3 Execute the following sequence of commands:

mvn clean test

mvn compile

mvn test

2. Result: The Cucumber test runner are performed