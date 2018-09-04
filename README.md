# movietheatre
Developed by Xuan Zhu in September 2018.

## Overview

This is the Java implementation of the Movie Theatre Code Challenge.

## To build the code:

$ mvn install

## To run the client:

$ target/bin/runClient input_file_path

Output is path to output file.

## To run the client with example:

$ target/bin/runClient src/main/resources/example.txt

## To delete all programs and object files

$ mvn clean

## To-Do:
Add more tests;

Improve seats arrangement (e.g. seats on neighbour rows);

Can make MovieTheatre class -> MovieTheatreScreen class,
then one theatre could have several screens
and schedules of different screens.

Add more applicable fields to MovieTheatre(start time, end time);