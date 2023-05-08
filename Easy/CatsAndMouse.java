/*
Two cats and a mouse are at various positions on a line. You will be given their starting positions. Your task is to determine which cat will reach the mouse first, assuming the mouse does not move and the cats travel at equal speed.
If the cats arrive at the same time, the mouse will be allowed to move and it will escape while they fight.
https://www.hackerrank.com/challenges/cats-and-a-mouse/problem?isFullScreen=true
TC: O(1)
SC: O(1)
*/

package Easy;

public class CatsAndMouse {
    public static void main(String[] args) {
        int x = 1;
        int y = 3;
        int z = 4;
        System.out.println(catAndMouse(x, y, z));
    }

    static String catAndMouse(int x, int y, int z) {
        int a = Math.abs( x-z );
        int b = Math.abs( y-z );
        if( a>b )
        {
            return ("Cat B");
        }
        else if( b>a )
        {
            return ("Cat A");
        }
        else
            return ("Mouse C");
    }
}
