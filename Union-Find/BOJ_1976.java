// BOJ - 1976
// Problem Sheet - https://www.acmicpc.net/problem/1976

import java.util.*;
import java.io.*;

public class Main {

    private static final String VALID = "YES";
    private static final String INVALID = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean isValidPlan = true;

        int numberOfCities = Integer.parseInt(bf.readLine());
        int numberOfCitiesInTravelPlans = Integer.parseInt(bf.readLine());
        int[] cities = new int[numberOfCities+1];
        for(int i=1 ; i<=numberOfCities ; i++) {
            cities[i] = i;
        }

        for(int i=1 ; i<=numberOfCities ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1 ; j<=numberOfCities ; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    connect(cities, i, j);
                }
            }
        }

        st = new StringTokenizer(bf.readLine());
        int prevCity = Integer.parseInt(st.nextToken());
        int nextCity;
        for(int i=0 ; i<numberOfCitiesInTravelPlans-1 ; i++) {
            nextCity = Integer.parseInt(st.nextToken());
            if(!isReachable(cities, prevCity, nextCity)) {
                isValidPlan = false;
                break;
            }
            prevCity = nextCity;
        }

        System.out.println(isValidPlan ? VALID : INVALID);

        bf.close();
        System.exit(0);
    }

    private static int getParent(int[] cities, int city) {
        if(cities[city] == city) {
            return city;
        }
        return cities[city] = getParent(cities, cities[city]);
    }

    private static void connect(int[] cities, int cityA, int cityB) {
        int parentOfCityA = getParent(cities, cityA);
        int parentOfCityB = getParent(cities, cityB);

        if(parentOfCityA < parentOfCityB) {
            cities[parentOfCityB] = parentOfCityA;
        } else {
            cities[parentOfCityA] = parentOfCityB;
        }
    }

    private static boolean isReachable(int[] cities, int cityA, int cityB) {
        return getParent(cities, cityA) == getParent(cities, cityB);
    }
}