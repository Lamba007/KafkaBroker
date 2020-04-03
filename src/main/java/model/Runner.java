package model;

import example.customeExceptions.IllegalTopicException;

public class Runner {

    public static void main(String[] args) throws IllegalTopicException {

        SampleApplication sampleApplication= new SampleApplication("ihub","name","This is the producer");
    }
}
