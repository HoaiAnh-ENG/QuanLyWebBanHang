/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import Extend.Account;
import Product.Product;
import User.User;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Hoaianh
 */
public class Admin extends Account {

    public static HashSet<Product> products = new HashSet<>();
    public static HashSet<User> users = new HashSet<>();

    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin() {
        this.setUsername("admin");
        this.setPassword("admin");
        products.add(
                new Product("Ao thun", 199000, 50)
        );
        products.add(
                new Product("Ao so mi", 350000, 20)
        );
        products.add(
                new Product("Quan tay", 400000, 30)
        );
        users.add(
                new User("Anh", "Anh")
        );
        users.add(
                new User("Hoa", "Hoa")
        );

    }

    @Override
    public int login(String un, String pw) {
        if (un.equals(this.getUsername()) && pw.equals(this.getPassword())) {
            return 0;
        } else {
            return -1;
        }
    }

    public void AddProduct(Scanner sc) {

        Product product = new Product();
        System.out.print("Please enter name of the product: ");
        product.setName(sc.nextLine());
        System.out.print("Please enter price of the product: ");
        product.setPrice(Double.parseDouble(sc.nextLine()));
        System.out.print("Please enter quantity in stock of the product: ");
        product.setQuantityStock(Integer.parseInt(sc.nextLine()));
        products.add(product);
        System.out.println("add successful products");
        System.out.println("------------------------------------------------");

    }

    public void ShowProduct() {
        Iterator<Product> it = products.iterator();
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

    public void UpdateProduct(Scanner sc) {
        Iterator<Product> it = products.iterator();
        System.out.print("Please enter the number to update: ");
        int index = Integer.parseInt(sc.nextLine());
        int i = 0;
        while (it.hasNext()) {
            Product product = it.next();
            i++;
            if (i == index) {
                products.remove(product);
                System.out.print("Please update name of the product: ");
                product.setName(sc.nextLine());
                System.out.print("Please update price of the product: ");
                product.setPrice(Double.parseDouble(sc.nextLine()));
                System.out.print("Please update quantity in stock of the product: ");
                product.setQuantityStock(Integer.parseInt(sc.nextLine()));
                products.add(product);
                System.out.println("update successful products");
                System.out.println("------------------------------------------------");
                break;
            }

        }
    }

    public void DeleteProduct(Scanner sc) {
        Iterator<Product> it = products.iterator();
        System.out.print("Please enter the number to delete product: ");
        int index = Integer.parseInt(sc.nextLine());
        int i = 0;
        while (it.hasNext()) {
            Product product = it.next();
            i++;
            if (i == index) {
                products.remove(product);
                System.out.println("Delete successful");
                break;
            }
        }
    }

    public void ShowUser() {
        Iterator<User> it = users.iterator();
        int index = 1;
        while (it.hasNext()) {
            User user = it.next();
            System.out.println("Index: " + index++);
            System.out.println("Account name: " + user.getUsername());
            System.out.println("------------------------------------------------");

        }
    }

    public void DeleteUser(Scanner sc) {
        Iterator<User> it = users.iterator();
        System.out.print("Please enter the number to delete account name: ");
        int index = Integer.parseInt(sc.nextLine());
        int i = 0;
        while (it.hasNext()) {
            User user = it.next();
            i++;
            if (i == index) {
                products.remove(user);
                System.out.println("Delete successful");
                break;
            }
        }
    }
}
