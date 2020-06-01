/*
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

*/
package leetCodeChallenge.may;

import java.util.HashMap;
import java.util.LinkedList;

public class Stock_Span {

    LinkedList<Integer> list = null;
    HashMap<Integer,Integer> map = null;

    public Stock_Span(){
        list = new LinkedList();
        map = new HashMap();
    }

    public int next(int price) {


        int size = list.size()-1 ;
        int num = 0;

        if(size >= 0) {
            num = list.get(size);
        }
        list.add(price);

        if(num > price || map.isEmpty()){
            map.put(price,1);
            return 1;
        }else{

            int sum =  map.get(num);
            size = size - sum;
            while(size >= 0){
                num = list.get(size);
                if(num <= price){
                    sum = sum + map.get(num);
                    size = size - map.get(num);
                }else{
                    break;
                }

            }
            map.put(price, sum+1);
            return  sum+1;
        }

    }

    public static void main(String[] args) {

        Stock_Span stock = new Stock_Span();
        System.out.println(stock.next(28));
        System.out.println(stock.next(14));
        System.out.println(stock.next(28));
        System.out.println(stock.next(35));
        System.out.println(stock.next(46));
        System.out.println(stock.next(53));
        System.out.println(stock.next(66));
        System.out.println(stock.next(80));
        System.out.println(stock.next(87));
        System.out.println(stock.next(88));
    }
}
