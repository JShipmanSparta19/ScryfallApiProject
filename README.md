# ScryfallApiProject

A simple project that queries the Scryfall API for Magic: The Gathering and returns a group of 8 sets, 2 core sets and 6 standard expansion sets.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

```
A version of the Java Development Kit (11 recommended)
An IDE for Java (Intellij recommended)
```

### Installing

A step by step series of examples that tell you how to get a development env running

Clone the repository

```
Using git clone command, acquire a copy of the source code using SSH or HTTPS.
```

Open in Intellij

```
On opening, Maven should automatically download the needed dependencies. If not, initialise a Maven environment from the file menu in Intellij or using your IDE's equivalent.
```

Upon running the main method, a list of Magic: The Gathering sets, including 2 core sets and 6 expert level expansion sets will be printed, as well as a link to a list of cards in those sets on Scryfall.

## Running the tests

Using Maven Integration, the test can be run using the Maven Test function or the test can be run directly from AppTest.java

### RESTAssured

The first test (listed as "ensureCorrectReturn") is a test to make sure the data obtained from the API is the data expected.

```
This test ensures that the connection is made correctly, that all the objects returned are sets and that they all have a set code of at least three characters.
```

### JUnit Tests

The remaining tests check that the analysis performed on the retrieved data has resulted in a valid output

```
These tests check that 8 sets are generated, that 2 core sets and 6 expansion sets are generated and that the list contains no duplicate objects.
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **John Shipman** - *Initial work* - [JShipmanSparta19](https://github.com/JShipmanSparta19)
