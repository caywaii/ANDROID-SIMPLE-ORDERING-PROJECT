
package com.carylsantiago.ma2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private RadioGroup pizza, burger, beveragesType, beveragesSize, payment;
//    PIZZA SIZE
    RadioButton small, medium, large, jumbo;
//    BURGER TYPE
    RadioButton chickenBurger, beefBurger, vegiBurger;
//    BEVERAGES TYPE
    RadioButton coke, sprite, royal, coffee, tea;
//    BEVERAGES SIZE
    RadioButton bReg, bLarge;
// PAYMENT
    RadioButton cash, savings, loan;
    CheckBox mushroom, onion, olive, sausage, pepperoni, morecheese;
    EditText qPizza, qBurger, qBeverages;
    Button order;
//    PRICES
    final double pSmall = 75;
    final double pMedium = 150;
    final double pLarge = 250;
    final double pJumbo = 400;
    final double burgerChicken = 50;
    final double burgerBeef = 75;
    final double burgerVegetarian = 60;
    final double regSD = 35;
    final double largeSD = 50;
    final double regCoffee = 30;
    final double largeCoffee = 50;
    final double regTea = 25;
    final double largeTea = 40;


    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RADIO GROUP
        pizza = findViewById(R.id.rgPizza);
        burger = findViewById(R.id.rgBurger);
        beveragesType = findViewById(R.id.rgBeveragesType);
        beveragesSize = findViewById(R.id.rgBeveragesSize);
        payment = findViewById(R.id.rgPayment);
        //RADIO BUTTON PIZZA
        small = findViewById(R.id.rbSmall);
        medium = findViewById(R.id.rbMedium);
        large = findViewById(R.id.rbLarge);
        jumbo = findViewById(R.id.rbJumbo);
        //RADIO BUTTON BURGER TYPE
        chickenBurger = findViewById(R.id.rbChickBurg);
        beefBurger = findViewById(R.id.rbBeefBurg);
        vegiBurger = findViewById(R.id.rbVegetarian);
        //RADIO BUTTON BEVERAGES TYPE
        coke = findViewById(R.id.rbCoke);
        sprite = findViewById(R.id.rbSprite);
        royal = findViewById(R.id.rbRoyal);
        coffee = findViewById(R.id.rbCoffee);
        tea = findViewById(R.id.rbTea);
        //RADIO BUTTON BEVERAGES SIZE
        bReg = findViewById(R.id.rbReg);
        bLarge = findViewById(R.id.rbBLarge);
        //CHECKBOX
        mushroom = findViewById(R.id.cMushroom);
        onion = findViewById(R.id.cOnion);
        olive = findViewById(R.id.cOlive);
        sausage = findViewById(R.id.cSausage);
        pepperoni = findViewById(R.id.cPepperoni);
        morecheese = findViewById(R.id.cMoreCheese);
        //EDIT TEXT
        qPizza = findViewById(R.id.quantityPizza);
        qBurger = findViewById(R.id.quantityBurger);
        qBeverages = findViewById(R.id.quantityBeverages);
        //BUTTON
        order = findViewById(R.id.btnOrder);

        cash = findViewById(R.id.rbCash);
        savings = findViewById(R.id.rbGDebit);
        loan = findViewById(R.id.rbCredit);
        builder = new AlertDialog.Builder(this);


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                result.append("You ordered the following:" + "\n");
                //EDIT TEXT
                int quantity = 0;

                //PIZZA SIZE
                double pizzaSizeAmnt = 0;
                int pizzaSize = pizza.getCheckedRadioButtonId();
                RadioButton selectedPizza = findViewById(pizzaSize);
                if(pizzaSize ==-1){
                    Toast.makeText(MainActivity.this, "Nothing selected, please select 1", Toast.LENGTH_SHORT).show();
                }else{
                    if(small.getId() == pizzaSize){
                        quantity = Integer.parseInt(qPizza.getText().toString());
                        pizzaSizeAmnt = quantity * pSmall;
                        selectedPizza = small;

                    }else if(medium.getId() == pizzaSize){
                       quantity = Integer.parseInt(qPizza.getText().toString());
                        pizzaSizeAmnt = quantity * pMedium;
                        selectedPizza = medium;
                    }else if(large.getId() == pizzaSize){
                        quantity = Integer.parseInt((qPizza.getText().toString()));
                        pizzaSizeAmnt = quantity * pLarge;
                        selectedPizza = large;
                    }else if(jumbo.getId() == pizzaSize){
                        quantity = Integer.parseInt(qPizza.getText().toString());
                        pizzaSizeAmnt = quantity * pJumbo;
                        selectedPizza = jumbo;
                    }
                }


                result.append("\n" + quantity + " " + selectedPizza.getText().toString() +" Pizza:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + (pizzaSizeAmnt));
                //PIZZA TOPPINGS
                int toppiAmount = 0;
                result.append("\n" + "With the following additional toppings:");
                if(mushroom.isChecked()){
                    builder.setMessage(result.append("\n" + "\t\tMushroom"));
                    toppiAmount += 20;
                }
                if(onion.isChecked()){
                    builder.setMessage(result.append("\n" +"\t\tOnion"));
                    toppiAmount += 20;
                }
                if(olive.isChecked()){
                    builder.setMessage(result.append("\n" +"\t\tOlive"));
                    toppiAmount += 20;
                }
                if(sausage.isChecked()){
                    builder.setMessage(result.append("\n" +"\t\tSausage"));
                    toppiAmount += 20;
                }
                if(pepperoni.isChecked()){
                    builder.setMessage(result.append("\n" +"\t\tPepperoni"));
                    toppiAmount += 20;
                }
                if(morecheese.isChecked()){
                    builder.setMessage(result.append("\n" +"\t\tMore Cheese"));
                    toppiAmount += 20;
                }

                quantity = Integer.parseInt(qPizza.getText().toString());
                int finalPizzaResult = toppiAmount * quantity;

                builder.setMessage(result.append("\nAdditional Toppings: " +"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+ finalPizzaResult + "\n"));
                result.append("\n" + quantity + " " + selectedPizza.getText().toString() +" Pizza: "+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + (pizzaSizeAmnt + finalPizzaResult));
                //BURGER SECTION
                double burgerAmount = 0;
                int burgerTime = burger.getCheckedRadioButtonId();
                RadioButton selectedBurger = findViewById(burgerTime);
                if(chickenBurger.getId() == burgerTime){
                    quantity = Integer.parseInt(qBurger.getText().toString());
                    burgerAmount = quantity * burgerChicken;
                    selectedBurger = chickenBurger;
                }
                if(beefBurger.getId() == burgerTime){
                    quantity = Integer.parseInt(qBurger.getText().toString());
                    burgerAmount = quantity * burgerBeef;
                    selectedBurger = beefBurger;
                }
                if(vegiBurger.getId() == burgerTime){
                    quantity = Integer.parseInt(qBurger.getText().toString());
                    burgerAmount = quantity * burgerVegetarian;
                    selectedBurger = vegiBurger;
                }
                result.append("\n" + quantity + " " + selectedBurger.getText().toString() +" \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + (burgerAmount));
                //BEVERAGES
                String selectedBeveragesType = null;
                String selectedBeveragesSize = null;
                double beveAmount = 0;
                if(coke.isChecked()){
                   selectedBeveragesType = coke.getText().toString();
                }else if(sprite.isChecked()){
                    selectedBeveragesType = sprite.getText().toString();
                }else if(royal.isChecked()){
                    selectedBeveragesType = royal.getText().toString();
                }else if(coffee.isChecked()){
                    selectedBeveragesType = coffee.getText().toString();
                }else if(tea.isChecked()){
                    selectedBeveragesType = tea.getText().toString();
                }

                if(bReg.isChecked()){
                    selectedBeveragesSize = bReg.getText().toString();
                }else if(bLarge.isChecked()){
                    selectedBeveragesSize = bLarge.getText().toString();
                }

                if(selectedBeveragesType.equals("Coke") || selectedBeveragesType.equals("Sprite") || selectedBeveragesType.equals("Royal")){
                    if(selectedBeveragesSize.equals("Regular")){
                        quantity = Integer.parseInt(qBeverages.getText().toString());
                        beveAmount = quantity * regSD;
                    }else{
                        quantity = Integer.parseInt(qBeverages.getText().toString());
                        beveAmount = quantity * largeSD;
                    }
                }else if(selectedBeveragesType.equals("Coffee")){
                    if(selectedBeveragesSize.equals("Regular")){
                        quantity = Integer.parseInt(qBeverages.getText().toString());
                        beveAmount = quantity * regCoffee;
                    }else{
                        quantity = Integer.parseInt(qBeverages.getText().toString());
                        beveAmount = quantity * largeCoffee;
                    }
                }else if(selectedBeveragesType.equals("Tea")) {
                    if (selectedBeveragesSize.equals("Regular")) {
                        quantity = Integer.parseInt(qBeverages.getText().toString());
                        beveAmount = quantity * regTea;
                    } else {
                        quantity = Integer.parseInt(qBeverages.getText().toString());
                        beveAmount = quantity * largeTea;
                    }
                }
                result.append("\n" + quantity + " " + selectedBeveragesType + " " + selectedBeveragesSize +" \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + (beveAmount));
                double totalAmount = pizzaSizeAmnt + finalPizzaResult + burgerAmount + beveAmount;




                //PAYMENT
                double realTotalAmount = 0;
                String selectedPayment = null;
                if(cash.isChecked()){
                    selectedPayment = cash.getText().toString();
                    realTotalAmount = totalAmount;
                }
                if(savings.isChecked()){
                    selectedPayment = savings.getText().toString();
                    double transpose = totalAmount * 0.05;
                    realTotalAmount = transpose + totalAmount;
                }
                if(loan.isChecked()){
                    selectedPayment = loan.getText().toString();
                    double transpose = totalAmount * 0.1;
                    realTotalAmount = transpose + totalAmount;
                }


                //TOTALITY EACH SECTION
                    //PIZZA

                    //BURGER

                    //BEVERAGES

                    //TOTAL AMOUNT
                result.append("\n" + "Total Amount: " + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + (totalAmount));
                //SELECTED PAYMENT
                result.append("\n" + "Payment thru: " +" \t\t\t\t\t\t"+ selectedPayment);
                result.append("\n" + "Total Amount is: " + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "P "+ (realTotalAmount));
                result.append("\nPay Now?");

                builder.setCancelable(true).setPositiveButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(getApplicationContext(), "You choose to order more", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Payment Made", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("CayRestaurant");
                alert.setMessage(result.toString());
                alert.show();
            }
        });
    }
}