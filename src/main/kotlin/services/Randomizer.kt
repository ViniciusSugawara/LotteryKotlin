package services
import kotlin.random.Random

//This class has the resonsibility of generating random numbers determined by two conditions:
// The first one is the quantity of numbers drawn
// THe second one is the maximum allowed number to be drawn
class Randomizer(val drawLimit: Int, val maxNumber: Int) {
    //This has a customized get so that i only need one randomizer object, and every generated value will be random.
    var randomizedNumbers: MutableSet<Int> = mutableSetOf()
        get(){
            field = generateSet()
            return field
        }

    // I had to create this method because defining the scope directly in the get method was increasing the size of the set,
    // each time that i called the function.
    private fun generateSet(): MutableSet<Int>{
        var generatedSet: MutableSet<Int> = mutableSetOf()
        do{
            generatedSet.add(generateRandomInt())
        } while(generatedSet.size < maxNumber) // Used a Do While structure instead of a For(i in drawLimit), because
                                               // if two equal numbers are generated, then a value will be missing.
        return generatedSet
    }
    //Just a method that returns a random int based on system time.
    private fun generateRandomInt() = Random(System.nanoTime()).nextInt(1, drawLimit+1)
}