package com.zxh.algorithms.interview.baidu;

import java.util.*;

/**
 * @Author: ningque
 * @Date: 2020/10/12
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            map.put(temp1, temp2);
        }
        hasNewSort(map);

        int size = 0;
        // 如果全部有序
        if(ans.size() == 1){
            System.out.println(ans.getFirst().indexOf(p) + 1);
        } else {
            for(LinkedList list : ans){
                //System.out.println(Arrays.toString(list.toArray()));
                if(!list.contains(p)){
                    size += list.size();
                }
            }
            int temp = 1;
            while (temp <= size){
                System.out.print(temp+" ");
                temp++;
            }
            System.out.println();
        }
    }
    static boolean flag = false;
    static LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
    private static void hasNewSort(HashMap<Integer, Integer> map) {
        flag = false;
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if(entry.getValue() != 0){
                flag = true;
                break;
            }
        }
        // 递归结束
        if(!flag){
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if(entry.getValue() != 0){
                if(list.isEmpty()){
                    list.add(entry.getKey());
                    list.add(entry.getValue());
                    map.put(entry.getKey(), 0);
                } else {
                    int key = entry.getKey();
                    int value = entry.getValue();
                    if(list.contains(key)){
                        int index = list.indexOf(key);
                        list.add(index+1, value);
                        map.put(key, 0);
                    }
                }
            }
        }
        ans.add(list);
        hasNewSort(map);
    }
}
