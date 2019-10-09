package com.zxh.leetcode.byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：
 *  给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 解题思路：
 *  采用回溯法解决；
 */
public class RestoreIpAddresses {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s){
        dfs(s, 0, 1, new ArrayList<String>());
        return res;
    }
    public void dfs(String s, int start, int end, List<String> r){
        if(start < 0 || start > s.length() || end < 0 || end > s.length()+1 || r.size() > 4) {
            return;
        }
        if(r.size() == 4 && start == s.length()){
            String rs = "";
            for(int i=0; i<r.size(); i++){
                if(i < r.size()-1){
                    rs += r.get(i) + ".";
                }else{
                    rs += r.get(i);
                }
            }
            res.add(rs);
            return;
        }
        for(int i=0; i<3; i++){
            int ends = end + i;
            if(start < 0 || start > s.length() || ends < 0 || ends > s.length()) {
                continue;
            }
            String juge = s.substring(start, ends);
            int jugeint = Integer.valueOf(juge);
            if(juge.charAt(0)=='0' && juge.length()>1) {
                continue;
            }
            if(jugeint <= 255){
                r.add(juge);
                dfs(s, ends,ends+1, r);
                r.remove(r.size()-1);

            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses ipAddresses = new RestoreIpAddresses();
        System.out.println(ipAddresses.restoreIpAddresses("25525511135"));
    }

}
