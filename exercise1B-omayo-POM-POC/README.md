
# Selenium Java Project with Page Object Model

## Prerequisites

Before you start, ensure that you have the following installed:

- Java Development Kit (JDK)
- Selenium WebDriver
- Firefox Driver (geckodriver)
- Web browser (Firefox)

## Getting Started

Follow these steps to set up and run the project:

1. **Clone the Repository**

2. **Set Up Dependencies:**
    - Ensure that you have Java and the required Selenium WebDriver libraries set up in your project

3. **Configure the WebDriver:**
    - Set the geckodriver path in the `setUp` method of the `EndToEnd` class:
      ```java
      System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
      ```

4. **Run Tests:**
    - Execute the tests using your IDE or the build automation tool (Gradle).

5. **Review the Test Results:**
    - The tests will open the specified website and perform various actions, asserting the expected outcomes.

## Project Structure

The project is organized with the following main components:

- `tests.EndToEnd`: Test classes containing test methods.
- `pages.HomePage`: Page class representing the home page of the website under test.

