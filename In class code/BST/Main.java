/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		
		bst.insert(17);
		bst.insert(16);
		bst.insert(18);
		bst.insert(20);
		bst.insert(1);
		
		System.out.println(bst.contains(17));
		System.out.println(bst.contains(2));
		System.out.println(bst.size());
		bst.inOrder();
	}
}
