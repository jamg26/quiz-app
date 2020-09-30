package com.jamg.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.random.Random


data class Quiz(
    val results: List<Results>
)

data class Results(
    val category: String,
    val type: String,
    val difficulty: String,
    val question: String,
    val correct_answer: String,
    val incorrect_answers: ArrayList<String>
)

class MainActivity : AppCompatActivity() {
    private val quiz: String = """{"response_code":0,"results":[{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Virgin Trains, Virgin Atlantic and Virgin Racing, are all companies owned by which famous entrepreneur?   ","correct_answer":"Richard Branson","incorrect_answers":["Alan Sugar","Donald Trump","Bill Gates"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Where is the train station Llanfair pwllgwyngyll gogery chwyrn drobwll llan tysilio gogo goch?","correct_answer":"Wales","incorrect_answers":["Moldova","Czech Republic","Denmark"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the most common surname Wales?","correct_answer":"Jones","incorrect_answers":["Williams","Davies","Evans"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What was the name of the WWF professional wrestling tag team made up of the wrestlers Ax and Smash?","correct_answer":"Demolition","incorrect_answers":["The Dream Team","The Bushwhackers","The British Bulldogs"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the first book of the Old Testament?","correct_answer":"Genesis","incorrect_answers":["Exodus","Leviticus","Numbers"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which best selling toy of 1983 caused hysteria, resulting in riots breaking out in stores?","correct_answer":"Cabbage Patch Kids","incorrect_answers":["Transformers","Care Bears","Rubik s Cube"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What does a funambulist walk on?","correct_answer":"A Tight Rope","incorrect_answers":["Broken Glass","Balls","The Moon"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"In past times, what would a gentleman keep in his fob pocket?","correct_answer":"Watch","incorrect_answers":["Money","Keys","Notebook"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the largest organ of the human body?","correct_answer":"Skin","incorrect_answers":["Heart","large Intestine","Liver"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which sign of the zodiac is represented by the Crab?","correct_answer":"Cancer","incorrect_answers":["Libra","Virgo","Sagittarius"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What does the  S  stand for in the abbreviation SIM, as in SIM card? ","correct_answer":"Subscriber","incorrect_answers":["Single","Secure","Solid"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What word represents the letter  T  in the NATO phonetic alphabet?","correct_answer":"Tango","incorrect_answers":["Target","Taxi","Turkey"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What alcoholic drink is made from molasses?","correct_answer":"Rum","incorrect_answers":["Gin","Vodka","Whisky"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which American president appears on a one dollar bill?","correct_answer":"George Washington","incorrect_answers":["Thomas Jefferson","Abraham Lincoln","Benjamin Franklin"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What geometric shape is generally used for stop signs?","correct_answer":"Octagon","incorrect_answers":["Hexagon","Circle","Triangle"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the shape of the toy invented by Hungarian professor Ern\u0151 Rubik?","correct_answer":"Cube","incorrect_answers":["Sphere","Cylinder","Pyramid"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the name of the Jewish New Year?","correct_answer":"Rosh Hashanah","incorrect_answers":["Elul","New Year","Succoss"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Red Vines is a brand of what type of candy?","correct_answer":"Licorice","incorrect_answers":["Lollipop","Chocolate","Bubblegum"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the nickname of the US state of California?","correct_answer":"Golden State","incorrect_answers":["Sunshine State","Bay State","Treasure State"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is on display in the Madame Tussaud s museum in London?","correct_answer":"Wax sculptures","incorrect_answers":["Designer clothing","Unreleased film reels","Vintage cars"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What was the nickname given to the Hughes H-4 Hercules, a heavy transport flying boat which achieved flight in 1947?","correct_answer":"Spruce Goose","incorrect_answers":["Noah s Ark","Fat Man","Trojan Horse"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which of these colours is NOT featured in the logo for Google?","correct_answer":"Pink","incorrect_answers":["Yellow","Blue","Green"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the Spanish word for donkey?","correct_answer":"Burro","incorrect_answers":["Caballo","Toro","Perro"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the French word for hat?","correct_answer":"Chapeau","incorrect_answers":["Bonnet","  charpe"," Casque"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Who is depicted on the US hundred dollar bill?","correct_answer":"Benjamin Franklin","incorrect_answers":["George Washington","Abraham Lincoln","Thomas Jefferson"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What do the letters in the GMT time zone stand for?","correct_answer":"Greenwich Mean Time","incorrect_answers":["Global Meridian Time","General Median Time","Glasgow Man Time"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which one of these is not a typical European sword design?","correct_answer":"Scimitar","incorrect_answers":["Falchion","Ulfberht","Flamberge"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which American-owned brewery led the country in sales by volume in 2015?","correct_answer":"D. G. Yuengling and Son, Inc","incorrect_answers":["Anheuser Busch","Boston Beer Company","Miller Coors"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"The New York Times slogan is,  All the News That s Fit to ","correct_answer":"Print","incorrect_answers":["Digest","Look","Read"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which restaurant s mascot is a clown?","correct_answer":"McDonald s","incorrect_answers":["Whataburger","Burger King","Sonic"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What color is the Ex in FedEx Ground?","correct_answer":"Green","incorrect_answers":["Red","Light Blue","Orange"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What was the first ever London Underground line to be built?","correct_answer":"Metropolitan Line","incorrect_answers":["Circle Line","Bakerloo Line","Victoria Line"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"How tall is the Burj Khalifa?","correct_answer":"2,722 ft","incorrect_answers":["2,717 ft","2,546 ft","3,024 ft"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What machine element is located in the center of fidget spinners?","correct_answer":"Bearings","incorrect_answers":["Axles","Gears","Belts"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which of the following presidents is not on Mount Rushmore?","correct_answer":"John F. Kennedy","incorrect_answers":["Theodore Roosevelt","Abraham Lincoln","Thomas Jefferson"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is Tasmania?","correct_answer":"An Australian State","incorrect_answers":["A flavor of Ben and Jerry s ice-cream","A Psychological Disorder","The Name of a Warner Brothers Cartoon Character"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which country, not including Japan, has the most people of japanese decent?","correct_answer":"Brazil","incorrect_answers":["China","South Korea","United States of America"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"In which fast food chain can you order a Jamocha Shake?","correct_answer":"Arby s","incorrect_answers":["McDonald s","Burger King","Wendy s"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the Zodiac symbol for Gemini?","correct_answer":"Twins","incorrect_answers":["Fish","Scales","Maiden"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What zodiac sign is represented by a pair of scales?","correct_answer":"Libra","incorrect_answers":["Aries","Capricorn","Sagittarius"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What nuts are used in the production of marzipan?","correct_answer":"Almonds","incorrect_answers":["Peanuts","Walnuts","Pistachios"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"According to the nursery rhyme, what fruit did Little Jack Horner pull out of his Christmas pie?","correct_answer":"Plum","incorrect_answers":["Apple","Peach","Pear"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Terry Gilliam was an animator that worked with which British comedy group?","correct_answer":"Monty Python","incorrect_answers":["The Goodies ","The League of Gentlemen ","The Penny Dreadfuls"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"When someone is inexperienced they are said to be what color?","correct_answer":"Green","incorrect_answers":["Red","Blue","Yellow"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"If you are caught Goldbricking, what are you doing wrong?","correct_answer":"Slacking","incorrect_answers":["Smoking","Stealing","Cheating"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"How many furlongs are there in a mile?","correct_answer":"Eight","incorrect_answers":["Two","Four","Six"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"When one is envious, they are said to be what color?","correct_answer":"Green","incorrect_answers":["Red","Blue","Yellow"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"When someone is cowardly, they are said to have what color belly?","correct_answer":"Yellow","incorrect_answers":["Green","Red","Blue"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the name of NASA s most famous space telescope?","correct_answer":"Hubble Space Telescope","incorrect_answers":["Big Eye","Death Star","Millenium Falcon"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Earth is located in which galaxy?","correct_answer":"The Milky Way Galaxy","incorrect_answers":["The Mars Galaxy","The Galaxy Note","The Black Hole"]}, {"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What does a milliner make and sell?","correct_answer":"Hats","incorrect_answers":["Shoes","Belts","Shirts"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"In a standard set of playing cards, which is the only king without a moustache?","correct_answer":"Hearts","incorrect_answers":["Spades","Diamonds","Clubs"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which river flows through the Scottish city of Glasgow?","correct_answer":"Clyde","incorrect_answers":["Tay","Dee","Tweed"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"When was the Declaration of Independence approved by the Second Continental Congress?","correct_answer":"July 2, 1776","incorrect_answers":["May 4, 1776","June 4, 1776","July 4, 1776"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the defining characteristic of someone who is described as hirsute?","correct_answer":"Hairy","incorrect_answers":["Rude","Funny","Tall"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Rolex is a company that specializes in what type of product?","correct_answer":"Watches","incorrect_answers":["Cars","Computers","Sports equipment"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Scotch whisky and Drambuie make up which cocktail?","correct_answer":"Rusty Nail","incorrect_answers":["Screwdriver","Sex on the Beach","Manhattan"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which language is NOT Indo-European?","correct_answer":"Hungarian","incorrect_answers":["Russian","Greek","Latvian"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which of the following Ivy League universities has its official motto in Hebrew as well as in Latin?","correct_answer":"Yale University","incorrect_answers":["Princeton University","Harvard University","Columbia University"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is a dakimakura?","correct_answer":"A body pillow","incorrect_answers":["A Chinese meal, essentially composed of fish","A yoga posture","A word used to describe two people who truly love each other"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the name of the very first video uploaded to YouTube?","correct_answer":"Me at the zoo","incorrect_answers":["tribute","carrie rides a truck","Her new puppy from great grandpa vern."]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"In 2013 how much money was lost by Nigerian scams?","correct_answer":"${'$'}12.7 Billion","incorrect_answers":["${'$'}95 Million","${'$'}956 Million","${'$'}2.7 Billion"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which of these companies does NOT manufacture automobiles?","correct_answer":"Ducati","incorrect_answers":["Nissan","GMC","Fiat"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Who is a co-founder of music streaming service Spotify?","correct_answer":"Daniel Ek","incorrect_answers":["Sean Parker","Felix Miller","Michael Breidenbruecker"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"A factiod is what?","correct_answer":"A falsehood","incorrect_answers":["Useless trivia","A tiny fact","A scientific figure"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the unit of currency in Laos?","correct_answer":"Kip","incorrect_answers":["Ruble","Konra","Dollar"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which of the following buildings is example of a structure primarily built in the Art Deco architectural style?","correct_answer":"Niagara Mohawk Building","incorrect_answers":["Taipei 101","One Detroit Center","Westendstrasse 1"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What alcoholic drink is mainly made from juniper berries?","correct_answer":"Gin","incorrect_answers":["Vodka","Rum","Tequila"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which Italian automobile manufacturer gained majority control of U.S. automobile manufacturer Chrysler in 2011?","correct_answer":"Fiat","incorrect_answers":["Maserati","Alfa Romeo","Ferrari"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the name given to Indian food cooked over charcoal in a clay oven?","correct_answer":"Tandoori","incorrect_answers":["Biryani","Pani puri","Tiki masala"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the German word for spoon?","correct_answer":"L ffel","incorrect_answers":["Gabel","Messer","Essst bchen"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the romanized Japanese word for university?","correct_answer":"Daigaku","incorrect_answers":["Toshokan","Jimusho","Shokudou"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the Swedish word for window?","correct_answer":"F nster","incorrect_answers":["H l","Sk rm","Ruta"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the Italian word for tomato?","correct_answer":"Pomodoro","incorrect_answers":["Aglio","Cipolla","Peperoncino"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the name of the popular animatronic singing fish prop, singing such hits such as Don t Worry, Be Happy?","correct_answer":"Big Mouth Billy Bass","incorrect_answers":["Big Billy Bass","Singing Fish","Sardeen"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"On average, Americans consume 100 pounds of what per second?","correct_answer":"Chocolate","incorrect_answers":["Potatoes","Donuts","Cocaine"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Who is the founder of The Lego Group?","correct_answer":"Ole Kirk Christiansen","incorrect_answers":[" Jens Niels Christiansen","Kirstine Christiansen"," Gerhardt Kirk Christiansen"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the last letter of the Greek alphabet?","correct_answer":"Omega","incorrect_answers":["Mu","Epsilon","Kappa"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What character was once considered to be the 27th letter of the alphabet?","correct_answer":"Ampersand","incorrect_answers":["Interrobang","Tilde","Pilcrow"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"When was Nintendo founded?","correct_answer":"September 23rd, 1889","incorrect_answers":["October 19th, 1891","March 4th, 1887","December 27th, 1894"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"The new One World Trade Center in Manhattan, New York City was designed by which architect? ","correct_answer":"David Childs","incorrect_answers":["Bjarke Ingels","Michael Arad","Fumihiko Maki"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which of the following carbonated soft drinks were introduced first?","correct_answer":"Dr. Pepper","incorrect_answers":["Coca-Cola","Sprite","Mountain Dew"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What direction does the Statue of Liberty face?","correct_answer":"Southeast","incorrect_answers":["Southwest","Northwest","Northeast"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which of the General Mills Corporation s monster cereals was the last to be released in the 1970 s?","correct_answer":"Fruit Brute","incorrect_answers":["Count Chocula","Franken Berry","Boo-Berry"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"When was Hubba Bubba first introduced?","correct_answer":"1979","incorrect_answers":["1984","1972","1980"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which iconic Disneyland attraction was closed in 2017 to be remodeled as a Guardians of the Galaxy themed ride?","correct_answer":"Twilight Zone Tower of Terror","incorrect_answers":["The Haunted Mansion","Pirates of the Caribbean","Peter Pan s Flight"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What was the soft drink Pepsi originally introduced as?","correct_answer":"Brad s Drink","incorrect_answers":["Pepsin Pop","Carolina Cola","Pepsin Syrup"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Where does water from Poland Spring water bottles come from?","correct_answer":"Maine, United States","incorrect_answers":["Hesse, Germany","Masovia, Poland","Bavaria, Poland"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Who invented Pastafarianism?","correct_answer":"Bobby Henderson","incorrect_answers":["Eric Tignor","Bill Nye","Zach Soldi"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Computer manufacturer Compaq was acquired for ${'$'}25 billion dollars in 2002 by which company?","correct_answer":"Hewlett-Packard","incorrect_answers":["Toshiba","Asus","Dell"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is real haggis made of?","correct_answer":"Sheep s Heart, Liver and Lungs","incorrect_answers":["Sheep s Heart, Kidneys and Lungs","Sheep s Liver, Kidneys and Eyes","Whole Sheep"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What was the original name of the search engine Google?","correct_answer":"BackRub","incorrect_answers":["CatMassage","SearchPro","Netscape Navigator"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Whose greyscale face is on the kappa emoticon on Twitch?","correct_answer":"Josh DeSeno","incorrect_answers":["Justin DeSeno","John DeSeno","Jimmy DeSeno"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which of these words means idle spectator?","correct_answer":"Gongoozler","incorrect_answers":["Gossypiboma","Jentacular","Meupareunia"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which country drives on the left side of the road?","correct_answer":"Japan","incorrect_answers":["Germany","Russia","China"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the currency of Poland?","correct_answer":"Z\u0142oty","incorrect_answers":["Ruble","Euro","Krone"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What was the name given to Japanese military dictators who ruled the country through the 12th and 19th Century?","correct_answer":"Shogun","incorrect_answers":["Ninja","Samurai","Shinobi"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"Which American manufactured submachine gun was informally known by the American soldiers that used it as Grease Gun?","correct_answer":"M3","incorrect_answers":["Colt 9mm","Thompson","MAC-10"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"A statue of Charles Darwin sits in what London museum?","correct_answer":"Natural History Museum","incorrect_answers":["Tate","British Museum","Science Museum"]},{"category":"General Knowledge","type":"multiple","difficulty":"medium","question":"What is the highest number of Michelin stars a restaurant can receive?","correct_answer":"Three","incorrect_answers":["Four","Five","Six"]}]}"""
    private var correct = ""
    var db = DatabaseHandler(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getQuiz()
        //var score = Score(0, 1)
        //db.insertData((score))
        try {
            getScore()
        } catch(e: Exception)  {
            var score = Score(0, 1)
            db.insertData((score))
            getScore()
        }
    }

    private fun getScore() {
        var data = db.readData()
        val score: Int = data[0].score
        when {
            score <= 1 -> txtLevel.text = "NEWBIE"
            score >= 10 -> txtLevel.text = "NOVICE"
            score >= 50 -> txtLevel.text = "ROOKIE"
            score >= 100 -> txtLevel.text = "BEGINNER"
            score >= 150 -> txtLevel.text = "TALENTED"
            score >= 200 -> txtLevel.text = "SKILLED"
            score >= 250 -> txtLevel.text = "INTERMEDIATE"
            score >= 300 -> txtLevel.text = "PROFICIENT"
            score >= 350 -> txtLevel.text = "EXPERIENCED"
            score >= 400 -> txtLevel.text = "ADVANCE"
            score >= 500 -> txtLevel.text = "EXPERT"
        }

    }

    private fun updateScore() {
        var data = db.readData()
        when (data[0].score) {
            1 -> Toast.makeText(this, "YOU ARE PROMOTED AS NEWBIE", Toast.LENGTH_LONG).show()
            10 -> Toast.makeText(this, "YOU ARE PROMOTED AS NOVICE", Toast.LENGTH_LONG).show()
            50 -> Toast.makeText(this, "YOU ARE PROMOTED AS ROOKIE", Toast.LENGTH_LONG).show()
            100 -> Toast.makeText(this, "YOU ARE PROMOTED AS BEGINNER", Toast.LENGTH_LONG).show()
            150 -> Toast.makeText(this, "YOU ARE PROMOTED AS TALENTED", Toast.LENGTH_LONG).show()
            200 -> Toast.makeText(this, "YOU ARE PROMOTED AS SKILLED", Toast.LENGTH_LONG).show()
            250 -> Toast.makeText(this, "YOU ARE PROMOTED AS INTERMEDIATE", Toast.LENGTH_LONG).show()
            300 -> Toast.makeText(this, "YOU ARE PROMOTED AS PROFICIENT", Toast.LENGTH_LONG).show()
            350 -> Toast.makeText(this, "YOU ARE PROMOTED AS EXPERIENCED", Toast.LENGTH_LONG).show()
            400 -> Toast.makeText(this, "YOU ARE PROMOTED AS ADVANCE", Toast.LENGTH_LONG).show()
            500 -> Toast.makeText(this, "YOU ARE PROMOTED AS EXPERT", Toast.LENGTH_LONG).show()
        }
        db.updateData()
    }

    private fun getQuiz() {
        val getResults = Gson().fromJson(quiz, Quiz::class.java)

        correct = ""
        val q = getResults.results.random()
        correct = q.correct_answer
        val incorrect = q.incorrect_answers

        when(Random.nextInt(0, 3)) {
            0 -> {
                btnA.text = correct
                btnB.text = incorrect[0]
                btnC.text = incorrect[1]
                btnD.text = incorrect[2]
            }
            1 -> {
                btnB.text = correct
                btnA.text = incorrect[2]
                btnC.text = incorrect[1]
                btnD.text = incorrect[0]
            }
            2 -> {
                btnC.text = correct
                btnB.text = incorrect[1]
                btnA.text = incorrect[0]
                btnD.text = incorrect[2]
            }
            3 -> {
                btnD.text = correct
                btnB.text = incorrect[0]
                btnC.text = incorrect[2]
                btnA.text = incorrect[1]
            }
        }

        txtQuestion.text = q.question

    }

    fun btnA(view: View) {
        if(correct == btnA.text) {
            println(correct)
            alert("You got it!")
            getQuiz()
            updateScore()
            getScore()
        } else {
            alert("WRONG ANSWER! :P")
        }
    }
    fun btnB(view: View) {
        if(correct == btnB.text) {
            println(correct)
            alert("You got it!")
            getQuiz()
            updateScore()
            getScore()
        } else {
            alert("WRONG ANSWER! :P")
        }
    }
    fun btnC(view: View) {
        if(correct == btnC.text) {
            println(correct)
            alert("You got it!")
            getQuiz()
            updateScore()
            getScore()
        } else {
            alert("WRONG ANSWER! :P")
        }
    }
    fun btnD(view: View) {
        if(correct == btnD.text) {
            println(correct)
            alert("You got it!")
            getQuiz()
            updateScore()
            getScore()
        } else {
            alert("WRONG ANSWER! :P")
        }
    }

    private fun alert(message: String) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Message")
        builder.setMessage(message)

        builder.setPositiveButton("OK"){dialog, which ->
            // Do something when user press the positive button
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
