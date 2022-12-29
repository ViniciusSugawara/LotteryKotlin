package models
import kotlin.random.Random

class Randomizer(val drawLimit: Int, val maxNumber: Int) {
    var randomizedNumbers: MutableSet<Int> = mutableSetOf()
        get(){
            field = generateSet()
            return field
        }

    private fun generateSet(): MutableSet<Int>{
        var generatedSet: MutableSet<Int> = mutableSetOf()
        do{
            generatedSet.add(generateRandomInt())
        } while(generatedSet.size < maxNumber)
        return generatedSet
    }
    private fun generateRandomInt() = Random(System.nanoTime()).nextInt(1, drawLimit+1)
}