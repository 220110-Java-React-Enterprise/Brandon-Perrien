public class BankMenu extends View{
    public BankMenu(){
        viewName = "BankMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView(){
        System.out.println("===== Bank Menu =====");
        AccountRepo arepo = new AccountRepo();
        AccountModel amodel = new AccountModel();
        BalanceModel model = new BalanceModel();
        BalanceRepo repo = new BalanceRepo();

        amodel.setId(arepo.read(LogIn.email).getId());

        model.setId(amodel.getId());
        model.setAccountName(repo.read(model.getId()).getAccountName());
        model.setBalance(repo.read(model.getId()).getBalance());



        System.out.println("Enter one of the following commands: ");
        System.out.println("1 - List accounts");
        System.out.println("2 - Withdraw/Deposit Money");
        System.out.println("3 - Delete Account");
        System.out.println("4 - Log Out");
        String in = viewManager.getScanner().nextLine();

switch(in) {
    case "1":
        System.out.println(amodel.getId());
        System.out.println(repo.read(model.getId()).getAccountName());
        System.out.println(model.getAccountName() + "'s Balance: $" + model.getBalance());
        break;
    case "2":
        System.out.println("Which account would you like to alter?");
        in = viewManager.getScanner().nextLine();
        if(!amodel.getId().equals(repo.read(in).getId())){
            System.out.println("You do not have an account with that name.");
            viewManager.quit();
            return;
        }
        model.setAccountName(repo.read(in).getAccountName());
        model.setBalance(repo.read(in).getBalance());
        System.out.println("What would you like to do?");
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        in = viewManager.getScanner().nextLine();
        switch(in){
            case "1":
                System.out.println("How much would you like to deposit?:");
                Double d = Double.valueOf(viewManager.getScanner().nextLine());
                model.deposit(d);
                repo.update(model);
                System.out.println(model.getAccountName() + "'s balance is now: $" + repo.read(model.getAccountName()).getBalance());
                break;
            case "2":
                System.out.println("How much would you like to withdraw?:");
                d = Double.valueOf(viewManager.getScanner().nextLine());
                model.withdraw(d);
                repo.update(model);
                System.out.println(model.getAccountName() + "'s balance is now: $" + repo.read(model.getAccountName()).getBalance());
                break;
            default:
                System.out.println("Going back to Bank Menu");
                viewManager.navigate("BankMenu");
        }
        break;
    case "3":
        System.out.println("WARNING! This will delete all of your banking accounts. \n Are you sure? (Y/N)");
        String confirm = viewManager.getScanner().nextLine();
       if(confirm.equals("Y")) {
            repo.delete(model.getId());
            System.out.println("Deletion successful.");
            viewManager.quit();
        }else{
           viewManager.navigate("BankMenu");
       }
        break;
    case "4":
        viewManager.quit();
        break;
    default:
        //Navigate back here as default case
        viewManager.navigate("AccountMenu");
}
viewManager.navigate("BankMenu");
    }
}
