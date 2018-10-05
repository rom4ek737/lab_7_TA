Feature: opengmail

Background:
   User navigates to Gmail Given
   I am on gmail login page


Scenario Outline: Login functionality for a gmail site

Given I am a gmail site user

When I enter the incorrect Username <username> and Password <password>

Then I don't should be redirected to the home page of the gmail

Examples:

|username                   |password           |

|"romanzdrok"               |"1@3$5^7*9"        |

|"roman"                    |"1@3$5^7*9"        |