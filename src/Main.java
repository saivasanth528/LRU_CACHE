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
        cache.put("replace", "replace");

        System.out.println(cache.get("hello"));
        System.out.println(cache.get("replace"));

        cache.put("hai", "new Hai");
        System.out.println(cache.get("hai"));





    }
}
