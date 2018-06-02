Feature: Clone a git repository in to the local workspace

  In order to be start using Oefff for a project
  As the Lead Developer
  I want to clone a repository into a local workspace


Scenario: Clone Oefff in to local workspace

  Given there is a GitHub repository for 'oefff/oefff'
   When Marco adds project 'Oefff' to the workspace
   Then the features of project 'Oefff' should be available via the online editor



