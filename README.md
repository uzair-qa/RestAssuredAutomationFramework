🚀 Rest Assured Hybrid API Automation Framework
-----------------------------------------------
A scalable and maintainable API Automation Framework built using Java, Rest Assured, and TestNG, following real-world enterprise automation practices with CI execution via Jenkins.


📝 Purpose
----------
This project demonstrates real-world API automation framework design, data-driven testing, and CI integration, and is intended for practical learning and practise.


✨ Highlights
-------------
- Hybrid framework (POJO + Data Driven)
- Clean layered architecture
- Centralized API route management
- Excel-based data-driven testing
- Rich HTML reporting & logging
- Maven-based execution
- Jenkins CI integration


🧱 Framework Architecture
-------------------------
Routes (URLs)
   ↓
Endpoints (HTTP Requests)
   ↓
Payloads (POJO)
   ↓
Test Cases (TestNG)
   ↓
Reports & Logs


🛠️ Tech Stack
-------------
- Java
- Rest Assured
- TestNG
- Maven
- Apache POI (Excel handling)
- Java Faker (test data generation)
- Extent Reports
- Log4j2
- Git & GitHub

Jenkins
-------
📂 Project Structure
src/main/java
 ├── api.routes        → API URLs
 ├── api.endpoints     → HTTP request methods
 ├── api.payload       → POJO payloads
 └── api.utilities     → Excel, Reports, Logs

src/test/java
 ├── api.testcases     → Test classes
 └── api.dataproviders → TestNG DataProviders

src/test/resources
 ├── testdata          → Excel files
 ├── log4j2.xml
 └── testng.xml

🔑 Key Features
---------------
✔ Centralized endpoint management
✔ Reusable API request methods
✔ POJO-based request payloads
✔ Data-driven testing using Excel
✔ Dynamic test data with Java Faker
✔ Detailed execution reports
✔ Logging for debugging and analysis
✔ CI-ready Maven execution


📊 Reporting & Logging
----------------------

- Extent Reports provide detailed execution status
- Log4j2 captures request/response and execution logs
- Reports and logs are generated at runtime and excluded from Git

▶️ Test Execution
----------------
- Run from IDE
  Right click → pom.xml → Run As → Maven Test

- Run from Command Line
  mvn clean test

🔄 CI Integration (Jenkins)
---------------------------

- Jenkins pulls code from GitHub
- Executes tests using Maven
- Generates reports and logs
- Build status reflects test results (SUCCESS / FAILURE)

👤 Author
---------
Mohammad Uzair Khan