class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (connections.size()==0){return result;}

        Map<Integer, List<Integer>> graph = buildGraph(connections, n);

        int[] disc = new int[n];
        int[] low = new int[n];

        Arrays.fill(disc, -1);
        int id=0;


        for (int i = 0; i < disc.length; i++){
            if (disc[i]==-1){
                dfs(id, disc, low, i, i, graph, result);
            }
        }

        return result;
    }


    public void dfs(int id, int[] disc, int[] low, int parent, int from, Map<Integer, List<Integer>> graph, List<List<Integer>> result){
        disc[from] = low[from] = id++;

        for (int to : graph.get(from)){
            if (to == parent){continue;}
            if (disc[to]==-1){
                dfs(id, disc, low, from, to, graph, result);
                low[from] = Math.min(low[from], low[to]);
                if (low[to] > disc[from]){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(to);
                    list.add(from);
                    result.add(list);
                }
            } else {
                low[from] = Math.min(low[from], disc[to]);

            }
        }
        return;

    }

    public Map<Integer, List<Integer>> buildGraph(List<List<Integer>> connections, int n){
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++){
            map.put(i, new ArrayList<Integer>());
        }
        for (List<Integer> edge : connections){
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }
        return map;
    }

}
