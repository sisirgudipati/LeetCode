class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        List<Integer> list = new LinkedList<Integer>();
        int AA = countFunction(A[0], A, B);
        if (AA != -1){list.add(AA);}
        int AB = countFunction(A[0], B, A);
        if (AB != -1){list.add(AB);}
        int BA = countFunction(B[0], A, B);
        if (BA != -1){list.add(BA);}
        int BB = countFunction(B[0], B, A);
        if (BB != -1){list.add(BB);}

        if (list.size()==0){return -1;}
        else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++){
                if (list.get(i) < min){min=list.get(i);}
            }
            if (min==Integer.MAX_VALUE){min=-1;}
            return min;
        }
    }

    public int countFunction(int val, int[] C, int[] D){
        int count = 0;
        int i = 0;
        while (i < C.length){
            if (val==C[i]){i++;}
            else if (val==D[i]) {
                count++;
                i++;
            } else {
                return -1;
            }
        }
        return count;
    }
