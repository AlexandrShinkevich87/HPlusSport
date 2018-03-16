# HPlusSport
Web Development. Java EE: Servlets and JavaServer Pages (JSP)

MVC architecture:
View - JSP or HTML files
Controller - servlet (component) classes that intercept request, and prepare the response
Model - data of the application.
DAO - design pattern called data access object. A class is going to hold all the methods to connect to the database and do all the transactions.
Tables to be used:
Users - to store all user information
Products - to store all product-related information
Orders - to store order history of a particular user

Types of HTTP Requests
GET - get or retrieve information from the server side
    Data sent along is a query string visible in URL, hence insecure request.
    Data limit 8KB, with a few caveats because that would depend upon the browser and the server configuration.
    Idempotent - would not change anything on server side if request is sent out multiple times. 
POST - process or manipulate information on the server side (change the data on the server side)
    POST is used to modify data into a data store (CRUD).
        Example, registering yourself as a new user on a website or checking out a shopping cart
    The data that you send along in a POST request is always going to be in a separate component, which is called payload of the request object, so it is never going to be exposed in the URL, which is why POST is considered to be a secured request
    The data that you can send out in a post request can be of unlimited character length, of course with a few caveats because it will depend upon the application and the server configuration which could possibly limit the character length.
    POST request is a nonidempotent request.
        Example, the user comes in through the browser and tries to check out her shopping cart. When she submits the request you must have already seen that you're asked to enter your credit card credentials and then when you submit them, you're always shown a pop up to not refresh the browser or go back to the previous page.
    ![](pic/POST%20Request%20Nonidempotent.png)
PUT - upload the definition of a resource on the server. 
DELETE - delete a resource from the server
HEAD - same as a get request, but returns with the header information, not the body of the response. 
OPTIONS - helps trace what HTTP methods work on the server, as in what are the possible options that you can run on the target resource.

