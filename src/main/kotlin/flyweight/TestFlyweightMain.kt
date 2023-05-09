package flyweight

import java.util.*
import kotlin.collections.ArrayList


fun main(args: Array<String>) {
    println("" +
            "Proceso de creación de playlist iniciado, este procecso puede\n" +
            "ser muy tardado por la gran cantidad de objetos que se \n" +
            "crearán, por favor espere un momento hasta que se le \n" +
            "notifique que el proceso ha terminado.")

    val runtime = Runtime.getRuntime()
    println("MaxMemory > " + runtime.maxMemory() / 1000000)
    PlayItemFactory.enableFlyweight = false
    initArrays()
    createRandonPlayList()

    println("total playlist > " + playLists.size)

    val memoryUsed = runtime.totalMemory() - runtime.freeMemory()
    println("Memory Used => " + memoryUsed / 1000000)
}
//
private val songNames = arrayOfNulls<String>(1000)
private val playListNames = arrayOfNulls<String>(174)
private val playLists: MutableList<PlayList> = ArrayList()

private fun createRandonPlayList() {
    val random = Random()
    var p = 0
    for (c in playListNames.indices) {
        val playList = PlayList(playListNames[c]!!)
        for (i in 0..9) {
            val song = random.nextInt(songNames.size)
            playList.addPlayItem(songNames[song]!!)
        }
        playLists.add(playList)
        if (c != 0 && (c + 1) % (playListNames.size / 10) == 0) {
            p += 10
            println("Completado $p%")
            println("Listas creadas " + playLists.size)
        }
    }
}

private fun initArrays() {
    for (c in songNames.indices) {
        songNames[c] = "Song " + (c + 1)
    }
    for (c in playListNames.indices) {
        playListNames[c] = "PlayList " + (c + 1)
    }
}

