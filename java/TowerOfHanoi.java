public class TowerOfHanoi {

    static long count = 0;

	private void towerRearrange(int discCount, char fromDisc, char toDisc, char auxDisc) {

		if(discCount == 1) {

            count++;
			System.out.println(count + " Moving from " + fromDisc + " to " + toDisc );
			return;
		}

		towerRearrange(discCount-1, fromDisc, auxDisc, toDisc);

        count++;
		System.out.println(count + " Moving from "+ fromDisc + " to " + toDisc);

		towerRearrange(discCount-1, auxDisc, toDisc, fromDisc);

        count++;
//		System.out.println(count + " Moving from " + auxDisc + " to " + toDisc);
	}

	public static void main(String[] args) {

		TowerOfHanoi hanoi1 = new TowerOfHanoi();

		hanoi1.towerRearrange(Integer.parseInt(args[0]), 'F', 'T', 'A');
	}

}
