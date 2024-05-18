import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  cart: [],
};

const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    addItem(state, action) {
      // payload is a new item to add to the cart
      state.cart.push(action.payload);
    },
    deleteItem(state, action) {
      // delete item by pizzaId
      state.cart = state.cart.filter((item) => item.pizzaId !== action.payload);
    },
    increaseItemQuantity(state, action) {
      // increase quantity of item by pizzaId
      const item = state.cart.find((item) => item.pizzaId === action.payload);
      item.quantity++;
      item.totalPrice = item.quantity * item.unitPrice;
    },
    decreaseItemQuantity(state, action) {
      // decrease quantity of item by pizzaId
      const item = state.cart.find((item) => item.pizzaId === action.payload);
      // if quantity is less than 1, delete item
      if (item.quantity <= 1) {
        state.cart = state.cart.filter(
          (item) => item.pizzaId !== action.payload
        );
        return;
      }
      item.quantity--;
      item.totalPrice = item.quantity * item.unitPrice;
    },
    clearCart(state) {
      state.cart = [];
    },
  },
});

export const {
  addItem,
  deleteItem,
  increaseItemQuantity,
  decreaseItemQuantity,
  clearCart,
} = cartSlice.actions;
export default cartSlice.reducer;
