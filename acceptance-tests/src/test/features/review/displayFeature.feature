Feature: Display an existing feature

  In order to review a specification
  As the Product Owner
  I want to see one of the existing feature files


Scenario: Marco views the displayFeature-feature

  Given the displayFeature has been written and is part of the existing project
   When Marco selects that feature for review
   Then the displayFeature should be displayed
