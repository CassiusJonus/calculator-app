 # Calculator App

## Description

This application is a terminal calculator that can perform standard arithmetic
operations (addition, subtraction, multiplication, division) as well as
scientific operations such as exponentiation, square roots, and logarithms.
These operations will be split into two modes, basic and scientific, with basic
being the default.
Users can store answers to entered calculations that they can use later in
other calculations with a terminal command, and clear the stored result with
another command.

## Features

- Input math expressions by typing them into the terminal while the application
  is running
- Enter a command to show scientific operations such as logarithms, exponentiation
  (10^x and x^y), square roots and triganometric functions.
- Store the result of an expression and recall it in another expression
- Clear a stored result


## Implementation

This project will use Cats Parse and Cats to parse user input and handle the
internal logic of the application such as evaluating parsed arithmetic and
scientific expressions. This project also uses Cats Parse to parse commands the
user enters.

## Todos

1. Create Scala-JS project (Completed)
2. Define project architecture and create a matching directory structure (Completed)
3. Define core domain traits and case classes
