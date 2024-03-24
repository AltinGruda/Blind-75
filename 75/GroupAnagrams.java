// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:

// Input: strs = [""]
// Output: [[""]]
// Example 3:

// Input: strs = ["a"]
// Output: [["a"]]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String word: strs) {
            // create an array count of all characters
            int[] count = new int[26];
            // count characters in a word and increase by one if it exists in the word
            for(char c : word.toCharArray()){
                count[c - 'a']++;
            }
            // build an unique key with string builder (using string builders since strings in java are immutable)
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                sb.append("#");
                sb.append(count[i]);
            }
            // check if key exists, if not create a list inside the map and put them, if not just get that key and put another value inside
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
