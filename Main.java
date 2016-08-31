package lab01;

import java.util.Scanner;

/*  Program Name:   Lab 01 Shovel Invoice
 *  Programmer:     Marcus Ross
 *  Date Due:       13 September 2013
 *  Description:	This program takes input from the user in the form of a customer's name, address, and how many shovels they want to buy. It then outputs a formatted invoice to screen after figuring costs and how many cases are needed to fit the shovels.
 */

public class Main {
    public static void main(String[] args) {
		//Declare vars
		String customerName, customerStreet, customerCity, customerState, customerZip;
		int shovelNum, xlBoxNum, lBoxNum, mBoxNum, sBoxNum, iBoxNum, shovelRemainder;
		double xlShovelCost, lShovelCost, mShovelCost, sShovelCost, iShovelCost, xlBoxCost, lBoxCost, mBoxCost, sBoxCost, iBoxCost, totalBoxCost, totalShovelCost, totalBill;

		//Set prices
		double xlBoxPrice = 19.00, lBoxPrice = 15.75, mBoxPrice = 11.50, sBoxPrice = 6.25, iBoxPrice = 1.35, shovelPrice = 4.25;

		//Set box capacities
		int xlBoxCapacity = 20, lBoxCapacity = 15, mBoxCapacity = 10, sBoxCapacity = 5, iBoxCapacity = 1;

		//Get customer info
		Scanner kbd = new Scanner(System.in);
		System.out.printf("Customer: ");
		customerName = kbd.nextLine();
		System.out.printf("Street Address: ");
		customerStreet = kbd.nextLine();
		System.out.printf("City: ");
		customerCity = kbd.nextLine();
		System.out.printf("State: ");
		customerState = kbd.nextLine();
		System.out.printf("Zip Code: ");
		customerZip = kbd.nextLine();

		//Get number of shovels
		System.out.printf("Number of shovels ordered: ");
		shovelNum = kbd.nextInt();

		//Calculate box quantity
		xlBoxNum = shovelNum / xlBoxCapacity;
		shovelRemainder = shovelNum % xlBoxCapacity;
		lBoxNum = shovelRemainder / lBoxCapacity;
		shovelRemainder = shovelRemainder % lBoxCapacity;
		mBoxNum = shovelRemainder / mBoxCapacity;
		shovelRemainder = shovelRemainder % mBoxCapacity;
		sBoxNum = shovelRemainder / sBoxCapacity;
		shovelRemainder = shovelRemainder % sBoxCapacity;
		iBoxNum = shovelRemainder / iBoxCapacity;

		//Calculate shipping cost
		xlBoxCost = xlBoxNum * xlBoxPrice;
		lBoxCost = lBoxNum * lBoxPrice;
		mBoxCost = mBoxNum * mBoxPrice;
		sBoxCost = sBoxNum * sBoxPrice;
		iBoxCost = iBoxNum * iBoxPrice;
		totalBoxCost = xlBoxCost + lBoxCost + mBoxCost + sBoxCost + iBoxCost;

		//Calculate product cost
		xlShovelCost = xlBoxNum * xlBoxCapacity * shovelPrice;
		lShovelCost = lBoxNum * lBoxCapacity * shovelPrice;
		mShovelCost = mBoxNum * mBoxCapacity * shovelPrice;
		sShovelCost = sBoxNum * sBoxCapacity * shovelPrice;
		iShovelCost = iBoxNum * iBoxCapacity * shovelPrice;
		totalShovelCost = xlShovelCost + lShovelCost + mShovelCost + sShovelCost + iShovelCost;
		
		//Calculate total bill
		totalBill = totalBoxCost + totalShovelCost;

		//Disp invoice to screen
		System.out.printf("\n%39s\n%32s\n\n%32s\n\n","MIRACLE SNOW SHOVELS UNLIMITED","WEST NOWHERE, NH","SHIPPING INVOICE");
		System.out.printf("CUSTOMER:\n%s\n%s\n%s, %s  %s\n\n",customerName,customerStreet,customerCity,customerState,customerZip);
		System.out.printf("%14s%18s%16s\n","ITEMS SHIPPED:","SHIPPING","PRODUCT COST");
		System.out.printf("%3d %-19s%9.2f%16.2f\n",xlBoxNum,"Extra Large Case(s)",xlBoxCost,xlShovelCost);
		System.out.printf("%3d %-19s%9.2f%16.2f\n",lBoxNum,"Large Case(s)",lBoxCost,lShovelCost);
		System.out.printf("%3d %-19s%9.2f%16.2f\n",mBoxNum,"Medium Case(s)",mBoxCost,mShovelCost);
		System.out.printf("%3d %-19s%9.2f%16.2f\n",sBoxNum,"Small Case(s)",sBoxCost,sShovelCost);
		System.out.printf("%3d %-19s%9.2f%16.2f\n\n",iBoxNum,"Individual Case(s)",iBoxCost,iShovelCost);
		System.out.printf("%-23s%9.2f%16.2f\n","TOTALS:",totalBoxCost,totalShovelCost);
		System.out.printf("%-23s%25.2f\n","TOTAL BILL:",totalBill);
	}
}