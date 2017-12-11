/*
Filename:   Acceptable.java
Author:     Connor Ness
Date:       December 10, 2017

The Acceptable interface lays the foundations for acceptable input.
 */

public interface Acceptable {
    boolean isNonEmptyString(String s);
    boolean isPositiveInput(double d);
}
