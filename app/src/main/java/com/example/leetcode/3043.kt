package com.example.leetcode

class Solution {

    fun comparePrefix(a:Int,b:Int) : Int{
        val s1 = a.toString()
        val s2 =b.toString()
        var i = 0
        while(i<s1.length && i<s2.length && s1[i]==s2[i]){
            i++
        }
        return i;
    }

    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        var max_len = Integer.MIN_VALUE
        for(i in arr1){
            for(j in arr2){
                val len:Int = comparePrefix(i,j)
                if(len>max_len){
                    max_len = len
                }
            }
        }
        return max_len


    }


}

fun main() {
    val sol = Solution()
    val longest = sol.longestCommonPrefix(intArrayOf(1,10,100), intArrayOf(1000))
    println(longest)
}

