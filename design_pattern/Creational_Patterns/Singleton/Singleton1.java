// 饿汉方式。指全局的单例实例在类装载时构建。

public class Singleton {

	private static volatile Singleton INSTANCE = null;
  
	// Private constructor suppresses 
	// default public constructor
	private Singleton() {};
  
	//Thread safe and performance  promote 
	public static  Singleton getInstance() {
		if (INSTANCE == null) {
			synchronized(Singleton.class) {
				// When more than two threads run into the first null check same time, 
				// to avoid instanced more than one time, it needs to be checked again.
				if (INSTANCE == null) { 
					INSTANCE = new Singleton();
            	}
            } 
        }
        return INSTANCE;
    }
}