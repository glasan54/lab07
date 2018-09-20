Feature: edit
  As a user
  I can edit income and expense

Background:
  Given a user total money 100 exit
  Given 11/11/2011 income 30 exit
  Given 12/12/2011 expense 20 exit

  Scenario: edit amount
    When 11/11/2011 income 30
    Then 11/11/2011 income 40

  Scenario: edit date
    When 11/11/2011 income 30
    Then 13/11/2011 income 30

   Scenario: edit category
     When 12/12/2011 expense 20
     Then 12/12/2011 income 20