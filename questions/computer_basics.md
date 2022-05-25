## Computer Basics


- Spring Bean 完整的生命周期

  实例化、属性赋值、初始化、销毁这 4 个大阶段；

  
    1. Bean容器在配置文件中找到Spring Bean的定义。
    2. Bean容器使用Java Reflection API创建Bean的实例。
    3. 如果声明了任何属性，声明的属性会被设置。如果属性本身是Bean，则将对其进行解析和设置。
    4. 如果Bean类实现BeanNameAware接口，则将通过传递Bean的名称来调用setBeanName()方法。
    5. 如果Bean类实现BeanClassLoaderAware接口，则将通过传递加载此Bean的ClassLoader对象的实例来调用setBeanClassLoader()方法。
    6. 如果Bean类实现BeanFactoryAware接口，则将通过传递BeanFactory对象的实例来调用setBeanFactory()方法。
    7. 如果有任何与BeanFactory关联的BeanPostProcessors对象已加载Bean，则将在设置Bean属性之前调用postProcessBeforeInitialization()方法。
    8. 如果Bean类实现了InitializingBean接口，则在设置了配置文件中定义的所有Bean属性后，将调用afterPropertiesSet()方法。
    9. 如果配置文件中的Bean定义包含init-method属性，则该属性的值将解析为Bean类中的方法名称，并将调用该方法。
    10. 如果为Bean Factory对象附加了任何Bean 后置处理器，则将调用postProcessAfterInitialization()方法。
    11. 如果Bean类实现DisposableBean接口，则当Application不再需要Bean引用时，将调用destroy()方法。
    12. 如果配置文件中的Bean定义包含destroy-method属性，那么将调用Bean类中的相应方法定义。


- Spring IOC, DI 和 AOP
  
  **IOC**: Inversion of Control, 传统应用程序都是由我们在类内部主动创建依赖对象，从而导致类与类之间高耦合，难于测试；有了IoC容器后，
  把创建和查找依赖对象的控制权交给了容器，由容器进行注入组合对象，所以对象与对象之间是松散耦合，这样也方便测试，利于功能复用。
  
  **DI**: Dependency Injection, 在系统运行中，动态的向某个对象提供它所需要的其他对象。Java 1.3之后一个重要特征是反射（reflection），
  它允许程序在运行的时候动态的生成对象、执行对象的方法、改变对象的属性，spring就是通过反射来实现注入的。
  (若 Spring 检测到 bean 实现了 Aware 接口，则会为其注入相应的依赖)
  
  **AOP**: Asepct-Orentid-Programming，AOP就是把与核心业务逻辑无关的代码全部抽取出来(权限认证、日志、事务处理)，放置到某个地方集中管理，
  然后在具体运行时，再由容器动态织入这些共有代码。
  

- Spring FactoryBean and BeanFactory 区别
  
  **BeanFactory**是个Factory，也就是IOC容器或对象工厂，**FactoryBean**是个Bean。
  在Spring中，所有的Bean都是由**BeanFactory**(也就是IOC容器)来进行管理的。
  但对**FactoryBean**而言，这个Bean不是简单的Bean，而是一个能生产或者修饰对象生成的工厂Bean,它的实现与设计模式中的工厂模式和修饰器模式类似。
  
  
- Spring Bean Scope: singleton and propertype
  
  **singleton**: 在Spring的IoC容器中只存在一个实例，所有对该对象的引用将共享这个实例。
  **propertype**: 针对声明为拥有prototype scope的bean定义，容器在接到该类型对象的请求的时候，会每次都重新生成一个新的对象实例给请求方。
  

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
  ```

- JDK Garbage Collection 原理


  确定堆内存中哪些对象是存活的，一般有两种方法：**引用计数法**和**可达性分析法**。
  
  **引用计数**：每个对象有一个引用计数属性，新增一个引用时计数加1，引用释放时计数减1，计数为0时可以回收。引用计数法实现简单，判定高效，但不能解决对象之间相互引用的问题。
  
  **可达性分析**（Reachability Analysis）：从GC Roots开始向下搜索，搜索所走过的路径称为引用链。当一个对象到GC Roots没有任何引用链相连时，则证明此对象是不可用的。
  当一个对象到 GC Roots 没有任何引用链时，意味着该对象可以被回收。


  GC垃圾回收算法:

  1. 标记 -清除算法 (Mark-Sweep)
     
     算法分为“标记”和“清除”两个阶段：首先标记出所有需要回收的对象，在标记完成后统一回收所有被标记的对象。之所以说它是最基础的内存回收算法，
     是因为后续的算法都是基于这种思路、并对其缺点进行改进而得到的。
     
     主要缺点有两个：一个是**效率问题**，标记和清除过程的效率都不高；另外一个是**空间问题**，标记清除之后会产生大量不连续的内存碎片，空间碎片太多可能会导致，
     当程序在以后的运行过程中需要分配较大对象时无法找到足够的连续内存时候，不得不提前触发另一次垃圾收集动作。


  2. 标记复制法 (Mark-Copy)
   
     标记复制法回收算法，它将可用内存按容量划分为大小相等的两块，每次只使用其中的一块。当这一块的内存用完了，就将还存活着的对象复制到另外一块上面，然后再把已使用过的内存空间一次清理掉。 
     这样使得每次都是对其中的一块进行内存回收，内存分配时也就不用考虑内存碎片等复杂情况，只要移动堆顶指针，按顺序分配内存即可，实现简单，运行高效。
     只是这种算法的代价是将**内存缩小**为原来的一半，持续复制长生存期的对象则导致**效率降低**。


  3. 标记-整(Mark-Compat)
     
     避免了上述两种算法的缺点，将垃圾对象清理掉后，同时将剩下的存活对象进行整理挪动（类似于windows的磁盘碎片整理）， 保证它们占用的空间连续，
     这样就避免了内存碎片问题，但是整理过程也会降低GC的效率。

     
  4. 分代收集算法 (Generation-Collect)

     GC分代的假设：绝大部分对象的生命周期都非常短暂，存活时间短。

     分代回收（Generational Collection）算法，把Java堆分为新生代和老年代，这样就可以根据各个年代的特点采用适当的收集算法。
     在新生代中，每次垃圾收集时都发现有大批对象死去，只有少量存活，那就选用复制算法，只需要付出少量存活对象的复制成本就可以完成收集。
     而老年代中因为对象存活率高、没有额外空间对它进行分配担保，就必须使用“标记-清理”或“标记-整理”算法来进行回收。

- JDK 8 s JDK 11 GC 有啥区别

   ZGC（The Z Garbage Collector）是JDK 11中推出的一款低延迟垃圾回收器，它的设计目标包括： 
  
  停顿时间不超过10ms； 
  停顿时间不会随着堆的大小，或者活跃对象的大小而增加； 
  支持8MB~4TB级别的堆（未来支持16TB）。
  

- 创建线程有哪几种方式

  1. 继承Thread类创建线程类
  2. 通过Runnable接口创建线程类
  3. 通过Callable和Future创建线程

  https://www.jianshu.com/p/985aa31a52c4

  
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


