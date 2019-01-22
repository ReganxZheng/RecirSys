/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ZhengJwh
 */
public class Order {

    protected String order_id;
    protected Time cutoff_date;
    protected Container size;

    public Order(String id, Time date, Container size) {
        this.order_id = id;
        this.cutoff_date = date;
        this.size = size;
    }

    public void setId(String id) {
        this.order_id = id;
    }

    public void setTime(Time time) {
        this.cutoff_date = time;
    }

    public void setSize(Container size) {
        this.size = size;
    }

    public String getId() {
        return order_id;
    }

    public String getTime() {
        return cutoff_date.formatCutOff();
    }

    public String getContainerSize() {
        return size.toString();
    }

    @Override
    public String toString() {
        return "Order id: " + order_id + ". " + cutoff_date.toString() + ". " + size.toString();
    }

    public static void main(String[] args) {
        ArrayList<Order> order_list = new ArrayList<Order>();
        while (true) {
            Scanner scan = new Scanner(System.in);
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
//        System.out.println(o.toString());
//        System.out.println(o.getTime());
//        System.out.println(o.getId());
//        System.out.println(o.getContainerSize());
            for (Order e : order_list) {
                System.out.println(e.toString());
            }
            System.out.println(order_list.size());
        }
    }
}
