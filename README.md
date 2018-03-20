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
    chapter 14
PUT - upload the definition of a resource on the server. 
DELETE - delete a resource from the server
HEAD - same as a get request, but returns with the header information, not the body of the response. 
OPTIONS - helps trace what HTTP methods work on the server, as in what are the possible options that you can run on the target resource.

Forward
chapter 18
Often in a web application, all the requests processing capability is never encapsulated into a single servlet. You often need to split up the functionality across multiple servlets to make the code more modular and maintainable. In that case it is necessary to understand how do you forward the control of the request from one servlet to another? Even in cases where the servlet is trying to ready the response and give it back to the client, we need to understand how do you forward the control from the servlet to let's say a JSP file. So let's look at this diagram. Whenever the user hits a request, it goes to your application context. Let's say that this requests functionality is split across servlet. So the request comes to the first servlet and when the servlet does what it is supposed to do, the request can be forwarded to the other servlet. Not only this, in some cases the servlet can also forward the entire request control to another JSP. Now be it a servlet or a JSP, they are all resources of the application. So this process by which you can forward the request control from one servlet to another servlet or from one servlet to another JSP is exactly the concept of forwarding under the servlets API. 
The URL only shows the login URL pattern, and that's exactly why we are safe now. It is not revealing any kind of implementation details in the URL. This exactly is the concept of forwarding. 
RequestDispatcher.include
What it essentially does is, it is going to combine the response of this login servlet and the response of this login.jsp file together and render it to the client.

RequestDispatcher. 
It's basically used to forward the control from one resource to another resource, but do not forget it is inside the same application. And in this entire process, the browser will play no part. Entirely, it's managed by the server site. This approach is very commonly used in a framework called Struts, where whenever you click on a hyperlink, you always go to an action class and from the action class, the request is dispatched to a JSP. That way, we are always safe, and we never reveal any of our folder details in the URL. 