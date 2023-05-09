package flyweight

object PlayItemFactory {
    var enableFlyweight = true
    private val PLAY_ITEMS: MutableMap<String, PlayItem> = HashMap()
    private var idSequence = 0L
    fun createPlayItem(songName: String): PlayItem? {
        return if (enableFlyweight && PLAY_ITEMS.containsKey(songName)) {
            PLAY_ITEMS[songName]
        } else {
            val playItem = PlayItem(++idSequence, songName)
            PLAY_ITEMS[songName] = playItem
            playItem
        }
    }
}