public class PathCompressionDS implements DisjointSets{
    private int[] parent;
    private int[] size;
    public PathCompressionDS(int N){
        parent=new int[N];
        size=new int[N];
        for(int i=0;i<N;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    private int find(int p){
        if(p!=parent[p]){
            parent[p]=find(parent[p]);
        }
        return parent[p];
    }
    @Override
    public void connect(int p,int q){
        int pid=find(p);
        int qid=find(q);
        if(pid==qid) return;
        if(size[pid]>size[qid]){
            parent[qid]=pid;
            size[pid]+=size[qid];
        }else{
            parent[pid]=qid;
            size[qid]+=pid;
        }
    }
    @Override
    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }

}
