package src.main.java;

public class Main {
    public static void main(String[] args) {
        //myarraylist(size: 0) doesnt work but i dont think it is supposed to
        MyArrayList<String> testArr = new MyArrayList<>(1);
        //test add - works
        testArr.add("Hello");
        testArr.add("Why");
        testArr.add("Three");
        testArr.add("Index 4");
        //test add at index - works
        testArr.add("Diffo", 0);



        //test get  -works
       System.out.println(testArr.get(0));
        System.out.println(testArr.get(1));
        System.out.println(testArr.get(2));
        System.out.println(testArr.get(3));
        System.out.println(testArr.get(4));
        System.out.println(testArr.get(5));
        System.out.println(testArr.get(6));
        System.out.println(testArr.get(7));

        //test size - works
        System.out.println(testArr.size());

        //test remove - works
        testArr.remove(1);


        testArr.remove(2);

        testArr.remove(2);

     System.out.println(testArr.get(0));
     System.out.println(testArr.get(1));
     System.out.println(testArr.get(2));
     System.out.println(testArr.get(3));
     System.out.println(testArr.get(4));
     System.out.println(testArr.get(5));
     System.out.println(testArr.get(6));
     System.out.println(testArr.get(7));
     System.out.println(testArr.size());


        //test clear - this works
        testArr.clear();
        System.out.println(testArr.size());





    }
}
