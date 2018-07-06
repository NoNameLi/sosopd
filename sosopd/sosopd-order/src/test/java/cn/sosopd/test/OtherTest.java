package cn.sosopd.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OtherTest {

    @Test
    public void stringSplitTest() {
        String str = "a,b,c,,,";
        String[] split = str.split(",");
        System.out.println(split.length);
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void ArrayListSubListTest() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        List<Integer> list = arr.subList(0, arr.size());
        list.set(0, 10);
        System.out.println(arr);
    }

    public void producerExtendsConsumerSuperTest() {
        ArrayList<? super Number> arr = new ArrayList<>();
        arr.add(Integer.valueOf(2));
        
    }

}
