# Movie Ticket Booking System

A comprehensive web-based movie ticket booking application with automated Selenium tests. This project demonstrates a complete movie ticket booking workflow, including login, movie selection, showtime selection, seat selection, and payment processing.

## 🎥 Demo Video  
<video width="600" controls>
  <source src="video/demo.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>

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

## Test Artifacts

## Setup Instructions

### Prerequisites

* Java JDK 17 or higher
* Maven
* Google Chrome browser
* Node.js (optional, for running a local web server)

### Web Application Setup

1. Clone the repository:
   <pre><div class="relative flex flex-col rounded-lg"><div class="text-text-300 absolute pl-3 pt-2.5 text-xs"></div><div class="pointer-events-none sticky my-0.5 ml-0.5 flex items-center justify-end px-1.5 py-1 mix-blend-luminosity top-0"><div class="from-bg-300/90 to-bg-300/70 pointer-events-auto rounded-md bg-gradient-to-b p-0.5 backdrop-blur-md"><button class="flex flex-row items-center gap-1 rounded-md p-1 py-0.5 text-xs transition-opacity delay-100 text-text-300 hover:bg-bg-200 opacity-60 hover:opacity-100" data-state="closed"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" viewBox="0 0 256 256" class="text-text-500 mr-px -translate-y-[0.5px]"><path d="M200,32H163.74a47.92,47.92,0,0,0-71.48,0H56A16,16,0,0,0,40,48V216a16,16,0,0,0,16,16H200a16,16,0,0,0,16-16V48A16,16,0,0,0,200,32Zm-72,0a32,32,0,0,1,32,32H96A32,32,0,0,1,128,32Zm72,184H56V48H82.75A47.93,47.93,0,0,0,80,64v8a8,8,0,0,0,8,8h80a8,8,0,0,0,8-8V64a47.93,47.93,0,0,0-2.75-16H200Z"></path></svg><span class="text-text-200 pr-0.5"></span></button></div></div><div><div class="prismjs code-block__code !my-0 !rounded-lg !text-sm !leading-relaxed"><code><span class=""><span class="">git clone https://github.com/your-username/Movie-ticket-booking-system.git
   </span></span><span class="">cd movie-ticket-booking</span></code></div></div></div></pre>
2. Host the web application:
   * Option 1: Using Python's built-in HTTP server:
     <pre><div class="relative flex flex-col rounded-lg"><div class="text-text-300 absolute pl-3 pt-2.5 text-xs"></div><div class="pointer-events-none sticky my-0.5 ml-0.5 flex items-center justify-end px-1.5 py-1 mix-blend-luminosity top-0"><div class="from-bg-300/90 to-bg-300/70 pointer-events-auto rounded-md bg-gradient-to-b p-0.5 backdrop-blur-md"><button class="flex flex-row items-center gap-1 rounded-md p-1 py-0.5 text-xs transition-opacity delay-100 text-text-300 hover:bg-bg-200 opacity-60 hover:opacity-100" data-state="closed"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" viewBox="0 0 256 256" class="text-text-500 mr-px -translate-y-[0.5px]"><path d="M200,32H163.74a47.92,47.92,0,0,0-71.48,0H56A16,16,0,0,0,40,48V216a16,16,0,0,0,16,16H200a16,16,0,0,0,16-16V48A16,16,0,0,0,200,32Zm-72,0a32,32,0,0,1,32,32H96A32,32,0,0,1,128,32Zm72,184H56V48H82.75A47.93,47.93,0,0,0,80,64v8a8,8,0,0,0,8,8h80a8,8,0,0,0,8-8V64a47.93,47.93,0,0,0-2.75-16H200Z"></path></svg><span class="text-text-200 pr-0.5"></span></button></div></div><div><div class="prismjs code-block__code !my-0 !rounded-lg !text-sm !leading-relaxed"><code><span class=""><span class="">python -m http.server 3000</span></span></code></div></div></div></pre>
   * Option 2: Using Node.js:
     <pre><div class="relative flex flex-col rounded-lg"><div class="text-text-300 absolute pl-3 pt-2.5 text-xs"></div><div class="pointer-events-none sticky my-0.5 ml-0.5 flex items-center justify-end px-1.5 py-1 mix-blend-luminosity top-0"><div class="from-bg-300/90 to-bg-300/70 pointer-events-auto rounded-md bg-gradient-to-b p-0.5 backdrop-blur-md"><button class="flex flex-row items-center gap-1 rounded-md p-1 py-0.5 text-xs transition-opacity delay-100 text-text-300 hover:bg-bg-200 opacity-60 hover:opacity-100" data-state="closed"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" viewBox="0 0 256 256" class="text-text-500 mr-px -translate-y-[0.5px]"><path d="M200,32H163.74a47.92,47.92,0,0,0-71.48,0H56A16,16,0,0,0,40,48V216a16,16,0,0,0,16,16H200a16,16,0,0,0,16-16V48A16,16,0,0,0,200,32Zm-72,0a32,32,0,0,1,32,32H96A32,32,0,0,1,128,32Zm72,184H56V48H82.75A47.93,47.93,0,0,0,80,64v8a8,8,0,0,0,8,8h80a8,8,0,0,0,8-8V64a47.93,47.93,0,0,0-2.75-16H200Z"></path></svg><span class="text-text-200 pr-0.5"></span></button></div></div><div><div class="prismjs code-block__code !my-0 !rounded-lg !text-sm !leading-relaxed"><code><span class=""><span class="">npm install -g http-server
     </span></span><span class="">http-server -p 3000</span></code></div></div></div></pre>
3. Access the application at `http://localhost:3000`

### Running Tests

1. Configure the test URL in `MovieTicketBookingTest.java` if needed:
   <pre><div class="relative flex flex-col rounded-lg"><div class="text-text-300 absolute pl-3 pt-2.5 text-xs">java</div><div class="pointer-events-none sticky my-0.5 ml-0.5 flex items-center justify-end px-1.5 py-1 mix-blend-luminosity top-0"><div class="from-bg-300/90 to-bg-300/70 pointer-events-auto rounded-md bg-gradient-to-b p-0.5 backdrop-blur-md"><button class="flex flex-row items-center gap-1 rounded-md p-1 py-0.5 text-xs transition-opacity delay-100 text-text-300 hover:bg-bg-200 opacity-60 hover:opacity-100" data-state="closed"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" viewBox="0 0 256 256" class="text-text-500 mr-px -translate-y-[0.5px]"><path d="M200,32H163.74a47.92,47.92,0,0,0-71.48,0H56A16,16,0,0,0,40,48V216a16,16,0,0,0,16,16H200a16,16,0,0,0,16-16V48A16,16,0,0,0,200,32Zm-72,0a32,32,0,0,1,32,32H96A32,32,0,0,1,128,32Zm72,184H56V48H82.75A47.93,47.93,0,0,0,80,64v8a8,8,0,0,0,8,8h80a8,8,0,0,0,8-8V64a47.93,47.93,0,0,0-2.75-16H200Z"></path></svg><span class="text-text-200 pr-0.5"></span></button></div></div><div><div class="prismjs code-block__code !my-0 !rounded-lg !text-sm !leading-relaxed"><code class="language-java"><span class=""><span class="token keyword">private</span><span class=""></span><span class="token class-name">String</span><span class=""> testUrl </span><span class="token operator">=</span><span class=""></span><span class="token string">"http://localhost:3000"</span><span class="token punctuation">;</span></span></code></div></div></div></pre>
2. Run tests using Maven:
   <pre><div class="relative flex flex-col rounded-lg"><div class="text-text-300 absolute pl-3 pt-2.5 text-xs"></div><div class="pointer-events-none sticky my-0.5 ml-0.5 flex items-center justify-end px-1.5 py-1 mix-blend-luminosity top-0"><div class="from-bg-300/90 to-bg-300/70 pointer-events-auto rounded-md bg-gradient-to-b p-0.5 backdrop-blur-md"><button class="flex flex-row items-center gap-1 rounded-md p-1 py-0.5 text-xs transition-opacity delay-100 text-text-300 hover:bg-bg-200 opacity-60 hover:opacity-100" data-state="closed"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" viewBox="0 0 256 256" class="text-text-500 mr-px -translate-y-[0.5px]"><path d="M200,32H163.74a47.92,47.92,0,0,0-71.48,0H56A16,16,0,0,0,40,48V216a16,16,0,0,0,16,16H200a16,16,0,0,0,16-16V48A16,16,0,0,0,200,32Zm-72,0a32,32,0,0,1,32,32H96A32,32,0,0,1,128,32Zm72,184H56V48H82.75A47.93,47.93,0,0,0,80,64v8a8,8,0,0,0,8,8h80a8,8,0,0,0,8-8V64a47.93,47.93,0,0,0-2.75-16H200Z"></path></svg><span class="text-text-200 pr-0.5"></span></button></div></div><div><div class="prismjs code-block__code !my-0 !rounded-lg !text-sm !leading-relaxed"><code><span class=""><span class="">mvn clean test</span></span></code></div></div></div></pre>
3. Test results will be generated in the `target/surefire-reports` directory

The test execution generates the following artifacts:

* Screenshots: Stored in the `screenshots` directory
* Logs: Stored in the `logs` directory
* Test Reports: Generated in the `target/surefire-reports` directory

## Bonus Features

* Responsive design for mobile and desktop
* Animated transitions between booking steps
* Visual progress indicator for the booking process
* Wallet balance display that updates in real-time
* Confirmation page with booking details and ticket code

## Credentials for Testing

The system is pre-configured with the following test users:

1. Username: `user1`, Password: `password1`, Wallet Balance: $100
2. Username: `user2`, Password: `password2`, Wallet Balance: $50

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
