package models
import kotlin.random.Random

class Randomizer(val numberLimit: Int, val maxNumber: Int) {
    var randomizedNumbers: MutableSet<Int> = mutableSetOf()
        get(){
            field = generate()
            return field
        }

    private fun generate(): MutableSet<Int>{
        var generatedSet: MutableSet<Int> = mutableSetOf()
        do{
            generatedSet.add(rand())
        } while(generatedSet.size < maxNumber)
        return generatedSet
    }
    private fun rand() = Random(System.nanoTime()).nextInt(1, numberLimit+1)
}