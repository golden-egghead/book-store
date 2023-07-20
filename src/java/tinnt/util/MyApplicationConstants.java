/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinnt.util;

/**
 *
 * @author Tin
 */
public class MyApplicationConstants {
    public class DispatchFeature {
        public static final String LOGIN_PAGE = "loginPage";
        public static final String LOGIN_CONTROLLER = "loginController";
    }    
    public class LoginFeature {
        public static final String START_CONTROLLER = "startController";
        public static final String INVALID_PAGE = "invalidPage";
        public static final String SEARCH_PAGE = "searchPage";
        public static final String CREATE_NEW_ACCOUNT_CONTROLLER = "createNewAccountController";
        public static final String CREATE_NEW_ACCOUNT_PAGE = "createNewAccountPage";
        public static final String LOGOUT_CONTROLLER = "logoutController";
    }
    
    public class SearchFeature {
        public static final String SEARCH_CONTROLLER = "searchController";
        public static final String DELETE_CONTROLLER = "deleteController";
        public static final String DELETE_ERROR_PAGE = "deleteErrorPage";
        public static final String UPDATE_CONTROLLER = "updateController";
        public static final String UPDATE_ERROR_PAGE = "updateErrorPage";
    }
    
    public class ShoppingCartFeature {
        public static final String ADD_ITEM_TO_CART_CONTROLLER = "addItemToCartController";
        public static final String VIEW_CART_PAGE = "viewCartPage";
        public static final String REMOVE_ITEMS_FROM_CART_CONTROLLER = "removeItemFromCartController";
        public static final String SHOPPING_PAGE = "shoppingPage";
    }
}
