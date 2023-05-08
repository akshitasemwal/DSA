/*
She decides to apply her game to decision making.
She will look at a numbered range of days and will only go to a movie on a beautiful day.
https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem?isFullScreen=true
TC: O(n)
SC: O(1)
*/

package Easy;

public class BeautifulDays {
    public static void main(String[] args) {
        int i = 20;
        int j = 23;
        int k = 6;
        System.out.print(beautifulDays(i, j, k));
    }

    public static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for(; i<=j; i++)
        {
            int x = i;
            int num = 0;
            int rem;
            while(x>0)
            {
                rem = x % 10;
                x = x/10;
                num = (num*10) + rem;
            }
            if(Math.abs(num-i)%k==0)
            {
                count++;
            }
        }
        return count;
    }
}
