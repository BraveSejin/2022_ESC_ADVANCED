package generics


interface Cleaner<T : WaterSupply> {
    fun clean(waterSupply: T)
}

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}


class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)
class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
    }

    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = waterSupply is R

}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun genericsExample() {
    val aquarium = Aquarium(TapWater())
    isWaterClean(aquarium)
    var a = 1
}


fun main() {
    genericsExample()
}