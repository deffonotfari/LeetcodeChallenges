class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        String temp = "";
        int pointsInWord = 0;
        boolean check = true;
        
        while(true){
            for (int i = 0; i<strs.length; i++) { 
                if(pointsInWord >= strs[i].length()) {
                    check = false;
                    break;
                }
                
                if(i == 0) { 
                    temp = Character.toString(strs[0].charAt(pointsInWord));
                }
                
                if(!temp.equals(Character.toString(strs[i].charAt(pointsInWord)))) {
                    check = false;
                    break;
                }
                
                if(i==strs.length-1) {
                    longestCommonPrefix += temp;
                }
            }
            if(!check){
                break;
            }
          
            pointsInWord++;
        }
        return longestCommonPrefix;
    }
}
