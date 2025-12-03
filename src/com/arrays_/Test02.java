package com.arrays_;

import java.util.Arrays;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {

        int[] arr = {2,3,4,5,6,7,6,1};
        Arrays.sort(arr);
        int a = Arrays.binarySearch(arr,1);
        System.out.println(a); //通过二分法进行查找  传入一个有序的数组 如果数组是无序的 不可以使用这个方法
        // 不存在返回 return -(low + 1);  // key not found.  low 如果存在的话 他的位置 + 1 取负


        int [] c =  Arrays.copyOf( arr , arr.length);
        // 拷贝长度 < 0  跑异常
        // 从arr copy arr.length 个元素
        // 如果拷贝长度大于 arr.length 就在新数组后面插入默认值 0 或者 null
        System.out.println(Arrays.toString(c));

        //fill 把所有的元素都变成 10
        Arrays.fill(arr , 10);

//        Arrays.equals()  比较两个数组内容是相等
        boolean b = Arrays.equals(arr , c);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(c));

        System.out.println(b);

        //Arrays.asList  可以将一组值 (2,3,4,5,6,7) 转换成  list集合
        List<Integer> l = Arrays.asList(2,3,4,5,6,7);
        // 编译类型 List 运行类型 java.util.Arrays$ArrayList  Arrays 的内部类 ArrayList
        // private static class ArrayList<E> extends AbstractList<E>
        System.out.println(l.getClass());





    }
}
