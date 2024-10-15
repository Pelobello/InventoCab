
package Trackify.Forms;

import Trackify.Event.others.EventItem;
import Trackify.Items.InventoryCartItem;
import Trackify.Items.InventoryItem;
import Trackify.Model.others.ItemDataModels;
import Trackify.Model.others.ItemLoanModel;
import Trackify.Popup.Forms.CartForm;
import Trackify.Popup.Forms.ItemDataForm;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import raven.datetime.component.date.DatePicker;
import raven.modal.ModalDialog;
import raven.modal.Toast;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.layout.ResponsiveLayout;
import raven.modal.option.Location;
import raven.modal.option.Option;


public class InventoryData extends javax.swing.JPanel {

private List<ItemDataModels>cartListData = new ArrayList<>();
  private EventItem event;
  private EventItem cartEvent;
    public InventoryData() {
        initComponents();
         init();
        setOpaque(true);
        populateItems();
       
    }
    public void addItemData(ItemDataModels data){
        InventoryItem item = new InventoryItem();
        item.setData(data);
        
        item.getAddCartBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addtoCart(data);
            }

        });
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    event.ItemClick(data, item);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
             
            }

            @Override
            public void mouseExited(MouseEvent e) {
            
            }
        
        
        });
        inventoPanel.add(item);
        repaint();
        revalidate(); 
    }
    
    public void addCartData(ItemDataModels data){
        InventoryCartItem cartItem = new InventoryCartItem();
        cartItem.setData(data);
        int cartIndex = cartListData.indexOf(data);
         ItemDataModels datamodel = cartListData.get(cartIndex);
        
        cartItem.getRemovebtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int cartIndexdata = cartListData.indexOf(data);
                if (cartIndexdata != -1) {
                    cartListData.remove(cartIndexdata);
                    cartPanel.remove(cartItem);
                      
                    repaint();
                    revalidate();
                }
            }
        
        
        });
        
        cartItem.getAddbtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cartIndex != -1) {
                   
                      int newQty = datamodel.getCartQuantity()+ 1;
                      datamodel.setCartQuantity(newQty);
                      cartItem.setQtyData(newQty);
                      cartListData.set(cartIndex, datamodel);
                }    
            }
        });
            cartItem.getMinusbtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cartIndex != -1) {
                    if (datamodel.getCartQuantity()>1) {
                      int newQty = datamodel.getCartQuantity()- 1;
                      datamodel.setCartQuantity(newQty);
                      cartItem.setQtyData(newQty);
                      cartListData.set(cartIndex, datamodel);  
                    }     
                }           
            }
        });
        
        cartItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                   cartEvent.ItemClick(data, cartItem);
                }
            }  
            
        });
        cartPanel.add(cartItem);
        repaint();
        revalidate();
    }
  public EventItem getEvent() {
        return event;
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }
    
       public EventItem getCartEvent() {
        return cartEvent;
    }

    public void setCartEvent(EventItem cartEvent) {
        this.cartEvent = cartEvent;
    }
      DatePicker eventSchedDate = new DatePicker();
    private void init(){
        ResponsiveLayout inventoLayout = new ResponsiveLayout(ResponsiveLayout.JustifyContent.FIT_CONTENT, new Dimension(-1,-1),2,2);
         jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
           jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);
        inventoLayout.setColumn(3);
        inventoLayout.setSize(new Dimension(216, 359));  
        inventoPanel.setLayout(inventoLayout);
        
        ResponsiveLayout cartLayout = new ResponsiveLayout(ResponsiveLayout.JustifyContent.FIT_CONTENT, new Dimension(-1,-1),2,2);
        cartLayout.setColumn(1);
        cartLayout.setSize(new Dimension(282, 131));
        cartPanel.setLayout(cartLayout);
        
        eventSchedDate.setEditor(schedDateBorrow);
       eventSchedDate.setDateFormat("yyyy-MM-dd");
        eventSchedDate.now();
        eventSchedDate.setCloseAfterSelected(true);
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartPanel = new javax.swing.JPanel();
        orderId = new javax.swing.JLabel();
        studentName = new javax.swing.JTextField();
        schedDateBorrow = new javax.swing.JFormattedTextField();
        lendererName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        inventoPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout inventoPanelLayout = new javax.swing.GroupLayout(inventoPanel);
        inventoPanel.setLayout(inventoPanelLayout);
        inventoPanelLayout.setHorizontalGroup(
            inventoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        inventoPanelLayout.setVerticalGroup(
            inventoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(inventoPanel);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(cartPanel);

        orderId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderId.setForeground(new java.awt.Color(102, 102, 102));
        orderId.setText("20241015214");

        studentName.setText("Student Name");

        lendererName.setText("Lenderer Name");

        jButton2.setText("Borrow");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderId, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(schedDateBorrow, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lendererName, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(orderId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lendererName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schedDateBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private List<ItemLoanModel> borrowedData = new ArrayList<>();
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String student = studentName.getText();
    String lenderer = lendererName.getText();
    Date borrowDate = new Date();
    String orderIdValue = orderId.getText();
 
    for (ItemDataModels itemData : cartListData) {
     
        ItemLoanModel loan = new ItemLoanModel(orderIdValue, student, lenderer, borrowDate, List.of(itemData));  // Wrap itemData in a list
        borrowedData.add(loan);
    }

    System.out.println("Borrowed Items List:");
    for (ItemLoanModel itemLoan : borrowedData) {
        System.out.println("Order ID: " + itemLoan.getListID());
        System.out.println("Borrower Name: " + itemLoan.getBorrowerName());
        System.out.println("Lender Name: " + itemLoan.getLendererName());
        System.out.println("Borrow Date: " + itemLoan.getBorrowDate());

        System.out.println("Items in Cart:");
        for (ItemDataModels itemData : itemLoan.getCartList()) {
          
            System.out.println("ID "+itemData.getItemID()); 
             System.out.println("Title"+itemData.getTitle()); 
              System.out.println("Quantity "+itemData.getCartQuantity()); 
          
        }
         
        System.out.println("------------");
      
    }
    borrowedData.clear();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addInventoryData();
    }//GEN-LAST:event_jButton1ActionPerformed
  private void addInventoryData(){
      ItemDataForm itemDataForm = new ItemDataForm();
      Option option = ModalDialog.createOption();
        option.getLayoutOption()
                .setLocation(Location.CENTER, Location.CENTER)
                .setAnimateDistance(0.9f, 0);
          SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{new SimpleModalBorder.Option("Add Item", SimpleModalBorder.YES_OPTION)
                  ,new SimpleModalBorder.Option("Cancel", SimpleModalBorder.CANCEL_OPTION)};
        
      
          
          ModalDialog.showModal(this, new SimpleModalBorder(itemDataForm, "Add to Cart",options,
           (controller, action) -> {
              
           }
          
          ),option);
          
          
  }
    
    
    
    
    
  public void addtoCart(ItemDataModels data){
      CartForm cartForm = new CartForm();
      cartForm.setData(data);
        Option option = ModalDialog.createOption();
        
          option.getLayoutOption()
                .setLocation(Location.CENTER, Location.CENTER)
                .setAnimateDistance(0.9f, 0);
       
          SimpleModalBorder.Option[] options = new SimpleModalBorder.Option[]{new SimpleModalBorder.Option("Add to Cart", SimpleModalBorder.YES_OPTION)
                  ,new SimpleModalBorder.Option("Cancel", SimpleModalBorder.CANCEL_OPTION)};
          
          ModalDialog.showModal(this, new SimpleModalBorder(cartForm, "Add to Cart",options,
           (controller, action) -> {
               if (action == SimpleModalBorder.YES_OPTION) {
                   ItemDataModels dataModels = cartForm.getData();
                   
                   for (ItemDataModels dataModel : cartListData) {
                       if (dataModel.getItemID().equals(data.getItemID())) {
                           Toast.show(this, Toast.Type.INFO, data.getTitle()+" is already in the cart!");
                           return;
                       }
                   }
                   
                   Toast.show(this, Toast.Type.SUCCESS, "Succesfully Added");
                     
                   cartListData.add(dataModels);
                   populateCartData();
                   
               }else{
                   
               }
           }
          
          ),option);
      
  }
    public void populateCartData(){
        
        cartPanel.removeAll();
        for (ItemDataModels itemDataModels : cartListData) {
            addCartData(itemDataModels);
        }
        this.setCartEvent(new EventItem() {
            @Override
            public void ItemClick(ItemDataModels data, Component com) {
                System.out.println("cart testing");
            }
        });
        
    }
    
    public void populateItems(){
        inventoPanel.removeAll();
        addItemData(new ItemDataModels("536f5", "1k Resistor", "bisag aha", "bisag unsang Category", 69, "Available", new ImageIcon(getClass().getResource("/Trackify/Icons/Admin.png"))));
        addItemData(new ItemDataModels("536f6", "2k Resistor", "bisag aha", "bisag unsang Category", 69, "Available", new ImageIcon(getClass().getResource("/Trackify/Icons/Admin.png"))));
        addItemData(new ItemDataModels("536f7", "3k Resistor", "bisag aha", "bisag unsang Category", 69, "Available", new ImageIcon(getClass().getResource("/Trackify/Icons/Admin.png"))));
        addItemData(new ItemDataModels("536f8", "4k Resistor", "bisag aha", "bisag unsang Category", 69, "Available", new ImageIcon(getClass().getResource("/Trackify/Icons/Admin.png"))));
        
        this.setEvent(new EventItem() {
            @Override
            public void ItemClick(ItemDataModels data, Component com) {
                System.out.println("testing");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cartPanel;
    private javax.swing.JPanel inventoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lendererName;
    private javax.swing.JLabel orderId;
    private javax.swing.JPanel panel1;
    private javax.swing.JFormattedTextField schedDateBorrow;
    private javax.swing.JTextField studentName;
    // End of variables declaration//GEN-END:variables
}
