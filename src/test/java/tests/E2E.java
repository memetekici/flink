package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.MoisturizersAndSunscreensPage;
import pages.WeatherShopperPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.*;

public class E2E {
    /*
    I have some problems at my codes.
    1)I coudn't use for repeating codes.
    2)I couldn't listOfProductName,listOfProductprice,listOfAddButton to get out if statement.
    So I had to write twice.
    3)I couldn't lacate the paypage.So ı couldn't do last validation.
    */
    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //We create weatherObj from WeatherShopperPage class.
        WeatherShopperPage weatherObj = new WeatherShopperPage();

        //We create  productObj from MoisturizersAndSunscreensPage class
        MoisturizersAndSunscreensPage productObj = new MoisturizersAndSunscreensPage();
        CheckoutPage checkoutObj = new CheckoutPage();
        String temperatureQuantity = weatherObj.temperature.getText();

        int temInteger = 0;
        //For the If statement, we turn the string temperatureQuantity to integer temInteger
        if (temperatureQuantity.length() == 4) {
            temInteger = Integer.parseInt(temperatureQuantity.substring(0, temperatureQuantity.length() - 2));
        }
        if(temperatureQuantity.length() == 5){
            temInteger = Integer.parseInt(temperatureQuantity.substring(0, temperatureQuantity.length() - 3));
        }

        //Shop for moisturizers if the weather is below 19 degrees.
        if (temInteger < 19) {
            weatherObj.buyMoisturizersButton.click();

            //We create a list for all product name
            List<String> listOfProductName = new ArrayList<>();
            listOfProductName.add(productObj.product1Name.getText().toUpperCase());
            listOfProductName.add(productObj.product2Name.getText().toUpperCase());
            listOfProductName.add(productObj.product3Name.getText().toUpperCase());
            listOfProductName.add(productObj.product4Name.getText().toUpperCase());
            listOfProductName.add(productObj.product5Name.getText().toUpperCase());
            listOfProductName.add(productObj.product6Name.getText().toUpperCase());

            //We create a list for all products price
            List<Integer> listOfProductPrice = new ArrayList<>();
            listOfProductPrice.add(Integer.parseInt(productObj.product1Price.getText().substring(productObj.product1Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product2Price.getText().substring(productObj.product2Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product3Price.getText().substring(productObj.product3Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product4Price.getText().substring(productObj.product4Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product5Price.getText().substring(productObj.product5Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product6Price.getText().substring(productObj.product6Price.getText().length() - 3)));

            //We create list for webelements of AddButton
            List<WebElement> listAddButton = new ArrayList<>();
            listAddButton.add(productObj.product1AddButton);
            listAddButton.add(productObj.product2AddButton);
            listAddButton.add(productObj.product3AddButton);
            listAddButton.add(productObj.product4AddButton);
            listAddButton.add(productObj.product5AddButton);
            listAddButton.add(productObj.product6AddButton);
            System.out.println(listAddButton);

            //***E2E TEST We find product contains Aloe
            List<String> listOfAloe = new ArrayList<>();
            List<Integer> indexListOfAloe = new ArrayList<>();
            int k = -1;
            System.out.println(listOfProductPrice);
            System.out.println("Length of Price List : " + listOfProductPrice.size());

            System.out.println(listOfProductName);
            for (String w : listOfProductName) {
                k++;
                if (w.contains("ALOE")) {
                    listOfAloe.add(w);
                    indexListOfAloe.add(k);
                }
            }
            List<Integer> listOfAloePrice = new ArrayList<>();
            System.out.println(listOfAloe);
            System.out.println(indexListOfAloe);

            for (int i = 0; i < listOfProductPrice.size(); i++) {
                for (int j = 0; j < indexListOfAloe.size(); j++) {
                    if (indexListOfAloe.get(j) == i) {
                        listOfAloePrice.add(listOfProductPrice.get(i));
                    }
                }
            }
            System.out.println(listOfAloePrice);
            int minAloePreis = listOfAloePrice.get(0);
            int counterForAloa = 0;
            for (int i = 0; i < listOfAloePrice.size(); i++) {
                if (listOfAloePrice.get(i) < minAloePreis) {
                    minAloePreis = listOfAloePrice.get(i);
                    counterForAloa = i;
                }
            }
            System.out.println("The cheapest Aloa product : " + listOfAloe.get(counterForAloa));
            System.out.println("Preis of the cheapest Aloa : " + listOfAloePrice.get(counterForAloa));
            System.out.println("İndex of the cheapest Aloa : " + indexListOfAloe.get(counterForAloa));


            listAddButton.get(indexListOfAloe.get(counterForAloa)).click();

            //***E2E TEST We find product contains Almond

            List<String> listOfAlmond = new ArrayList<>();
            List<Integer> indexListOfAlmond = new ArrayList<>();
            int l = -1;

            for (String w : listOfProductName) {
                l++;
                if (w.contains("ALMOND")) {
                    listOfAlmond.add(w);
                    indexListOfAlmond.add(l);
                }
            }
            List<Integer> listOfAlmondPrice = new ArrayList<>();
            System.out.println(listOfAlmond);
            System.out.println(indexListOfAlmond);

            for (int i = 0; i < listOfProductPrice.size(); i++) {
                for (int j = 0; j < indexListOfAlmond.size(); j++) {
                    if (indexListOfAlmond.get(j) == i) {
                        listOfAlmondPrice.add(listOfProductPrice.get(i));
                    }
                }
            }

            System.out.println(listOfAlmondPrice);
            int minAlmondPreis = listOfAlmondPrice.get(0);
            int counterForAlmond = 0;
            for (int i = 0; i < listOfAlmondPrice.size(); i++) {
                if (listOfAlmondPrice.get(i) < minAlmondPreis) {
                    minAlmondPreis = listOfAlmondPrice.get(i);
                    counterForAlmond = i;
                }
            }
            System.out.println("The cheapest Almond product:" + listOfAlmond.get(counterForAlmond));
            System.out.println("Preis of cheapest Almond: " + listOfAlmondPrice.get(counterForAlmond));
            System.out.println("Index of Cheapest Almond : " + indexListOfAlmond.get(counterForAlmond));

            listAddButton.get(indexListOfAlmond.get(counterForAlmond)).click();


            //Verify that the shopping cart looks correct
            productObj.cartButton.click();
            int expectedTotalPrice = listOfAloePrice.get(counterForAloa) + listOfAlmondPrice.get(counterForAlmond);
            int actualTotalPrice = Integer.parseInt(checkoutObj.totalPrice.getText().substring(checkoutObj.totalPrice.getText().length() - 3));
            System.out.println("expected total price : " + expectedTotalPrice);
            System.out.println("Actual total price : " + actualTotalPrice);
            Assert.assertEquals(expectedTotalPrice,actualTotalPrice);

            checkoutObj.payWithCardButton.click();
            /*
            //I COULD NOT LOCATE THIS PAGE.I TRIED IFRAME ,HOWEROVER ETC.implicit wait BUT I COULD NOT
            //System.out.println(checkoutObj.emailButton.isDisplayed());
            //checkoutObj.emailButton.sendKeys(ConfigReader.getProperty("email"));
            checkoutObj.cardNummerButton.sendKeys(ConfigReader.getProperty("cardNumber"));
            checkoutObj.date.sendKeys(ConfigReader.getProperty("date"));
            checkoutObj.cvc.sendKeys(ConfigReader.getProperty("cvcNumber"));
            checkoutObj.zipCodeButton.sendKeys(ConfigReader.getProperty("111"));
            checkoutObj.lastPayButton.click();

            String expextedText = "Your payment was successful. You should receive a follow-up call from our sales team.";
            Assert.assertEquals(checkoutObj.successMessage.getText(),expextedText);

            */

        }
        //Shop for suncreens if the weather is above 34 degrees

        if(temInteger > 34){
            weatherObj.buySunScreensButton.click();
            //We create a list for all product name
            List<String> listOfProductName = new ArrayList<>();
            listOfProductName.add(productObj.product1Name.getText().toUpperCase());
            listOfProductName.add(productObj.product2Name.getText().toUpperCase());
            listOfProductName.add(productObj.product3Name.getText().toUpperCase());
            listOfProductName.add(productObj.product4Name.getText().toUpperCase());
            listOfProductName.add(productObj.product5Name.getText().toUpperCase());
            listOfProductName.add(productObj.product6Name.getText().toUpperCase());

            //We create a list for all products price
            List<Integer> listOfProductPrice = new ArrayList<>();
            listOfProductPrice.add(Integer.parseInt(productObj.product1Price.getText().substring(productObj.product1Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product2Price.getText().substring(productObj.product2Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product3Price.getText().substring(productObj.product3Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product4Price.getText().substring(productObj.product4Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product5Price.getText().substring(productObj.product5Price.getText().length() - 3)));
            listOfProductPrice.add(Integer.parseInt(productObj.product6Price.getText().substring(productObj.product6Price.getText().length() - 3)));

            //We create list for webelements of AddButton
            List<WebElement> listAddButton = new ArrayList<>();
            listAddButton.add(productObj.product1AddButton);
            listAddButton.add(productObj.product2AddButton);
            listAddButton.add(productObj.product3AddButton);
            listAddButton.add(productObj.product4AddButton);
            listAddButton.add(productObj.product5AddButton);
            listAddButton.add(productObj.product6AddButton);
            System.out.println(listAddButton);

            //***E2E TEST We find product contains SPF50
            List<String> listOfSPF50 = new ArrayList<>();
            List<Integer> indexListOfSPF50 = new ArrayList<>();
            int k = -1;

            for (String w : listOfProductName) {
                k++;
                if (w.contains("50")) {
                    listOfSPF50.add(w);
                    indexListOfSPF50.add(k);
                }
            }
            List<Integer> listOfSPF50Price = new ArrayList<>();
            System.out.println(listOfSPF50);
            System.out.println(indexListOfSPF50);

            for (int i = 0; i < listOfProductPrice.size(); i++) {
                for (int j = 0; j < indexListOfSPF50.size(); j++) {
                    if (indexListOfSPF50.get(j) == i) {
                        listOfSPF50Price.add(listOfProductPrice.get(i));
                    }
                }
            }
            System.out.println(listOfSPF50Price);
            int minSPF50Preis = listOfSPF50Price.get(0);
            int sayacForSPF50 = 0;
            for (int i = 0; i < listOfSPF50Price.size(); i++) {
                if (listOfSPF50Price.get(i) < minSPF50Preis) {
                    minSPF50Preis = listOfSPF50Price.get(i);
                    sayacForSPF50 = i;
                }
            }
            System.out.println("The cheapest SPF50 product :" + listOfSPF50.get(sayacForSPF50));
            System.out.println("Preis of cheapest SPF50 : " + listOfSPF50Price.get(sayacForSPF50));
            System.out.println("Index of cheapest SPF50 " + indexListOfSPF50.get(sayacForSPF50));

            listAddButton.get(indexListOfSPF50.get(sayacForSPF50)).click();

            //***E2E TEST We find product contains SPF30
            List<String> listOfSPF30 = new ArrayList<>();
            List<Integer> indexListOfSPF30 = new ArrayList<>();
            int l = -1;

            System.out.println(listOfProductName);
            for (String w : listOfProductName) {
                l++;
                if (w.contains("30")) {
                    listOfSPF30.add(w);
                    indexListOfSPF30.add(l);
                }
            }
            List<Integer> listOfSPF30Price = new ArrayList<>();
            System.out.println(listOfSPF30);
            System.out.println(indexListOfSPF30);

            for (int i = 0; i < listOfProductPrice.size(); i++) {
                for (int j = 0; j < indexListOfSPF30.size(); j++) {
                    if (indexListOfSPF30.get(j) == i) {
                        listOfSPF30Price.add(listOfProductPrice.get(i));
                    }
                }
            }
            System.out.println(listOfSPF30Price);
            int minSPF30Preis = listOfSPF30Price.get(0);
            int sayacForSPF30 = 0;
            for (int i = 0; i < listOfSPF30Price.size(); i++) {
                if (listOfSPF30Price.get(i) < minSPF30Preis) {
                    minSPF30Preis = listOfSPF30Price.get(i);
                    sayacForSPF30 = i;
                }
            }
            System.out.println("The cheapest SPF30 :" + listOfSPF30.get(sayacForSPF30));
            System.out.println("Preis of the cheapest SPF30 : " + listOfSPF30Price.get(sayacForSPF30));
            System.out.println("Index of the cheapest SPF30 " + indexListOfSPF30.get(sayacForSPF30));


            listAddButton.get(indexListOfSPF30.get(sayacForSPF30)).click();

            //Verify that the shopping cart looks correct
            productObj.cartButton.click();
            int expectedTotalPrice = listOfSPF50Price.get(sayacForSPF50) + listOfSPF30Price.get(sayacForSPF30);
            int actualTotalPrice = Integer.parseInt(checkoutObj.totalPrice.getText().substring(checkoutObj.totalPrice.getText().length() - 3));
            System.out.println("expected total price : " + expectedTotalPrice);
            System.out.println("Actual total price : " + actualTotalPrice);
            Assert.assertEquals(expectedTotalPrice,actualTotalPrice);

            checkoutObj.payWithCardButton.click();
            /*I COULD NOT LOCATE THIS PAGE.I TRIED IFRAME ,HOWEROVER ETC, implicit wait.BUT I COULD NOT
            //System.out.println(checkoutObj.emailButton.isDisplayed());
            //checkoutObj.emailButton.sendKeys(ConfigReader.getProperty("email"));
            checkoutObj.cardNummerButton.sendKeys(ConfigReader.getProperty("cardNumber"));
            checkoutObj.date.sendKeys(ConfigReader.getProperty("date"));
            checkoutObj.cvc.sendKeys(ConfigReader.getProperty("cvcNumber"));
            checkoutObj.zipCodeButton.sendKeys(ConfigReader.getProperty("111"));
            checkoutObj.lastPayButton.click();

            String expextedText = "Your payment was successful. You should receive a follow-up call from our sales team.";
            Assert.assertEquals(checkoutObj.successMessage.getText(),expextedText);

             */


        }
    }

}
