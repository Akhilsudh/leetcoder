# Multithreading

New -> Runnable     ->      Running -> Terminated (done/stop())
        |       |               |
    Blocked   Waiting           TimedWaiting
    (IO)     (notify()/Wait())  (sleep()/join())

Monitor Locking: Every object has a monitor lock for a shared resource