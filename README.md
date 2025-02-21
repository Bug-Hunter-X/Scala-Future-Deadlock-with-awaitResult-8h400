# Scala Future Deadlock Example

This example demonstrates a potential deadlock scenario when using `Future` and `awaitResult` in Scala. It is crucial to understand how implicit ExecutionContexts and thread management influence concurrency.

## The Problem

The `awaitResult` method blocks the current thread until the Future completes. If the Future itself is executed within the same thread, it creates a deadlock situation. The thread is waiting for the Future, but the Future cannot complete because it is blocked by the same thread.

## How to Reproduce

1. Copy and paste `ImplicitExecutionContextExample.scala`.
2. Compile and run the code. This will result in a deadlock and no output after the program runs for an extended time.

## Solution

The solution is to ensure that the Futures are executed in a separate thread pool, avoiding a deadlock.

See the corrected example in `ImplicitExecutionContextExampleSolution.scala`.