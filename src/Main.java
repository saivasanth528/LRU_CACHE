import cache.Cache;
import factories.CacheFactory;

public class Main {
    public static void main(String args[]) {
        System.out.print("************LRU CACHE MECHANISM **************\n");
        System.out.print("Initializing the cache\n");

        Cache<String, String> cache;

        cache = new CacheFactory<String, String>().defaultCacheMechanism(3);

        cache.put("hello", "hello");
        cache.put("test", "test");
        cache.put("hai", "hai");
        cache.put("nurture", "farm");

        System.out.println("Value of hello --> " + cache.get("hello"));
        System.out.println("Value of nurture --> " + cache.get("nurture"));

        cache.put("hai", "Hello Nurture Farm");
        System.out.println(cache.get("hai"));




    }
}
