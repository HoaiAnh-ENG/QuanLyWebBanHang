/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extend;

/**
 *
 * @author Hoaianh
 */
public abstract class Account {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {
    }
    
    public abstract int login(String un, String pw); // un, pw là cái mà nguoi dung nhap vao khac voi username, password(là tk và mk cua admin hoac user); 
}
