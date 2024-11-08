/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trackify.Controller;

import Trackify.Database.DatabaseConnection;
import Trackify.Model.others.ItemDataModels;
import Trackify.Factory.ItemsData;
import Trackify.Model.others.FileImageModel;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.coobird.thumbnailator.Thumbnails;
import raven.modal.Toast;


public class ItemController implements ItemsData{

   private PreparedStatement ps;
   private ResultSet rs;
    public ItemController() {
        
        
    }
 
    @Override
    public void insertItem(ItemDataModels data)throws IOException,SQLException {
        try {
            String sql = "INSERT INTO items_data (ItemID,Title,Location,Category,Quantity,Status,Image)VALUES(?,?,?,?,?,?,?)";
           ps  = prepareStatement(sql);
           ps.setString(1,data.getItemID());
           ps.setString(2,data.getTitle());
           ps.setString(3,data.getLocation());
           ps.setString(4,data.getCategory());
           ps.setInt(5, data.getQuantity());
           ps.setString(6, data.getStatus());
           
            if (data.getItemImage()!=null) {
                ps.setBytes(7, getByteImage(data.getItemImage().getPath()));
            }else{
                ps.setBytes(7, null);
            }
            System.out.println("succesfully Added");
           
           ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (rs!=null) {
                    rs.close();             
            }
            if (ps!=null) {            
                    ps.close();
            } 
        }
    }

    @Override
    public void updateItem(ItemDataModels data) {
     
        
        
    }

    @Override
    public void deleteItem(ItemDataModels data) {
      
        
        
    }

    @Override
    public List<ItemDataModels> populateData()throws SQLException{
        List<ItemDataModels>list = new ArrayList<>();
       
        try {
             String sql = "SELECT * FROM items_data WHERE DateDeleted IS NULL";
             ps = prepareStatement(sql);
             rs = ps.executeQuery();
             
             while (rs.next()) {                
                Blob blob = (Blob) rs.getBlob("Image");
                ImageIcon icon = null;
            
                if (blob != null) {
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                icon = new ImageIcon(imageBytes);
                }else{
                icon = new ImageIcon(getClass().getResource("/Trackify/Icons/Admin.png"));
                }
                
                 FileImageModel fileImageModel = new FileImageModel();
                 fileImageModel.setIcon(icon);
                 ItemDataModels itemDataModels = new ItemDataModels(rs.getString("ItemID"),
                         rs.getString("Title"), rs.getString("Location"), rs.getString("Category"),
                         rs.getInt("Quantity"), rs.getString("Status"), fileImageModel);
                 
                 
                 list.add(itemDataModels);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (rs!=null) {
                    rs.close();             
            }
            if (ps!=null) {            
                    ps.close();
            }
        }
        
        return list;
    }
   
      private byte[] getByteImage(File file) throws IOException {
        BufferedImage image = Thumbnails.of(file)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    
    private Connection getConnection() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            return databaseConnection.getCConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement prepareStatement(String sql) {
        try {
            Connection con = getConnection();
            if (con != null) {
                return con.prepareStatement(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
