package Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//901. Online Stock Span
/*
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 */
public class OnlineStockSpan {
    List<Integer> prices;
    Stack<Integer> stockSpan;
    int count;
    public OnlineStockSpan() {
        prices = new ArrayList<>();
        stockSpan = new Stack<>();
        count=0;
    }

    public int next(int price) {
        int span;
        prices.add(price);
        while(!stockSpan.isEmpty()&&price>=prices.get(stockSpan.peek())) stockSpan.pop();
        if(!stockSpan.isEmpty()) span = count - stockSpan.peek();
        else span = count+1;
        stockSpan.add(count++);
        return span;
    }

    public static void main(String[] args) {
        OnlineStockSpan stockSpan = new OnlineStockSpan();
        System.out.println(stockSpan.next(31));
        System.out.println(stockSpan.next(41));
        System.out.println(stockSpan.next(48));
        System.out.println(stockSpan.next(59));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(55));
        System.out.println(stockSpan.next(44));
    }
}
