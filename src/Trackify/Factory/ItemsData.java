/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trackify.Factory;

import Trackify.Model.others.ItemDataModels;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface ItemsData {
    void insertItem(ItemDataModels data)throws IOException,SQLException;
     
    void updateItem(ItemDataModels data);
    
    void deleteItem(ItemDataModels data);
    
    List<ItemDataModels> populateData()throws SQLException;
    
}
