import java.util.*;

/*
You have a browser application where you start on the homepage. You can visit a url, move forward x steps, or move back in history x steps.
Implement the BrowserHistory class to add these functions:
BrowserHistory(string homepage) - Initialize the object starting at homepage
void visit(string url) - Visit url from page. All forward history is erased.
string back(int steps) - Move steps back in history. If you can only go back x steps in history and steps > x, you will only return x steps.
string forward(int steps) - Moves steps forward in history. If you can only move forward x steps and steps > x, you will only move forward x steps.

Input Format
The first line will contain the starting homepage.
The second line will contain n - the number of operations.
The next n lines will contain the various functions in space separated parameters. (Explained below)

Output Format
The output should contain the resultant string of all back and forward operations.

Example 1
Input
google.com
5
visit facebook.com
visit linkedin.com
back 2
forward 1
visit gmail.com

Output
google.com
facebook.com

Explanation
We are on google.com, we move to facebook.com then linkedin.com, when we go back 2 we come back to google.com therefore first string is google.com.
When we move one forward we go to facebook.com therefore next output is facebook.com

Example 2
Input
google.com
5
visit facebook.com
back 3
visit linkedin.com
back 1
forward 1

Output
google.com
google.com
linkedin.com

Explanation
We are on google.com, we move to facebook.com then go back at max 2 steps which is google.com. 
Then go to linkedin.com and 1 step back again which is google.com and then one step forward which is linkedin.com.

Constraints
1 <= url.length <= 20
1 <= steps <= 100
1 <= n <= 5000
*/

public class designBrowserHistory {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String homepage = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        BrowserHistory browserHistory = new BrowserHistory(homepage);
        for(int i = 0; i < n; i++) {
            String q = sc.nextLine();
            String[] query = q.split("\\s+");
			
            if(query[0].equals("visit")){
                browserHistory.visit(query[1]);
            } else if(query[0].equals("back")){
                browserHistory.back(Integer.parseInt(query[1]));
            } else if(query[0].equals("forward")){
                browserHistory.forward(Integer.parseInt(query[1]));
            }
        }
    }
}
class BrowserHistory {
	//create array of string to store the url string
	String[]url;
	int index = -1; //current index
	int max = -1; //maximum index with history
	
	//constructor
    public BrowserHistory(String homepage) {
        url = new String[5000]; //as given in constraints
		url[++index] = homepage;
		max++;
    }

	//visit a new website
    public void visit(String urls) {
        url[++index] = urls;
		max = index; //currently visited new url will be max
    }
	//visit previously visited url
    public void back(int steps) {
        if((index - steps) <= 0){
			index=0; //reached Homepage
			System.out.println(url[0]); //print homePage
			return;
		}
		index-=steps;
		System.out.println(url[index]); //print homePage
    }
	//go to next url
    public void forward(int steps) {
        if(index+steps < max){
			index+=steps;
			System.out.println(url[index]);
			return;
		}
		index = max; //index reached the max
		System.out.println(url[max]);
    }
}
