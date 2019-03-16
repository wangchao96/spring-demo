/**
 * 双重检测-懒加载单例
 */
class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类单例
 */
class StaticSingleton{

    private StaticSingleton(){}

    private static class SingletonHolder{
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    public StaticSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

}



