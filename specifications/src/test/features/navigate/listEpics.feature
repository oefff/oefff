@workInProgresss
Feature: Display the list of epics of an application

  In order to find a specific feature to review
  As the Product Owner
  I want to see a browse through a list of epics of the application


Scenario: Marco wants to find the navigate epic

  Given the Online Editor For Feature File is configured to edit itself
   When Marco looks at the epic overview of 'oefff'
   Then he should be able to see:
    | configuration   |
    | navigate        |
    | review          |
