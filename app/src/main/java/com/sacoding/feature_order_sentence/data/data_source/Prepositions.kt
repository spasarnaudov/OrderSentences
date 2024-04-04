package com.sacoding.feature_order_sentence.data.data_source

object Prepositions {

    //Prepositions of Time  =====================================================

    val preciseTimes = listOf("at")
    //"Meet me at 5:00 PM."

    val daysAndDates = listOf("on")
    //"My birthday is on April 10th."

    val monthsYearsCenturiesAndLongPeriods = listOf("in")
    //"She was born in February."
    //"In the 21st century..."

    //Prepositions of Place =====================================================

    val specificPointsOrLocations = listOf("at")
    //"She is waiting at the entrance."

    val surfaces = listOf("on")
    //"The book is on the table."

    val enclosedSpaces = listOf("in")
    //"He is in the garden."

    //Prepositions of Direction/Movement    ======================================

    val directionTowardsASpecificDestination = listOf("to")
    //"We are going to the cinema."

    val originOrSourceOfMovement = listOf("from")
    //"She travels from Paris to Rome."1

    val movementTowardsTheInsideOfSomething = listOf("into")
    //"She jumped into the pool."

    //Prepositions of Location  ==================================================

    val higherThanSomethingElse = listOf("above")
    //"The picture hangs above the fireplace."

    val lowerThanSomethingElse = listOf("below")
    //"The village is below the mountain."

    val inTheMiddleOfTwoPoints = listOf("between")
    //"The park is between the museum and the river."

    val nextTo = listOf("beside")
    //"She sat beside her friend."

    //Prepositions for Other Relationships  ======================================

    val accompanimentOrPossession = listOf("with")
    //"I will go with you."

    val purposeOrReason = listOf("for")
    //"This gift is for you."

    val concerningOrOnTheSubjectOf = listOf("about")
    //"We talked about our plans."

    val similarityOrManner = listOf("like")
    //"She sings like an angel."

    val aboveOrCovering = listOf("over")
    //"He held the umbrella over both of us."

    val lowerOrBeneath = listOf("under")
    //"The cat hid under the bed."

    //Complex Prepositions  =======================================================

    val asStatedBy = listOf("according to")
    //"According to the report, sales have increased."

    val dueTo = listOf("because of")
    //"The game was canceled because of the rain."

    val aheadOf = listOf("in front of")
    //"There's a garden in front of the house."

    val regardlessOf = listOf("in spite of", "despite")
    //"In spite of the rain, we went hiking."
}

fun String.addPreposition(preposition: String): String {
    if (preposition.isNotBlank()) {
        return "$preposition $this"
    }
    return this
}