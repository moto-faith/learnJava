package com.learn.java;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

//        HashMap<Student,String> map = new HashMap<>();
//        map.put(new Student("a",1),"bj");
//        map.put(new Student("b",2),"hn");
//        map.put(new Student("c",3),"jp");
//        Set<Student> sets = map.keySet();
//        for (Student set : sets) {
//            String s = map.get(set);
//            System.out.println(set.toString()+"---"+s);
//        }

//        MyThread mt = new MyThread("Th");
//        mt.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Thread=="+i);
//        }

//        MyRunnable mr= new MyRunnable();
//        Thread t = new Thread(mr);
//        t.start();

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println("aa" + i);
//                }
//            }
//        };
//        new Thread(runnable).start();

//        Ticket ticket = new Ticket();
//        Thread window1 = new Thread(ticket, "window1");
//        Thread window2 = new Thread(ticket, "window2");
//        Thread window3 = new Thread(ticket, "window3");
//        window1.start();
//        window2.start();
//        window3.start();

//        BaoZi bz = new BaoZi();
//        ChiHuo ch = new ChiHuo("吃货",bz);
//        BaoZiPu bzp = new BaoZiPu("包子铺",bz);
//
//        ch.start();
//        bzp.start();

//        ExecutorService service = Executors.newFixedThreadPool(2);
//        MyRunnable r = new MyRunnable();
//        service.submit(r);
//        service.submit(r);
//        service.submit(r);

//        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
//        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
//        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();

//        File file = new File("a.txt");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getPath());
//        System.out.println(file.getName());
//        System.out.println(file.length());
//        System.out.println(file.exists());
//        System.out.println(file.isDirectory());
//        System.out.println(file.isFile());
//        System.out.println(file.createNewFile());
//        System.out.println(file.mkdirs());
//        System.out.println(file.delete());
//        File file1 = new File("E:\\xupeng\\javatest\\src\\com\\learn\\java");
//        String[] list = file1.list();
//        for (String s : list) {
//            System.out.println(s);
//        }
//        File[] files = file1.listFiles();
//        for (File file2 : files) {
//            System.out.println(file2.isFile());
//        }

//        File file = new File("a.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//        fos.write(97);
//        fos.write(98);
//        fos.write(99);
//        fos.write("\r".getBytes());
//        fos.write("程序员".getBytes());
//        fos.close();

//        FileInputStream fis = new FileInputStream("a.txt");
//        int read ;
//        byte[] b = new byte[3];
//        while ((read=fis.read(b))!=-1){
//            System.out.print(new String(b,0,read));
//        }
//        fis.close();

//        FileReader fr = new FileReader("a.txt");
//        int line;
//        char[] b= new char[2];
//        while ((line=fr.read(b))!=-1){
//            System.out.print(new String(b,0,line));
//        }
//        fr.close();

//        FileWriter fw = new FileWriter("a.txt");
//        fw.write("关闭刷新");
//        fw.close();

//        Properties properties = new Properties();
//        properties.setProperty("a","1");
//        properties.setProperty("b","2");
//        properties.setProperty("c","3");
//        System.out.println(properties);
//        System.out.println(properties.getProperty("a"));
//        Set<String> strings = properties.stringPropertyNames();
//        for (String string : strings) {
//            System.out.println(string+":"+properties.getProperty(string));
//        }

//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.txt"));
//        int line;
//        byte[] bytes = new byte[1024];
//        while ((line=bis.read(bytes))!=-1){
//            bos.write(bytes,0,line);
//        }
//        bis.close();
//        bos.close();

//        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
//        String line;
//        while ((line=br.readLine())!=null){
//            System.out.println(line);
//            System.out.println("-----");
//        }
//        br.close();
//
//        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
//        bw.write("程序");
//        bw.newLine();
//        bw.write("员");
//        bw.close();

//        HashMap<String,String> lineMap = new HashMap<>();
//        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
//        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
//        String line;
//        while ((line=br.readLine())!=null){
//            String[] split = line.split("\\.");
//            lineMap.put(split[0],split[1]);
//        }
//        br.close();
//
//        for (int i =1;i<=lineMap.size();i++){
//            String key = String.valueOf(i);
//            String value = lineMap.get(key);
//            bw.write(key+"."+value);
//            bw.newLine();
//        }
//        bw.close();


//        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"),"gbk");
//        int len;
//        while ((len=isr.read())!=-1){
//            System.out.println((char)len);
//        }

//        Employee e = new Employee();
//        e.name = "zhangsan";
//        e.address = "beiqinglu";
//        e.age = 20;
//        try {
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("a.txt"));
//            out.writeObject(e);
//            out.close();
//
//        }catch (IOException i){
//            i.printStackTrace();
//        }

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
//        Employee e = null;
//        e = (Employee)ois.readObject();
//        System.out.println(e.name+e.address+e.age);

//        PrintStream ps = new PrintStream("a.txt");
////        System.setOut(ps);
////        System.out.println(97);

//        doSomething(()-> System.out.println("Lambda执行"));

//        String msgA = "hello ";
//        String msgB = "world ";
//        String msgC = "java";
//        log(1,()->msgA+msgB+msgC);

//        startThread(()-> System.out.println("线程任务执行"));

//        List<String> list = new ArrayList<>();
//        list.add("ass");
//        list.add("ab");
//        list.add("c");
//        list.add("d");
//        list.stream()
//                .filter(s -> s.startsWith("a"))
//                .filter(s -> s.length()>2)
//                .forEach(System.out::println);




        




    }
//    public static void startThread(Runnable task){
//        new Thread(task).start();
//    }
//    public static void log(int level,MessageBuilder builder){
//        if(level==1){
//            System.out.println(builder.buildMessage());
//        }
//    }
//    public static void doSomething(MyFuncationInterface inter){
//        inter.method();
//    }
//    public static int getSum(int...arr){
//        int sum = 0;
//        for (int i : arr) {
//            sum+=i;
//        }
//        return sum;
//    }
}
