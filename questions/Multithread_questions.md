- 创建线程有哪几种方式

  1. 继承Thread类创建线程类
  2. 通过Runnable接口创建线程类
  3. 通过Callable和Future创建线程

  
- 创建线程池有哪几种方式

  1. newFixedThreadPool(int nThreads)
  2. newCachedThreadPool()
  3. newSingleThreadExecutor()
  4. newScheduledThreadPool(int corePoolSize)

  
- 列举几种线程安全集合

  1. Vector
  2. HashTable
  3. ConcurrentHashMap
  4. CopyOnWriteArrayList and CopyOnWriteArraySet


JDK5正式提出Future特性支持异步编程，但只能算是半异步，因为需要通过阻塞或轮询的方式获取结果；
Netty/Guava等众多三方库对Future功能进行增强，提供注册回调函数、主动完成等功能；
JDK8借鉴各家所长，正式推出了官方版的CompletableFuture，自此Java有了内置的异步编程模型；

https://www.jianshu.com/p/985aa31a52c4

Future 接口设计：

提供了获取任务结果、取消任务、判断任务状态接口。调用获取任务结果方法，在任务未完成情况下，会导致调用阻塞。


CompletableFuture 核心优势：

1）无需手工维护线程，给任务分配线程的工作无需开发人员关注；

2）在使用上，语义更加清晰明确；

例如：t3 = t1.thenCombine(t2, () -> { // doSomething ... } 能够明确的表述任务 3 要等任务 2 和 任务 1完成后才会开始执行。

3）代码更加简练，支持链式调用，让你更专注业务逻辑。

4）方便的处理异常情况
