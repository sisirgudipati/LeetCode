class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        int low = 0;
        int high = 0;

        while (high < (nums.length)){
            while ((high != nums.length-1) && ((nums[high+1]-nums[high]) == 1)){
                high++;
            }
            int lowVal = nums[low];
            int highVal = nums[high];

            if (lowVal == highVal){list.add(Integer.toString(lowVal));}
            else {
                String formatNum = lowVal + "->" + highVal;
                list.add(formatNum);
            }
            high++;
            low=high;
        }
        return list;
    }
}
