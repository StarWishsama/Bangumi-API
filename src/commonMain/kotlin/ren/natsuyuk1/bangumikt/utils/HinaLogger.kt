package ren.natsuyuk1.bangumikt.utils

import kotlinx.atomicfu.AtomicRef
import kotlinx.atomicfu.atomic
import ren.natsuyuk1.bangumikt.BangumiApi
import ren.natsuyuk1.bangumikt.logger
import kotlin.native.concurrent.SharedImmutable

internal typealias LogImpl = ( level: HinaLogLevel, message: String?, throwable: Throwable?, prefix: String, ) -> Unit

internal val DEFAULT_LOG: LogImpl = { level: HinaLogLevel, message: String?, throwable: Throwable?, prefix: String ->
    if (level >= BangumiApi.bangumiLogLevel.value) {
        logger.logAction(
            "${level.color}${nowLocalString()} ${level.internalName}/${level.simpleName}" +
                    "${logger.loggerName} -> ${if (prefix.isEmpty()) "" else "$prefix "}$message"
                    + if (throwable != null) "\n\n${throwable.stackTraceToString()}\n" else "" + "${AnsiUtil.Color.RESET}"
        )
    }
}

@SharedImmutable
private val log: AtomicRef<LogImpl> = atomic(DEFAULT_LOG)

@Suppress("unused", "MemberVisibilityCanBePrivate")
internal class HinaLogger(
    val loggerName: String,
    val logAction: (String) -> Unit = {
        println(it)
    },
) {

    /** 时间 日志等级/日志等级缩写 logger名字 -> logger前缀 消息
     * 例: 2022-01-01T19:00:00 19:18:32 N/MainLogger(i.g.s.c.t.ClassName) -> [Main] Logger Example
    */
    fun log(
        level: HinaLogLevel,
        message: String?,
        throwable: Throwable? = null,
        prefix: String = "",
    ) {
        log.value(level, message, throwable, prefix)
    }

    fun info(content: String?) {
        log(HinaLogLevel.Info, content)
    }

    fun info(content: String?, stacktrace: Throwable?) {
        log(HinaLogLevel.Info, content, stacktrace)
    }

    fun verbose(content: String?) {
        log(HinaLogLevel.Verbose, content)
    }

    fun verbose(content: String?, stacktrace: Throwable?) {
        log(HinaLogLevel.Verbose, content, stacktrace)
    }

    fun error(content: String?) {
        log(HinaLogLevel.Error, content)
    }

    fun error(content: String?, stacktrace: Throwable?) {
        log(HinaLogLevel.Error, content, stacktrace)
    }

    fun warning(content: String?) {
        log(HinaLogLevel.Warn, content)
    }

    fun warning(content: String?, stacktrace: Throwable?) {
        log(HinaLogLevel.Warn, content, stacktrace)
    }

    fun warning(stacktrace: Throwable?) {
        log(HinaLogLevel.Warn, throwable = stacktrace, message = null)
    }

    fun debug(content: String?) {
        log(HinaLogLevel.Debug, content)
    }

    fun debug(content: String?, stacktrace: Throwable?) {
        log(HinaLogLevel.Debug, content, stacktrace)
    }

    fun serve(content: String?, stacktrace: Throwable?) {
        log(HinaLogLevel.Serve, content, stacktrace)
    }

    fun serve(content: String?) {
        log(HinaLogLevel.Serve, content)
    }

    fun fatal(content: String?, stacktrace: Throwable?) {
        log(HinaLogLevel.Fatal, content, stacktrace)
    }

    fun fatal(content: String?) {
        log(HinaLogLevel.Fatal, content)
    }
}


public enum class HinaLogLevel(val internalName: String, val simpleName: String, val color: AnsiUtil.Color) {
    Verbose("VERBOSE", "V", AnsiUtil.Color.GRAY),
    Info("INFO", "I", AnsiUtil.Color.RESET),
    Debug("DEBUG", "D", AnsiUtil.Color.LIGHT_BLUE),
    Error("ERROR", "E", AnsiUtil.Color.LIGHT_RED),
    Warn("WARN", "W", AnsiUtil.Color.LIGHT_YELLOW),
    Serve("SERVE", "S", AnsiUtil.Color.RED),
    Fatal("FATAL", "F", AnsiUtil.Color.RED),
}