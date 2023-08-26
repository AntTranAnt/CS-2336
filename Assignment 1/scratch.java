public class scratch {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;
        boolean z = true;
        boolean a = (!x && !y && !z) && (x || y) && (!x || !y);
        System.out.println(a);
    }
    
}
