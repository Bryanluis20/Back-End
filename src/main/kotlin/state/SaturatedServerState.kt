package state

class SaturatedServerState(server: Server) : AbstractServerState() {
    private val monitoringThread: Thread

    init {
        server.messageProcess.start()
        monitoringThread = Thread {
            try {
                while (true) {
                    if (server.messageProcess
                            .countMessage() <
                        server.maxRequest
                    ) {
                        server.setState(
                            StartServerState(server)
                        )
                        break
                    }
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
        monitoringThread.start()
    }

    override fun handleMessage(server: Server?, message: String?) {
        println("Cann´t process request, Server Saturated")
    }
}