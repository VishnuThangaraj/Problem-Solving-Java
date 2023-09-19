import java.io.*;
import java.util.*;

/*
Given a dictionary of employee:manager where they are represented by characters,
Print manager number_of employees_under_the_manager where managers sorted in lexical order
Number of employees also include indirect reports not only direct reports.
It may be assumed that an employee directly reports to only one manager.
In the above dictionary the root node/ceo is listed as reporting to himself.

Note You are given a dictionary named emp containing employee:manager as key:value so you only need to complete the function and print output

Input Format
First line of input denotes the number of pairs
followed by n space seperated pairs denoting employee and manager

Output Format
Print manager number_of_employees space seperated where each pair is in new line in lexically sorted order

Example
Input
6
A C
B C
C F
D E
E F
F F

Output
A 0  
B 0
C 2
D 0
E 1
F 5 

Explanation
Each denotes number of employees directly and indirectly under the manager. F is the CEO therefore all other employees are under him

Constraints
1<=Total number of employees<=100
*/

class Solution {

	private int empUnderMe(TreeMap<String,Integer> indirect, HashMap<String, ArrayList<String>> direct, String manager){
		if(!direct.containsKey(manager)){
			indirect.put(manager, 0); //no-one under this manager
			return 1;
		}

		int count = 0;

		for(String employe : direct.get(manager)){
			count += empUnderMe(indirect,direct,employe);
		}

		indirect.put(manager,count);
		return count+1; //+1 because inclues current as a count
	}

    public void EmpUnderManager(Map<String, String> emp)
	{
		//HashMap to store the direct reports 
		HashMap<String, ArrayList<String>> direct = new HashMap<>();

		String CEO = "";

		for(String employe : emp.keySet()){
			String manager = emp.get(employe);
			if(employe.equals(manager)){
				CEO = employe; //find the CEO
			}else{
				//update the direct reports
				ArrayList<String> report = direct.getOrDefault(manager, new ArrayList<String>());
				report.add(employe);
				direct.put(manager, report);
			}
		}

		TreeMap<String,Integer> indirect = new TreeMap<>();
		//similar to hashMap but keys will be sorted

		empUnderMe(indirect, direct, CEO);

		for(String key : indirect.keySet()){
			System.out.println(key+" "+indirect.get(key));
		}
	}
}

public class employeesAndManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}
