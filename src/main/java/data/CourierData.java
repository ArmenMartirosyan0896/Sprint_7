package data;

import model.Courier;

public class CourierData {

    public static Courier defaultCourier(){
        return new Courier("murad_legendaaue", "Feduk_one_love", "Интересно");
    }

    public static Courier courierWithoutLogin(){
        return new Courier("", "aue-chelyaba", "Найтли");
    }

    public static Courier courierWirhoutPassword(){
        return new Courier("lovenwantity", "", "Уоттакуот");
    }
}