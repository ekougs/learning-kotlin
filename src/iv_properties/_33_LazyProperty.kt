package iv_properties

import util.TODO
import java.util.concurrent.CompletableFuture

class LazyProperty(val initializer: () -> Int) {
    val _lazy: CompletableFuture<Int> = CompletableFuture()
    val lazy: Int get():Int {
        if (!_lazy.isDone) {
            _lazy.complete(initializer());
        }
        return _lazy.get()
    }
}

fun todoTask33(): Nothing = TODO(
        """
        Task 33.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegated properties!
    """,
        references = { LazyProperty({ 42 }).lazy }
                                )
