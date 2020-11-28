学习笔记小结

1. HashMap
// HashMap作为一种数据结构，像数组和链表一样用于常规的增删改查，在存数据的时候(put)并不是随便乱放，
// 而是会先做一次类似“分类”的操作再存储，一旦“分类”存储之后，下次取(get)的时候就可以大大缩短查找的时间。
// 我们知道数组在执行查、改的效率很高，而增、删(不是尾部)的效率低，链表相反，HashMap则是把这两者结合起来。
// 通常情况下HashMap是以数组和链表的组合构成(Java8之后将链表长度超过8的链表转化成红黑树);
// 存取时都会根据键值计算出"类别"(hashCode)，再根据"类别"定位到数组中的位置并执行操作。

// hashCode是一个对象的标识，Java中对象的hashCode是一个int类型值。
// 通过hashCode来指定数组的索引可以快速定位到要找的对象在数组中的位置，
// 之后再遍历链表找到对应值，理想情况下时间复杂度为O(1)，并且不同对象可以拥有相同的hashCode。

// HashMap的时间复杂度取决于hash算法，优秀的hash算法可以让时间复杂度趋于常数O(1)，
// 糟糕的hash算法可以让时间复杂度趋于O(N)。

// 在数组大小不变的情况下，存放键值对越多，查找的时间效率会降低，扩容可以解决该问题，
// 而负载因子决定了什么时候扩容，负载因子是已存键值对的数量和总的数组长度的比值。
// 默认情况下负载因子为0.75，我们可在初始化HashMap的时候自己修改。
// 阀值 = 当前数组长度✖负载因子

// HashMap简单使用
// Map接口的特点：key不允许重复，而且key是无序的

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {

        // 创建对象
        HashMap hm = new HashMap();

        // 添加元素 put(Object key, Object value)
        hm.put(10, "Hello");
        hm.put(11, "world");
        hm.put(11, "hahah");   // 如果key重复，值将进行覆盖

        // size();  --返回int类型数据
        int length = hm.size();
        System.out.println(length);

        // isEmpty(); --返回Boolean类型
        boolean isEmpty = hm.isEmpty();
        System.out.println(isEmpty);

        // remove(Object key); --先输出，后移除
        Object remove = hm.remove(10);
        System.out.println(remove);

        // remove(Object key, object value); 
        //--返回Boolean类型，本次删除为true，找不到或者已被删除返回false
        boolean isRemove = hm.remove(10, "hello");
        System.out.println(isRemove);

        // 判断containsKey(); containsValue(); --判断是否包含key或者value，返回Boolean类型
        boolean containsKey = hm.containsKey(10);
        boolean containsValue = hm.containsValue("java");
        System.out.println(containsKey);
        System.out.println(containsValue);

        //7、获取元素 get(Object key); 返回key对应的键值，若没有返回null
        Object getNumber = hm.get(12);
        System.out.println(getNumber);

    }
}


Map.getOrDefault(Object key, V defaultValue)方法的作用是：
  当Map集合中有这个key时，就使用这个key值；
  如果没有就使用默认值defaultValue。
代码示例如下：
HashMap<String, String> map = new HashMap<>();
map.put("name", "cookie");
map.put("age", "18");
map.put("sex", "女");
String name = map.getOrDefault("name", "random");
System.out.println(name);// cookie，map中存在name,获得name对应的value
int score = map.getOrDefault("score", 80);
System.out.println(score);// 80，map中不存在score,使用默认值80

2. 堆
至少掌握二叉堆，有时间可以看看斐波那契堆。

3. 图
图好难啊。再找点资料看看。






