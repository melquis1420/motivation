package com.example.motivation.infra

/**
 * Create this class for all immutable words.
 * It's the similar functon of colors.xml or strings.xml,
 * grouping all immutable words
 */

class MotivationConstants private constructor(){

    object Key{

        val PERSON_NAME = "name"

    }

    object PHRASEFILTER{
        val ALL = 1
        val HAPPY= 2
        val MORNING= 3
    }
}