package data;

import model.Order;

public class OrderData {
    public static Order scooterColourGrey(){
        return new Order("Абдурозик","Хасбулла", "Марио", "1", "+79991112233", "2023-04-10", "3", new String[]{"GREY"}, "Не так важно как ты бьешь");
    }

    public static Order scooterColourBlack(){
        return new Order("Абдурозик","Хасбулла", "Марио", "1", "+79991112233", "2023-04-10", "3", new String[]{"BLACK"}, "Не так важно как ты бьешь");

    }

    public static Order scooterNoColour(){
        return new Order("Абдурозик","Хасбулла", "Марио", "1", "+79991112233", "2023-04-10", "3",null, "Не так важно как ты бьешь");

    }

    public static Order scooterAllColor(){
        return new Order("Абдурозик","Хасбулла", "Марио", "1", "+79991112233", "2023-04-10", "3", new String[]{"GREY","BLACK"}, "Не так важно как ты бьешь");

    }
}