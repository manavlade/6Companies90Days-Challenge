/*
 Question 7
 You are given an array start where start = [startX, startY] represents your initial 
 position (startX, startY) in a 2D space. You are also given the array target where 
 target = [targetX, targetY] represents your target position (targetX, targetY).
The cost of going from a position (x1, y1) to any other position in the space (x2, y2) is |x2 - x1| + |y2 - y1|.
There are also some special roads. You are given a 2D array specialRoads where 
specialRoads[i] = [x1i, y1i, x2i, y2i, costi] indicates that the ith special 
road can take you from (x1i, y1i) to (x2i, y2i) with a cost equal to costi. 
You can use each special road any number of times.
Return the minimum cost required to go from (startX, startY) to (targetX, targetY).
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Question7 {
    
    
    class Pair{
        int x;
        int y;
        int cost;
        Pair(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    
    
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int m=specialRoads.length;
        int n=specialRoads[0].length;
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.cost-b.cost);;
        
        
        int fx=target[0],fy=target[1];
        int x1=start[0],y1=start[1];
        
        
        pq.add(new Pair(x1,y1,0));
        
        while(pq.size()!=0){

              Pair rem=pq.remove();
            x1=rem.x;
            y1=rem.y;

             if(map.containsKey(x1)&&map.get(x1).contains(y1)){
                        continue;
               }

          
            
            if(map.containsKey(x1)==false){
                map.put(x1,new HashSet<Integer>());
            }
            map.get(x1).add(y1);
            
            
            if(rem.x==fx&&rem.y==fy){
                return rem.cost;
            }
            
            pq.add(new Pair(fx,fy,rem.cost+Math.abs(x1-fx)+Math.abs(y1-fy)));
            
            for(int i=0;i<specialRoads.length;i++){
                
                int x=specialRoads[i][0];
                int y=specialRoads[i][1];
                int x2=specialRoads[i][2];
                int y2=specialRoads[i][3];
                int ct=specialRoads[i][4];
                
               
                    if(map.containsKey(x2)&&map.get(x2).contains(y2)){
                        continue;
                    }
                    pq.add(new Pair(x2,y2,rem.cost+ct+Math.abs(x1-x)+Math.abs(y1-y)));
                    
                
                
            }
            
           
            
            
        }
        
        return -1;
        
        
        
        
        
    }
}


