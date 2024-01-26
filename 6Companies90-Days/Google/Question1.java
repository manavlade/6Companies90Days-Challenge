import java.util.Arrays;
/*
 Question 1
You are given an integer mass, which represents the original mass of a planet. 
You are further given an integer array asteroids, where asteroids[i] is the mass of 
the ith asteroid. You can arrange for the planet to collide with the asteroids in any 
arbitrary order. If the mass of the planet is greater than or equal to the mass of the 
asteroid, the asteroid is destroyed and the planet gains the mass of the asteroid.
 Otherwise, the planet is destroyed.
Return true if all asteroids can be destroyed. Otherwise, return false.
 */
public class Question1 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long mas = (long) mass;
        for (int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] > mas){
                return false;
            }
            else {
                mas += asteroids[i];
            }
        }
        return true;
    }
}