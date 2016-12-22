# test newtours website
Feature: Book flight
	As a registered user
	I can book a flight
	So I can go on a trip
Scenario:
	Given I am on the login page
	And I enter "a" as the username
	And I enter "a" as the password
	When I click login button
	Then I will be on the find flight page
Scenario: 
	Given I am on the find flight page
	And I select one-way flight
	And I select 2 passengers
	And I select "New York" as departing location
	When I click continue button
	Then I will be on the select flight page