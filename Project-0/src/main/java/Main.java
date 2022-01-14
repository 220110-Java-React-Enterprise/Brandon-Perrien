package src.main.java;

public class Main {
    public static void main(String[] args) {
        //only the size parameter constructor doesn't work!
        MyArrayList<String> testArr = new MyArrayList<>();
        //test add - seems to work
        testArr.add("Hello");
        testArr.add("Why");
        testArr.add("Three");

        //test add at index - this seems to work as well
        testArr.add("Diffo", 3);
        testArr.add("Easy", 1);

        //test get  - get seems to be fine
       System.out.println(testArr.get(0));
        System.out.println(testArr.get(1));
        System.out.println(testArr.get(2));
        System.out.println(testArr.get(3));

//test contains - good
        System.out.println(testArr.contains("Three"));
        //test size - this should be working as well
        System.out.println(testArr.size());

        //test remove - this works
        testArr.remove(3);
        System.out.println(testArr.get(0));
        System.out.println(testArr.get(1));
        System.out.println(testArr.get(2));
        System.out.println(testArr.get(3));
        System.out.println(testArr.size());


        //test clear - this works
        testArr.clear();
        System.out.println(testArr.get(0));
        System.out.println(testArr.get(1));
        System.out.println(testArr.get(2));
        System.out.println(testArr.get(3));





    }
}
