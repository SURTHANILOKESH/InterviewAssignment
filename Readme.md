#Optics Project Setup Details 


##Project Setup Details 

- Run the Maven build
- Add [Cucumber extension for eclipse](https://marketplace.eclipse.org/content/cucumber-eclipse-plugin)
- Setup the Excel from oneDrive
- Update the Test Runner with which Suite or a Specific Tag
- 



##Test Data file Setup 
	Step 1: Setup the One Drive application in VM with proper credentials.
	Step 2: Open the following one drive link 	
		Link:  "https://up0.sharepoint.com/:f:/r/sites/LocomotiveTeam/Shared%20Documents/Arete%20Team/Automation_Test_Data_Files?csf=1&web=1&e=TIZ2Pi"
	Step 3: After opening of the link click on the "Add Shortcut to OneDrive". Then make sure "Automation_Test_Data_Files" folder was added in your VM's Local OneDrive Folder.
	Step 4: Update the Config.properties file, for this Property "optimusLocalOneDriveTestDataFileLocation" with your Local OneDrive File Path
		Example :optimusLocalOneDriveTestDataFileLocation = "C:/Users/xprk565/OneDrive - Union Pacific/Automation_Test_Data_Files/Optimus_Test_Data.xlsx".
		
##Important Reminders: Excel Data Sheet
	--> Don't commit the Config.properties file to SVN with your local file path addresses
	--> Don't update the test data file, from the VM's local OneDrive. ONLY DO UPDATE THROUGH ONLINE.
	--> Only open in local for checking of test data is updated or not.
	--> If test data not updated in your local, Quit the OneDrive in VM local and reopen the OneDrive application. It will helps to do proper synchronization.
	
	==> ONCE ALL THE TEST DATA IS STABLE, IT WILL MOVES TO PROJECT AND WILL COMMIT IN SVN 
	
##Useful Tags
 - **@ALL**
 - **@ASSIGNPOWERSUITE** 
 - **@OPTICSSUITE**
 - **@MOVEINTERCHANGESUITE**
 - **@SETUISUITE**
 - **@CONNECTINGTRAINSUITE**
 
 
 To run Individual cases Pattern would be like folder name followed by use case number
 -  **@OPTICS_UC01** 
 - **@ASSIGNPOWER_UC01**

	
	
##Framework Details 
		selenium - 4.14.1
		restAssured - 4.3.0
		cucumber - 6.1.1
		testng - 7.5
		poi - 5.2.0
		log4j - 2.20.0
		hamcrest - 2.2
		Xjms - 2.0.1
		Ojdbc - 1019.21.0.0
	
	
## Recent Updates 2/19/2023
- Updated the Selenium to 4.14.1
