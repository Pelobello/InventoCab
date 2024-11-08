/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trackify.Factory;

import Trackify.Controller.ItemController;
import Trackify.Model.others.ItemDataModels;


public class ItemsFactory {

    public ItemsData createItemController() {
        return new ItemController();
    }
 
}
