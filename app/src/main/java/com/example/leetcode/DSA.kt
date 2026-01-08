package com.example.leetcode



// Check if a Given String is Palindrome or not without finding the reverse of the string.


fun String.checkPalindrome( ): Boolean{

    var a = 0
    var last= (this.length)-1
    while(a<last)
    {
       if(this[a] != this[last]) {

         return false
       }
           a++
           last--
       }
        return true
    }

//Count the number of occurrences of each char in the input string.

fun String.noOfOccurences():MutableMap<Char,Int>{
    val hmap = mutableMapOf<Char,Int>()
    for(ch in this) {
        hmap[ch] = hmap.getOrDefault(ch,0)+1
    }
     return hmap
}

//Find the most recurring char in the input string.
fun String.mostRecurringChar():Char{
    val hmap = mutableMapOf<Char,Int>()
    var max_count = Integer.MIN_VALUE
    var maxchar = this[0]
    for(ch in this){
        hmap[ch] = hmap.getOrDefault(ch,0)+1
    }

    for((ch,count) in hmap){
        if(count>max_count){
            maxchar = ch
            max_count = count

        }
    }
    return maxchar

}



fun duplicate_chars(str:String): StringBuilder{

    val hmap = mutableMapOf<Char,Int>()
   // var result = ""
    var sb = StringBuilder()
    for(ch in str){
        hmap[ch] = hmap.getOrDefault(ch,0)+1
    }
    for((ch,count) in hmap){
        if(count<2){
       //    result = result + ch
            sb.append(ch)
        }
    }
   // return result
    return sb
}

val lb1:(String) -> StringBuilder = { str ->
    val hmap = mutableMapOf<Char,Int>()

    var sb = StringBuilder()
    for(ch in str){
        hmap[ch] = hmap.getOrDefault(ch,0)+1
    }
    for((ch,count) in hmap){
        if(count>1){

            sb.append(ch)

        }
    }

     sb
}




fun isValid(s: String): Boolean {
     var stack = ArrayDeque<Char>()
     val map = mutableMapOf(')' to '(',']' to '[','{' to '}')

    for(ch in s){
        if(ch in ")}]")
        {
            stack.addLast(ch)
        }
        else {
            if(stack.isEmpty()||stack.removeLast()!=map[ch]){
                return false
            }
        }
    }

    return stack.isEmpty()
}

//Rotations
fun areRotations(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) return false
    return (s1 + s1).contains(s2)
}
//Anagrams

fun areAnagramsUsingHashMap(a: String, b: String): Boolean {
    if (a.length != b.length) return false

    val freq = mutableMapOf<Char, Int>()


    for (ch in a) {
        freq[ch] = freq.getOrDefault(ch, 0) + 1
    }

    for (ch in b) {
        if (!freq.containsKey(ch)) return false
        freq[ch] = freq[ch]!! - 1
    }


    for ((_, count) in freq) {
        if (count != 0) return false
    }

    return true
}

fun String.firstNonRepeatingChar(): Char? {
    val freq = mutableMapOf<Char, Int>()

    for (ch in this) {
        freq[ch] = freq.getOrDefault(ch, 0) + 1
    }

    for (ch in this) {
        if (freq[ch] == 1) return ch
    }

    return null
}

fun removeChars(s1: String, s2: String): String {
    val removeSet = HashSet<Char>()
    for (ch in s2) {
        removeSet.add(ch)
    }
    val sb = StringBuilder()
    for (ch in s1) {
        if (!removeSet.contains(ch)) {
            sb.append(ch)
        }
    }

    return sb.toString()
}

fun reverseEachWord(sentence: String): String {
    val result = StringBuilder()
    val word = StringBuilder()

    for (ch in sentence) {
        if (ch != ' ') {
            word.append(ch)
        } else {
            result.append(word.reverse())
            result.append(' ')
            word.setLength(0)
        }
    }

    result.append(word.reverse())

    return result.toString()
}

fun removeConsecutiveDuplicates(str: String): String {
    if (str.isEmpty()) return ""

    val result = StringBuilder()
    result.append(str[0])

    for (i in 1 until str.length) {
        if (str[i] != str[i - 1]) {
            result.append(str[i])
        }
    }

    return result.toString()
}




fun main(){

  println("ATA".checkPalindrome())
    println("Burner".noOfOccurences())
    println("Burner".mostRecurringChar())
    println(duplicate_chars("banana"))
    println(lb1("banana"))
    println("Rotations are : ${areRotations("abcd", "acbd")}")
    println("Anagram: ${areAnagramsUsingHashMap("listen", "silent")}")
    println("First non-repeating: ${"banana".firstNonRepeatingChar()}")
    println(removeChars("computer", "cat"))
    println(reverseEachWord("Android is best"))
    println(removeConsecutiveDuplicates("coooommpuuuuuuuuttttter"))
}