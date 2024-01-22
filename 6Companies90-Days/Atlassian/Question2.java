import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 Question 2
 A kingdom consists of a king, his children, his grandchildren, 
 and so on. Every once in a while, someone in the family dies or a child is born.
The kingdom has a well-defined order of inheritance that consists of the king as the 
first member. Let's define the recursive function Successor(x, curOrder), which given 
a person x and the inheritance order so far, returns who should be the next person after
 x in the order of inheritance.
Successor(x, curOrder):
    if x has no children or all of x's children are in curOrder:
        if x is the king return null
        else return Successor(x's parent, curOrder)
    else return x's oldest child who's not in curOrder
For example, assume we have a kingdom that consists of the king, his children Alice and Bob (Alice is older than Bob), and finally Alice's son Jack.
In the beginning, curOrder will be ["king"].
Calling Successor(king, curOrder) will return Alice, so we append to curOrder to get ["king", "Alice"].
Calling Successor(Alice, curOrder) will return Jack, so we append to curOrder to get ["king", "Alice", "Jack"].
Calling Successor(Jack, curOrder) will return Bob, so we append to curOrder to get ["king", "Alice", "Jack", "Bob"].
Calling Successor(Bob, curOrder) will return null. Thus the order of inheritance will be ["king", "Alice", "Jack", "Bob"].
Using the above function, we can always obtain a unique order of inheritance.
Implement the ThroneInheritance class:
ThroneInheritance(string kingName) Initializes an object of the ThroneInheritance class. The name of the king is given as part of the constructor.
void birth(string parentName, string childName) Indicates that parentName gave birth to childName.
void death(string name) Indicates the death of name. The death of the person doesn't affect the Successor function nor the current inheritance order. You can treat it as just marking the person as dead.
string[] getInheritanceOrder() Returns a list representing the current order of inheritance excluding dead people. 
 */

public class Question2 {
    class ThroneInheritance {
        HashMap<String, ArrayList<String>> h;
        String king = "";
        HashSet<String> hset = new HashSet<String>();

        public ThroneInheritance(String kingName) {
            h = new HashMap<String, ArrayList<String>>();
            king = kingName;
        }

        public void birth(String parentName, String childName) {
            if (!h.containsKey(parentName)) {
                ArrayList<String> l = new ArrayList<String>();
                l.add(childName);
                h.put(parentName, l);
            } else {
                ArrayList<String> l = h.get(parentName);
                l.add(childName);
                h.put(parentName, l);
            }
        }

        public void death(String name) {
            hset.add(name);
        }

        public List<String> getInheritanceOrder() {
            ArrayList<String> result = new ArrayList<String>();
            Stack<String> stck = new Stack<String>();
            stck.add(king);
            while (stck.size() > 0) {
                String s = stck.pop();
                if (!hset.contains(s)) {
                    result.add(s);
                }
                if (h.containsKey(s)) {
                    ArrayList<String> l = h.get(s);
                    for (int j = l.size() - 1; j >= 0; j--) {
                        stck.push(l.get(j));
                    }
                }
            }

            return result;

        }
    }

    /**
     * Your ThroneInheritance object will be instantiated and called as such:
     * ThroneInheritance obj = new ThroneInheritance(kingName);
     * obj.birth(parentName,childName);
     * obj.death(name);
     * List<String> param_3 = obj.getInheritanceOrder();
     */
}
