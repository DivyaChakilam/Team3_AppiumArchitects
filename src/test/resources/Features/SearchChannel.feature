
@searchChannel
Feature: Search for a channel
 Background: Launching the emulator and SkyTube app
 Given User launches the emulator and SkyTube app
 

 Scenario Outline: User searches for the channel which is valid and invalid channel names
    When User enter a "<channel name>" to search in search field
    Then User sees the searched channel  

    Examples: 
      | channel name  |
      |	chuchu tv			|
      | chuchu        | 
      
#| \;./ [ q      | 