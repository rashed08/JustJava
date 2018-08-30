/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Increment value

    public void increment(View view) {

        quantity = quantity + 1;
        display(quantity);

    }

    //decrement value
    public void decrement(View view) {

        quantity = quantity - 1;
        display(quantity);

    }

    // Calculates the price of the order
    // @return total price
    //@param addWhippedCream is weather or not the user wants whipped cream topping

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {

        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;

        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You!";
        return priceMessage;


    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {

        EditText nameField = (EditText)findViewById(R.id.enter_full_name);
        String name = nameField.getText().toString();
       // Log.v("Main Activity " , "Name: " + name);

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
       // Log.v("MainActivity", "Has Whipped Cream: " + hasWhippedCream);

        //CheckBox for chocolate

        CheckBox chocolateChecklBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean haschocolate = chocolateChecklBox.isChecked();


        // display(quantity);gyff
        // displayPrice(quantity*5);

        int price = calculatePrice();
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, haschocolate);
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    // Order Summary

    private void createOrderSummary() {


    }
}