package Streams;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        HashMap<String, Double> map = new HashMap<>();

        list.add(new Employee(1, "mech", "john", 1000));
        list.add(new Employee(4, "cse", "ram", 4000));
        list.add(new Employee(5, "cse", "nishant", 5000));
        list.add(new Employee(7, "ece", "paul", 7000));
        list.add(new Employee(3, "mech", "ben", 3000)); //
        list.add(new Employee(8, "ece", "sarath", 8000));
        list.add(new Employee(9, "ece", "pran", 9000)); //
        list.add(new Employee(2, "mech", "ken", 2000));
        list.add(new Employee(6, "cse", "vishal", 6000)); //


//        for(Employee emp : list){
//            Double prevMax = map.getOrDefault(emp.department, 0.0);
//            if(emp.salary > prevMax){
//                map.put(emp.department, emp.salary);
//            }
//        }
//        for(Map.Entry<String, Double> entry : map.entrySet()){
//            System.out.println("Max salary for " + entry.getKey() + " : " + entry.getValue());
//        }
//
//        map.clear();
        list.stream()
                .forEach(emp -> {
                    map.compute(emp.getDepartment(), (key, prevMax)-> {
                        System.out.println(key);
// The first argument (key) in the lambda will always match the key you pass to compute. in this case emp.getDepartment()
                        return prevMax == null || prevMax < emp.getSalary() ? emp.getSalary() : prevMax;
                    });
                });

        for(Map.Entry<String, Double> entry : map.entrySet()){
            System.out.println("Max salary for " + entry.getKey() + " : " + entry.getValue());
        }


//        -------------------------------------------------------------


//Map<String, Double> map2 = Collections.synchronizedMap(map);
//        SyncHashMap sMap = new SyncHashMap();
//        Thread t1 = new Thread(()->{
//            for(int i=5; i<15; i++){
//                System.out.println(sMap.getter(i));
//                try {
//                    Thread.currentThread().wait(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//        Thread t2 = new Thread(()->{
//            for(int i=5; i<15; i++){
//                sMap.setter(i, i*100);
//                try {
//                    Thread.currentThread().wait(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//
//        String s = "[{()}]"
//        output = true
//        String s = "[})"
//        output = false
//

//        Optional<String> name = Optional.ofNullable("john");
//        Optional<String> name = Optional.ofNullable(null);
//        Optional<Integer> length = name.map(String::length);
//        int len = name.map(String::length).orElse(0);
//        System.out.println(length);
//        System.out.println(len);



//        -------------------------------------------------------------



//        List<Double> list = List.of(1.0,2.2,3.4,4.3);
//        double sum = list.stream().mapToDouble(Double::doubleValue).reduce(0.0, (c, e) -> c+e);
//        double sum = list.stream().mapToDouble(Double::doubleValue).reduce(0.0, (c, e) -> c+e);
//        System.out.println(sum);
//        DoubleStream ds = list.stream().mapToDouble(Double::doubleValue);
//        System.out.println(ds.sum());
//        double sum2 = list.stream().flatMapToDouble(n -> DoubleStream.of(n)).reduce(0.0, (c, e) -> c+e);
//        System.out.println(sum2);
//        Integer a = 1;
//        int b = 2;
//        System.out.println(a+b);



//        -------------------------------------------------------------



//
//        List<Integer> list = List.of(1,2,3,4); // object reference is mutable, but values are immutable
//        System.out.println(list);
////        list.set(0, 9);
//        list = List.of(54);
//        list = new ArrayList<>();
//        list.add(34);
//        list.add(43);
//        System.out.println(list);


//        final List<Integer> list2 = new ArrayList<>(); // object reference is immutable, but values are mutable
//        list2.add(1);
//        list2.add(2);
////        list2.add(3);
//        System.out.println(list2);
//        list2 = new ArrayList<>();
//


//        List<Integer> list3 = Arrays.asList(1,2,3);
//        System.out.println(list3);
//        list3.add(5);
//        list3.remove(2);
//        list3.set(0,99);
//        System.out.println(list3);
//list3 = new ArrayList<>();
//        list3.add(11);
//        list3.add(12);
//        list3.add(13);
//        System.out.println(list3);
//        Integer[] arr = list3.toArray(new Integer[1]); //toArray() returns an Object[]. You must explicitly cast it to the desired type, which can lead to runtime errors if the cast is incorrect.
//        Integer[] arr = list3.toArray(new Integer[5]);
//        System.out.println(Arrays.asList(arr)); // .asList() works only with Object types.since arr1 is composed of Integer object type, .asList() will work here.
//Why an Array of Size 0?
//Passing new Integer[0] is a common idiom because:
//If the array size is smaller than the list size, toArray will create a new array of the same type and size as required.
//If the array size is equal to or larger than the list size, toArray will reuse the passed array by populating it and returning it.

//        int[] arr2 = list3.stream().mapToInt(Integer::intValue).toArray();
//        System.out.println(arr2);
//        System.out.println(Arrays.asList(arr2)); // since arr2 is composed of primitive type, .asList() wont work here.
//        for(int i:arr2)
//            System.out.println(i);
//        System.out.println(Arrays.toString(arr2)); // since arr2 is composed of primitive type, we need to use the toString() method of Arrays class to print the array directly as a string.



//        -------------------------------------------------------------



//        List<Integer> list4 = new ArrayList<>();
//        list4.add(9);
//        list4.add(4);
//        list4.add(6);
//        list4.add(1);
//        int max = list4.stream().max(Comparator.naturalOrder()).get();
//        List<String> list5 = List.of("Johnny", "Stacy", "kim", "pam", "Adam", "John");
//        List<String> sorted = list5.stream().sorted(Comparator.comparing(String::toString).reversed().thenComparing(String::length)).collect(Collectors.toList());
//      List<String> sorted = list5.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList()); // uses the normal comparator.
//      List<String> sorted = list5.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
//        System.out.println(sorted);



//        -------------------------------------------------------------

//
//        List<Employee> list6 = new ArrayList<>();
//        list6.add(new Employee(4, "ece", "ken", 3000)); //
//        list6.add(new Employee(3, "ece", "ben", 3000)); //
//        list6.add(new Employee(1, "mech", "john", 1000));
//        list6.add(new Employee(2, "cse", "ken", 2000));
//
//        List<Employee> sorted = list6.stream().sorted(Comparator.comparing(Employee::getName)
//                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()))
//                .collect(Collectors.toList());
//        System.out.println(sorted);
        // sorting by name in ascending, then by salary in descending

//        -------------------------------------------------------------

//
//        Map<String, Integer> hm = new HashMap<>();
//        hm.put("john", 3);
//        hm.put("ben", 1);
//        hm.put("ken", 2);
//        hm.put("pam", 2);
//        System.out.println(hm);
//        hm.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.<String, Integer>comparingByKey().reversed())).forEach(System.out::println);
// sorting by value in ascending, then by key in descending


//        -------------------------------------------------------------



//        int[] arr = {1,2,3,4,5,6,7,8,9};
//        int evenCount = (int)Arrays.stream(arr).filter(n->n%2==0).count(); // returns a long value
//        System.out.println(evenCount);
//
//        double average = Arrays.stream(arr).average().getAsDouble(); // returns OptionalDouble, so use getAsDouble to extract the value.
//        System.out.println(average);


//        -------------------------------------------------------------
//
//
//        List<String> list7 = List.of("Johnny", "Stacy", "kim", "pam", "Adam", "John", "kim", new String("pam"));
//        System.out.println(list7);
//        String joined = list7.stream().collect(Collectors.joining(", "));
//        System.out.println(joined);
//        System.out.println(list7.stream().distinct().collect(Collectors.toList()));


//        -------------------------------------------------------------


//
//        int[]arr = {1,2,3,4,4,5,5,6,7,8};
//        List<Integer> temp = Arrays.stream(arr).distinct()
////                .map(n -> Integer.valueOf(n)) // output type should be the same as input type. hence won't work here.
// IntStream.map() expects and returns a primitive int because it uses an IntUnaryOperator.
//Even though you use Integer.valueOf(n), it is unboxed back into int.
//                .mapToObj(n->Integer.valueOf(n)) // output type is object type and input type is primitive. works for this case.
////                .boxed() // both mapToObj and boxed does the same work in this case. converts primitive int stream to Integer object stream
//                .collect(Collectors.toList()); // boxed() uses mapToObj under the hood. mapToObj works with any primitive stream. boxed() is used only to convert primitive to wrapper class objects
////        int[] temp2 = Arrays.stream(arr).distinct().toArray(); // distinct() returns an IntStream
//        System.out.println(temp);
//        System.out.println(Arrays.toString(temp2));
// the above returns only distinct values
// the below returns only the elements with duplicate values
//        Arrays.stream(arr).boxed() // mapToInt converts Integer to int, boxed does the opposite. converts Intstream to Integer stream because collectors work with objects
//                .collect(Collectors.groupingBy(n->n, Collectors.counting()))
//                .entrySet().stream()
//                .filter(item -> item.getValue()>1)
//                .map(Map.Entry::getKey) // extracts the keys
//                .forEach(System.out::println);
//
//
//        List<Integer> list8 = List.of(1,2,3,4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 14);
//        int[] temp = list8.stream().filter(n->n%2==0).sorted(Comparator.reverseOrder()).distinct().limit(3).mapToInt(Integer::intValue).toArray(); // takes a list object and returns a primitive array
//        System.out.println(Arrays.toString(temp));


//        -------------------------------------------------------------



//        String str = "Java is a good language. java is awesome";
//        int n = 2; // print the top n words with highest occurences using streams.
//        Map<String, Long> wordFreqMap = Arrays
//                                            .stream(str.split("\\s+"))
//                                            .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
//        wordFreqMap.entrySet().stream()
//                              .forEach(item -> System.out.println(item.getKey() + " : " + item.getValue()));
//        wordFreqMap.entrySet().stream()
//                              .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                              .limit(n)
//                              .forEach(System.out::println);
//
//        List<Map.Entry<String, Long>> list9 = wordFreqMap.entrySet().stream()
//                                                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                                                    .collect(Collectors.toList());
//        list9.stream().forEach(System.out::println);
        // returning the sorted map as List of Map entries.

//        Map<String, Long> list9 = wordFreqMap.entrySet().stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        // this won't matter because even though it is sorting here, when reading the map later, the order of read is not guaranteed in a map anyways.
//        // so for sorting in a map, just print or work with the values as it comes out of the sorted() as a stream. Like below.
//        list9.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(n).forEach(System.out::println);
        // returning the sorted map as a map.


//        -------------------------------------------------------------

//
//        List<String> words = List.of("deed", "animal", "bob", "pap", "cop");
//        List<String> palindromicWords = words.stream().filter(word -> word.equals(new StringBuilder(word).reverse().toString())).collect(Collectors.toList());
//        System.out.println(words);
//        System.out.println(palindromicWords);


//        -------------------------------------------------------------


//        List<Integer> list10 = List.of(11,21,13,14,52,24); // get list of numbers that start with 1.
//        List<Integer> listWith1 = list10.stream()
//                                        .filter(n -> String.valueOf(n).startsWith("1")) // this doesn't actually convert the list elements into string. this is a predicate interface. only evaluates for boolean
//                                        .collect(Collectors.toList());
//        System.out.println(listWith1);

//        -------------------------------------------------------------

//        int[] arr1 = {1,3,5,7,9, 2, 3};
//        int[]arr2 = {2,4,6,8,10};
//        IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
////                .distinct() // removes duplicates
//                .boxed() // Comparator works with objects. so need to convert int to Integer
//                .sorted(Comparator.reverseOrder()).forEach(System.out::println);
////the above uses primitive specific Intstream to concat and then uses boxed to autobox the resultant stream.
////the below uses the general Stream to concat, but for this case, while passing each array itself they need to be boxed.
//        Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed())
//                .distinct()
//                .sorted(Comparator.reverseOrder()).forEach(System.out::println);
//

//        -------------------------------------------------------------


//        List<String> listStr1 = List.of("john", "ben", "kim");
//        List<String> listStr2 = List.of("pam", "ben", "kevin", "kim");
//        Stream.concat(listStr1.stream(), listStr2.stream()).distinct().forEach(System.out::println);


//        -------------------------------------------------------------


//        List<Employee> employeesList = List.of(
//                new Employee(1, "cse", "jack", 1000),
//                new Employee(2, "ece", "ben", 2000),
//                new Employee(3, "mech", "paul", 3000),
//                new Employee(4, "cse", "kim", 4000),
//                new Employee(5, "cse", "ken", 5000)
//        );
//// print list of employees with salary >2000
////        employeesList.stream().filter(item -> item.salary>2000).forEach(System.out::println);
// get map of employees with salary > 2000 as senior and <= 2000 as junior
//        Map<String, List<Employee>> empMap = employeesList.stream().collect(Collectors.groupingBy(item -> item.salary>2000 ? "senior" : "junior", Collectors.toList())); // uses classifier, downstream reduction
//        Map<String, List<Employee>> empMap2 = employeesList.stream().collect(Collectors.groupingBy(item -> item.salary>2000 ? "senior" : "junior")); // uses only classifier
//        Map<String, List<Employee>> empMap3 = employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment)); // uses only classifier
//        System.out.println(empMap);
//        System.out.println(empMap2);
//        employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
//                Collectors.groupingBy(item -> item.salary>2000 ? "senior" : "junior")))
//                .forEach((key, val) -> System.out.println(key + " || " + val)); // uses only classifier
//
//        employeesList.stream().collect(Collectors.groupingBy(
//                Employee::getDepartment,
//                Collectors.groupingBy(emp -> emp.getName().charAt(0)) // Group by first letter of name
//        )).forEach((key, val) -> System.out.println(key + " || " + val));



//        -------------------------------------------------------------

//        List<String> fruits = List.of("Apple", "Banana", "Cherry", "Avocado", "cantaloupe");
//        fruits.stream().collect(Collectors.groupingBy(item -> item.charAt(0),
//                        Collectors.groupingBy(String::length)))
//                .forEach((key, val) -> System.out.println(key + " || " + val));
//
//
//
//        List<String> fruits2 = List.of("Apple", "Banana", "Cherry", "Apple", "Cherry");
//        fruits2.stream().collect(Collectors.toMap(
//                item -> item,
//                item -> 1L,
////                (existing, newVal) -> existing + newVal
//                Long::sum
//        )).forEach((key, val) -> System.out.println(key + " || " + val));
//
//



//        String str = "Java is cool. java is beautiful.";
//        Arrays.stream(str.split("\\s+"))
//                .map(String::toLowerCase)
//                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
//                .entrySet().stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .limit(2)
//                .map(s -> s.getKey())
//                .forEach(System.out::println);


    }
}