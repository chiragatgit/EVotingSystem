# Project Goal

The organization requires an E-Voting System to conduct online elections. The system should allow users to create elections, cast votes, and monitor election results. The application will be built using Spring Boot, Hibernate, and MySQL for the database. It should include CRUD operations to manage elections, election choices, and votes easily.

## Features of the Application:

The application should allow users to:

- Create elections with a title.
- Add choices to an election.
- Register as voters with unique usernames.
- Cast votes for a specific election and election choice.
- Retrieve election results, including the total votes and winning candidate.

## End Points To Be Created:

### 1. Election Endpoints:

- **GET** `/get/elections`: It retrieves the list of all elections.
- **POST** `/add/election` (`@RequestBody Election election`): It creates a new election.

### 2. ElectionChoice Endpoints:

- **POST** `/add/electionChoice` (`@RequestBody ElectionChoice electionChoice`): It adds an election choice.
- **GET** `/get/electionChoices`: It fetches the list of all electionChoices from the database.
- **POST** `/count/election/choices` (`@RequestBody Election election`): It retrieves the list of all choices for the given election.

### 3. User Endpoints:

- **POST** `/add/user` (`@RequestBody User user`): It creates a new user into the database.
- **GET** `/get/users`: It fetches the list of all users from the database.

### 4. Vote Endpoints:

- **GET** `/get/votes`: It fetches the list of all votes from the database.
- **POST** `/add/vote` (`@RequestBody Vote vote`): It registers a new vote into the database.
- **GET** `/count/votes`: It fetches the count of total votes from the database.
- **POST** `/count/election/votes` (`@RequestBody Election election`): It returns the count of total votes by-election in long.

### 5. Results Endpoints:

- **POST** `/winner/election` (`@RequestBody Election election`): It retrieves the ElectionChoice for a specific election as the winner.
