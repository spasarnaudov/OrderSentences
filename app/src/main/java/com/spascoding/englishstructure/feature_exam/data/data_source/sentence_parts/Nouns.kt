package com.spascoding.englishstructure.feature_exam.data.data_source.sentence_parts

import com.spascoding.englishstructure.feature_exam.domain.enums.Plurality
import com.spascoding.englishstructure.feature_exam.domain.model.noun.CommonNoun
import com.spascoding.englishstructure.feature_exam.domain.model.noun.Pronoun

object Nouns {

    val name = CommonNoun(value = "name", countable = true, Plurality.SINGULAR)

    //Countries

    val australia = Pronoun(value = "Australia")
    val brazil = Pronoun(value = "Brazil")
    val bulgaria = Pronoun(value = "Bulgaria")
    val canada = Pronoun(value = "Canada")
    val china = Pronoun(value = "China")
    val france = Pronoun(value = "France")
    val mexico = Pronoun(value = "Mexico")
    val netherlands = Pronoun(value = "Netherlands", Plurality.PLURAL)
    val india = Pronoun(value = "India")
    val indonesia = Pronoun(value = "Indonesia")
    val italy = Pronoun(value = "Italy")
    val japan = Pronoun(value = "Japan")
    val saudiArabia = Pronoun(value = "Saudi Arabia")
    val southKorea = Pronoun(value = "South Korea")
    val spain = Pronoun(value = "Spain")
    val sweden = Pronoun(value = "Sweden")
    val switzerland = Pronoun(value = "Switzerland")
    val turkey = Pronoun(value = "Turkey")
    val theUnitedKingdom = Pronoun(value = "The United Kingdom")
    val theUnitedStates = Pronoun(value = "The United States", Plurality.PLURAL)

    //Cities

    val amsterdam = Pronoun(value = "Amsterdam")
    val bangkok = Pronoun(value = "Bangkok")
    val cairo = Pronoun(value = "Cairo")
    val dublin = Pronoun(value = "Dublin")
    val edinburgh = Pronoun(value = "Edinburgh")
    val florence = Pronoun(value = "Florence")
    val geneva = Pronoun(value = "Geneva")
    val hongKong = Pronoun(value = "Hong Kong")
    val istanbul = Pronoun(value = "Istanbul")
    val jakarta = Pronoun(value = "Jakarta")
    val kyoto = Pronoun(value = "Kyoto")
    val london = Pronoun(value = "London")
    val moscow = Pronoun(value = "Moscow")
    val newYork = Pronoun(value = "New York")
    val oslo = Pronoun(value = "Oslo")
    val paris = Pronoun(value = "Paris")
    val quebecCity = Pronoun(value = "Quebec City")
    val rome = Pronoun(value = "Rome")
    val sydney = Pronoun(value = "Sydney")
    val tokyo = Pronoun(value = "Tokyo")
    val utrecht = Pronoun(value = "Utrecht")
    val vienna = Pronoun(value = "Vienna")
    val warsaw = Pronoun(value = "Warsaw")
    val xian = Pronoun(value = "Xian")
    val york = Pronoun(value = "York")
    val zurich = Pronoun(value = "Zurich")

    //Nationals

    val australian = Pronoun(value = "Australian")
    val brazilian = Pronoun(value = "Brazilian")
    val bulgarian = Pronoun(value = "Bulgarian")
    val canadian = Pronoun(value = "Canadian")
    val chinese = Pronoun(value = "Chinese")
    val french = Pronoun(value = "French")
    val german = Pronoun(value = "German")
    val indian = Pronoun(value = "Indian")
    val indonesian = Pronoun(value = "Indonesian")
    val italian = Pronoun(value = "Italian")
    val japanese = Pronoun(value = "Japanese")
    val mexican = Pronoun(value = "Mexican")
    val dutch = Pronoun(value = "Dutch")
    val russian = Pronoun(value = "Russian")
    val saudiArabian = Pronoun(value = "Saudi Arabian")
    val southKorean = Pronoun(value = "South Korean")
    val spanish = Pronoun(value = "Spanish")
    val swedish = Pronoun(value = "Swedish")
    val swiss = Pronoun(value = "Swiss")
    val turkish = Pronoun(value = "Turkish")
    val british = Pronoun(value = "British")
    val american = Pronoun(value = "American")

    val english = Pronoun(value = "English")

    //Jobs

    val doctor = CommonNoun(value = "doctor", countable = true, Plurality.SINGULAR)
    val nurse = CommonNoun(value = "nurse", countable = true, Plurality.SINGULAR)
    val dentist = CommonNoun(value = "dentist", countable = true, Plurality.SINGULAR)
    val programmer = CommonNoun(value = "programmer", countable = true, Plurality.SINGULAR)
    val designer = CommonNoun(value = "designer", countable = true, Plurality.SINGULAR)
    val teacher = CommonNoun(value = "teacher", countable = true, Plurality.SINGULAR)
    val professor = CommonNoun(value = "professor", countable = true, Plurality.SINGULAR)
    val mechanic = CommonNoun(value = "mechanic", countable = true, Plurality.SINGULAR)
    val electrician = CommonNoun(value = "electrician", countable = true, Plurality.SINGULAR)
    val accountant = CommonNoun(value = "accountant", countable = true, Plurality.SINGULAR)
    val musician = CommonNoun(value = "musician", countable = true, Plurality.SINGULAR)
    val actor = CommonNoun(value = "actor", countable = true, Plurality.SINGULAR)
    val chef = CommonNoun(value = "chef", countable = true, Plurality.SINGULAR)
    val lawyer = CommonNoun(value = "lawyer", countable = true, Plurality.SINGULAR)
    val biologist = CommonNoun(value = "biologist", countable = true, Plurality.SINGULAR)

    //Pets

    val cat = CommonNoun(value = "cat", countable = true, Plurality.SINGULAR)
    val dog = CommonNoun(value = "dog", countable = true, Plurality.SINGULAR)

    //Sports

    val basketball = CommonNoun(value = "basketball", countable = true, Plurality.SINGULAR)
    val boardGame = CommonNoun(value = "board game", countable = true, Plurality.SINGULAR)
    val card = CommonNoun(value = "card", countable = true, Plurality.SINGULAR)
    val chess = CommonNoun(value = "chess", countable = true, Plurality.SINGULAR)
    val football = CommonNoun(value = "football", countable = true, Plurality.SINGULAR)
    val golf = CommonNoun(value = "golf", countable = true, Plurality.SINGULAR)
    val hideAndSeek = CommonNoun(value = "hide and seek", countable = true, Plurality.SINGULAR)
    val soccer = CommonNoun(value = "soccer", countable = true, Plurality.SINGULAR)
    val tennis = CommonNoun(value = "tennis", countable = true, Plurality.SINGULAR)
    val videoGame = CommonNoun(value = "video game", countable = true, Plurality.SINGULAR)
    val volleyball = CommonNoun(value = "volleyball", countable = true, Plurality.SINGULAR)

    //Musical instruments

    val accordion = CommonNoun(value = "accordion", countable = true, Plurality.SINGULAR)
    val clarinet = CommonNoun(value = "clarinet", countable = true, Plurality.SINGULAR)
    val drum = CommonNoun(value = "drum", countable = true, Plurality.SINGULAR)
    val flute = CommonNoun(value = "flute", countable = true, Plurality.SINGULAR)
    val guitar = CommonNoun(value = "guitar", countable = true, Plurality.SINGULAR)
    val piano = CommonNoun(value = "piano", countable = true, Plurality.SINGULAR)
    val saxophone = CommonNoun(value = "saxophone", countable = true, Plurality.SINGULAR)
    val trumpet = CommonNoun(value = "trumpet", countable = true, Plurality.SINGULAR)
    val ukulele = CommonNoun(value = "ukulele", countable = true, Plurality.SINGULAR)
    val viola = CommonNoun(value = "viola", countable = true, Plurality.SINGULAR)
    val violin = CommonNoun(value = "violin", countable = true, Plurality.SINGULAR)

    //Places

    val artGallery = CommonNoun(value = "art gallery", countable = true, Plurality.SINGULAR)
    val aquarium = CommonNoun(value = "aquarium", countable = true, Plurality.SINGULAR)
    val beach = CommonNoun(value = "beach", countable = true, Plurality.SINGULAR)
    val castle = CommonNoun(value = "castle", countable = true, Plurality.SINGULAR)
    val church = CommonNoun(value = "church", countable = true, Plurality.SINGULAR)
    val cinema = CommonNoun(value = "cinema", countable = true, Plurality.SINGULAR)
    val gallery = CommonNoun(value = "gallery", countable = true, Plurality.SINGULAR)
    val library = CommonNoun(value = "library", countable = true, Plurality.SINGULAR)
    val mountain = CommonNoun(value = "mountain", countable = true, Plurality.SINGULAR)
    val museum = CommonNoun(value = "museum", countable = true, Plurality.SINGULAR)
    val park = CommonNoun(value = "park", countable = true, Plurality.SINGULAR)
    val theater = CommonNoun(value = "theater", countable = true, Plurality.SINGULAR)
    val zoo = CommonNoun(value = "zoo", countable = true, Plurality.SINGULAR)

    //Fruits

    val apple = CommonNoun(value = "apple", countable = true, Plurality.SINGULAR)
    val banana = CommonNoun(value = "banana", countable = true, Plurality.SINGULAR)
    val blueberry = CommonNoun(value = "blueberry", countable = true, Plurality.SINGULAR)
    val cherry = CommonNoun(value = "cherry", countable = true, Plurality.SINGULAR)
    val coconut = CommonNoun(value = "coconut", countable = true, Plurality.SINGULAR)
    val grape = CommonNoun(value = "grape", countable = true, Plurality.SINGULAR)
    val kiwi = CommonNoun(value = "kiwi", countable = true, Plurality.SINGULAR)
    val lemon = CommonNoun(value = "lemon", countable = true, Plurality.SINGULAR)
    val mango = CommonNoun(value = "mango", countable = true, Plurality.SINGULAR)
    val orange = CommonNoun(value = "orange", countable = true, Plurality.SINGULAR)
    val peach = CommonNoun(value = "peach", countable = true, Plurality.SINGULAR)
    val pear = CommonNoun(value = "pear", countable = true, Plurality.SINGULAR)
    val raspberry = CommonNoun(value = "raspberry", countable = true, Plurality.SINGULAR)
    val strawberry = CommonNoun(value = "strawberry", countable = true, Plurality.SINGULAR)
    val watermelon = CommonNoun(value = "watermelon", countable = true, Plurality.SINGULAR)

    //Vegetables

    val asparagus = CommonNoun(value = "asparagus", countable = true, Plurality.SINGULAR)
    val broccoli = CommonNoun(value = "broccoli", countable = true, Plurality.SINGULAR)
    val cabbage = CommonNoun(value = "cabbage", countable = true, Plurality.SINGULAR)
    val carrot = CommonNoun(value = "carrot", countable = true, Plurality.SINGULAR)
    val cauliflower = CommonNoun(value = "cauliflower", countable = true, Plurality.SINGULAR)
    val celery = CommonNoun(value = "celery", countable = false, Plurality.SINGULAR)
    val corn = CommonNoun(value = "corn", countable = false, Plurality.SINGULAR)
    val courgette = CommonNoun(value = "courgette", countable = true, Plurality.SINGULAR)
    val cucumber = CommonNoun(value = "cucumber", countable = true, Plurality.SINGULAR)
    val garlic = CommonNoun(value = "garlic", countable = true, Plurality.SINGULAR)
    val greenBeans = CommonNoun(value = "green beans", countable = false, Plurality.SINGULAR)
    val greenPeas = CommonNoun(value = "green peas", countable = false, Plurality.SINGULAR)
    val leeks = CommonNoun(value = "leeks", countable = true, Plurality.SINGULAR)
    val lentils = CommonNoun(value = "lentils", countable = false, Plurality.SINGULAR)
    val onion = CommonNoun(value = "onion", countable = true, Plurality.SINGULAR)
    val pepper = CommonNoun(value = "pepper", countable = true, Plurality.SINGULAR)
    val potato = CommonNoun(value = "potato", countable = true, Plurality.SINGULAR)
    val pumpkin = CommonNoun(value = "pumpkin", countable = true, Plurality.SINGULAR)
    val rice = CommonNoun(value = "rice", countable = false, Plurality.SINGULAR)
    val tomato = CommonNoun(value = "tomato", countable = true, Plurality.SINGULAR)
    val turnip = CommonNoun(value = "turnip", countable = true, Plurality.SINGULAR)

    //Drinks

    val beer = CommonNoun(value = "beer", countable = false, Plurality.SINGULAR)
    val cocktail = CommonNoun(value = "cocktail", countable = false, Plurality.SINGULAR)
    val coffee = CommonNoun(value = "coffee", countable = false, Plurality.SINGULAR)
    val fruitJuice = CommonNoun(value = "fruit juice", countable = false, Plurality.SINGULAR)
    val lemonade = CommonNoun(value = "lemonade", countable = false, Plurality.SINGULAR)
    val milk = CommonNoun(value = "milk", countable = false, Plurality.SINGULAR)
    val vegetableJuice = CommonNoun(value = "vegetable juice", countable = false, Plurality.SINGULAR)
    val water = CommonNoun(value = "water", countable = false, Plurality.SINGULAR)
    val wine = CommonNoun(value = "wine", countable = false, Plurality.SINGULAR)

    val dinner = CommonNoun(value = "dinner", countable = true, Plurality.SINGULAR)

    val pizza = CommonNoun(value = "pizza", countable = true, Plurality.SINGULAR)
    val chicken = CommonNoun(value = "chicken", countable = true, Plurality.SINGULAR)
    val fish = CommonNoun(value = "fish", countable = true, Plurality.SINGULAR)

    val dishes = CommonNoun(value = "dishes", countable = true, Plurality.SINGULAR)

    val article = CommonNoun(value = "article", countable = true, Plurality.SINGULAR)
    val autobiography = CommonNoun(value = "autobiography", countable = true, Plurality.SINGULAR)
    val biography = CommonNoun(value = "biography", countable = true, Plurality.SINGULAR)
    val blog = CommonNoun(value = "blog", countable = true, Plurality.SINGULAR)
    val book = CommonNoun(value = "book", countable = true, Plurality.SINGULAR)
    val content = CommonNoun(value = "content", countable = true, Plurality.SINGULAR)
    val email = CommonNoun(value = "email", countable = true, Plurality.SINGULAR)
    val journal = CommonNoun(value = "journal", countable = true, Plurality.SINGULAR)
    val letter = CommonNoun(value = "letter", countable = true, Plurality.SINGULAR)
    val report = CommonNoun(value = "report", countable = true, Plurality.SINGULAR)
    val socialMediaPost = CommonNoun(value = "social media post", countable = true, Plurality.SINGULAR)

    //School subjects

    val art = Pronoun(value = "art")
    val biology = Pronoun(value = "biology")
    val dance = Pronoun(value = "dance")
    val drama = Pronoun(value = "drama")
    val economics = Pronoun(value = "economics")
    val geography = Pronoun(value = "geography")
    val history = Pronoun(value = "history")
    val math = Pronoun(value = "math")
    val music = Pronoun(value = "music")
    val psychology = Pronoun(value = "psychology")
    val science = Pronoun(value = "science")
    val sociology = Pronoun(value = "sociology")


    val womanNames = listOf(
        Pronoun("Emily"),
        Pronoun("Jennifer"),
    )

    val manNames = listOf(
        Pronoun("John"),
        Pronoun("William"),
    )

    val names = womanNames.plus(manNames)

    //Transport

    val bus = CommonNoun(value = "bus", countable = true, Plurality.SINGULAR)
    val car = CommonNoun(value = "car", countable = true, Plurality.SINGULAR)
    val taxi = CommonNoun(value = "taxi", countable = true, Plurality.SINGULAR)
    val train = CommonNoun(value = "train", countable = true, Plurality.SINGULAR)

    //Others

    val laptop = CommonNoun(value = "laptop", countable = true, Plurality.SINGULAR)
    val phone = CommonNoun(value = "phone", countable = true, Plurality.SINGULAR)
    val house = CommonNoun(value = "house", countable = true, Plurality.SINGULAR)
    val key = CommonNoun(value = "key", countable = true, Plurality.SINGULAR)
    val desk = CommonNoun(value = "desk", countable = true, Plurality.SINGULAR)
    val pen = CommonNoun(value = "pen", countable = true, Plurality.SINGULAR)
    val boy = CommonNoun(value = "boy", countable = true, Plurality.SINGULAR)
    val bench = CommonNoun(value = "bench", countable = true, Plurality.SINGULAR)
    val box = CommonNoun(value = "box", countable = true, Plurality.SINGULAR)
    val kiss = CommonNoun(value = "kiss", countable = true, Plurality.SINGULAR)
    val dish = CommonNoun(value = "dish", countable = true, Plurality.SINGULAR)
    val buzz = CommonNoun(value = "buzz", countable = true, Plurality.SINGULAR)
    val shelf = CommonNoun(value = "shelf", countable = true, Plurality.SINGULAR)
    val wife = CommonNoun(value = "wife", countable = true, Plurality.SINGULAR)
    val radio = CommonNoun(value = "radio", countable = true, Plurality.SINGULAR)
    val city = CommonNoun(value = "city", countable = true, Plurality.SINGULAR)
    val day = CommonNoun(value = "day", countable = true, Plurality.SINGULAR)
    val sofa = CommonNoun(value = "sofa", countable = true, Plurality.SINGULAR)
    val song = CommonNoun(value = "song", countable = true, Plurality.SINGULAR)
    val lesson = CommonNoun(value = "lesson", countable = true, Plurality.SINGULAR)
    val picture = CommonNoun(value = "picture", countable = true, Plurality.SINGULAR)
    val school = CommonNoun(value = "school", countable = true, Plurality.SINGULAR)
    val movie = CommonNoun(value = "movie", countable = true, Plurality.SINGULAR)
    val rule = CommonNoun(value = "rule", countable = true, Plurality.SINGULAR)
    val homework = CommonNoun(value = "homework", countable = true, Plurality.SINGULAR)
}