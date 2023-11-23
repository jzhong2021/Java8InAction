package lambdasinaction.chap5;

import lambdasinaction.chap5.*;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPracticeChangedByJZ{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
		System.out.println("Query 1: Find all transactions from year 2011 and sort them by value (small to high).");
        List<Transaction> tr2011 = transactions.stream()
                                               .filter(transaction -> transaction.getYear() == 2011)
                                               //.sorted(comparing(Transaction::getValue))
                                               //.sorted((x,y)->Integer.compare(x.getValue(), y.getValue()))	//Good2 ascending
                                               //.sorted((y,x)->Integer.compare(x.getValue(), y.getValue()))		//Good2 descending
                                               .sorted((x,y)->Integer.compare(x.getValue(), y.getValue())*(-1))		//Good2 descending
                                               .collect(toList());
        System.out.println(tr2011);
        
        // Query 2: What are all the unique cities where the traders work?
        List<String> cities = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        System.out.println(cities);

        // Query 3: Find all traders from Cambridge and sort them by name.
        
        List<Trader> traders = 
            transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);
        
        
        // Query 4: Return a string of all traders’ names sorted alphabetically.
        System.out.println("Query 4: Return a string of all traders’ names sorted alphabetically.");
        String traderStr = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);
        
        // Query 5: Are there any trader based in Milan?
        
        boolean milanBased =
            transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                                            .getCity()
                                                            .equals("Milan")
                                 );
        System.out.println(milanBased);
        
        
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        System.out.println("Query 6: Update all transactions so that the traders from Milan are set to Cambridge.");
        System.out.println(transactions);
        // Good
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equals("Milan"))
                    .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);
        /*
		[{Trader:Brian in Cambridge, year: 2011, value:300}, {Trader:Raoul in Cambridge, year: 2012, value:1000}, {Trader:Raoul in Cambridge, year: 2011, value:400}, {Trader:Mario in Milan, year: 2012, value:710}, {Trader:Mario in Milan, year: 2012, value:700}, {Trader:Alan in Cambridge, year: 2012, value:950}]
		[{Trader:Brian in Cambridge, year: 2011, value:300}, {Trader:Raoul in Cambridge, year: 2012, value:1000}, {Trader:Raoul in Cambridge, year: 2011, value:400}, {Trader:Mario in Cambridge, year: 2012, value:710}, {Trader:Mario in Cambridge, year: 2012, value:700}, {Trader:Alan in Cambridge, year: 2012, value:950}]
        */
        
        //JZ Good 1
//        transactions.stream()
//        .filter(txn -> txn.getTrader().getCity().equals("Milan"))
//        .forEach(txn -> txn.getTrader().setCity("Cambridgexx"));
//        System.out.println(transactions);
        /*
			[{Trader:Brian in Cambridge, year: 2011, value:300}, {Trader:Raoul in Cambridge, year: 2012, value:1000}, {Trader:Raoul in Cambridge, year: 2011, value:400}, {Trader:Mario in Milan, year: 2012, value:710}, {Trader:Mario in Milan, year: 2012, value:700}, {Trader:Alan in Cambridge, year: 2012, value:950}]
			[{Trader:Brian in Cambridge, year: 2011, value:300}, {Trader:Raoul in Cambridge, year: 2012, value:1000}, {Trader:Raoul in Cambridge, year: 2011, value:400}, {Trader:Mario in Cambridgexx, year: 2012, value:710}, {Trader:Mario in Cambridgexx, year: 2012, value:700}, {Trader:Alan in Cambridge, year: 2012, value:950}]          
         */

        //JZ Bug: no change
//        transactions.stream()
//        .map(txn -> txn.getTrader().getCity())
//        .filter(city -> city.equals("Milan"))
//        .forEach(city -> city="CambridgeYY");
//        System.out.println(transactions);
        /*
		[{Trader:Brian in Cambridge, year: 2011, value:300}, {Trader:Raoul in Cambridge, year: 2012, value:1000}, {Trader:Raoul in Cambridge, year: 2011, value:400}, {Trader:Mario in Milan, year: 2012, value:710}, {Trader:Mario in Milan, year: 2012, value:700}, {Trader:Alan in Cambridge, year: 2012, value:950}]
		[{Trader:Brian in Cambridge, year: 2011, value:300}, {Trader:Raoul in Cambridge, year: 2012, value:1000}, {Trader:Raoul in Cambridge, year: 2011, value:400}, {Trader:Mario in Milan, year: 2012, value:710}, {Trader:Mario in Milan, year: 2012, value:700}, {Trader:Alan in Cambridge, year: 2012, value:950}]         
		
         */
        // Query 7: What's the highest value in all the transactions?
        int highestValue = 
            transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(0, Integer::max);
        System.out.println(highestValue);
        
        //JZ
        OptionalInt highestValue2 = 
                transactions.stream()
                            .mapToInt(Transaction::getValue)
                            .max();
            System.out.println(highestValue2.getAsInt());           
    }
}