Feature: Oefff should be able to find feature file from custom location

  In order to be free to use a custom project directory layout
  As the Lead Developer
  I want to configure the location of feature files


Scenario: Oefff is configured to use /specifications/src/test/features

  Given the Oefff git repository has custom configuration
    And the project contains feature files underneath the configured specification location
   When Marco selects the 'configureProject' feature for review
   Then the feature should be displayed and have the name: Oefff should be able to find feature file from
