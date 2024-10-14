/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trackify.Model.others;

import java.util.Date;
import java.util.List;

public class ItemLoanModel {

 
    public String getListID() {
        return listID;
    }

  
    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

  
    public String getLendererName() {
        return lendererName;
    }

    public void setLendererName(String lendererName) {
        this.lendererName = lendererName;
    }

  
 

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public List<ItemDataModels> getCartList() {
        return cartList;
    }

    public void setCartList(List<ItemDataModels> cartList) {
        this.cartList = cartList;
    }

    public ItemLoanModel() {
    }

    public ItemLoanModel(String listID, String borrowerName, String lendererName, Date borrowDate, List<ItemDataModels> cartList) {
        this.listID = listID;
        this.borrowerName = borrowerName;
        this.lendererName = lendererName;
        this.borrowDate = borrowDate;
        this.cartList = cartList;
    }

   

   
    
    private String listID;
    private String borrowerName;
    private String lendererName;
    private Date borrowDate;
    private List<ItemDataModels>cartList;
}
