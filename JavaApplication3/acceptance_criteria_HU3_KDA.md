# Acceptance Criteria for HU3: KDA Calculation

## User Story

As a user, I want to view the KDA (Kill/Death/Assist ratio) for each player in a team so that I can evaluate player performance.

## Acceptance Criteria

### Scenario 1: View KDA for Players in a Team

- **Given** the user has selected a team from the dropdown
- **When** the user clicks the "Calculate" button in the KDA panel
- **Then** the system displays a list of players with their KDA ratios
- **And** each KDA is calculated as (kills + assists) / max(deaths, 1)

### Scenario 2: KDA Calculation with Deaths > 0

- **Given** a player has kills=10, deaths=2, assists=5
- **When** the KDA is calculated
- **Then** the KDA should be 7.5 (15 / 2)

### Scenario 3: KDA Calculation with Deaths = 0

- **Given** a player has kills=5, deaths=0, assists=3
- **When** the KDA is calculated
- **Then** the KDA should be 8.0 (8 / 1)

### Scenario 4: KDA Calculation with High Deaths

- **Given** a player has kills=2, deaths=10, assists=1
- **When** the KDA is calculated
- **Then** the KDA should be 0.3 (3 / 10)

### Scenario 5: No Players in Team

- **Given** a team has no players
- **When** the user selects the team and clicks calculate
- **Then** the list should be empty

### Scenario 6: Navigation to KDA Panel

- **Given** the main interface is displayed
- **When** the user triggers the method to show KDA panel (e.g., via menu or button)
- **Then** the KDA panel becomes visible
- **And** other panels are hidden
