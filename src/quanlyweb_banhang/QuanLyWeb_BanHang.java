/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlyweb_banhang;

import Admin.Admin;
import User.User;
import java.util.Scanner;

/**
 *
 * @author Hoaianh
 */
public class QuanLyWeb_BanHang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        User user = new User();
        while (true) {
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.print("Please enter your choice ");
            int Choice = Integer.parseInt(sc.next());
            if (Choice == 1) {
                user.SignUp(sc);
                
            } else {
                System.out.print("Please enter your username: ");
                String un = sc.next();
                System.out.print("Please enter your password: ");
                String pw = sc.next();
                if (admin.login(un, pw) == 0) {
                    adminRule(admin, sc); // Hàm theo nguyen tac admin
                       
                } else if (user.login(un, pw) == 1) {
                    userRule(un, sc, user); // Hàm theo nguyen tac user

                } else {
                    System.out.println("Account does not exist!");
                }
            }

        }
    }

    public static void userRule(String un, Scanner sc, User user) throws NumberFormatException {
        System.out.println("Welcome " + un);
        while (true) {
            System.out.println("0. Log out");
            System.out.println("1. Show all the product");
            System.out.println("2. Add product to cart");
            System.out.println("3. Show the product in cart");
            System.out.println("4. Update the product in cart");
            System.out.println("5. Delete the product in cart");
            System.out.print("Please enter your choice ");
            int choice = Integer.parseInt(sc.next());
            switch (choice) {
                case 0:
                    return;
                case 1:
                    user.ShowProduct();
                    break;
                case 2:
                    user.AddCart(sc);
                    break;
                case 3:
                    user.ShowCart();
                    break;
                case 4:
                    user.UpdateCart(sc);
                    break;
                case 5:
                    user.DeleteCart(sc);
                    break;
            }
        }
    }

    public static void adminRule(Admin admin, Scanner sc) {
        System.out.println("Welcome " + admin.getUsername());
        while (true) {
            System.out.println("1. Add product");
            System.out.println("2. Show product");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Show user");
            System.out.println("6. Delete user");
            System.out.println("0. Log out!");
            System.out.print("Please enter your choice: ");
            int choice = sc.nextInt();//Integer.parseInt(sc.nextLine()) - (lênh này thì co loi)?
            switch (choice) {
                case 1:
                    admin.AddProduct(sc);
                    break;
                case 2:
                    admin.ShowProduct();
                    break;
                case 3:
                    admin.UpdateProduct(sc);
                    break;
                case 4:
                    admin.DeleteProduct(sc);
                    break;
                case 5:
                    admin.ShowUser();
                    break;
                case 6:
                    admin.DeleteUser(sc);
                    break;
                case 0:
                    return;
            }
        }
        
    }

}
