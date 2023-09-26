import java.util.*;

/*
There are n rooms labelled from 0 to n - 1. 
Except for room 0 are locked. You require the room''s key in order to enter a locked one.
You might discover a set of unique keys inside a room when you visit it. 
You can take all the keys with you to unlock the other rooms. Each key has a number on it that indicates which room it unlocks.

Return true if you can visit all the rooms, false otherwise, given an array rooms where rooms[i] is the set of keys you can get if you visit room i.

Input Format
First line contains an integer n which denotes the number of rooms
For next n lines, ith line contains some space-separated integers in the format m r0 r1 ... rm-1, 
where m is the number of keys in ith room. Example, if there are 2 keys in a room, the format will be: 2 a b where a and b can be any room number. 
If there are 0 keys in a room, the format will be 0.

Output Format
Complete the function CanVisitAllRooms() which returns true of false

Example 1
Input
4           ==> total 4 rooms labelled as 0, 1, 2, 3
1 1         ==> room = 0, has 1 key ie, of room 1
1 2         ==> room = 1, has 1 key ie, of room 2
1 3         ==> room = 2, has 1 key ie, of room 3
0           ==> room = 4, has 0 keys

Output
true

Explanation
We visit room 0 and pick up key 1. We then visit room 1 and pick up key 2. We then visit room 2 and pick up key 3.
We then visit room 3. Since we were able to visit every room, we return true.

Example 2
Input
4           ==> total 4 rooms labelled as 0, 1, 2, 3
2 1 3       ==> room = 0, has 2 key ie, of rooms 1, 2
3 3 0 1     ==> room = 1, has 3 key ie, of rooms 3, 0, 1
1 2         ==> room = 2, has 1 key ie, of room 2
1 0         ==> room = 3, has 1 key ie, of room 0

Output
false

Constraints
2 <= n <= 1000
-1 <= rooms[i] <= n
*/

class Solution {
    public boolean CanVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) {
        boolean[]visited = new boolean[rooms.size()];
		Queue<Integer> door = new LinkedList<>();
		//add all the keys of 0th room
		visited[0] = true;
		for(int key : rooms.get(0))
			door.offer(key);

		//explore the rooms with given keys
		while(!door.isEmpty()){
			int current = door.poll();
			//continue if already visited
			if(visited[current]) continue;

			//mark as visited
			visited[current] = true;

			//add all the keys from the current room
			for(int keys : rooms.get(current)){
				door.offer(keys);
			}
		}

		// CHECK IF ALL THE DOORS ARE VISITED
		for(boolean check : visited)
			if(!check) return false; // unvisited room found
			//System.out.print(check+" ");

		return true; // all rooms visited
    }
}

public class keysAndRooms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < m; j++) {
                temp.add(sc.nextInt());
            }
            r.add(temp);
        }
	    Solution Obj = new Solution();
        if(Obj.CanVisitAllRooms(r))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
