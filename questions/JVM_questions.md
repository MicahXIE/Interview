- JVM 内存结构
  
  JVM内存结构主要有三大块：**堆内存**、**方法区**和**栈**。
  
  **堆内存**是JVM中最大的一块由**年轻代**和**老年代**组成，而年轻代内存又被分成三部分，**Eden空间**、**From Survivor空间**、**To Survivor空间**,
  默认情况下年轻代按照8:1:1的比例来分配；
  **方法区**存储类信息、常量、静态变量等数据，是线程共享的区域，为与Java堆区分，方法区还有一个别名Non-Heap(非堆)；
  **栈**又分为java虚拟机栈和本地方法栈主要用于方法的执行。
  
  ```
  控制参数
  -Xms设置堆的最小空间大小。
  
  -Xmx设置堆的最大空间大小。
  
  -XX:NewSize设置新生代最小空间大小。

  -XX:MaxNewSize设置新生代最大空间大小。

  -XX:PermSize设置永久代最小空间大小。

  -XX:MaxPermSize设置永久代最大空间大小。

  -Xss设置每个线程的堆栈大小。


MinorGC && MajorGC && FullGC
When the new generation fills up, it triggers a minor collection in which the surviving objects are moved to the old generation. 
When the old generation fills up, it triggers a major collection which involves the entire object heap.
FullGC clear all the young and old generation heap


FullGC触发场景： 
1、System.gc

2.promotion failed (年代晋升失败,比如eden区的存活对象晋升到S区放不下，又尝试直接晋升到Old区又放不下，那么Promotion Failed,会触发FullGC)

3.CMS的Concurrent-Mode-Failure 由于CMS回收过程中主要分为四步: 
1.CMS initial mark 2.CMS Concurrent mark 3.CMS remark 4.CMS Concurrent sweep。

在2中gc线程与用户线程同时执行，那么用户线程依旧可能同时产生垃圾， 
如果这个垃圾较多无法放入预留的空间就会产生CMS-Mode-Failure， 
切换为SerialOld单线程做mark-sweep-compact。

4.新生代晋升的平均大小 大于 老年代的剩余空间 （为了避免新生代晋升到老年代失败）


常见OOM问题 怎么调试：
1. StackOverflowError
线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常 。递归调用方法，如果没有方法出口的方法会造成StackOverflowError，或者说如果调用的过深都会抛出，这种错误也比较容易定位。

2. java.lang.OutOfMemoryError: Java heap space
溢出原因：深入理解Java虚拟机书中讲到java堆溢出，Java堆用于存储对象实例，只要不断地创建对象，并且保证GC Roots到对象之间有可达路径来避免垃圾回收机制清除这些对象，那么在对象数量到达最大堆的容量限制后就会产生内存溢出异常。

3. java.lang.OutOfMemoryError:GC overhead limit exceeded
GC回收时间长时会抛出OutOfMemoryError。过长的定义是，超过98%的时间用来做GC并且回收了不到2%的堆内存，连续多次GC都只回收了不到2%的极端情况下才会抛出。假设不抛出GC overhead limit错误会发生什么情况呢？那就是GC清理的这么点内存很快会再次填满，迫使GC再次执行，这样就形成恶性循环，CPU使用率一直是100%，而GC缺没有任何成果。


4. java.lang.OutOfMemoryError:Direct buffer memory
Direct memory可以通过参数-XX:MaxDirectMemorySize设定本机直接内存可用大小，如果不指定，则默认与java堆内存大小相同。过使用-XX:MaxDirectMemorySize=5M，限制最大可使用的本机直接内存大小为5MB，如果超过将抛出异常。


5. java.lang.OutOfMemoryError:unable to create new native thread

不知道你们生产环境是否会出现这种情况，高并发请求服务器时，经常出现如下异常java.lang.OutOfMemoryError:unable to create new native thread。那出现的原因呢？

1.创建太多的线程了2.服务器的设置限制了你创建线程的数量了


6. java.langOutOfMemoryError:Metaspace

我们知道Java8及以后已经使用Metaspace来替代永久代，Metaspace并不在虚拟机内存中而是使用本地内存。主要还是是加载到内存中的 class 数量太多或者体积太大。这时可以通过JVM参数-XX:MaxMetaspaceSize指定。
