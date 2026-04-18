# Weather Analyzer App 🌦️

This repository contains the winning solution for the NEIU HackFest 2026 hackathon. The application simulates a backend service designed to process, store, and analyze daily weather records for the city of Chicago.

---

## 🏆 Hackathon Details
* **Team Name:** Sleepy Threads
* **Team Members:** Jennifer McDonnell, Patrick Olszewski, Danny Panettieri, and Iris Antunez Reyna
* **Development Time:** 4 Hours (10:30 AM – 2:30 PM)
* **Achievement:** 1st Place Winner

---

## 📋 Problem Description
The goal was to build a robust system capable of handling weather data stored in a specific format. The application performs high-speed data retrieval and comprehensive statistical analysis on large datasets.

### Key Requirements:
1.  **Data Validation:** Efficiently parse input strings and ignore any records with invalid date formats using Regular Expressions.
2.  **Hybrid Storage:**
    * **List:** Used for sequential processing and global statistical calculations.
    * **Map (HashMap):** Used for $O(1)$ constant-time data retrieval when searching by date.
4.  **Core Functionalities:**
    * **Option 1 (Stats):** Calculate extreme temperatures, average humidity, total rainfall, and identify the date with the highest wind speed.
    * **Option 2 (Search):** Retrieve full weather details for a specific date provided by the user.

---

## 🛠️ Technical Specifications

### Input Format
The application expects input in the following structure:
1.  **N**: The number of weather records.
2.  **Records**: $N$ lines of comma-separated values (`MM-DD-YYYY,Temp,Humidity,WindSpeed,Rainfall`).
3.  **Query Type**: `1` for Stats, `2` for Search.
4.  **Date (Optional)**: If query type is `2`, a specific date must be provided.

### Statistics Computed
* **Highest/Lowest Temperature** (Fahrenheit)
* **Average Temperature & Humidity** (Formatted to 2 decimal places)
* **Total Rainfall** (mm)
* **Extreme Wind Events** (Identifies the first occurrence of peak wind speed)

---

## 💻 Implementation Highlights

The solution is implemented in **Java** and emphasizes clean code and efficient data structures.

```java
// Example of the Regex used for Date Validation
Pattern rg_date_format = Pattern.compile("^(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])-(19|20)\\d{2}$");
```

### Constraints Handled:
| Metric | Range |
| :--- | :--- |
| Temperature | -100 to 150 °F |
| Humidity | 0% to 100% |
| Wind Speed | 0 to 200 mph |
| Rainfall | 0 to 500 mm |

---

## 🚀 How to Run
1.  Ensure you have **JDK 8 or higher** installed.
2.  Compile the solution:
    ```bash
    javac Solution.java
    ```
3.  Run the application:
    ```bash
    java Solution
    ```
4.  Provide input via standard input or redirect from a file:
    ```bash
    java Solution < input.txt
    ```

---

## 👤 The "Sleepy Threads" Team
We are a group of developers who believe that even if we're tired, our code shouldn't be. This project showcases our ability to work under tight deadlines, implement data validation, and utilize Java Collections effectively.
