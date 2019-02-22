package com.learn.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo01 {
    public static void main(String[] args) throws Exception {
//        Scanner c= new Scanner(System.in);
//        int num = c.nextInt();
//        Random r= new Random();
//        int i = r.nextInt(10);
//        System.out.print(i);
//        ArrayList<String> list = new ArrayList<>();
//        list.add("12");
//        list.remove(1);
//        list.get(1);
//        list.size();
//        System.out.println(list);
//        String str = "abc";
//        str = str.concat("def");
//        char c = str.charAt(1);
//        int i = str.indexOf("a");
//        String substring = str.substring(3, 5);
//        char[] chars = str.toCharArray();
//        for (char aChar : chars) {
//            System.out.println(aChar);
//        }
//        byte[] bytes = str.getBytes();
//        for (byte aByte : bytes) {
//            System.out.println(aByte);
//        }
//        str = str.replace("f", "g");
//        String[] ds = str.split("d");
//        for (String d : ds) {
//            System.out.println(d);
//        }
//        System.out.println(str);

//        System.out.println(substring);
//        System.out.println(i);
//        System.out.println(c);
//        System.out.println(str);
//        int[] coll = {1,2,6,4,5};
//        Arrays.sort(coll);
//        System.out.println(Arrays.toString(coll));
//        System.out.println(Math.abs(-1));
//        System.out.println(Math.ceil(2.2));
//        System.out.println(Math.floor(2.2));
//        System.out.println(Math.round(2.2));

//        Animal c= new Dog();
//        c.eat();
//        if(c instanceof Cat){
//            Cat cat = (Cat)c;
//            cat.catchMouse();
//        }else if (c instanceof Dog){
//            Dog dog = (Dog)c;
//            dog.watchHouse();
//        }


//        System.out.println(new Date().getTime());
//        System.out.println(System.currentTimeMillis());
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(df.format(new Date()));
//        String str = "2018年2月21日 14时55分00秒";
//        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//        Date parse = df.parse(str);
//        System.out.println(parse);

//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH)+1;
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println(year+"年"+month+"月"+day+"日");
//        cal.set(Calendar.YEAR, 2020);
//        System.out.print(cal.get(Calendar.YEAR));
//        cal.add(Calendar.DAY_OF_MONTH, 2);
//        cal.add(Calendar.YEAR, -3);

//        int[] a = {1,2,3,4,5};
//        int[] b = {6,7,8,9,10};
//        System.arraycopy(a,0,b,0,3);
//        System.out.println(Arrays.toString(b));

//        StringBuilder sb = new StringBuilder();
//        StringBuilder sb2 = sb.append("abc");
//        System.out.println(sb==sb2);
//        String str = sb.toString();

//        Integer.parseInt("100");
//        Boolean.parseBoolean("true");
//        Float.parseFloat("1.1");

//        Collection<String> coll = new ArrayList<>();
//        coll.add("aaa");
//        coll.add("bbb");
//        coll.add("ccc");
//        boolean b = coll.contains("aaa");
//        coll.remove("aaa");
//        Object[] arr = coll.toArray();
//        int size = coll.size();
//        coll.clear();
//        boolean empty = coll.isEmpty();

//        Collection<Integer> coll = new ArrayList<>();
//        coll.add(1);
//        coll.add(2);
//        coll.add(3);
//        Iterator<Integer> it = coll.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

//        LinkedList<String> list = new LinkedList<>();
//        list.addFirst("a");
//        list.addFirst("b");
//        list.addFirst("c");
//        System.out.println(list.getFirst());
//        System.out.println(list.getLast());
//        System.out.println(list.removeFirst());
//        System.out.println(list.removeLast());
//        if(!list.isEmpty()){
//            System.out.println(list.pop());
//        }

//        LinkedHashSet<String> set = new LinkedHashSet<>();
//        set.add("abc");
//        set.add("bca");
//        set.add("cba");
//        for (String s : set) {
//            System.out.println(s);
//        }

//        int[] arr = {1,2,3,4,5,6};
//        int sum = getSum(arr);
//        System.out.println(sum);
//        System.out.println(getSum(1,2,3,4,5,6));

//        ArrayList<Integer> arr = new ArrayList<>();
//        Collections.addAll(arr,4,2,1,3,6,5);
//        Collections.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;//倒序
//            }
//        });
//        System.out.println(arr);

//        ArrayList<Student> list = new ArrayList<>();
//        list.add(new Student("a",1));
//        list.add(new Student("b",2));
//        list.add(new Student("c",3));
//        Collections.sort(list);
//        System.out.println(list);

//        HashMap<String,String> map = new HashMap<>();
//        map.put("a","1");
//        map.put("b","2");
//        map.put("c","3");
//        map.remove("c");
//        Set<String> strings = map.keySet();//键的集合
//        for (String string : strings) {
//            System.out.println(map.get(string));
//        }
//        Set<Map.Entry<String, String>> entries = map.entrySet();//键值对的对象
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.print(entry.getKey());
//            System.out.println(entry.getValue());
//        }

    }
//    public static int getSum(int...arr){
//        int sum = 0;
//        for (int i : arr) {
//            sum+=i;
//        }
//        return sum;
//    }
}
