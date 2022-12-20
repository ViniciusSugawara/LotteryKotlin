package models
import kotlin.random.Random

class Randomizer {
    fun rand(start: Int, end: Int) = Random(System.nanoTime()).nextInt(start, end+1)
}