/*
Each day, floor(recipients/2)  of the recipients like the advertisement and will share it with  friends on the following day.
Assuming nobody receives the advertisement twice, determine how many people have liked the ad by the end of a given day, beginning with launch day as day .
https://www.hackerrank.com/challenges/strange-advertising/problem?isFullScreen=true
TC: O(n)
SC: O(1)
*/

package Easy;

public class ViralAdvertising {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(viralAdvertising(n));
    }

    public static int viralAdvertising(int n) {
        int shared = 5;
        int liked, cum = 0;
        for(int i = 1; i<=n; i++)
        {
            liked = shared/2;
            shared = liked*3;
            cum += liked;
        }
        return cum;
    }
}
