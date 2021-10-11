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
    String vaccine_name;
    String hosp_name;

    public create_slots(int hospital_id, int slots, int dayno, int quantity, String vaccine_name, String hosp_name) {
        this.hospital_id = hospital_id;
        this.slots = slots;
        this.dayno = dayno;
        this.quantity = quantity;
        this.vaccine_name = vaccine_name;
        this.hosp_name = hosp_name;
    }
}

public class Main {

    public static void main(String[] args) {

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
        ArrayList<create_slots> slot = new ArrayList<>();


        while (true) {
            System.out.println("enter query number:");
            query = scn.nextInt();

            if (query == 2) {


                System.out.print("hospital name:");
                String hospital_name = scn.next();
                System.out.print("pincode:");
                int pincode = scn.nextInt();
                int c = 0;
                int pincode_duplicate = pincode;
                while (pincode_duplicate != 0) {
                    pincode_duplicate = pincode_duplicate / 10;
                    c++;
                }
                if (c < 6 || c > 6) {
                    System.out.println("invalid pincode");
                    System.out.println("---------------------------------\n" +
                            "{Menu Options}");
                } else {


                    int y = 0;
                    Register_hospital h = new Register_hospital(hospital_name, pincode, y);
                    y = h.getUnique_id();

                    System.out.print("hospital name: " + hospital_name + ", pincode: " + pincode + ", Unique id: " + y + "\n");
                    System.out.println("---------------------------------\n" +
                            "{Menu Options}");
                    hospital.add(new Register_hospital(hospital_name, pincode, y));

                }
            }
            if (query == 3) {
                System.out.println("citizen name:");
                String citizen_name = scn.next();
                System.out.println("Age:");
                int age = scn.nextInt();
                if (age < 18) {
                    System.out.println("Only above 18 are allowed\n" +
                            "---------------------------------\n" +
                            "{Menu Options}");
                } else {
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
                        System.out.println("---------------------------------\n" +
                                "{Menu Options}");
                    } else {
                        System.out.print("citizen name: " + citizen_name + ", ");
                        System.out.print("Age: " + age + ", ");
                        System.out.println("unique id: " + uid + ", ");
                        System.out.println("User registered successfully");
                        System.out.println("---------------------------------\n" +
                                "{Menu Options}");
                        citizen.add(new Register_citizen(citizen_name, age, uid));
                    }
                }
            }
            if (query == 4) {
                System.out.println("Enter Hospital ID:");

                int hospital_id = scn.nextInt();
                int check;
                check = 0;
                if (hospital.size() > 0) {
                    for (int i = 0; i < hospital.size(); i++) {
                        if (hospital_id == hospital.get(i).unique_id) {

                            check = 1;
                            break;
                        }


                    }
                    if (check != 1) {
                        System.out.println("there is no such hospital found with this id");
                        System.out.println("---------------------------------\n" +
                                "{Menu Options}");
                    }if(check==1){
                    System.out.println("Enter number of Slots to be added:");
                    int slots = scn.nextInt();
                    while (slots != 0) {
                        System.out.println("enter day number:");
                        int dayno = scn.nextInt();
                        System.out.println("Enter Quantity:");
                        int quantity = scn.nextInt();


                        int i;
                        if (add_vaccines.size() > 0) {
                            System.out.println("Select Vaccine");
                            for (i = 0; i < add_vaccines.size(); i++) {
                                System.out.println(i + ". " + add_vaccines.get(i).vacc_name);


                            }
                        }
                        if (add_vaccines.size() == 0) {
                            System.out.println("no vaccine found\nfailed to add slot");
                            System.out.println("---------------------------------\n" +
                                    "{Menu Options}"
                            );
                            break;
                        }


                        int x = scn.nextInt();
                        System.out.println("Slot added by Hospital " + hospital_id + " for Day: " + dayno + ", Available Quantity: " + quantity + " of vaccine " + add_vaccines.get(x).vacc_name);
                        System.out.println("---------------------------------\n" +
                                "{Menu Options}");
                        int idx = 0;
                        for (int k = 0; k < hospital.size(); k++) {
                            if (hospital_id == hospital.get(k).unique_id) {
                                idx = k;
                                break;
                            }
                        }
                        slot.add(new create_slots(hospital_id, slots, dayno, quantity, add_vaccines.get(x).vacc_name, hospital.get(idx).hospital_name));

                        slots--;
                    }}
                } else {
                    System.out.println("No Hospital Found");
                    System.out.println("---------------------------------\n" +
                            "{Menu Options}");
                }
            }
            if (query == 5) {
                System.out.println("enter pateint Unique ID:");
                long pui = scn.nextLong();
                int check_pui;
                check_pui = 0;
                if (citizen.size() > 0) {
                    for (int i = 0; i < citizen.size(); i++) {

                        if (pui == citizen.get(i).uid) {

                            check_pui = 1;
                            break;
                        }


                    }

                }
                if (check_pui != 1) {
                    System.out.println("there is no citizen found with this id");
                    System.out.println("---------------------------------\n" +
                            "{Menu Options}");
                }
                if (check_pui == 1) {
                    System.out.println("1. Search by area\n" +
                            "2. Search by Vaccine\n" +
                            "3. Exit");
                    System.out.print("Enter option: ");
                    int option = scn.nextInt();
                    int pc;
                    int hos_id;
                    if (option == 1) {
                        System.out.print("Enter Pincode: ");
                        int digits = 0;
                        //    int count = 0;

                        pc = scn.nextInt();
                        int pc1 = pc;
                        while (pc1 != 0) {
                            pc1 = pc1 / 10;
                            digits++;
                        }
                        if (digits < 6 || digits > 6 ) {
                            System.out.println("invalid pincode");
                        } else {
                            if (hospital.size() > 0) {
                                int i = 0;
                                while (i < hospital.size()) {
                                    if (pc == hospital.get(i).pincode) {

                                        System.out.print(hospital.get(i).unique_id + ", " + hospital.get(i).hospital_name + "\n");
                                    }
                                    i++;
                                }
                            }
                            int bl;
                            bl=0;
                            System.out.print("Enter hospital id: ");
                            hos_id = scn.nextInt();
                            for(int j=0;j<hospital.size();j++){
                                if(hos_id!=hospital.get(j).unique_id){
                                    bl=1;
                                    System.out.println("incorrect hospital id");
                              break;

                                }
                            }
                            if(bl!=1){



                            if (slot.size() < 1) {
                                System.out.println("no slot added to the hospital");
                            } else {

                                int bool;
                                bool = 0;

                                for (int i = slot.size() - 1; i >= 0; i--) {

                                    if (hos_id == slot.get(i).hospital_id) {
                                        bool = 1;
                                        System.out.println(i + "-> " + "Day:" + slot.get(i).dayno + " Avaiable Qty:" + slot.get(i).quantity + " vaccine: " + slot.get(i).vaccine_name);
                                    }
                                }
                                System.out.print("Choose Slot:\n");
                                int input = scn.nextInt();
                                for (int i = 0; i < citizen.size(); i++) {
                                    if (pui == citizen.get(i).uid) {
                                        System.out.println(citizen.get(i).citizen_name + " vaccinated with " + slot.get(input).vaccine_name);
                                    }
                                }
                                if (bool == 0) {
                                    System.out.println("no slots available");
                                }
                            }}

                        }
                    }
                    if (option == 2) {
                        System.out.print("Enter Vaccine name: ");
                        String v_name, v;
                        v_name = scn.next();
                        for (int i = 0; i < slot.size(); i++) {

                            if ((v_name.equals(slot.get(i).vaccine_name))) {
                                System.out.println(slot.get(i).hospital_id + ", " + slot.get(i).hosp_name);

                            }
                            else{
                                System.out.println("no vaccine found");
                                System.out.println("---------------------------------\n" +
                                        "{Menu Options}");
                                break;
                            }
                        }
                        System.out.print("Enter hospital id: \n");
                        int newhid = scn.nextInt();
                        int bool1;
                        bool1 = 0;
                        for (int i = slot.size() - 1; i >= 0; i--) {

                            if (newhid == slot.get(i).hospital_id) {
                                bool1 = 1;
                                System.out.println(i + "-> " + "Day:" + slot.get(i).dayno + " Avaiable Qty:" + slot.get(i).quantity + " vaccine: " + slot.get(i).vaccine_name);
                            }
                            else{
                                System.out.println("incorrect hospital id");
                                break;
                            }
                        }
                        System.out.print("Choose Slot:\n");
                        int input1 = scn.nextInt();
                        for (int i = 0; i < citizen.size(); i++) {

                            if (pui == citizen.get(i).uid) {
                                System.out.println(citizen.get(i).citizen_name + " vaccinated with " + slot.get(input1).vaccine_name);
                            }
                        }
                        if (bool1 == 0) {
                            System.out.println("no slots available");
                        }

                    }
                    if(option==3){
                        continue;
                    }
                }
            }
            if (query == 6) {
                System.out.print("Enter Hospital Id: \n");
                int hid1 = scn.nextInt();
                for (int i = 0; i < slot.size(); i++) {
                    if(hid1==slot.get(i).hospital_id){
                    System.out.println("Day: " + slot.get(i).dayno + " Vaccine: " + slot.get(i).vaccine_name + " Availabe Qty: " + slot.get(i).quantity);
                }
                else{
                        System.out.println("incorrect hospital id");
                        break;
                }
                }

                System.out.println("---------------------------------\n" +
                        "{Menu Options}");
            }

            if (query == 8) {
                System.out.println("{End of Test Case}");
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
                System.out.println("---------------------------------\n" +
                        "{Menu Options}");
                add_vaccines.add(new Add_vaccine(vacc_Name, number_of_doses, gap_between_doses));


            }

        }
    }
}

