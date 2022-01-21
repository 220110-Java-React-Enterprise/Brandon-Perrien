public class AccountMenu extends View{
    public AccountMenu(){
        viewName = "AccountMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView(){
        //prompt user
        System.out.println("===== Account Menu =====");
        System.out.println("Enter one of the following commands: ");
        System.out.println("1 - View bank accounts");
        System.out.println("2 - Add bank account");
        System.out.println("3 - Update Account Information");
        System.out.println("4 - Withdraw or Deposit Money");
        System.out.println("5 - Log Out");

        String in = viewManager.getScanner().nextLine();

        AccountRepo arepo = new AccountRepo();
        AccountModel amodel = new AccountModel();
        BalanceModel model = new BalanceModel();
        BalanceRepo repo = new BalanceRepo();

        switch(in){
            case "1":
               // repo.read(email).getAccountName();
                System.out.println("temp");
                break;
            case "2":
              /*  System.out.println("Name the account: ");
                String name = viewManager.getScanner().nextLine();
                model.setAccountName(name);
                model.setEmail(email);
                model.setBalance(0.00);
                repo.create(model);*/
                System.out.println("temp2");
                break;
            case "3":
                System.out.println("Enter your current email: ");
                String email = viewManager.getScanner().nextLine();
                amodel.setId(arepo.read(email).getId());

                System.out.println("Enter your First Name: ");
                in = viewManager.getScanner().nextLine();
                if(VerifyName.verify(in)) {
                    amodel.setFirstName(in);
                }else{
                    //this might need to be switched to exception instead of a println
                    System.out.println("First Name can only contain letters");
                    viewManager.quit();
                    return;
                }

                System.out.println("Enter your Last Name: ");
                in = viewManager.getScanner().nextLine();
                if(VerifyName.verify(in)) {
                    amodel.setLastName(in);
                }else{
                    System.out.println("First Name can only contain letters");
                    viewManager.quit();
                    return;
                }

                System.out.println("Enter your new email: ");
                in = viewManager.getScanner().nextLine();
                if(VerifyEmail.verify(in)){
                    amodel.setEmail(in);
                }else{
                    System.out.println("Invalid email address");
                    viewManager.quit();
                    return;
                }

                System.out.println("Enter your new password: ");
                in = viewManager.getScanner().nextLine();
                if(in.length() < 7 | in.length() > 50){
                    //this might need to be an exception instead
                    System.out.println("Password has an invalid amount of characters");
                    viewManager.quit();
                    return;
                }else {
                    amodel.setPassword(in);
                }

                arepo.update(amodel);
                System.out.println("tempo");
                break;
            case "4":
                System.out.println("tempa");
                break;
            case "5":
                viewManager.quit();
                break;
            default:
                //Navigate back here as default case
                viewManager.navigate("AccountMenu");
        }
    }
}
