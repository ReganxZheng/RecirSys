
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZhengJwh
 */
public class SysRun {
    private static int MAX_ROUNT = 6;
    private static ArrayList<Order> order_list = new ArrayList<Order>();
    private static ArrayList<Driver> driver_list = new ArrayList<Driver>();
    private static HashMap<Driver, Order> dispatch = new HashMap<Driver, Order>();
    public void printOrderList() {
        if (order_list.isEmpty()) {
            System.out.println("The order list is currently empty, please add orders!");
        }
        int num = 1;
        for (Order o : order_list) {
            System.out.println("Order priority: " + num +", "+ o.toString());
            num++;
        }
    }

    public void printDriverList() {
        if(driver_list.isEmpty()) {
            System.out.println("No data store in driver list yet!");
        }
        for(Driver d :driver_list) {
            System.out.println(d.toString());
        }
    } 

    public void sortDriverList() {
        Driver temp;
        for(int i=0;i<driver_list.size();i++) {
            for(int j=1;j<driver_list.size();j++) {
                if((driver_list.get(j).getPriority()) < (driver_list.get(j-1).getPriority())) {
                    //two different type of swap. both works.
//                    temp = driver_list.get(j-1);
//                    driver_list.set(j-1, driver_list.get(j));
//                    driver_list.set(j, temp);
                      Collections.swap(driver_list, j-1, j);
                }
            }
        }
    }
    
    public void dispatchingOrders() {
        //Before dispathing. The system should require sorting on both
        //order_list and driver_list in order to follow the algorithm.
        
        //In this method. Use two while loop to justify each rounds, algorithm
        //will add datas into dispatch, such as, when algorithm runs, it will evaluate
        //the first Driver and Order object in both list.
        //In plain code: if first Order subject contains (10x40ft, 5x20ft) initial round = 1;
        //<Driver> - <Order object (2x40ft, 1x20ft)> <-- change happens in Order object (10-2 x40ft, 5-1 x20ft) round++;
        //dispatch.put(key, value)
        //if the round reach MAX_ROUND, change into second Driver object in the list.
        //if the Order object isEmpty, change into second Order object in the list.
        
        //Google online for Hashmap External Chaining to finish this part.
    }
    
    public void printUI() {
        System.out.println("Welcome to the Recur Transportataion User Interface: ");
        System.out.println("Please select below options: ");
        System.out.println("1----------------Add orders");
        System.out.println("2----------------Add driver details");
        System.out.println("3----------------Check orders:");
        System.out.println("4----------------Check drivers detail");
        System.out.println("5----------------Dispatch existing orders to drivers");
        System.out.println("q----------------Exit the system");
        System.out.print("Your input: >>>  ");
    }
    
    public void formDatabaseTable() {
        //Use DMBC create your own local database. Form a TABLE for ORDER, DRIVER
        //In ORDER table, the variables are ORDER_ID VARCHAR(20), START_DATE VARCHAR(30),
        //CUTOFF_DATE VARCHAR(30), 20_FT_CONTAINER INT, 40_FT_CONTAINER INT.
        
        //In DRIVER table, the varibles are DRIVER_NAME VARCHAR(30), DRIVER_ID VARCHAR(20),
        //DRIVER_PRIORITY INT.
    }
    public static void retriveData() {
        //In your global variables: You should include
        //String url = "jdbc:derby://localhost:1527/DealorNoDealDB; create=true"
        //String username = "recir"
        //String password = "Sys"
        //Statement statement;
        
        //Use this method to connect the database.
        //Connection conn = null;
        //conn = DriverManager.getConnection(url, username, password);
        //statement = conn.createStatement();
        
        //Retrived the data from table, one ORDER equal to a String.
        //Split the Split with switch method then put into a ArrayList<Order> - existing_order
        
    }
    public static void main(String[] args) {
        SysRun run = new SysRun();
        driver_list.add(new Driver("Frankie Zheng", "REC001", 1));
        driver_list.add(new Driver("Antony Li", "REC004", 3));             //this info only for testing purpose.
        driver_list.add(new Driver("Webber Jiang", "REC002",2));
        driver_list.add(new Driver("Charlie Ye","REC003", 2));     
        boolean terminate = false;
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        //Before the System runs, must 
        while (!terminate) {
            run.printUI();
            String user_choice;
            user_choice = scan1.nextLine();
            switch (user_choice) {
                case "1":
                    String id;
                    String date;
                    String[] splitdate;
                    int year;
                    int month;
                    int day;
                    int con20;
                    int con40;
                    System.out.println("Enter id num: ");
                    id = scan.nextLine();
                    System.out.println("Enter date by (year/month/day)");
                    date = scan.nextLine();
                    splitdate = date.split("/", 3);
                    year = Integer.parseInt(splitdate[0]) - 1900;
                    month = Integer.parseInt(splitdate[1]) - 1;
                    day = Integer.parseInt(splitdate[2]);
                    System.out.println("Enter 20 ft container num: ");
                    con20 = scan.nextInt();
                    System.out.println("Enter 40 ft container num: ");
                    con40 = scan.nextInt();
                    Order o = new Order(id, new Time(year, month, day), new Container(con20, con40));
                    order_list.add(o);
                    break;
                case "2" :
                    String driver_id;
                    String driver_name;
                    int priority;
                    System.out.println("Enter driver name");
                    driver_name = scan.nextLine();
                    System.out.println("Enter driver_id");
                    driver_id = scan.nextLine();
                    System.out.println("Enter driver priority");
                    priority = scan.nextInt();
                    Driver d = new Driver(driver_name, driver_id, priority);
                    driver_list.add(d);
                    System.out.println();
                    break;
                case "3" :
                    run.printOrderList();
                    System.out.println();
                    break;
                case "4" :
                    run.sortDriverList();
                    run.printDriverList();
                    System.out.println();
                    break;
                case "5" :
                    //check if the order_list been sorted.
                    //check if the driver_list been sorted.
                    //run.dispatchingOrders();
                case "q" :
                    terminate = true;
                    System.out.println("Farewell!");
                    break;
                default: 
                    System.out.println("please enter a vaild key to proceed!!!");
                    System.out.println();
                    break;
            }
        }
    }
}
