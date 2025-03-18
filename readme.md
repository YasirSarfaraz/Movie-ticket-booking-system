# Movie Ticket Booking System

A comprehensive web-based movie ticket booking application with automated Selenium tests. This project demonstrates a complete movie ticket booking workflow, including login, movie selection, showtime selection, seat selection, and payment processing.

## Project Structure

- **movie-ticket-booking**: Frontend application
- **movie-ticket-booking-test**: Automated test suite

## Features

- **User Authentication**: Secure login system
- **Movie Selection**: Browse available movies with details
- **Date & Time Selection**: Choose from available showtimes
- **Seat Selection**: Interactive seat map for selection
- **Payment Processing**: Payment validation with balance checks
- **Booking Confirmation**: Confirmation and receipt generation

## Test Coverage

The automated test suite covers the entire booking workflow:

1. User login
2. Movie selection
3. Date and time selection
4. Seat selection
5. Payment processing (both successful and insufficient balance scenarios)
6. Return to login functionality

All tests passed successfully as of March 18, 2025.

## Technology Stack

### Frontend

- HTML5
- CSS3
- JavaScript

### Testing

- Java 17
- Selenium WebDriver 4.16.1
- TestNG 7.8.0
- Maven

## Setup Instructions

### Prerequisites

- JDK 17 or higher
- Maven
- Chrome browser
- Node.js and npm (for serving the frontend)

### Running the Frontend


1. Navigate to the frontend directory:
```
    cd c:\Users\yasir\OneDrive\Desktop\moviee\movie-ticket-booking
```
2. Start a local server:
```
    npm install -g http-server http-server -p 3000
```
3. Access the application at ``` http://localhost:3000 ```

### Running the Tests

1. Navigate to the test directory: 
```cd c:\Users\yasir\OneDrive\Desktop\moviee\movie-ticket-booking-test```
2. Run tests using Maven:
``` mvn clean test ```
3. View test results in the `target/surefire-reports` directory and screenshots in the `screenshots` folder

## Test Results

The test suite includes 7 test methods that validate different aspects of the booking process. All tests pass successfully with the following execution times:

- **testLogin**: 1067ms
- **testMovieSelection**: 455ms
- **testDateTimeSelection**: 356ms
- **testSeatSelection**: 420ms
- **testPaymentWithSufficientBalance**: 436ms
- **testInsufficientBalance**: 983ms
- **testReturnToLogin**: 262ms

Test artifacts including screenshots are generated during test execution.

## Acknowledgments

- Selenium WebDriver team for their excellent testing framework
- TestNG team for the comprehensive testing framework