public class AccountMenu extends View{
    public AccountMenu(){
        viewName = "AccountMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //prompt user
        System.out.println("===== Account Menu =====");
        System.out.println("Enter one of the following commands: ");
        System.out.println("1 - View bank accounts");
        System.out.println("2 - Add bank account");
        System.out.println("3 - Update Account Information");
        System.out.println("4 - Log Out");

        String in = viewManager.getScanner().nextLine();

        AccountRepo arepo = new AccountRepo();
        AccountModel amodel = new AccountModel();
        BalanceModel model = new BalanceModel();
        BalanceRepo repo = new BalanceRepo();

        switch(in){
            case "1":
               viewManager.navigate("BankMenu");
                break;
            case "2":
                model.setBalance(0.00);
                System.out.println("Enter a name for this bank account: ");
                in = viewManager.getScanner().nextLine();
                if(in.equals(repo.read(in).getAccountName())){
                    System.out.println("An account already exists with that name");
                    viewManager.quit();
                    return;
                }
                model.setAccountName(in);
                model.setId(arepo.read(LogIn.email).getId());
                repo.create(model);
                System.out.println("Bank account added.");
                break;
            case "3":
                amodel.setId(arepo.read(LogIn.email).getId());

                System.out.println("Enter your First Name: ");
                in = viewManager.getScanner().nextLine();
                if(VerifyName.verify(in)) {
                    amodel.setFirstName(in);
                }else{
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

                System.out.println("Enter your current email or a new one: ");
                in = viewManager.getScanner().nextLine();
                AccountModel queryAccount = arepo.read(in);

                if (VerifyEmail.verify(in)) {
                    amodel.setEmail(in);
                } else {
                    System.out.println("Invalid email address");
                    viewManager.quit();
                    return;
                }

                if(!in.equals(LogIn.email) & amodel.getEmail().equals(queryAccount.getEmail())){
                    System.out.println("Email address already in use.");
                    viewManager.quit();
                    return;
                }

                System.out.println("Enter your new password: ");
                in = viewManager.getScanner().nextLine();
                if(in.length() < 7 | in.length() > 50){
                    System.out.println("Password has an invalid amount of characters");
                    viewManager.quit();
                    return;
                }else {
                    amodel.setPassword(in);
                }
                arepo.update(amodel);
                break;

            case "4":
                viewManager.quit();
                break;
            default:
                //Navigate back here as default case
                viewManager.navigate("AccountMenu");
        }
    }
}
