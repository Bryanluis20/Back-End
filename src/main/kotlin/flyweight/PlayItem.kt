package flyweight

class PlayItem {
    private var id: Long? = null
    private var songName: String? = null
    private val song = ByteArray(1000000)

    constructor(id: Long?, songName: String?) {
        this.id = id
        this.songName = songName
    }
    constructor()

    override fun toString(): String {
        return "PlayItem{id=$id, songName=$songName}"
    }
    /** GET and SET  */
}