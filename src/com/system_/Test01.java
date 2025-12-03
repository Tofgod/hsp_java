package com.system_;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {


//        System.out.println("ok");
//        System.exit(0); // 标题一个状态 0 正常退出
//        System.out.println("ok1");

        int [] a = {1,2,3,4,4,2};
        int [] c = new int[6];
        System.arraycopy( a , 1 , c , 3 , 1);//复制数组  搞清楚 参数含义

        //     * @param      src      the source array.  //元数组
        //     * @param      srcPos   starting position in the source array. //元数组的开始拷贝的索引
        //     * @param      dest     the destination array. //目标数组
        //     * @param      destPos  starting position in the destination data. //拷贝到目标数组的哪个位置
        //     * @param      length   the number of array elements to be copied. //拷贝几个内容

        System.out.println(Arrays.toString(c));
        System.out.println(System.currentTimeMillis());; // 距离1970 1-1 的毫秒数
        System.gc();//垃圾回收
    }
}
