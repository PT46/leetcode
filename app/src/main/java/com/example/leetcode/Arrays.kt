package com.example.leetcode

import java.util.HashSet

object ArrayPrograms {

    // Second Largest
    fun secondLargest(arr: IntArray): Int {
        var largest = Int.MIN_VALUE
        var secondLargest = Int.MIN_VALUE

        for (num in arr) {
            if (num > largest) {
                secondLargest = largest
                largest = num
            } else if (num > secondLargest && num != largest) {
                secondLargest = num
            }
        }
        return secondLargest
    }

    //  Second Smallest
    fun secondSmallest(arr: IntArray): Int {
        var smallest = Int.MAX_VALUE
        var secondSmallest = Int.MAX_VALUE

        for (num in arr) {
            if (num < smallest) {
                secondSmallest = smallest
                smallest = num
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num
            }
        }
        return secondSmallest
    }

    //  Merge two arrays (alternate merge)
    fun mergeAlternate(a: IntArray, b: IntArray): IntArray {
        val result = IntArray(a.size + b.size)
        var i = 0
        var j = 0
        var k = 0

        while (i < a.size) {
            result[k++] = a[i++]
            if (j < b.size) {
                result[k++] = b[j++]
            }
        }
        return result
    }

    // Merge two sorted arrays
    fun mergeSorted(a: IntArray, b: IntArray): IntArray {
        val result = IntArray(a.size + b.size)
        var i = 0
        var j = 0
        var k = 0

        while (i < a.size && j < b.size) {
            if (a[i] < b[j]) {
                result[k++] = a[i++]
            } else {
                result[k++] = b[j++]
            }
        }

        while (i < a.size) result[k++] = a[i++]
        while (j < b.size) result[k++] = b[j++]

        return result
    }

    // 5. Rotate Left → Right by n
    fun rotateLeftToRight(arr: IntArray, n: Int) {
        val k = n % arr.size
        reverse(arr, 0, k - 1)
        reverse(arr, k, arr.size - 1)
        reverse(arr, 0, arr.size - 1)
    }

    //  Rotate Right → Left by n
    fun rotateRightToLeft(arr: IntArray, n: Int) {
        val k = n % arr.size
        reverse(arr, 0, arr.size - 1)
        reverse(arr, 0, k - 1)
        reverse(arr, k, arr.size - 1)
    }

    private fun reverse(arr: IntArray, start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            val temp = arr[i]
            arr[i++] = arr[j]
            arr[j--] = temp
        }
    }

    //  First pair with sum = 0
    fun firstPairSumZero(arr: IntArray) {
        val set = HashSet<Int>()

        for (num in arr) {
            if (set.contains(-num)) {
                println("First pair sum zero: $num, ${-num}")
                return
            }
            set.add(num)
        }
        println("No pair found")
    }

    //  All pairs with given sum
    fun allPairsWithSum(arr: IntArray, target: Int) {
        val set = HashSet<Int>()
        println("Pairs with sum $target:")

        for (num in arr) {
            val complement = target - num
            if (set.contains(complement)) {
                println("$num, $complement")
            }
            set.add(num)
        }
    }
}

fun main() {

    val arr = intArrayOf(10, 50, 20, 30, 70, 80, 40)

    println("Second Largest: ${ArrayPrograms.secondLargest(arr)}")
    println("Second Smallest: ${ArrayPrograms.secondSmallest(arr)}")

    val arr1 = intArrayOf(10, 50, 20, 30, 70, 80, 40)
    val arr2 = intArrayOf(25, 75, 5, 25)

    println("Merged Alternate: ${ArrayPrograms.mergeAlternate(arr1, arr2).contentToString()}")

    val sorted1 = intArrayOf(10, 28, 50, 75, 80, 95, 100)
    val sorted2 = intArrayOf(35, 60, 70, 78)

    println("Merged Sorted: ${ArrayPrograms.mergeSorted(sorted1, sorted2).contentToString()}")

    val rotateArr = intArrayOf(1, 2, 3, 4, 5)
    ArrayPrograms.rotateLeftToRight(rotateArr, 2)
    println("Left to Right Rotate: ${rotateArr.contentToString()}")

    ArrayPrograms.rotateRightToLeft(rotateArr, 2)
    println("Right to Left Rotate: ${rotateArr.contentToString()}")

    val sumZeroArr = intArrayOf(2, -3, 3, 5, -2)
    ArrayPrograms.firstPairSumZero(sumZeroArr)

    val sumArr = intArrayOf(1, 5, 7, -1, 5)
    ArrayPrograms.allPairsWithSum(sumArr, 6)
}
