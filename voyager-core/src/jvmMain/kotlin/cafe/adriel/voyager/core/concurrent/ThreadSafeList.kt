package cafe.adriel.voyager.core.concurrent

import java.util.concurrent.CopyOnWriteArrayList
import java.util.function.IntFunction

public actual class ThreadSafeList<T> : MutableList<T>, CopyOnWriteArrayList<T>()

