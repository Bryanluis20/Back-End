package flyweight
import flyweight.PlayItemFactory.createPlayItem
class PlayList(private val playListName: String) {
    private val playItems: MutableList<PlayItem?> = ArrayList()
    fun addPlayItem(songName: String?) {
        playItems.add(createPlayItem(songName!!))
    }

    fun printList() {
        var out = "\nPlayList > $playListName"
        for (playItem in playItems) {
            out += "\n\t" + playItem.toString()
        }
        println(out)
    }
}