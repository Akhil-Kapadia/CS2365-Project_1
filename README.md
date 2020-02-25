# CS2365 Object Oriented Programming - Spring 2020 Project 2

### Background

UNO the card game

_According to Wikipedia..._

Uno is an American card game which is played with a specially printed deck. The game was
originally developed in 1971 by Merle Robbins, an Ohio barbershop owner, who loved to play
cards. Merle came up with the idea for UNO and introduced the game to his family. When his
family and friends began playing UNO more and more, Robbins and his family spent $8,
to have 5,000 games made. At first, Robbins sold UNO from his barbershop. A few local
businesses sold it as well. Later Robbins sold the UNO rights to a funeral parlor owner and
UNO fan from
Joliet, Illinois, for $50,000, plus royalties of 10 cents per game. International Games Inc. was formed to market UNO, and
sales skyrocketed. In 1992, International Games became part of the Mattel product line

The deck consists of ...

108 cards, of which there are 25 of each color (red, green, blue, and yellow), each color having two of each rank except

0. The ranks in each color are 0 to 9, "Skip", "Draw Two" and "Reverse" (the last three of these being classified as "action
cards"). In addition, the deck contains four each of "Wild" and "Wild Draw Four" cards.

To start a hand, seven cards are dealt out to each player, and the top card of the deck is flipped over and set aside to
begin the discard pile. The player to the dealer's left plays first unless the first card on the discard pile is an action or Wild
card (see below). On a player's turn, he/she must do one of the following:

- play a card matching the discard in color, number or symbol
- playa Wild card, or a playable Wild Draw Four card (see restriction below)
- draw the top card of the deck

If a player chooses to draw the top card of the deck, and that card is playable (it matches the discard, or is a playable wild
card), then the player may (but need not) immediately play that card.

Play proceeds clockwise around the table.

Action and Wild cards have the following effects:

### Action Card Effect when played from hand Effect as the first discard

```
SKIP Next player in sequence loses a turn Player to dealer's left loses a turn
```
#### DRAW TWO

```
Next player in sequence draws two cards and loses a
turn
```
```
Player to dealer's left draws two cards and
loses a turn
```
#### REVERSE

```
Order of play switches directions (clockwise to
counterclockwise, and vice versa)
```
```
The dealer plays first; play proceeds
counterclockwise
```
#### WILD

```
Player declares next color to be matched (may be used
on any turn even if the player has matching color)
```
```
Player to dealer's left declares the first color
to be matched, then plays normally
```
#### WILD DRAW 4

```
Player declares next color to be matched; next player
draws four cards and loses a turn (maybe legally
played only if the player has no cards of the current
color or number)
```
```
Return card to the deck, shuffle, flip-top card
to start a discard pile
```
- A player may draw a card from the deck even if that player has a playable card.
- If a player chooses to draw a card and the drawn card is playable, the player has the option of either keeping it or
    playing it immediately (as part of that turn).
- If a player chooses to draw, the player may not play any card (other than the drawn card, if playable) on that turn.
- A player may play a Wild card at any time (even if that player has other playable cards).


- A player may play a Wild Draw Four card only if that player has no cards matching the current color (the player
    may have cards matching the current number or symbol). A player who plays a Wild Draw Four may be
    challenged.
- If the entire deck is used during play, the top discard is set aside and the rest of the pile is shuffled to create a
    new deck. Play then proceeds normally.
- It is illegal to trade cards of any sort, including special cards such as wild, blank, and reversal cards.
A player who plays his/her next-to-last card must call "UNO" as a warning to the others.[4] A player who is caught failing to
call "UNO" may be penalized.
The first player to get rid of his/her last card ("going out") wins the hand and scores points for the cards held by the other
players. Number cards count their face value, all action cards count 20, and Wild and Wild Draw Four cards count 50. If a
Draw Two or Wild Draw Four card is played to go out, the next player in the sequence must draw the appropriate number
of cards before the score is tallied.
The first player to reach 500 points is the winner.

### Deck of Cards Workout

```
Using the deck of cards Uno, select an exercise for each color.
```
```
For example, consider the following exercises per color
```
## BLUE YELLOW RED GREEN

## Push Ups Squat Sit Ups Lounges

- Shuffle the deck and used it as a pile to draw cards.
- Draw seven cards to form a Hand.
- Sort the Hand by colors then by rank.
- Add the numbers per color and apply for the action cards, as described below, then performed the round of
    exercises, the total for each color is the number of repetitions for the corresponding exercise. Perform the
    exercises, one after another with no breaks.
- In the case that around contains a Zero card, the person gets a 1-Minute break after the corresponding exercise.
    Once the outcome of the first Hand is performed, another Hand is drawn for the next round of exercises This
    continues until the whole pile is consumed.

### Note: If the person is not challenging enough they can use additional decks shuffle individually or combined.

```
In the case that one or more of the special cards are drawn, they processed in the following order.
"Skip",
"Draw 2",
"Reverse",
"Wild",
"Wild Draw 4"
```
```
All the cards of this color that are in the hand are discarded for this hand.
The total number of the matching color is multiplied by 2.
All the cards of the matching color return to the bottom of the pile except the “Reverse” card
that is discarded.
The presence of this card will add 10 Burpees to the round of exercises of this hand.
This card will, in addition, to add the Burpees, multiply by 4 the total of each color.
Project Description
```
Make a model with objects for the Deck of Cards Workout, using the cards from the UNO game.

```
Once your model is completed, implement your solution in Java.
The implementation should include classes like Card, Deck, Hand and any other the team considers necessary.
Each class needs to be code in its own file, be documented using JavaDoc comments, and specify the main author and
list of collaborators if someone different than the main author makes changes to code.
```
Any Data Structures for this project should be implemented from scratch, the team is not allowed to use pre-built abstract
data structures provided by the language.

```
The project must allow the user to select...
```
- The number of decks to be used for the workout, from 1 and up to 3 decks of cards.


- The user can choose to shuffle the decks together or individually.
- The user may remove action cards from the decks, by default all action cards are included.
- The output of your project is a HTML document file, where you show...
    o For each hand of 7 cards drawn
    o The interpretation of the cards present in the hand.
    o The total number of repetitions per exercise present to be done in this round after all computations and
       rules are applied.
    o Display the number of cards left on the pile.
    o Then, draw the next hand from the draw pile and repeat until the last hand of cards is drawn.
    o Once the draw pile is consumed completely, provide the following stats.
       ▪ The total number of repetitions per exercise.
       ▪ The total number of repetitions per exercise that were skipped.
       ▪ What was the biggest number of repetitions in a single hand for each exercise?

o
Your submission should include

- Every class should have JavaDoc documentation.
- A File header on each file, denoting who is the Main Author of the class and if someone else collaborates on that
    file.
- Collaboration should be documented for Classes and individual Methods, provide a description of the
    contribution.
- UML Class Diagrams for every class you modeled in the project.
- Test cases for each of the classes and their methods, these test cases need to be included in your code for
    example the main method in the class file or a client class that performs the testing.


