package cw1;

public class Main {
    public static void main(String[] args) {
        String name1 = "Ivanov";
        String name2 = "Petrov";
        String name3 = "Dorn";
        int phone1 = 123456;
        int phone2 = 654321;
        int phone3 = 777777;
        int phone4 = 555555;

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone3);
        myPhoneBook.add(name3, phone4);
        myPhoneBook.add(name3, phone1);

        System.out.println(PhoneBook.getPhoneBook());
        System.out.println("Найти номера Ivanov:" + myPhoneBook.find(name1));
        System.out.println("Найти номера Me:" + myPhoneBook.find("Me"));
        myPhoneBook.delnum(name3, phone1);
        myPhoneBook.delnum(name2, phone2);
        myPhoneBook.delpers(name1);
        System.out.println(PhoneBook.getPhoneBook());
    }
}

