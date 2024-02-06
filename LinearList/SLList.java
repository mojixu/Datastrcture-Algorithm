public class SLList {
    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i,IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    public int size;
    public SLList(int x) {
        first = new IntNode(x, null);
        size=1;
    }

    public void addFirst(int x){
        first=new IntNode(x,first);
        size+=1;
    }

    public void addLast(int x){
        IntNode p=first;
        while(p.next!=null){
            p=p.next;
        }
        IntNode L=new IntNode(x,null);
        p.next=L;
        size+=1;
    }
    public int getFirst(){
        return first.item;
    }



}
