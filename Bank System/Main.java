import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import acc.Acc;
import acc.Trans;

import java.util.Map;

// System.out.print("\033[H\033[2J"); clear main
// System.out.flush();
public class Main {

    static void build() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome To Our Bank\n\n");
            System.out.println("1- Create new Account\n\n");
            System.out.println("2- Login to Existing Account\n\n");
            System.out.println("3- Delete Existing Account\n\n");
            System.out.println("4-Exit\n\n");
            System.out.println("Make Your Choice :");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Enter Your Name :\n");
                String name = scanner.nextLine();
                name = scanner.nextLine();
                // System.out.println(name);
                System.out.println("\nEnter Your Password :");
                String password = scanner.nextLine();
                System.out.println("\nEnter Your Secret Information that to reset your password : ");
                String secret = scanner.nextLine();
                System.out.println("\nEnter Your Start Amount : ");
                int amount = scanner.nextInt();
                Acc obj = new Acc(name, password, secret, amount);
                System.out.println("\n" + obj.toString() + "\n");
                build();
            } else if (input == 2) {
                System.out.println("Enter Id of your Account : ");
                int id = scanner.nextInt();
                if (Trans.contains(id)) {
                    Acc obj = Trans.search(id);
                    System.out.println("\n\nEnter Password : ");
                    String password = scanner.nextLine();
                    password = scanner.nextLine();
                    if (password.equals(obj.getPassword())) {
                        Trans.some_T(obj);
                        build();
                    } else {
                        System.out.println("\n\nWrong Password");
                        System.out.println("\n\nEnter Your Secret Information : ");
                        String secret = scanner.nextLine();
                        if (secret.equals(obj.getSecret_info())) {
                            System.out.println("Enter New Password : ");
                            password = scanner.nextLine();
                            obj.setPassword(password);
                            Trans.some_T(obj);
                            build();
                        } else {
                            System.out.println("\n\nWrong informations Please Try Again\n");
                            build();
                        }
                    }
                } else {
                    System.out.println("This Id is not in the System please try again.\n");
                    build();
                }
            } else if (input == 3) {

                System.out.println("Enter Id of your Account : ");
                int id = scanner.nextInt();
                Trans.delete(id);
                build();
            } else if (input == 4) {
                return;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            build();
            return;
        }
    }

    public static void main(String[] args) {
        build();
    }

}