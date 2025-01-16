import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
      static class Inner{
           String name;
        Inner(String n){
            name = n;
        }
    }
    public static void main(String[] args) {
//         Test alp = new Test();
//        Inner obj = alp.new Inner("john");
//        Inner obj2 = alp.new Inner("brown");
//        Inner obj = new Inner("john");
//        Inner obj2 = new Inner("brown");
//        obj.name = "jack";
//        System.out.println(obj.name);
//        System.out.println(obj2.name);
        Outer obj = new Sub();
        ((Sub)obj).area();
        List<Integer> list = new ArrayList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        final int[] sum = {0};
        list.forEach((item) -> {
            sum[0] += item;
            int a = item;
            a++;
            System.out.println(sum[0]);
            System.out.println(a);
        });
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        list.sort(null);

        System.out.println(list.indexOf(1));
        System.out.println(list.hashCode());

    }
}

class Outer {
    void area(){
        System.out.println("this is parent");
    }
}

class Sub extends Outer{
    @Override
    void area(){
        System.out.println("this is sub");
    }
}