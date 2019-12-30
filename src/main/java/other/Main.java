package other;

public class Main {
    public static void main(String[] args) {
        OptimizedArrayList<Integer> list = new OptimizedArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        list.add(66);
        list.add(0, 88);
        list.add(3, 99);
        list.set(0, 888);
        list.set(2, 222);
        list.set(7, 666); // [888,11,222,99,33,44,55,666]
        System.out.println("0:" + list.get(0));
        System.out.println("1:" + list.get(1));
        System.out.println("4:" + list.get(4));
        System.out.println("7:" + list.get(7));
        System.out.println("IsEmpty:" + list.isEmpty() + ", Size:" + list.size());
        System.out.println("99-index:" + list.indexOf(99));
        System.out.println(list);
        list.clear();
        System.out.println(list);

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println(list);
        list.remove(0);
        list.remove(5);
        list.remove(10);
        list.remove(list.size() - 1);
        System.out.println(list);
    }
}
