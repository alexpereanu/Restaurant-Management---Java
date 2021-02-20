# Restaurant-Management---Java
Consider implementing a restaurant management system. The system should have three types of users: administrator, waiter and chef. 
The administrator can add, delete and modify existing products from the menu. The waiter can create a new order for a table, add elements from the menu, 
and compute the bill for an order.  The chef is notified each time it must cook food ordered through a waiter. Consider the system of classes in the diagram below. 

The objective of the project is to create and program an application that processes the menu and orders of a restaurant. Also, the objective of this theme is to implement simple and easy to use interfaces through which you can manage the activity of a restaurant regarding its menu and its orders.
The application manages the actions performed in a fictitious restaurant, namely the actions of creating, updating and deleting a menu item and creating, view and compute bill for an order

The project was made with the help of 16 classes divided into 4 packages:
BusinessLayer, DataLayer, PresentationLater, Main. The BusinessLayer package contains the following classes (BaseProduct, CompositeProduct, MenuItem, Order, Restaurant, IObservable, IObserver). In this package are implemented the basic classes, the essential classes for the implementation of the project, respectively the class of the basic menus and that of the composite menus as well as the MenuItem class which is extended by BaseProduct and CompositeProduct.
The DataLayer package contains only one class, namely RestaurantSerializer, the class with which the respective serialization and deserialization of the data will be performed.
The PresentationLayer package is the package that contains the classes with which we create the graphical interface. The package presents the following 7 classes: AdministratorGraphicalUserInterface, ChefGraphicalUserInterface, WaiterGraphicalUserInterface, MainInterface, Table, TableOrder, and Invoice. The first 4 classes are for the creation of the graphical interface and the last classes are the classes with the help of which we create JTables for visualizing the data, respectively the Invoice class with the help of which we can create an invoice in .txt format.
The Main package contains the App class which is actually the main of our program.

