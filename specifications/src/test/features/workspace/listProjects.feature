@workInProgress
Feature: List all current project from local workspace

  In order to be start
  As the Product Owner
  I want to be able to select a project


  Scenario: Clone Oefff in to local workspace

    Given there is a GitHub repository for 'oefff/oefff'
    When Marco adds project 'Oefff' to the workspace
    Then the features of project 'Oefff' should be available via the online editor



