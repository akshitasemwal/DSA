package Graphs.MST;

import java.util.*;

public class DisjointSets {
    List<Integer> ranks = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSets(int n)
    {
        for(int i = 0; i<=n; i++)
        {
            ranks.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int u)
    {
        if( u == parent.get(u) ) return u;  // if current node is equal to its ultimate parent, then it itself is the ultimate parent
        //return findParent(parent.get(u)); // O(log n)

        //path compression: attaching each node directly to its ultimate parent
        int pu = findParent(parent.get(u)); //finding the ultimate parent of u
        parent.set(u, pu);  //attaching u to its ultimate parent(updating ultimate parent value in parent list)
        return parent.get(u); //return the ultimate parent of u
    }

    public void unionByRank(int u, int v)
    {
        int pu = findParent(u);   // Step 1
        int pv = findParent(v);

        int ru = ranks.get(pu);   // Step 2
        int rv = ranks.get(pv);

        if(ru < rv) parent.set(pu, pv);  //parent with smaller rank gets connected to bigger rank, and hence they now share the bigger parent's ultimate parent
        else if(ru > rv) parent.set(pv, pu); //in these cases, rank remains same since the bigger rank parent was already bigger in height
        else
        {
            parent.set(pu, pv);  //u gets connected to v
            ranks.set(pv, rv + 1); //rank of v will now increase since both were of same heights
        }
    }

    public void unionBySize(int u, int v)
    {
        int pu = findParent(u);
        int pv = findParent(v);

        int su = size.get(pu);
        int sv = size.get(pv);

        if(su < sv)
        {
            parent.set(pu, pv);
            size.set(pv, su + sv);  //size of the bigger parent increases as new nodes get attached to it
        }
        else if(sv < su)
        {
            parent.set(pv, pu);
            size.set(pu, su + sv);
        }
        else
        {
            parent.set(pu, pv);
            size.set(pv, sv + sv);
        }
    }
}

class Main{
public static void main(String[] args) {
        DisjointSets ds = new DisjointSets(7);
//        ds.unionByRank(1, 2);
//        ds.unionByRank(2, 3);
//        ds.unionByRank(4, 5);
//        ds.unionByRank(6, 7);
//        ds.unionByRank(5, 6);
//
//        if(ds.findParent(3) == ds.findParent(7))
//        {
//            System.out.println("Same parents");
//        }
//        else
//        {
//            System.out.println("Not Same");
//        }
//
//        ds.unionByRank(3, 7);
//
//        if(ds.findParent(3) == ds.findParent(7))
//        {
//            System.out.println("Same parents");
//        }
//        else
//        {
//            System.out.println("Not Same");
//        }

    ds.unionBySize(1, 2);
    ds.unionBySize(2, 3);
    ds.unionBySize(4, 5);
    ds.unionBySize(6, 7);
    ds.unionBySize(5, 6);

    if(ds.findParent(3) == ds.findParent(7))
    {
        System.out.println("Same parents");
    }
    else
    {
        System.out.println("Not Same");
    }

    ds.unionBySize(3, 7);

    if(ds.findParent(3) == ds.findParent(7))
    {
        System.out.println("Same parents");
    }
    else
    {
        System.out.println("Not Same");
    }
    }
}
