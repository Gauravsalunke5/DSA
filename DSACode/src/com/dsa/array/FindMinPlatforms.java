package com.dsa.array;

import java.util.Arrays;

public class FindMinPlatforms {
	static int minimumNumberOfPlatform(int array[], int departure[], int n) { 
        //Sort arrival and departure arrays
        Arrays.sort(array); 
        Arrays.sort(departure); 
        //plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, maxPlatform = 1; 
        int i = 1, j = 0; 
        
        while (i < n && j < n) { 
            //If next event in sorted order is arrival, increment count of platforms needed
            if (array[i] <= departure[j]) 
            { 
                plat_needed++; 
                i++; 
                if (plat_needed > maxPlatform) 
                maxPlatform = plat_needed;
            } //Else decrement count of platforms needed
            else if (array[i] > departure[j]) { 
                plat_needed--; 
                j++; 
            } 
             
        } 
  
        return maxPlatform; 
    }

	public static void main(String[] args) {
		int[] arrival = { 100, 140, 150, 200, 215, 400 };
		int[] departure = { 110, 300, 220, 230, 315, 600 };
		int n = arrival.length;

		System.out.print("Minimum platforms required is " + minimumNumberOfPlatform(arrival, departure, n));
	}
}

/*
 * Try more Inputs case 1: actual =
 * minimumNumberOfPlatform([900,940,950,1100,1500,1800],[910, 1200, 1120, 1130,
 * 1900, 2000],6) expected = 3
 * 
 * case2: actual = minimumNumberOfPlatform([200, 210, 300, 320, 350, 500],[230,
 * 340, 320, 430, 400, 520],6) expected = 3
 * 
 * case3: actual = minimumNumberOfPlatform([900, 1100, 1235],[1000, 1200,
 * 1240],3) expected = 1
 */
/*
 * Greedy Techniques to find minimum number of platforms Asked In:
 */
/*
 * List of arrival and departure time is given, Find the minimum number of
 * platforms are required for the railway as no train waits
 */
