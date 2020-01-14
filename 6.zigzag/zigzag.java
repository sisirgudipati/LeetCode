class Solution {
    public String convert(String s, int numRows) {
        if (s.isEmpty()){return "";}
        if (numRows == 0 || numRows == 1){return s;}
        if (numRows > s.length()){return s;}

        Map<Integer, StringBuilder> map = new HashMap<Integer, StringBuilder>();

        boolean switcher = true;

        int counter = 1;
        for (int j = 0; j < s.length(); j++){
            char curr = s.charAt(j);

            StringBuilder mapString = new StringBuilder();
            if (map.containsKey(counter)){
                mapString = map.get(counter);
            }

            mapString.append(curr);

            map.put(counter, mapString);
            if ((counter == numRows)) {switcher = !switcher;}
            if ((counter == 1) && (j != 0)){switcher = !switcher;}

            if (switcher){
                counter++;
            } else {
                counter--;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= numRows; i++){
            ans.append(map.get(i).toString());

        }
        return ans.toString();

    }
}
