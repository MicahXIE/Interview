// 懒汉方式。指全局的单例实例在第一次被使用时构建。

public class Singleton {

	private static final Singleton INSTANCE = new Singleton();
  
	// Private constructor suppresses
	// default public constructor
	private Singleton() {};
 
	public static Singleton getInstance() {
		return INSTANCE;
	}
}