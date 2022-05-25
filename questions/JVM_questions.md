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