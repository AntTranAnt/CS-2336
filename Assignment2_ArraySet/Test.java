public class Test
{
	public static void main(String[] args) {
		ArrayNumSet<Integer> testing = new ArrayNumSet(5);
		testing.add(12);
		testing.add(27);
		testing.add(26);
		testing.add(28);
		testing.add(29);
		testing.add(20);
		testing.add(21);
		testing.remove(12);
		System.out.println(testing.get(0));
		//System.out.println(testing.size());
	}
}