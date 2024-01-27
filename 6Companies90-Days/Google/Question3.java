import java.util.Arrays;
import java.util.Comparator;

/*
 Question 
 Alice and Bob take turns playing a game, with Alice starting first.
There are n stones in a pile. On each player's turn, they can remove a stone from the
 pile and receive points based on the stone's value. Alice and Bob may value the stones differently.
You are given two integer arrays of length n, aliceValues and bobValues. Each
 aliceValues[i] and bobValues[i] represents how Alice and Bob, respectively, value the ith stone.
The winner is the person with the most points after all the stones are chosen. 
If both players have the same amount of points, the game results in a draw. Both players
 will play optimally. Both players know the other's values.
 */
public class Question3 {
    
        static class Pair {
            int sum = 0;
            int alice = 0;
            int bob = 0;

            public Pair(int sum, int alice, int bob) {
                this.sum = sum;
                this.alice = alice;
                this.bob = bob;
            }
        }

        static class Compare {

            static void compare(Pair arr[], int n) {
                
                Arrays.sort(arr, new Comparator<Pair>() {
                    @Override
                    public int compare(Pair p1, Pair p2) {
                        return p2.sum - p1.sum;
                    }
                });

            }
        }

        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            int n = aliceValues.length;
            Pair[] a = new Pair[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Pair(aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]);
            }
            Compare.compare(a, n);
            int al = 0;
            int bo = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    al += a[i].alice;
                } else {
                    bo += a[i].bob;
                }
            }
            return Integer.compare(al, bo);

        }
    }
