package com.mukhar;

import java.util.ArrayList;
import java.util.TreeMap;

public class DagPath {
    public int getLongestPath(int source, int sink, ArrayList<int[]> edges, String[] path) {
        int maxNode = 0;
        for (int[] edge : edges) {
            if (edge[0] > maxNode)
                maxNode = edge[0];
            if (edge[1] > maxNode)
                maxNode = edge[1];
        }
        TreeMap<Integer, ArrayList<int[]>> sortedEdges = new TreeMap<>();
        for (int[] edge : edges) {
            ArrayList<int[]> edgeList = sortedEdges.get(edge[0]);
            if (edgeList == null)
                edgeList = new ArrayList<>();
            edgeList.add(edge);
            sortedEdges.put(edge[0], edgeList);
        }

        int[] dPath = new int[maxNode + 1];
        int[] backPath = new int[maxNode + 1];
        dPath[source] = 0;
        for (int i = source; i <= sink; i++) {
            ArrayList<int[]> edgeList = sortedEdges.get(i);
            if (edgeList == null)
                continue;
            if (i != source && dPath[i] == 0)
                continue;
            for (int[] edge : edgeList) {
                int temp = dPath[edge[0]] + edge[2];
                if (temp > dPath[edge[1]]) {
                    dPath[edge[1]] = temp;
                    backPath[edge[1]] = edge[0];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sink);
        int idx = backPath[sink];
        while (idx != source) {
            sb.insert(0, idx + "->");
            idx = backPath[idx];
        }
        sb.insert(0, source + "->");
        path[0] = sb.toString();
        return dPath[sink];
    }
}
