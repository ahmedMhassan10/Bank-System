package acc;

import acc.Acc;
import acc.Trans;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trans {
    public static Map<Integer, Acc> ma = new HashMap<Integer, Acc>();

    public static void add(Acc obj) {
        ma.put(obj.getId(), obj);
    }

    public static boolean contains(Integer id) {
        if (ma.containsKey(id)) {
            return true;
        }
        return false;
    }

    public static Acc search(Integer id) {
        return ma.get(id);

    }

    public static void delete(Integer id) {
        if (ma.containsKey(id))
            ma.remove(id);
        else {
            System.out.println("There is no account with this id\n\n");
        }
    }

    public static void some_T(Acc obj) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("1- Show Account Information.\n\n");
            System.out.println("2- Deposit Amount of Money.\n\n");
            System.out.println("3- Withdraw Amount of Money.\n\n");
            System.out.println("4- Exit.\n\n");
            System.out.println("Make Your Choice :");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("\n" + obj.toString() + "\n");
                obj.toString();
                some_T(obj);
            } else if (input == 2) {
                System.out.println("Enter Amount of money you want to deposit : \n");
                int input2 = scanner.nextInt();
                obj.deposit(input2);
                some_T(obj);
            } else if (input == 3) {
                System.out.println("Enter Amount of money you want to withdraw : \n");
                int input2 = scanner.nextInt();
                obj.withdraw(input2);
                some_T(obj);
            } else if (input == 4) {
                return;
            } else {
                throw new Exception("Enter valid Value\n\n");
            }
        } catch (Exception e) {
            some_T(obj);
        }
    }
}
