#language:en
#Author: alcides_hidalgo@live.com

Feature: FYI AI Website

  Background:
    Given open the URL

  @TermsOfServiceDisplays
  Scenario: Terms of Service Page Displays "©2024 FYI.FYI, Inc." at the Bottom
    Then search the phrase at the bottom of the page and realize the validation

  @HMenuContainsOptions
  Scenario: Hamburger Menu Contains Correct User Selection Options
    Then Open the Hamburger Menu and validate that all the options are displayed

  @CSBRedirectToSRP
  Scenario: Contact Support Button Redirects User to the Submit Request Page
    Then go to the option Contact Support and validate that the title Submit a request is displayed

  @VerifyAIResults
  Scenario: Verify Search Results for "AI" on the Submit a Request Page
    Then go to the page Submit a request perform the search "AI" and validate that 15 records are displayed



