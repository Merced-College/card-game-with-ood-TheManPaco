[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19825288)

# Card Game with Object-Oriented Design

## Author
Francisco Vazquez & GitHub Copilot

## Date
June 20, 2025

## Project Description
This project implements a card game using Object-Oriented Design principles in Java. The program reads card information from a file, creates a deck of cards, and implements various card game functionalities.

### Core Features
- Card class with proper encapsulation (getters/setters)
- Deck management with ArrayList
- Card shuffling functionality
- Hand evaluation (pairs, three of a kind, flush)

### Enhanced Features Added
1. **Improved Card Organization**
   - Added card sorting by suit and value
   - Enhanced card comparison functionality

2. **Advanced Hand Evaluation**
   - Check for three of a kind
   - Check for flush (all cards of same suit)
   - Calculate total hand value

3. **Game Statistics**
   - Track number of games played
   - Count pairs found
   - Monitor cards dealt
   - Display comprehensive game statistics

4. **Better Code Organization**
   - Added comprehensive documentation
   - Improved error handling
   - Enhanced code readability with comments

## How to Run
1. Ensure you have Java installed
2. Place your cards.txt file in the project directory
3. Compile both Card.java and CardGame.java
4. Run CardGame

## File Structure
- `Card.java`: Contains the Card class implementation
- `CardGame.java`: Contains the main game logic
- `cards.txt`: Input file containing card information
- `README.md`: This file

## Card File Format:
```
suit,name,value,picture
```
Example:
```
Hearts,Ace,14,A♥
```