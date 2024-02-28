public class Main {
    public static void main(String[] args){
        PathCompressionDS d=new PathCompressionDS(9);
        d.connect(1,3);
        d.connect(2,4);
        d.connect(3,4);
        System.out.println("2 and 4 isConnected:"+d.isConnected(2,4));
        System.out.println("1 and 2 isConnected:"+d.isConnected(1,2));
    }
}