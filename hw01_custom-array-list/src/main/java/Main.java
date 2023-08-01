import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        CustomList<String> customList = new CustomList<>();
        customList.add("Hello");
        System.out.println(customList.size());
        customList.add("Aston");
        customList.add("Trainee");
        System.out.println(customList);
        customList.add(2,"Senior");
        System.out.println(customList);
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("bb");
        list3.add("Ccc");
        list3.add("Zzz");
        customList.addAll(list3);
        System.out.println(customList.get(4));
        customList.remove("AA");
        System.out.println(customList);
        customList.remove(5);
        System.out.println(customList);
        customList.remove(2);
        System.out.println(customList);
        customList.sort(Comparator.naturalOrder());
        System.out.println(customList);
        System.out.println(customList.size());

        System.out.println("-------------------------------");

        List<String> list = new ArrayList<>();
        list.add("Hello");
        System.out.println(list.size());
        list.add("Aston");
        list.add("Trainee");
        System.out.println(list);
        list.add(2,"Senior");
        System.out.println(list);
        List<String> list4 = new ArrayList<>();
        list4.add("AA");
        list4.add("bb");
        list4.add("Ccc");
        list4.add("Zzz");
        list.addAll(list4);
        System.out.println(list.get(4));
        list.remove("AA");
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        System.out.println(list.size());

    }
}
