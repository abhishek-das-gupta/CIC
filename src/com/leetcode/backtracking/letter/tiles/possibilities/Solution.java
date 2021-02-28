package com.leetcode.backtracking.letter.tiles.possibilities;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numTilePossibilities(String tiles) {
        List<String> result = new ArrayList<>();
        explore(0, tiles, new StringBuilder(), result);
        return result.size();
    }

    private void explore(int currentIndex, String tiles, StringBuilder partialString, List<String> result){
        if(currentIndex == tiles.length()){
            result.add(partialString.toString());
            return;
        }

        partialString.append(tiles.charAt(currentIndex));
        explore(currentIndex+1, tiles,partialString,result);

        partialString.deleteCharAt(partialString.length()-1);
        explore(currentIndex+1, tiles,partialString,result);

    }


}