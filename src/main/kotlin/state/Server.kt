package state

class Server {
    val messageProcess: MessageProcess = MessageProcess(this)
    var serverState: AbstractServerState? = null

    init {
        setState(StopServerState(this))
    }

    fun handleMessage(message: String?) {
        serverState?.handleMessage(this, message)
    }

    val maxRequest: Int
        get() = Companion.maxRequest

    fun getState(): AbstractServerState? {
        return serverState
    }

    fun setState(state: AbstractServerState?) {
        if (serverState is StartingServerState && state is StopServerState) {
            println("Server is starting, cannot change state")
            return
        }
        serverState = state
        println("Server change state > ${serverState?.javaClass?.simpleName}")
    }

    companion object {
        private const val maxRequest = 5
    }
}
