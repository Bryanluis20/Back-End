package state

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.OutputStream
import java.io.PrintStream
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextArea

class ServerPanel : JPanel() {
    private var server: Server
    private var messageCounter: Int
    private lateinit var btnStart: JButton
    private lateinit var jTextArea1: JTextArea

    init {
        initComponents()
        val defaultPrinter = System.out
        val interceptor = TextAreaPrinter(defaultPrinter)
        System.setOut(interceptor)
        server = Server()
        messageCounter = 0
    }

    private inner class TextAreaPrinter(out: OutputStream) : PrintStream(out, true) {
        override fun print(line: String) {
            println(line)
        }

        override fun println(line: String) {
            val modifiedLine = "$line\n"
            super.print(modifiedLine)
            if (::jTextArea1.isInitialized) {
                jTextArea1.append(modifiedLine)
                jTextArea1.caretPosition = jTextArea1.document.length
            }
        }
    }

    private fun initComponents() {
        btnStart = JButton() // Inicializar btnStart aquí
        // Código para inicializar los demás componentes gráficos
    }

    private fun sendMessageEvent(evt: ActionEvent) {
        server.handleMessage("Send Message + ${++messageCounter}")
    }

    private fun startAction(evt: ActionEvent) {
        val state = server.serverState
        if (state is StopServerState) {
            btnStart.text = "Stop"
            server.serverState = StartingServerState(server)
        } else {
            if (state is StartingServerState) {
                server.serverState = StopServerState(server)
            } else {
                btnStart.text = "Start"
                server.serverState = StopServerState(server)
            }
        }
    }

    init {
        btnStart.addActionListener(object : ActionListener {
            override fun actionPerformed(e: ActionEvent) {
                startAction(e)
            }
        })
    }
}
