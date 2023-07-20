/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinnt.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tin
 */
public class CartObj implements Serializable {
    private Map<String, Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    }
    
    public boolean addItemToCard(String id, int quantity) {
        boolean result = false;
        //1. check data validation
        if(id == null) {
            return result;
        }
        if(id.trim().isEmpty()) {
            return result;
        }
        if(quantity <= 0) {
            return result;
        }
        //2. check existed items
        if(this.items == null) {
            this.items = new HashMap<>();
        }
        //3. drops item to items       
        if(this.items.containsKey(id)) {
            int quan = items.get(id);
            quantity = quantity + quan;
        }
        // end item had existed
        //4. Update items
        items.put(id, quantity);
        result = true;
        
        return result;
    }
    
    public boolean removeItemFromCart(String id, int quantity) {
        boolean result = false;
        //1. check data validation
        
        if(id == null) {
            return result;
        }
        if(id.trim().isEmpty()) {
            return result;
        }
        if(quantity <= 0) {
            return result;
        }
        //2. Check existed items 
        if(this.items == null) {
            return result;
        }
        
        //3. check existed item
        if(this.items.containsKey(id)) {
            // 4. compare quantity
            int quan = this.items.get(id);
            if (quan < quantity) {
                return result;
            }// available quantity smaller than
            quantity = quan - quantity;
            if(quantity == 0) {
                this.items.remove(id);
                if(this.items.isEmpty()) {
                    this.items = null;
                }// empty cart when items has not existed
            } else {
                this.items.put(id, quantity);// update cart item
            }
            result = true;
        }// end item had existed
        return result;
    }
}
