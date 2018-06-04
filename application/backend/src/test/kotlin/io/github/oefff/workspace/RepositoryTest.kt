package io.github.oefff.workspace

import org.eclipse.jgit.api.CloneCommand
import org.eclipse.jgit.api.CloneCommand.Callback
import org.eclipse.jgit.lib.AnyObjectId
import org.eclipse.jgit.lib.TextProgressMonitor
import org.junit.Ignore
import org.junit.Test
import java.io.File

class RepositoryTest {


    @Test
    @Ignore
    fun `it should be able to checkout a project`() {

        val createTempDir = createTempDir("junit", ".oefff-workspace")
        val oefffProjectDir = File(createTempDir, "oefff")
        oefffProjectDir.mkdir()

        println("Should clone to ${oefffProjectDir.absolutePath}")

        val monitor = TextProgressMonitor(System.out.writer())
        val callback = LoggingCallback()

        // val jschConfigSessionFactory = DefaultSshSessionFactory()

//        val transportConfigCallback = TransportConfigCallback { it: Transport? ->
//            if ( it is SshTransport ) {
//                it.sshSessionFactory = jschConfigSessionFactory
//            }
//        }
        val cloneCommand = CloneCommand().setURI("git@github.com:oefff/oefff.git")
                .setProgressMonitor(monitor)
                .setDirectory(oefffProjectDir)
                .setCallback(callback)



        val git = cloneCommand.call()

        println(git.log().call().first().fullMessage)


    }
}


class LoggingCallback : Callback {
    override fun checkingOut(commit: AnyObjectId?, path: String?) {
        println("Checking out $commit at $path")
    }

    override fun initializedSubmodules(submodules: MutableCollection<String>?) {
        // No support for logging submodules
    }

    override fun cloningSubmodule(path: String?) {
        // No support for logging submodules
    }

}
