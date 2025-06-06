# luminor-home-task

This repository provides a framework for automated UI testing using Selenide, TestNG and Allure Reporting. It is designed to work with Java 17 and Gradle.

## Getting Started

### Prerequisites

Ensure the following are installed on your system:
 - Java: Version 17
 - Gradle: Latest version

### Installation

1. Clone the repository
    ```sh
   git clone https://github.com/artursnikitakoblinecs/luminor-home-task.git
    ```
2. Navigate to the project directory
    ```sh
   cd luminor-home-task
    ```
3. Install dependencies
    ```sh
   gradle clean build
    ```

## Running Tests

- Run tests using Gradle
    ```sh
   gradle clean test
    ```

## Generating Allure Report

- Generate and View Allure Report (once tests have been executed at least once) using command
    ```sh
    ./gradlew allureServe
    ```