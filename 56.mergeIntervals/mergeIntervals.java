class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }
        java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(intervals[0][0], intervals[0][1]);
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            if (x <= max){
                if (y <= max){
                    continue;
                }
                int key = findByValue(map, max);
                map.put(key, y);
            } else {
               map.put(x, y);
            }
            max = y;
        }

         int[][] ans = new int[map.size()][2];
         int count = 0;
         for (int keyVal : map.keySet()){
             ans[count][0] = keyVal;
             ans[count][1] = map.get(keyVal);
             count++;
         }
        return ans;
    }


    public int findByValue(Map<Integer, Integer> map, int value){
        for (int key : map.keySet()){
            if (value == map.get(key)){
                return key;
            }
        }
        return -1;
    }

}
