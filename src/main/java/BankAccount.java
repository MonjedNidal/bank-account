/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
class BankAccount{
    int balance;
    boolean status = false;
    BankAccount (){
        balance = 0;
    }
    void open(){
        status = true;
    }
    void close(){
        status = false;
    }
    int getBalance () throws BankAccountActionInvalidException {
        if(status){
            return balance;
        }throw new BankAccountActionInvalidException("Account closed");

    }
    void  deposit(int value) throws BankAccountActionInvalidException {
        if(status){
            synchronized (this){
                if (value < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
                balance += value;
            }

        }else throw new BankAccountActionInvalidException("Account closed");
    }
    void withdraw(int value) throws BankAccountActionInvalidException {

        if(status){
            if (value < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            synchronized (this){
                if (balance == 0) throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
                if (value > balance) throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
                balance -= value;
            }

        }else throw new BankAccountActionInvalidException("Account closed");
    }
}