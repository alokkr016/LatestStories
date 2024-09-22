# Time.com Latest Stories API

## Project Overview

This Spring Boot application uses Selenium to scrape the latest story headlines from [Time.com](https://time.com/). The scraped data is returned via a REST API, providing both the titles and links of the latest stories in a JSON format.

## Features

- **Web Scraping with Selenium**: Automatically opens Time.com, scrolls to the latest stories, and extracts their headlines and links.
- **REST API**: Exposes an endpoint to retrieve the latest story headlines in JSON format.

Example API response:

```json
[
    {
        "link": "https://time.com/7023265/israel-gaza-school-strike/",
        "title": "Israeli Strike on a School Kills at Least 22, Gaza Health Ministry Says"
    },
    {
        "link": "https://time.com/7023258/arizona-supreme-court-citizenship-vote-ruling/",
        "title": "Arizonans Whose Citizenship Hadn't Been Confirmed Can Vote"
    },
    {
        "link": "https://time.com/7023255/stairs-exercise-calories-weight-loss/",
        "title": "Climbing Stairs Might Be the Most Effective Exercise for You"
    },
    {
        "link": "https://time.com/7022935/kamala-harris-israel-gaza-west-bank/",
        "title": "How Kamala Harris Can Craft a Fair Middle East Strategy"
    },
    {
        "link": "https://time.com/7023226/pesto-penguin-australia/",
        "title": "Move Over Moo Deng, Meet Pesto the Penguin"
    },
    {
        "link": "https://time.com/7023138/sean-diddy-combs-music-back-catalog/",
        "title": "What Happens to Diddy's Back Catalog?"
    }
]
```

## Technologies Used

- **Spring Boot**: Java-based framework for building the REST API.
- **Selenium**: Automates the browser for web scraping.
- **ChromeDriver**: WebDriver for controlling the Chrome browser.
- **WebDriverManager**: Simplifies the setup and management of WebDriver binaries.

## How It Works

1. **Scraping Process**:
    - The application launches Chrome in headless mode.
    - It navigates to [Time.com](https://time.com/).
    - Scrolls to the latest stories section and extracts the headlines and their respective links.

2. **API Endpoint**:
    - The `GET /latest-stories` endpoint returns the latest stories as a list of JSON objects containing the title and link.


## How to Run

No installation is required beyond running a typical Spring Boot application.

1. **Clone the repository**:
    ```bash
    git clone https://github.com/alokkr016/LatestStories.git
    cd LatestStories
    ```

2. **Run the application**:
   You can run the Spring Boot app using Maven or Gradle:
    ```bash
    ./mvnw spring-boot:run
    ```

3. **Access the API**:
   Once the application is running, visit the following endpoint in your browser or via tools like Postman or curl:

   ```
   http://localhost:8080/latest-stories
   ```

## Future Enhancements

- Add error handling for cases where the page structure changes.
- Implement retry mechanisms for failed scraping attempts.
- Add caching to reduce the number of requests made to the site.

---
