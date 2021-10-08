package PartII;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputerDriver {

	static final String PASSWORD = "password";
	static Computer inventory[];

	public static int getAvailableSpace(int maxComputers) {
		int existingCount = 0;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				existingCount++;
				continue;
			}
			break;
		}
		return (inventory.length - existingCount);

	}

	public static void addComputerInfo(int noOfComputers) {

		Scanner s = new Scanner(System.in);
		int computerno = 1;
		boolean first = true;
		for (int i = 0; i < inventory.length && computerno <= noOfComputers; i++) {
			if (inventory[i] != null) {
				continue;
			} else {
				String inputType = "";
				try {
					System.out.println("enter the details of computer : " + computerno);
					if (!first) {
						s.nextLine();
					}
					System.out.println("Enter the brand name");
					String brandName = s.nextLine();
					System.out.println("Enter the model name");
					String modelName = s.nextLine();
					if (computerno == 1) {
						first = false;
					}
					System.out.println("Enter the serial number");
					inputType = "long";
					long serialNumber = s.nextLong();
					System.out.println("Enter the price");
					inputType = "double";
					double price = s.nextDouble();
					inventory[i] = new Computer(brandName, modelName, serialNumber, price);
					System.out.println("Computer Added Successfully!!");
					computerno++;
				} catch (InputMismatchException e) {
					System.out.println("Input type is wrong." + inputType + " is expected. Try again!!");
					i--;
				}
			}
		}

	}

	public static void findCheaperThan(double price) {
		
		boolean present = false;
		for (int i = 0; i < inventory.length && inventory[i] != null; i++) {
			if (inventory[i].getPrice() < price) {
				present = true;
				System.out.println(inventory[i]);
				System.out.println("********************");
			}
		}
		
		if(!present) {
			System.out.println("No computers present with the price below the given value");
		}
	}

	public static void findComputersBy(String brandName) {
		
		boolean found = false;
		for (int i = 0; i < inventory.length && inventory[i] != null; i++) {
			if (inventory[i].getBrand().equals(brandName)) {
				found = true;
				System.out.println(inventory[i]);
				System.out.println("********************");
			}
		}
		
		if(!found) {
			System.out.println("No computer exists with the given brand name");
		}
	}

	public static void displayComputerInfo(int computerNo) {
		System.out.println("Computer : " + computerNo + "\nBrand : " + inventory[computerNo].getBrand() + ""
				+ "\nModel : " + inventory[computerNo].getModel() + "\nSN : " + inventory[computerNo].getSn() + ""
				+ "\nPrice : " + inventory[computerNo].getPrice());
	}


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean menuTest = true;
		int maxComputers = 0;
		while (menuTest) {
			System.out.println("Welcome :) Please enter the maximum number of " + "computers your store can contain");
			
			try {
				maxComputers = s.nextInt();
				inventory = new Computer[maxComputers];
			} catch (InputMismatchException e) {
				System.out.println(
						"Input should be of proper type.int is expected");
				s.nextLine();
				continue;
			}
			menuTest = false;
		}
		boolean askInput = true;
		while (askInput) {
			System.out.print("What do you want to do?\r\n" + "1. Enter new computer (password required)\r\n"
					+ "2. Change information of a computer (password required)\r\n"
					+ "3. Display all computers by a specific brand\r\n"
					+ "4. Display all computers under a certain a price.\r\n" + "5. Quit\r\n"
					+ "Please enter your choice>");
			int userChoice;
			try {
				userChoice = s.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Integer input is expected. Try again!!");
				s.nextLine();
				continue;
			}
			switch (userChoice) {
			case 1:
				System.out.println("Please enter your password");
				int count = 1;
				s.nextLine();
				boolean success = false;
				while (count <= 3) {
					String password = s.nextLine();
					count++;
					if (password.equals(PASSWORD)) {
						success = true;
						System.out.println("Enter no.of computers to add");
						int noOfComputers = s.nextInt();
						int available = getAvailableSpace(maxComputers);
						if (available >= noOfComputers) {
							addComputerInfo(noOfComputers);
						} else if (available == 0) {
							System.out.println("There is no space available in computer store to add a new computer.");
						} else {
							System.out.println("You can only enter " + available + " computers. "
									+ "Please enter their information");
							addComputerInfo(available);
						}
						break;
					} else {
						if (count != 4) {
							System.out.println("Password entered is incorrect.Try again!!");
						}
					}
				}

				if (count == 4 && !success) {
					System.out.println("Sorry! you have reached the maximum no.of tries");
				}
				break;

			case 2:
				System.out.println("Please enter your password");
				count = 1;
				s.nextLine();
				boolean entered = false;
				while (count <= 3) {
					String password = s.nextLine();
					count++;
					if (password.equals(PASSWORD)) {
						entered = true;
						boolean userContinues = true;
						while (userContinues) {
							System.out.println("Enter the computer number to change information");
							int computerNo = s.nextInt();
							if (computerNo < inventory.length && inventory[computerNo] != null) {

								displayComputerInfo(computerNo);
								boolean isContinue = true;
								while (isContinue) {
									System.out.println("What information would you like to" + "change?\n" + "1. brand\n"
											+ "2. model\n" + "3. SN\n" + "4. price\n" + "5. Quit\n"
											+ "Enter your choice >");
									String choice = s.next();
									switch (choice.trim()) {
									case "1":
										System.out.println("Enter the new brand name");
										s.nextLine();
										String newBrandName = s.nextLine();
										inventory[computerNo].setBrand(newBrandName);
										System.out.println("Brand name updated successfully!!");
										displayComputerInfo(computerNo);
										break;
									case "2":
										System.out.println("Enter the new model name");
										s.nextLine();
										String newModelName = s.nextLine();
										inventory[computerNo].setBrand(newModelName);
										System.out.println("Model name updated succesfully!!");
										displayComputerInfo(computerNo);
										break;
									case "3":
										System.out.println("Enter the new Serial Number");
										try {
											long newSN = s.nextLong();
											inventory[computerNo].setSn(newSN);
											System.out.println("Serial number updated successfully!!");
											displayComputerInfo(computerNo);
										} catch (InputMismatchException e) {
											System.out.println("Input should be a long type");
										}
										break;
									case "4":
										System.out.println("Enter the new price");
										try {
											double newPrice = s.nextDouble();
											inventory[computerNo].setPrice(newPrice);
											System.out.println("Price updated succesfully!!");
											displayComputerInfo(computerNo);
										} catch (InputMismatchException e) {
											System.out.println("Input should be a double type");
										}
										break;
									case "5":
										isContinue = false;
										userContinues = false;
										count = 9;
										break;
									default:
										System.out.println("Invalid Option entered. Try again!!");
									}
								}
							} else {
								System.out.println("The entered computer number does not exist."
										+ "\nType 1 if you want to try with other number or any other "
										+ "character to return to the " + "main menu.");
								String option = s.next();
								if (!option.trim().equals("1")) {
									userContinues = false;
									count = 9;
								}
							}
						}
					} else {
						System.out.println("Password entered is incorrect.Try again!!");
					}
				}
				if (!entered && count == 4) {
					System.out.println("Sorry! you have reached the maximum no.of tries");
				}

				break;
			case 3:
				System.out.println("Enter the brand name");
				s.nextLine();
				String brandName = s.nextLine();
				findComputersBy(brandName);
				break;
			case 4:
				System.out.println("Enter the price");
				double price = s.nextDouble();
				findCheaperThan(price);
				break;
			case 5:
				askInput = false;
				System.out.println("Application is quitting!!");
			}
		}
		s.close();
	}
}
