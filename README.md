# Bonus Eligibility API

This is a Spring project that implements an API which determines which employees are eligible for a bonus. The API receives a list of bonus elements in JSON format and returns a list of eligible employee elements in the response JSON.

## Getting Started

To get started with this project, you'll need to clone the repository and set up your development environment. Here are the steps:

1. Clone the repository: `git clone https://github.com/your-username/bonus-eligibility-api.git`

2. Open the project in your IDE of choice, such as IntelliJ or Eclipse.

3. Build the project and resolve any dependencies.

4. Run the project using the main class `BonusEligibilityApiApplication`.

5. Use a tool such as `curl` or `Postman` to send HTTP requests to the API.

## API Endpoints

The following endpoints are available in this API:



- `POST /tci/bonus/eligibility`: Determines which employees are eligible for a bonus based on the bonus elements received in the request body. Returns a list of eligible employee elements in the response JSON.

## Request and Response Formats

The API receives and returns data in JSON format. Here are the request and response formats for the `POST /bonus-eligibility` endpoint:




