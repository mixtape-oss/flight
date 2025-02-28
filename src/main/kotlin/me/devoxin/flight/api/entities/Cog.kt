package me.devoxin.flight.api.entities

import me.devoxin.flight.api.command.Context
import me.devoxin.flight.internal.entities.ICommand

interface Cog {
    fun name(): String? = null

    /**
     * Invoked when an error occurs during command execution.
     * This is local to the cog, allowing for per-cog error handling.
     *
     * @return Whether the error was handled or not. If it wasn't,
     *         the error will be passed back to the registered
     *         CommandClientAdapter for handling.
     */
    suspend fun onCommandError(ctx: Context, command: ICommand, error: Throwable): Boolean = false

    /**
     * Invoked before a command is executed. This check is local to
     * all commands inside the cog.
     *
     * @return Whether the command execution should continue or not.
     */
    suspend fun localCheck(ctx: Context, command: ICommand): Boolean = true
}
