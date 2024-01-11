/*
 Question 13
 In LeetCode Store, there are n items to sell. Each item has a price. However, there are some special offers, and a special 
 offer consists of one or more different kinds of items with a sale price.
You are given an integer array price where price[i] is the price of the ith item, and an integer 
array needs where needs[i] is the number of pieces of the ith item you want to buy.
You are also given an array special where special[i] is of size n + 1 where special[i][j] is the number of pieces of the jth item in the ith offer and special[i][n] 
(i.e., the last integer in the array) is the price of the ith offer.
Return the lowest price you have to pay for exactly certain items as given, where you could make optimal use of 
the special offers. You are not allowed to buy more items than you want, even if that would lower the overall price. You could use any of the special offers as many times as you want.
*/
import java.util.ArrayList;
import java.util.List;

public class Question13 {
    int minPrice;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        minPrice=directlyBuy(price,needs);
        help(price,special,needs,0,0);
        return minPrice;
    }
    private int directlyBuy(List<Integer> price,List<Integer> needs){
        int total=0;
        int n=needs.size();
        for(int i=0;i<n;i++){
            total+=price.get(i)*needs.get(i);
        }
        return total;
    }
    private boolean canUse(List<Integer> offer,List<Integer> needs){
        int n=needs.size();
        for(int i=0;i<n;i++){
            if(offer.get(i)>needs.get(i))return false;
        }
        return true;
    }
    private void help(List<Integer> price,List<List<Integer>> special,List<Integer> needs,int used,int index){
        if(used>=minPrice)return;
        if(index==special.size()){
            used+=directlyBuy(price,needs);
            if(used<minPrice){
                minPrice=used;
            }
            return;
        }
        List<Integer> offer=special.get(index);
        if(canUse(offer,needs)){
            int n=needs.size();
            List<Integer> updatedNeeds=new ArrayList<>();
            for(int i=0;i<n;i++){
                updatedNeeds.add(needs.get(i)-offer.get(i));
            }
            help(price,special,updatedNeeds,used+offer.get(n),index);
        }
        help(price,special,needs,used,index+1);
    }
}
