package com.czj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        for (int i = 0; i< nums.length ; i++) {
            for (int j=0; j< nums.length; j++) {
                if (j == i) {
                    continue;
                }
                for( int k = 0; k<nums.length; k++) {
                    if (k ==i || k ==j) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sumZero = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k]));
                        result.add(sumZero);
                    }
                }
            }
        }
        return removeDuplicates(result);
    }

    public static List<List<Integer>> removeDuplicates(List<List<Integer>> lists) {
        Set<String> seen = new HashSet<>();
        List<List<Integer>> uniqueLists = new ArrayList<>();

        for (List<Integer> list : lists) {
            // 对列表进行排序
            List<Integer> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);

            // 将排序后的列表转换为字符串，便于存储在HashSet中
            String key = sortedList.toString();

            if (!seen.contains(key)) {
                seen.add(key);
                uniqueLists.add(sortedList);
            }
        }

        return uniqueLists;
    }
}
