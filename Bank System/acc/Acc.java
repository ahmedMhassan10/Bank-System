package acc;

import acc.Acc;
import acc.Trans;
import java.util.Map;

public class Acc extends Trans {
    private String name;
    private String password;
    private Integer id;
    private String secret_info;
    static int calc = 1;
    private int amount;

    public Acc(String name, String password, String secret_info, int amount) {
        this.name = name;
        this.password = password;
        this.id = new Integer(calc);
        calc = calc + 1;
        this.secret_info = secret_info;
        this.amount = amount;
        Trans.add(this);
    }

    @Override
    public String toString() {
        return "Your Name : " + name + "\nYour Id : " + id + "\nYour Amount : " + amount + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecret_info() {
        return secret_info;
    }

    public void setSecret_info(String secret_info) {
        this.secret_info = secret_info;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void deposit(int amount) {
        this.amount += amount;
        System.out.println("Your current amount is :" + this.amount + "\n");
    }

    public void withdraw(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            System.out.println("Your current amount is :" + this.amount + "\n");
        } else {
            System.out.println("You can`t do this operation\n");
            System.out.println("Your current amount is :" + this.amount + "\n");
        }
    }
}
