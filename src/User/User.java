/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Admin.Admin;
import static Admin.Admin.products;
import Extend.Account;
import Product.Product;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Hoaianh
 */
public class User extends Account {

    public static HashSet<Product> carts = new HashSet<Product>();

    public User(String username, String password) {
        super(username, password);
    }

    public User() {
    }

    @Override
    public int login(String un, String pw) {
        Iterator<User> it = Admin.users.iterator(); // su dung hashset cua user nam o Admin dung Admin.users;
        while (it.hasNext()) {
            User user = it.next();
            if (un.equals(user.getUsername()) && pw.equals(user.getPassword())) {
                return 1;
            }

        }
        return -1;

    }

    public void SignUp(Scanner sc) {
        User user = new User();
        System.out.print("Username: ");
        user.setUsername(sc.next());
        System.out.print("Password: ");
        user.setPassword(sc.next());
        Admin.users.add(user);
        System.out.println("Sign up successful! ");
    }

    public void ShowProduct() {
        Iterator<Product> it = Admin.products.iterator();
        int index = 1;
        while (it.hasNext()) {
            Product product = it.next();
            System.out.println("Index: " + index++);
            System.out.println("Name of the product: " + product.getName());
            System.out.println("Price of the product: " + product.getPrice());
            System.out.println("Quantity in stock of the product: " + product.getQuantityStock());
            System.out.println("------------------------------------------------");

        }
    }

    public void AddCart(Scanner sc) {
        System.out.print("Please enter the product you want to add to your cart: ");
        int choice = Integer.parseInt(sc.next());
        Iterator<Product> it = products.iterator();
        int index = 0;
        while (it.hasNext()) {
            Product product = it.next();
            index++;
            if (choice == index) {
                product.setQuantity(1);
                carts.add(product);
                System.out.println("Product added to cart successfully ");
            }

        }
    }

    public void ShowCart() {
        Iterator<Product> it = carts.iterator();
        int index = 1;
        while (it.hasNext()) {
            Product product = it.next();
            System.out.println("Index: " + index++);
            System.out.println("Name of the product: " + product.getName());
            System.out.println("Price of the product: " + product.getPrice());
            System.out.println("Quantity in cart of the product: " + product.getQuantity());
            System.out.println("------------------------------------------------");

        }
    }

    public void UpdateCart(Scanner sc) {
        Iterator<Product> it = carts.iterator();
        System.out.print("Please enter the number you want to update: ");
        int index = sc.nextInt();
        int i = 0;
        while (it.hasNext()) {
            Product product = it.next();
            i++;
            if (i == index) {
                products.remove(product);
                System.out.print("Please update quantity in cart of the product: ");
                product.setQuantity(sc.nextInt());
                carts.add(product);
                System.out.println("update successful products in cart");
                System.out.println("------------------------------------------------");
                break;
            }

        }
    }

    public void DeleteCart(Scanner sc) {
        Iterator<Product> it = carts.iterator();
        System.out.print("Please enter the number you want to delete: ");
        int index = sc.nextInt();
        int i = 0;
        while (it.hasNext()) {
            Product product = it.next();
            i++;
            if (i == index) {
                carts.remove(product);
                System.out.println("Delete successful");
                break;
            }
        }
    }

}
