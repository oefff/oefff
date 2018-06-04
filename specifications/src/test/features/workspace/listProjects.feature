@current
Feature: List all projects from local workspace

  In order to be edit specifications of the proper project
  As the Product Owner
  I want to be able to select a project from the list of configured projects


  Scenario: Marco wants to edit the Specifications of Oefff in Oefff

    Given the project 'oefff' is present in the configured workspace
     When Marco opens Oefff to edit the specifications
     Then Marco should be able to select of project 'oefff'



