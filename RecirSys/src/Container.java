/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FrankieZheng
 */
public class Container {
    protected int con20_num;
    protected int con40_num;

    public Container(int con20, int con40) {
        this.con20_num=con20;
        this.con40_num=con40;
    }

    public void setContainer20(int num) {
        this.con20_num = num;
    }

    public void setContainer40(int num) {
        this.con40_num=num;
    }

    public int getContainer20() {return con20_num;}
    public int getContainer40() {return con40_num;}

    public String toString() {
        return "This order has <20ft-container> = ["+con20_num+"]  <40ft-container> = ["+con40_num+"]";
    }
}
