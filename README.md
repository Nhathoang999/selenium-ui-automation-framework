# Enterprise UI Test Automation Framework

## Overview
This project is a robust, production-grade UI Test Automation Framework built for web applications. Designed with scalability and maintainability in mind, it implements the Page Object Model (POM) design pattern, utilizes Data-Driven Testing (DDT), and is fully integrated with a CI/CD pipeline via GitHub Actions.

## Business Value
In a real-world Agile/DevOps environment, manual testing becomes a bottleneck for continuous delivery. This framework provides immense business value by:
- Accelerating Time-to-Market (TTM): Reduces regression testing time from days to minutes.
- High ROI on Maintenance: The strict POM architecture ensures that UI changes only require updates in one centralized location, drastically reducing script maintenance overhead.
- Continuous Feedback Loop: CI/CD integration ensures developers get immediate feedback on pull requests, preventing defective code from reaching production.
- Rich Reporting for Stakeholders: Allure reports translate complex technical failures into readable, actionable metrics for Product Owners and QA Managers.

## Architecture & Tech Stack

- Language: Java 11
- Core Engine: Selenium WebDriver 4
- Test Runner: TestNG
- Build Management: Apache Maven
- Driver Management: WebDriverManager (Automated binary handling)
- Reporting: Allure Reports
- CI/CD: GitHub Actions

## Test Strategy
This framework is categorized into distinct testing layers to optimize execution time and feedback:

1. Smoke Testing (smoke.xml)
   - Purpose: Fast validation of mission-critical user journeys (e.g., Login, Add to Cart, Checkout).
   - Trigger: Runs on every single Pull Request. Fails fast if the environment is fundamentally broken.
2. Regression Testing (regression.xml)
   - Purpose: Deep, comprehensive testing of all functional modules, edge cases, and integrated features.
   - Trigger: Scheduled nightly runs and triggered before major production releases.
3. Negative Testing
   - Purpose: Validates the system's resilience against invalid data, unauthorized access, and malicious inputs. Ensures graceful error handling.
   - Approach: Handled via TestNG @DataProvider matrices to test dozens of invalid permutations through a single, maintainable script.

## How to Run Locally

### Prerequisites
- JDK 11 or higher installed and configured on PATH.
- Apache Maven installed.
- IDE of choice (IntelliJ IDEA / Eclipse).

### Execution Steps
1. Clone the repository:
   git clone https://github.com/YourUsername/selenium-ui-automation-framework.git
   cd selenium-ui-automation-framework

2. Run the entire suite:
   mvn clean test

3. Run a specific suite (e.g., Smoke):
   mvn clean test -DsuiteXmlFile=src/test/resources/suites/smoke.xml

4. Override the default browser (Chrome):
   mvn clean test -Dbrowser=firefox

### Generating the Allure Report
After test execution, generate and serve the interactive HTML report:
   mvn allure:serve

## CI/CD Pipeline
The .github/workflows/ui-tests.yml automates the testing lifecycle:
1. Checks out code and provisions an Ubuntu runner.
2. Sets up JDK 11 & Caches Maven packages to optimize build speed.
3. Executes Tests in Headless Mode against the target environment.
4. Generates and Uploads Allure Reports directly to the GitHub Action run summary as a downloadable .zip artifact.

---
Created by [Your Name] - Senior QA Automation Architect.
