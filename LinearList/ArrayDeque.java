public class ArrayDeque<T> {
     public T[] item;
     public int size;
     public int nextFirst;
     public int nextLast;
     public ArrayDeque(T x){
         item=(T[]) new Object[8];
         item[0]=x;
         nextFirst=7;
         nextLast=1;
         size=1;
     }
     private int plusOne(int index){
         return Math.floorMod(index+1,item.length);
     }
     private int minusOne(int index){
         return Math.floorMod(index-1,item.length);
     }
     private void resize(){
         if(size==item.length){
             expand();
         }
         if(size<=item.length*0.25&&item.length>8){
             reduce();
         }
     }
     private void expand(){
          sizeHelper((item.length)*2);
     }
     private void reduce(){
          sizeHelper(item.length/2);
     }
     private int plusOne(int index,int length){
         return Math.floorMod(index+1,length);
     }
    private int minusOne(int index,int length){
        return Math.floorMod(index-1,length);
    }
     private void sizeHelper(int capacity){
         T[] temp=item;
         item=(T[])new Object[capacity];
         int begin=plusOne(nextFirst,temp.length);
         int end=minusOne(nextLast,temp.length);
         nextFirst=capacity-1;
         nextLast=0;
         for(int i=begin;i!=end;i=plusOne(i)){
             item[nextLast++]=temp[i];
         }
         item[nextLast]=temp[end];
         nextLast=plusOne(nextLast);
     }
     public void addFirst(T x){
         resize();
         item[nextFirst]=x;
         nextFirst=minusOne(nextFirst);
         size+=1;
     }
     public void addLast(T x){
         resize();
         item[nextLast]=x;
         nextLast=plusOne(nextLast);
         size+=1;
     }
     public boolean isEmpty(){
         return size==0;
     }
     public T removeFirst(){
         if(isEmpty()){
             System.out.println("Fail remove the first node!");
             return null;
         }
         nextFirst=plusOne(nextFirst);
         T ans=item[nextFirst];
         item[nextFirst]=null;
         size-=1;
         return ans;
     }
     public T removeLast(){
         if(isEmpty()){
             System.out.println("Fail remove the last node!");
             return null;
         }
         nextLast=minusOne(nextLast);
         T ans=item[nextLast];
         item[nextLast]=null;
         size-=1;
         return ans;
     }
     public int size(){
         return size;
     }
     public void printDeque(){
         int begin=plusOne(nextFirst);
         for(int i=begin;i!=nextLast;i=plusOne(i)){
             System.out.print(item[i]+" ");
         }
     }
     public T get(int index){
         return item[plusOne(nextFirst+index)];
     }
}
