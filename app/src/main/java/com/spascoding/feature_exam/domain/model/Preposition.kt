package com.spascoding.feature_exam.domain.model

enum class Preposition(val value: String) {

    EMPTY(""),

//    Prepositions of Time

    AT("at"),               //Used for specific times (e.g., at 5 o'clock)
    ON("on"),               //Used for days and dates (e.g., on Monday, on December 5th)
    IN("in"),               //Used for nonspecific times during a day, month, season, year (e.g., in the morning, in December, in summer)

//    Prepositions of Place

//    At: Indicates a specific point (e.g., at the corner, at the bus stop)
//    On: Indicates a surface (e.g., on the table)
//    In: Indicates an enclosed space (e.g., in the room, in a building)

//    Prepositions of Direction

    TO("to"),               //Indicates movement toward a place (e.g., go to the office)
    FROM("from"),           //Indicates the origin of something (e.g., from America)
    INTO("into"),           //Indicates movement from outside to a point inside (e.g., go into the room)

//    Prepositions of Agency, Instrumentality, or Method

    BY("by"),               //Indicates an agent performing an action; also used for transportation modes (e.g., by the teacher, by car)
    WITH("with"),           //Used to indicate the instrument used to do something (e.g., cut with a knife)

//    Prepositions of Purpose

    FOR("for"),             //Indicates the purpose or a beneficiary (e.g., a gift for you)
//    To: Often indicates the purpose of something (e.g., go to learn)

//    Miscellaneous Prepositions

    ABOUT("about"),         //Concerning or regarding (e.g., talk about the weather)
    ABOVE("above"),         //Higher than a point (e.g., above the ceiling)
    ACROSS("across"),       //From one side to the other (e.g., across the road)
    AGAINST("against"),     //In opposition to (e.g., against the rules)
    ALONG("along"),         //In a line with (e.g., walk along the river)
    AMONG("among"),         //In the middle of (e.g., among friends)
    AROUND("around"),       //Surrounding (e.g., all around the house)
    BEFORE("before"),       //Earlier than (e.g., before noon)
    BEHIND("behind"),       //At the back of (e.g., behind the building)
    BELOW("below"),         //Lower than (e.g., below sea level)
    BENEATH("beneath"),     //Under (e.g., beneath the surface)
    BESIDE("beside"),       //Next to (e.g., sit beside me)
    BETWEEN("between"),     //In the middle of two (e.g., between two trees)
    BEYOND("beyond"),       //Further than (e.g., beyond the horizon)
    DURING("during"),       //Throughout the duration of (e.g., during the movie)
    EXCEPT("except"),       //Not including (e.g., everyone except me)
    INSIDE("inside"),       //Within (e.g., inside the house)
    LIKE("like"),           //Similar to (e.g., act like a leader)
    NEAR("near"),           //Close to (e.g., near the market)
    OF("of"),               //Belonging to (e.g., the color of the car)
    OFF("off"),             //Away from (e.g., take a day off)
    OUTSIDE("outside"),     //Not within (e.g., outside the house)
    OVER("over"),           //Higher and across (e.g., over the fence)
    THROUGH("through"),     //From one end to another (e.g., walk through the door)
    UNDER("under"),         //Below something else (e.g., under the table)
    UNTIL("until"),         //Up to the time of (e.g., work until dusk)
    WITHOUT("without"),     //Lacking (e.g., go without dinner)
    WITHIN("within"),       //Inside the limits (e.g., within a day)
}