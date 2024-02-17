public class LinkedListDeque<T> {
     public class TNode{
          public T first;
          public TNode next;
          public TNode pre;
          public TNode(T x,TNode n,TNode p){
               first=x;
               next=n;
               pre=p;
          }
     }

     public TNode item;
     public int size;
     public LinkedListDeque(T x){
          item=new TNode(x,null,null);
          item.pre=item;
          size=1;
     }
     public void addLast(T x){
          TNode temp=new TNode(x,null,item.pre);
          item.pre.next=temp;
          item.pre=item.pre.next;
          size+=1;
     }
     public void addFirst(T x){
          TNode temp=new TNode(x,item,item.pre);
          item.pre=temp;
          item=temp;
          size+=1;
     }

     public boolean isEmpty(){
          return item==null;
     }

     public int size(){
          return size;
     }

     public void printDeque(){
          TNode temp=item;
          while(item.pre!=temp){
               System.out.print(temp.first);
               System.out.print(' ');
               temp=temp.next;
          }
     }

     public T removeFirst(){
          if(isEmpty()){
               System.out.println("You can not remove first item,because the node is empty!");
               return null;
          }else{
               T ans=item.first;
               if(item.next==null){
                    item=null;
               }else {
                    item.next.pre = item.pre;
               }
               size-=1;
               return ans;
          }
     }
     public T removeLast(){
          if(isEmpty()) {
               System.out.println("You can not remove first item,because the node is empty!");
               return null;
          }else {
               T ans = item.pre.first;
               if (item.next == null) {
                    item = null;
               } else {
                    item.pre.pre.next = null;
               }
               size-=1;
               return ans;
          }
     }
     public T get(int index){
          TNode temp=item;
          while(index>0){
               temp=temp.next;
               index-=1;
          }
          return temp.first;
     }

     public T getRecursive(int index){
          if(index==0){
               return item.first;
          }
          return getRecursive(index-1);
     }
}
