package my.project.command;

public class CommandFactory {
	
	
	private static CommandFactory factory = null;
	

    private CommandFactory() {
    	
    }
    
    

    /**
     * Get an instance of the CommandFactory
     * @return The singleton CommandFactory object
     */
    
    
    public synchronized static CommandFactory getInstance() {
        if (factory == null) {      // first time

            factory = new CommandFactory();
        }
        return factory;
    }
    
    

    /**
     * 
     * @param commandStr Identifier for the exact Command object required
     * @return The specific Command object requested
     */
    
    
    
    public synchronized Command createCommand(String commandStr) {
    	
    	Command command = null;

    	//Instantiate the required Command object.............................................................................
    	// All the action from the buttons and anchor tags and the corresponding commands..............................
    	
    	if (commandStr.equals("registration")) {
    		command = new RegisterUserCommand();
    	}
    	if (commandStr.equals("adminlogin")) {
    		command = new LoginAdministrationCommand();
    	}
    	if (commandStr.equals("userlogin")) {
    		command = new LoginUserCommand();
    	}
    	if (commandStr.equals("listAllTickets")) {
    		command = new ListAllTicketsCommand();
    	}
    	if (commandStr.equals("listAllProducts")) {
    		command = new ListAllProductsCommand();
    	}
    	if (commandStr.equals("listAllAdminProducts")) {
    		command = new ListAllProductsForAdminCommand();
    	}
    	if (commandStr.equals("listAllNewProducts")) {
    		command = new ListAllNewReleasesCommand();
    	}
    	if (commandStr.equals("sortByPrice")) {
    		command = new SortByAlbumPriceCommand();
    	}
    	if (commandStr.equals("sortByName")) {
    		command = new SortByAlbumNameCommand();
    	}
    	if (commandStr.equals("sortByCode")) {
    		command = new SortByAlbumCodeCommand();
    	}
    	if (commandStr.equals("sortByFName")) {
    		command = new SortByCustFirstNameCommand();
    	}
    	if (commandStr.equals("sortByLName")) {
    		command = new SortByCustLastNameCommand();
    	}
    	if (commandStr.equals("sortByCity")) {
    		command = new SoetByCustCityCommand();
    	}
    	if (commandStr.equals("sortByCounty")) {
    		command = new SortByCustCountyCommand();
    	}
    	if (commandStr.equals("addtocart")) {
    		command = new DisplayProductCommand();
    	}
    	if (commandStr.equals("viewAlbumInfo")) {
    		command = new ViewAlbumInfoCommand();
    	}
    	if (commandStr.equals("logout")) {
    		command = new LogOutCommand();
    	}
    	if (commandStr.equals("update")) {
    		command = new UpdatePasswordCommand();
    	}
    	if (commandStr.equals("delete")) {
    		command = new DeleteUserCommand();
    	}
    	if (commandStr.equals("processorder")) {
    		command = new GetCustomerDetailsForOrderCommand();
    	}
    	if (commandStr.equals("order")) {
    		command = new OrderCommand();
    	}
    	if (commandStr.equals("finish")) {
    		command = new OrderItemCommand();
    	}
    	if (commandStr.equals("invoices")) {
    		command = new ListAllCustomersCommand();
    	}
    	if (commandStr.equals("records")) {
    		command = new ListAllDeletedUsersCommand();
    	}
    	if (commandStr.equals("listCustomerOrder")) {
    		command = new ListCustomerOrderCommand();
    	}
    	if (commandStr.equals("check")) {
    		command = new CheckForUsernameBeingUsedCommand();
    	}
    	if (commandStr.equals("post")) {
    		command = new ListAllCommentsCommand();
    	}
    	if (commandStr.equals("track")) {
    		command = new ListAllTracksForAlbumCommand();
    	}
    	if (commandStr.equals("remove")) {
    		command = new RemoveCustAndOrderCommand();
    	}
    	if (commandStr.equals("removeAlbum")) {
    		command = new RemoveAllAlbumInfoFromDbCommand();
    	}
    	if (commandStr.equals("insertAlbum")) {
    		command = new AddNewReleaseCommand();
    	}
    
    	//Return the instantiated Command object to the calling code..........................................................
    	
    	return command;		// may be null....................................................................................

    }
	

}
