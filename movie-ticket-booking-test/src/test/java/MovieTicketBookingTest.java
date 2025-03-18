import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MovieTicketBookingTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger;
    private String screenShotPath = "screenshots/";
    private String logFilePath = "logs/";
    private String testUrl = "http://localhost:3000"; // Update with your actual URL

    @BeforeClass
    public void setup() {
        try {
            // Set up logging
            setupLogger();
            logger.info("Setting up test environment");
            
            // Create directories for screenshots and logs if they don't exist
            Files.createDirectories(Paths.get(screenShotPath));
            Files.createDirectories(Paths.get(logFilePath));
            
            // Setup Chrome driver
            ChromeOptions options = new ChromeOptions();
            // Add options if needed, e.g., headless mode
            // options.addArguments("--headless");
            
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Maximize window
            driver.manage().window().maximize();
            logger.info("Browser started successfully");
        } catch (Exception e) {
            logger.severe("Error during setup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void testLogin() {
        try {
            logger.info("Starting login test");
            
            // Navigate to the website
            driver.get(testUrl);
            takeScreenshot("01_initial_page");
            
            // Find login form elements
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            
            // Enter credentials
            usernameField.sendKeys("user1");
            passwordField.sendKeys("password1");
            
            // Take screenshot before clicking login
            takeScreenshot("02_login_form_filled");
            
            // Click login button
            loginButton.click();
            
            // Wait for booking container to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookingContainer")));
            
            // Verify wallet balance is displayed
            WebElement walletDisplay = driver.findElement(By.id("walletDisplay"));
            Assert.assertTrue(walletDisplay.isDisplayed(), "Wallet balance should be displayed after login");
            String walletText = walletDisplay.getText();
            Assert.assertTrue(walletText.contains("$100.00"), "Wallet should show $100.00 for user1");
            
            takeScreenshot("03_after_login");
            logger.info("Login test completed successfully");
        } catch (Exception e) {
            logger.severe("Error during login test: " + e.getMessage());
            takeScreenshot("error_login");
            Assert.fail("Login test failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testMovieSelection() {
        try {
            logger.info("Starting movie selection test");
            
            // Wait for movie cards to be visible
            List<WebElement> movieCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("movie-card")));
            Assert.assertTrue(movieCards.size() > 0, "Movie cards should be displayed");
            
            // Select the first movie
            movieCards.get(0).click();
            
            // Verify movie is selected
            wait.until(ExpectedConditions.attributeContains(movieCards.get(0), "class", "selected"));
            
            // Take screenshot after movie selection
            takeScreenshot("04_movie_selected");
            
            // Continue to date-time selection
            WebElement continueButton = driver.findElement(By.id("continueToDateTime"));
            Assert.assertFalse(continueButton.getAttribute("class").contains("disabled"), "Continue button should be enabled");
            continueButton.click();
            
            // Verify date-time selection page is displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateTimeSelection")));
            
            logger.info("Movie selection test completed successfully");
        } catch (Exception e) {
            logger.severe("Error during movie selection test: " + e.getMessage());
            takeScreenshot("error_movie_selection");
            Assert.fail("Movie selection test failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testDateTimeSelection() {
        try {
            logger.info("Starting date and time selection test");
            
            // Wait for date options to be visible
            List<WebElement> dateOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("date-option")));
            Assert.assertTrue(dateOptions.size() > 0, "Date options should be displayed");
            
            // Select the first date
            dateOptions.get(0).click();
            
            // Verify date is selected
            wait.until(ExpectedConditions.attributeContains(dateOptions.get(0), "class", "selected"));
            
            // Select the first time slot
            List<WebElement> timeOptions = driver.findElements(By.className("time-option"));
            Assert.assertTrue(timeOptions.size() > 0, "Time options should be displayed");
            timeOptions.get(0).click();
            
            // Verify time is selected
            wait.until(ExpectedConditions.attributeContains(timeOptions.get(0), "class", "selected"));
            
            // Take screenshot after date and time selection
            takeScreenshot("05_date_time_selected");
            
            // Continue to seat selection
            WebElement continueButton = driver.findElement(By.id("continueToSeats"));
            Assert.assertFalse(continueButton.getAttribute("class").contains("disabled"), "Continue button should be enabled");
            continueButton.click();
            
            // Verify seat selection page is displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("seatSelection")));
            
            logger.info("Date and time selection test completed successfully");
        } catch (Exception e) {
            logger.severe("Error during date and time selection test: " + e.getMessage());
            takeScreenshot("error_date_time_selection");
            Assert.fail("Date and time selection test failed: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void testSeatSelection() {
        try {
            logger.info("Starting seat selection test");
            
            // Wait for seats to be visible
            List<WebElement> seats = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("seat")));
            Assert.assertTrue(seats.size() > 0, "Seats should be displayed");
            
            // Find available seats (not booked)
            List<WebElement> availableSeats = seats.stream()
                .filter(seat -> !seat.getAttribute("class").contains("booked"))
                .limit(2)
                .toList();
            
            // Select two seats
            for (WebElement seat : availableSeats) {
                seat.click();
                wait.until(ExpectedConditions.attributeContains(seat, "class", "selected"));
            }
            
            // Take screenshot after seat selection
            takeScreenshot("06_seats_selected");
            
            // Verify seats are selected
            Assert.assertEquals(availableSeats.size(), 2, "Two seats should be selected");
            
            // Verify continue button is enabled
            WebElement continueButton = driver.findElement(By.id("continueToPayment"));
            Assert.assertFalse(continueButton.getAttribute("class").contains("disabled"), "Continue button should be enabled");
            
            // Verify booking summary is updated
            WebElement summarySeats = driver.findElement(By.id("summarySeats"));
            Assert.assertFalse(summarySeats.getText().equals("None"), "Selected seats should be displayed in summary");
            
            // Verify total price is updated
            WebElement summaryTotal = driver.findElement(By.id("summaryTotal"));
            String totalText = summaryTotal.getText();
            Assert.assertTrue(totalText.contains("$24.00"), "Total price should be $24.00 for 2 seats");
            
            // Continue to payment
            continueButton.click();
            
            // Verify payment section is displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentSection")));
            
            logger.info("Seat selection test completed successfully");
        } catch (Exception e) {
            logger.severe("Error during seat selection test: " + e.getMessage());
            takeScreenshot("error_seat_selection");
            Assert.fail("Seat selection test failed: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void testPaymentWithSufficientBalance() {
        try {
            logger.info("Starting payment test with sufficient balance");
            
            // Wait for payment section to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentSection")));
            
            // Verify payment details
            WebElement paymentTotal = driver.findElement(By.id("paymentTotal"));
            String totalText = paymentTotal.getText();
            Assert.assertTrue(totalText.contains("$24.00"), "Payment total should be $24.00");
            
            WebElement paymentWallet = driver.findElement(By.id("paymentWallet"));
            String walletText = paymentWallet.getText();
            Assert.assertTrue(walletText.contains("$100.00"), "Wallet balance should be $100.00");
            
            // Take screenshot before payment
            takeScreenshot("07_payment_page");
            
            // Confirm payment
            WebElement confirmButton = driver.findElement(By.id("confirmPayment"));
            confirmButton.click();
            
            // Wait for confirmation page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmationContainer")));
            
            // Verify confirmation details
            WebElement confirmWallet = driver.findElement(By.id("confirmWallet"));
            String newWalletText = confirmWallet.getText();
            Assert.assertTrue(newWalletText.contains("$76.00"), "Wallet balance should be $76.00 after payment");
            
            // Check if ticket code is generated
            WebElement ticketCode = driver.findElement(By.id("ticketCode"));
            Assert.assertFalse(ticketCode.getText().isEmpty(), "Ticket code should be generated");
            
            // Take screenshot after payment confirmation
            takeScreenshot("08_booking_confirmed");
            
            logger.info("Payment test with sufficient balance completed successfully");
        } catch (Exception e) {
            logger.severe("Error during payment test: " + e.getMessage());
            takeScreenshot("error_payment");
            Assert.fail("Payment test failed: " + e.getMessage());
        }
    }

    @Test(priority = 6)
    public void testInsufficientBalance() {
        try {
            logger.info("Starting test for insufficient balance");
            
            // Click on Book Again button
            WebElement bookAgainButton = driver.findElement(By.id("bookAgain"));
            bookAgainButton.click();
            
            // Wait for booking container to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookingContainer")));
            
            // Repeat the booking process
            // Select movie
            List<WebElement> movieCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("movie-card")));
            movieCards.get(0).click();
            
            // Continue to date-time selection
            WebElement continueToDateTime = driver.findElement(By.id("continueToDateTime"));
            continueToDateTime.click();
            
            // Select date and time
            List<WebElement> dateOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("date-option")));
            dateOptions.get(0).click();
            
            List<WebElement> timeOptions = driver.findElements(By.className("time-option"));
            timeOptions.get(0).click();
            
            // Continue to seat selection
            WebElement continueToSeats = driver.findElement(By.id("continueToSeats"));
            continueToSeats.click();
            
            // This time, select more seats than we can afford
            // Since the balance is now $76 and each ticket is $12, we need to select 7 or more seats
            List<WebElement> seats = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("seat")));
            List<WebElement> availableSeats = seats.stream()
                .filter(seat -> !seat.getAttribute("class").contains("booked"))
                .limit(7)
                .toList();
            
            // Select seats
            for (WebElement seat : availableSeats) {
                seat.click();
            }
            
            // Continue to payment
            WebElement continueToPayment = driver.findElement(By.id("continueToPayment"));
            continueToPayment.click();
            
            // Take screenshot before payment
            takeScreenshot("09_insufficient_balance_payment");
            
            // Confirm payment
            WebElement confirmPayment = driver.findElement(By.id("confirmPayment"));
            confirmPayment.click();
            
            // Verify error message is displayed
            WebElement bookingAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookingAlert")));
            Assert.assertTrue(bookingAlert.isDisplayed(), "Error message should be displayed");
            Assert.assertTrue(bookingAlert.getText().contains("Insufficient balance"), "Error message should mention insufficient balance");
            
            // Take screenshot after insufficient balance error
            takeScreenshot("10_insufficient_balance_error");
            
            logger.info("Test for insufficient balance completed successfully");
        } catch (Exception e) {
            logger.severe("Error during insufficient balance test: " + e.getMessage());
            takeScreenshot("error_insufficient_balance");
            Assert.fail("Insufficient balance test failed: " + e.getMessage());
        }
    }

    @Test(priority = 7)
    public void testReturnToLogin() {
        try {
            logger.info("Starting test for returning to login");
            
            // Return to login page (this would typically be a logout button, but we'll just navigate back)
            driver.get(testUrl);
            
            // Wait for login form to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginContainer")));
            
            // Take screenshot of login form
            takeScreenshot("11_returned_to_login");
            
            // Verify login form is displayed
            WebElement loginForm = driver.findElement(By.id("loginForm"));
            Assert.assertTrue(loginForm.isDisplayed(), "Login form should be displayed");
            
            logger.info("Test for returning to login completed successfully");
        } catch (Exception e) {
            logger.severe("Error during return to login test: " + e.getMessage());
            takeScreenshot("error_return_to_login");
            Assert.fail("Return to login test failed: " + e.getMessage());
        }
    }

    private void takeScreenshot(String name) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshotFile.toPath(), Path.of(screenShotPath + name + ".png"));
            logger.info("Screenshot saved: " + name + ".png");
        } catch (Exception e) {
            logger.severe("Error taking screenshot: " + e.getMessage());
        }
    }

    private void setupLogger() {
        try {
            // Create log directory if it doesn't exist
            Files.createDirectories(Paths.get(logFilePath));
            
            // Set up logger
            logger = Logger.getLogger("MovieTicketBookingTest");
            FileHandler fileHandler = new FileHandler(logFilePath + "test_execution.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.setLevel(Level.INFO);
        } catch (Exception e) {
            System.err.println("Error setting up logger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        logger.info("Tearing down test environment");
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}