# Collegify - College Prediction Web Application

## Overview

**Collegify** is a web application designed to help students identify the best colleges based on their academic performance. Built using **Spring Boot**, **Thymeleaf**, and **MySQL**, this application predicts suitable colleges for students by analyzing their percentile, department, and category, offering a user-friendly and efficient tool for college admissions.

## Features

- **Predictive Analysis:** Suggests top colleges based on user input (percentile, department, category).
- **Responsive Design:** Seamless user experience across various devices.
- **Data-Driven:** Utilizes historical cutoff data for accurate predictions.
- **Error Handling:** Provides feedback if no colleges are found for the given input.

## Technologies Used

- **Spring Boot:** Framework for building the web application.
- **Thymeleaf:** Template engine for rendering dynamic web pages.
- **MySQL:** Database for storing and retrieving college and cutoff data.
- **Bootstrap:** Framework for responsive and modern UI design.

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven**
- **MySQL** or any compatible database
- **IDE** (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/Jaykumar0710/Collegify-college-prediction-webApplication.git

2. **Navigate to Project Directory:**

    cd Collegify-college-prediction-webApplication
3. **Configure Database:**
    Set up a MySQL database and update application.properties with your database credentials.
     spring.datasource.url=jdbc:mysql://localhost:3306/mht_cetdb
     spring.datasource.username=root  
     spring.datasource.password=JaY@0710
   
5. **Build and Run the Application:**
    mvn clean install
    mvn spring-boot:run
   
6. **Access the Application:**
    Open your browser and go to http://localhost:8080 to start using the College Prediction Web Application.

**Usage**
1. **Input Details:**
Enter your percentile, department, and category in the prediction form.

3. **Get Predictions:**
The system will display a list of top colleges based on your input.

**Contributing**
Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

**Thank You So Much**


  

   


