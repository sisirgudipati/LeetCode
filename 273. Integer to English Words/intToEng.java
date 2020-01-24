class Solution {
    Map<Integer, String> ones;
    Map<Integer, String> teens;
    Map<Integer, String> tens;
    Stack<String> stack;
    String[] suffix;
    public String numberToWords(int num) {
        if (num==0){return "Zero";}

        stack = new Stack<String>();
        suffix = new String[3];
        suffix[0] = "Thousand";
        suffix[1] = "Million";
        suffix[2] = "Billion";


        ones = new HashMap<Integer, String>();
        teens = new HashMap<Integer, String>();
        tens = new HashMap<Integer, String>();

        ones.put(1, "One");
        ones.put(2, "Two");
        ones.put(3, "Three");
        ones.put(4, "Four");
        ones.put(5, "Five");
        ones.put(6, "Six");
        ones.put(7, "Seven");
        ones.put(8, "Eight");
        ones.put(9, "Nine");

        teens.put(11, "Eleven");
        teens.put(12, "Twelve");
        teens.put(13, "Thirteen");
        teens.put(14, "Fourteen");
        teens.put(15, "Fifteen");
        teens.put(16, "Sixteen");
        teens.put(17, "Seventeen");
        teens.put(18, "Eighteen");
        teens.put(19, "Nineteen");

        tens.put(10, "Ten");
        tens.put(20, "Twenty");
        tens.put(30, "Thirty");
        tens.put(40, "Forty");
        tens.put(50, "Fifty");
        tens.put(60, "Sixty");
        tens.put(70, "Seventy");
        tens.put(80, "Eighty");
        tens.put(90, "Ninety");


        while (num > 0){
            int digits = num % 1000;
            parseDigits(digits, stack, ones, teens, tens, suffix);
            num /= 1000;
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (!stack.isEmpty()){
            if (stack.peek().equals("X")){
                stack.pop();
                continue;}
            ans.append(stack.pop());
            System.out.println(i);
            System.out.println(ans.toString());

            if (stack.size() != 0){
                System.out.println("hey");
                ans.append(" ");
            }
            i++;
        }


        return ans.toString().trim();

    }

    public void parseDigits(int digits, Stack<String> stack, Map<Integer, String> ones, Map<Integer, String> teens, Map<Integer, String> tens, String[] suffix){
        StringBuilder sb = new StringBuilder();
        int digCopy = digits;

        if ((digits/100) != 0){
            int hun = digits / 100;
            String hundreds = ones.get(hun);
            sb.append(hundreds);
            sb.append(" ");
            sb.append("Hundred");
            sb.append(" ");
            digits %= 100;
        }

        if (digits != 0){
            if (digits < 10){
                String s1 = ones.get(digits);
                sb.append(s1);
                sb.append(" ");
            } else if ((digits < 20) && (digits != 10)){
                String s2 = teens.get(digits);
                sb.append(s2);
                sb.append(" ");
            } else {
                int oneDigit = digits % 10;
                digits -= oneDigit;
                sb.append(tens.get(digits));
                sb.append(" ");
                if (oneDigit != 0){
                    sb.append(ones.get(oneDigit));
                    sb.append(" ");
                }
            }
        }

        if (digCopy != 0){
            if (stack.size() != 0){
                sb.append(suffix[stack.size()-1]);
            }
            stack.push(sb.toString().trim());
        } else {
            stack.push("X");
        }


        return;
    }


}
