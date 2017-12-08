# GOEURO TEST
## Testing Task
GoEuro lists the travel results sorted by smartest, cheapest, fastest or by time
(departure/arrival). Please create an automated test that will make a search between Berlin
and Prague and will verify that the sorting by price is correct. The test should be done using
either Java or Javascript, using open source tools.
We’ll take a look at your solution considering if the test is working, the design choices, the
commit messages on github (best practices of version control), the test report and the
README file. Please also explain your technology and approach choices.
Constraints:
 - We’ll only accept solutions with a github link.
 - Keep in mind that the test should be ready to run either in Linux or OS X only.
 
 ## TEST SCENARIOS
 
 ### Basic scenario - Cheapest price
 
 1. Go to http://goeuro.com
 2. Make a search for following conditions:
  - Desitnation city: Berlin, Germany
  - Arrival city: Prague, Czechia
  - Trip type: One-Way
  - Number of passengers: 1
  - No German Rails Card selected.
  - Date of the trip: current date +1
  - Site language: Default
  - Currency: Default
 3. Check Search result:
  - There should be search result according destination-arrival and date you selected
  - Result should include Train, Flight and Buses
  - Default Tab should be Train
  - There should be no more that 10 results on the page
  - If there is more than 10 results there should be several pages available, numbers of pages, Next and Last buttons
  - If there is no result there should be message: Sorry! We are not able to find a <flight, bus, train> between these two places.
 4. Change sorting option to "Cheapest"
 5. Check Search result:
  - Search result should be sorted by price from cheapest to the most expensive
 6. Go through all pages of search result for train and check price sorting.
 7. Go through all pages of search result for flight and check price sorting.
 8. Go through all pages of search result for bus and check price sorting.
 9. Also there can be "Alternative dates" section in search result. On this section check:
   - Search results are grouped by date
   - For each date search result is sorted by price from cheapest to the most expensive
 
  ### Tools used for test automation
  
   - Control Version System: git, using github as remote repository
   - Automation tool: Selenium + WebDriver
   - Testing framework: TestNG
   - Programming language: Java
   - Build tool: maven
  
  ### Automation technologies and approach
  
   - PageObject pattern - allows to separate test and UAT
   - Data-Driven testing - test data is separated from the test and taken from csv file
  
  
  
  