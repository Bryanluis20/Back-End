package state

class StartingServerState(server: Server) : AbstractServerState() {
    init {
        Thread {
            try {
                println("Server Starting")
                Thread.sleep((1000 * 10).toLong())
                if (server.messageProcess.countMessage()
                    >= server.maxRequest
                ) {
                    server.setState(
                        SaturatedServerState(server)
                    )
                } else {
                    server.setState(
                        StartServerState(server)
                    )
                }
                println("Server Start")
            } catch (e: Exception) {
            }
        }.start()
    }

    override fun handleMessage(server: Server?, message: String?) {
        server!!.messageProcess.queueMessage(message!!)
    }
}

