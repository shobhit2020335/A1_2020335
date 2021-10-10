package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Add_vaccine {
    String vacc_name;
    int number_of_doses;
    int gap_between_doses;

    public Add_vaccine(String vacc_name, int number_of_doses, int gap_between_doses) {
        this.vacc_name = vacc_name;
        this.number_of_doses = number_of_doses;
        this.gap_between_doses = gap_between_doses;
    }
}

class Register_hospital {

    String hospital_name;
    int pincode;
    int unique_id;

    public int getUnique_id() {


        int min = 100000;
        int max = 999999;
        unique_id = (int) (Math.random() * (max - min + 1) + min);
        return unique_id;
    }

    public Register_hospital(String hospital_name, int pincode, int unique_id) {
        this.hospital_name = hospital_name;
        this.pincode = pincode;
        this.unique_id = unique_id;
    }
}

class Register_citizen {
    String citizen_name;
    int age;
    int count = 0;
    long uid;

    public Register_citizen(String citizen_name, int age, long uid) {
        this.citizen_name = citizen_name;
        this.age = age;
        this.uid = uid;
    }
}

class create_slots {

    int hospital_id;
    int slots;
    int dayno;
    int quantity;

    public create_slots(int hospital_id, int slots, int dayno, int quantity) {
        this.hospital_id = hospital_id;
        this.slots = slots;
        this.dayno = dayno;
        this.quantity = quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.print("CoWin Portal initialized....\n" +
                "---------------------------------\n" +
                "1. Add Vaccine\n" +
                "2. Register Hospital\n" +
                "3. Register Citizen\n" +
                "4. Add Slot for Vaccination\n" +
                "5. Book Slot for Vaccination\n" +
                "6. List all slots for a hospital\n" +
                "7. Check Vaccination Status\n" +
                "8. Exit\n" +
                "---------------------------------\n");
        Scanner scn = new Scanner(System.in);
        int query;
        ArrayList<Add_vaccine> add_vaccines = new ArrayList<>();
        ArrayList<Register_hospital> hospital = new ArrayList<>();
        ArrayList<Register_citizen> citizen = new ArrayList<>();

        while (true) {
            System.out.println("enter query number:");
            query = scn.nextInt();
            if (query == 2) {


                System.out.print("hospital name:");
                String hospital_name = scn.next();
                System.out.print("pincode:");
                int pincode = scn.nextInt();
                int y = 0;
                Register_hospital h = new Register_hospital(hospital_name, pincode, y);
                y = h.getUnique_id();

                System.out.print("hospital name: " + hospital_name + ", pincode: " + pincode + ", Unique id: " + y + "\n");
                hospital.add(new Register_hospital(hospital_name, pincode, y));

            }
            if (query == 3) {
                System.out.println("citizen name:");
                String citizen_name = scn.next();
                System.out.println("Age:");
                int age = scn.nextInt();
                System.out.println("unique id:");
                long uid = scn.nextLong();
                long x = uid;
                int count = 0;
                while (x != 0) {
                    x = x / 10;
                    count++;
                }
                if (count < 12 || count > 12) {
                    System.out.println("invalid unique id \nUser Registration Failed");
                } else {
                    System.out.print("citizen name: " + citizen_name + ", ");
                    System.out.print("Age: " + age + ", ");
                    System.out.println("unique id: " + uid + ", ");
                    System.out.println("User registered successfully");
                    citizen.add(new Register_citizen(citizen_name, age, uid));
                }
            }
            if (query == 4) {
                System.out.println("Enter Hospital ID:");
              //  int hid;
                int hospital_id = scn.nextInt();
                int check;
                check=0;
                if (hospital.size() > 0) {
                    for (int i = 0; i < hospital.size(); i++) {
                        if (hospital_id == hospital.get(i).unique_id) {
                          //  hid=hospital.get(i).unique_id;
                            check=1;
                           break;
                        }
                          //

                    }
                    if(check!=1){
                        System.out.println("there is no such hospital found with this id");
                    }
                    System.out.println("Enter number of Slots to be added:");
                    int slots = scn.nextInt();
                    while (slots != 0) {
                        System.out.println("enter day number:");
                        int dayno = scn.nextInt();
                        System.out.println("Enter Quantity:");
                        int quantity = scn.nextInt();

                        System.out.println("Select Vaccine");
                        int i;
                        for (i = 0; i < add_vaccines.size(); i++) {
                            System.out.println(i + ". " + add_vaccines.get(i).vacc_name);
                        }


                        int x = scn.nextInt();
                        System.out.println("Slot added by Hospital " + hospital_id + " for Day: " + dayno + ", Available Quantity: " + quantity + " of vaccine " + add_vaccines.get(x).vacc_name);


                        slots--;
                    }
                } else {
                    System.out.println("please add a hospital first");
                }
            }
            if (query == 8) {
                break;
            }

            if (query == 1) {


                System.out.print("Vaccine Name:");
                String vacc_Name = scn.next();
                System.out.print("Number of Doses:");
                int number_of_doses = scn.nextInt();
                System.out.print("Gap between Doses:");
                int gap_between_doses = scn.nextInt();
                System.out.println("Vaccine Name:" + vacc_Name + ", " + "Number of Doses:" + number_of_doses + ", " + "Gap Between Doses:" + gap_between_doses);
                add_vaccines.add(new Add_vaccine(vacc_Name, number_of_doses, gap_between_doses));


            }

        }
//        for(int i= 0; i<add_vaccines.size();i++){
//            System.out.println(add_vaccines.get(i).vacc_name);
//
//        }
        for (int i = 0; i < hospital.size(); i++) {
            System.out.println(hospital.get(i).unique_id);

        }
    }
}

